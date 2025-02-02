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

public class Employee extends User {
    // รับวันที่ปัจจุบัน
    LocalDate current_date = LocalDate.now();
    // กำหนดรูปแบบการแสดงผล
    DateTimeFormatter format_date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    // แปลงและแสดงผลวันที่ปัจจุบัน
    String date_today = current_date.format(format_date);

    // Attributes

    // Default contructor
    public Employee() {
        super();
    }

    // Overload constructor
    public Employee(String user_id, String username, String password, String firstname, String lastname, String email, String tel, String role) {
        super(user_id, username, password, firstname, lastname, email, tel, role);
    }

    // Overload Methods

    // Methods
    public boolean authenticator_employee(String login_username_employee, String login_password_employee) {
        try {
            JSONArray users = load_from_file_employee("User.json");

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").equals(login_username_employee) && user.get("password").equals(login_password_employee) && user.get("role").equals("Employee")) {
                    return true;
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    private JSONArray load_from_file_employee(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader file = new FileReader(filename)) {
            Object obj = parser.parse(file);
            return (JSONArray) obj;
        }
    }

    // PrintInfo
    public void employee_profile_detail(String login_username_admin, String login_password_admin) {
        try {
            JSONArray employee = load_from_file_employee("User.json");

            for (Object obj : employee) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").equals(login_username_admin) && user.get("password").equals(login_password_admin)) {
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("| %-57s %58s |\n", "Profile Account ID : #" + user.get("user_id"), "Today's date : " + date_today);
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("| %-116s |\n", "Profile Detail");
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("| %-57s %-58s |\n", "- First Name : " + user.get("firstname"), "- Last Name : " + user.get("lastname"));
                    System.out.printf("| %-57s %-58s |\n", "- E-Mail : " + user.get("email"), "- Phone Number : " + user.get("tel"));
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    return;
                }
            }
            System.out.println("No matching employee found.");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
