package com.example.springapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
 
@SpringBootApplication
@RestController
public class StarterController implements CommandLineRunner {
    // Const CORS = /;
    @Autowired
    private JdbcTemplate jdbcTemplate;
     
    public static void main(String[] args) {
        SpringApplication.run(StarterController.class, args);
    }

    String users = "[";
 
    @Override
    public void run(String... args) throws Exception {
        String sql = "select * from users";
         
        List<User> usrs = jdbcTemplate.query(
                sql, 
                (rs, rowNum) -> 
                        new User(
                                rs.getInt("ID"), 
                                rs.getString("USERNAME"), 
                                rs.getString("PASSWORD"), 
                                rs.getString("EMAIL"), 
                                rs.getBoolean("ISADMIN"), 
                                rs.getBoolean("ISAPPROVED")
                        )
        );
         
        for(User user : usrs) {
            users += user.getUser();
        }
        users = users.substring(0, users.length() - 1);
        users += "]";
    }


    // allow cors
    @CrossOrigin(origins = "http://localhost:8081/")
    @GetMapping("/users")
    public String Users(){
        return users;
    }
    


    // login users
    @CrossOrigin(origins = "http://localhost:8081/")
    @PostMapping("/login")
    public String Login(@RequestBody User user){
        String sql = "select * from users where USERNAME = ? and PASSWORD = ?";

        try{

            List<User> usrs = jdbcTemplate.query(
                sql, 
                (rs, rowNum) -> 
                        new User(
                                rs.getInt("ID"), 
                                rs.getString("USERNAME"), 
                                rs.getString("PASSWORD"), 
                                rs.getString("EMAIL"), 
                                rs.getBoolean("ISADMIN"), 
                                rs.getBoolean("ISAPPROVED")
                        ),
                user.getUSERNAME(),
                user.getPASSWORD()
            );
            String res = usrs.get(0).getUser();
            res = res.substring(0, res.length() - 1);
            return res;
        }catch(Exception e){
            return "{\"message\" : \"Login Failed\"}";
        }
    }

    // register users
    @CrossOrigin(origins = "http://localhost:8081/")
    @PostMapping("/register")
    public String Register(@RequestBody RegisterUser user){
        String sql = "insert into users (USERNAME, PASSWORD, EMAIL) values (?, ?, ?)";

        try{
            jdbcTemplate.update(sql, user.getUSERNAME(), user.getPASSWORD(), user.getEMAIL());

            String sql3 = "select * from users where USERNAME = ?";
            List<User> usrs = jdbcTemplate.query(
                sql3, 
                (rs, rowNum) -> 
                        new User(
                                rs.getInt("ID"), 
                                rs.getString("USERNAME"), 
                                rs.getString("PASSWORD"), 
                                rs.getString("EMAIL"), 
                                rs.getBoolean("ISADMIN"), 
                                rs.getBoolean("ISAPPROVED")
                        ),
                user.getUSERNAME()
            );
            String sql2= "insert into accounts (USER_ID,ACCOUNT_NUMBER,BALANCE) values (?, ?, ?)";

            jdbcTemplate.update(sql2, usrs.get(0).getID(), user.getACCOUNT_NUMBER(), 0);
            return "{\"message\" : \"Registration Successful\"}";
        }catch(Exception e){
            return e.getMessage();
        }
    }


    // get user accounts 
    @CrossOrigin(origins = "http://localhost:8081/")
    @PostMapping("/accounts")
    public String USER_ACCOUNT(@RequestBody String accn){

        String sql = "select * from user_account where ID=?";
        try{
            List<UserDetails> usrs = jdbcTemplate.query(
                sql, 
                (rs, rowNum) -> 
                        new UserDetails(
                            rs.getString("ID"), 
                            rs.getString("USERNAME"), 
                            rs.getString("EMAIL"),
                            rs.getBoolean("ISAPPROVED"),
                            rs.getString("ACCOUNT_NUMBER"), 
                            rs.getInt("BALANCE"),
                            rs.getInt("ACCOUNT_ID")
                        ),
                accn
            );

            String res = "[";
            for(UserDetails user : usrs) {
                res += user.getUser();
            }
            res = res.substring(0, res.length() - 1);
            res += "]";

            return res;
            
        }catch(Exception e){
            return e.getMessage();
        }

    }

    // get Transactions 
    @CrossOrigin(origins = "http://localhost:8081/")
    @GetMapping("/transactions")
    public String USER_TRANSACTIONS(){

        String sql = "select * from transactions";
        try{
            List<Transaction> usrs = jdbcTemplate.query(
                sql, 
                (rs, rowNum) -> 
                        new Transaction(
                            rs.getInt("ID"),
                            rs.getString("ACCOUNT_NUMBER"),
                            rs.getInt("AMOUNT"),
                            rs.getString("TRANSFERED_ACCOUNT_NUMBER"),
                            rs.getString("TRANSACTION_TYPE"),
                            rs.getString("TRANSACTION_DATE"),
                            rs.getString("DESCRIPTION")
                        )
            );

            String res = "[";
            for(Transaction user : usrs) {
                res += user.getTransaction();
            }
            res = res.substring(0, res.length() - 1);
            res += "]";

            return res;
            
        }catch(Exception e){
            return e.getMessage();
        }

    }

    // get Transactions by account number

    @CrossOrigin(origins = "http://localhost:8081/")
    @PostMapping("/transaction")
    public String USER_TRANSACTION(@RequestBody String accn){

        String sql = "select * from transactions where ACCOUNT_NUMBER=?";
        try{
            List<Transaction> usrs = jdbcTemplate.query(
                sql, 
                (rs, rowNum) -> 
                        new Transaction(
                            rs.getInt("ID"),
                            rs.getString("ACCOUNT_NUMBER"),
                            rs.getInt("AMOUNT"),
                            rs.getString("TRANSFERED_ACCOUNT_NUMBER"),
                            rs.getString("TRANSACTION_TYPE"),
                            rs.getString("TRANSACTION_DATE"),
                            rs.getString("DESCRIPTION")
                        ),
                accn
            );

            String res = "[";
            for(Transaction user : usrs) {
                res += user.getTransaction();
            }
            res = res.substring(0, res.length() - 1);
            res += "]";

            return res;
            
        }catch(Exception e){
            return e.getMessage();
        }

    }

    
}