// Import API
import java.io.Console;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class User {
    // รับวันที่ปัจจุบัน
    LocalDate current_date = LocalDate.now();
    // กำหนดรูปแบบการแสดงผล
    DateTimeFormatter format_date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // แปลงและแสดงผลวันที่ปัจจุบัน
    String date_today = current_date.format(format_date);

    // Attributes
    protected JSONArray user;

    private String user_id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private String tel;
    private String role;

    // Default contructor
    public User() {
        this.user = new JSONArray();
    }

    // Overload constructor
    public User(String user_id, String username, String password, String firstname, String lastname, String email, String tel, String role) {
        this();
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.tel = tel;
        this.role = role;
    }

    // Overload Methods

    // Methods
    public void add_user(User user) {
        JSONObject new_user = new JSONObject();
        new_user.put("user_id", user.getUser_id());
        new_user.put("username", user.getUsername());
        new_user.put("password", user.getPassword());
        new_user.put("firstname", user.getFirstname());
        new_user.put("lastname", user.getLastname());
        new_user.put("email", user.getEmail());
        new_user.put("tel", user.getTel());
        new_user.put("role", user.getRole());
        this.user.add(new_user);
    }

    public void save_to_file_user(String filename) throws IOException {
        try (FileWriter file = new FileWriter(filename)) {
            file.write(this.user.toJSONString());
        }
    }

    public void load_from_file_user(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader file = new FileReader(filename)) {
            Object obj = parser.parse(file);
            this.user = (JSONArray) obj;
        }
    }
    

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }
    public String getUser_id() {
        return user_id;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getLastname() {
        return lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public String getTel() {
        return tel;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    // PrintInfo
    public void admin_view_all_member() {
        for (Object obj : this.user) {
            JSONObject user = (JSONObject) obj;

            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-116s |\n", "Profile Account ID : #" + user.get("user_id"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %-58s |\n", "- First Name : " + user.get("firstname"), "- Last Name : " + user.get("lastname"));
            System.out.printf("| %-57s %-58s |\n", "- E-Mail : " + user.get("email"), "- Phone Number : " + user.get("tel"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");

        }
    }

    public void admin_view_all_admin() {
        for (Object obj : this.user) {
            JSONObject user = (JSONObject) obj;

            if (user.get("role").equals("Admin")) {

                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-116s |\n", "Profile Account ID : #" + user.get("user_id"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-57s %-58s |\n", "- First Name : " + user.get("firstname"), "- Last Name : " + user.get("lastname"));
                System.out.printf("| %-57s %-58s |\n", "- E-Mail : " + user.get("email"), "- Phone Number : " + user.get("tel"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");

            }
        }
    }

    public void admin_view_all_employee() {
        for (Object obj : this.user) {
            JSONObject user = (JSONObject) obj;

            if (user.get("role").equals("Employee")) {

                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-116s |\n", "Profile Account ID : #" + user.get("user_id"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-57s %-58s |\n", "- First Name : " + user.get("firstname"), "- Last Name : " + user.get("lastname"));
                System.out.printf("| %-57s %-58s |\n", "- E-Mail : " + user.get("email"), "- Phone Number : " + user.get("tel"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                
            }
        }
    }
}
