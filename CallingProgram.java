// Import API
import java.io.Console;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CallingProgram {
    public static void main(String[] args) {
        // รับวันที่ปัจจุบัน
        LocalDate current_date = LocalDate.now();
        // กำหนดรูปแบบการแสดงผล
        DateTimeFormatter format_date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // แปลงและแสดงผลวันที่ปัจจุบัน
        String date_today = current_date.format(format_date);
        
        // สร้างอ็อบเจ็กต์ของคลาส Random
        Random random = new Random();
        // เก็บตัวเลขสุ่มในรูปของสตริง
        
        StringBuilder random_number_work_receipt = new StringBuilder();
        StringBuilder random_number_bill_payment = new StringBuilder();
        StringBuilder random_number_receipt_payment = new StringBuilder();
        // สุ่มตัวเลข 10 หลัก
        
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10); // สุ่มตัวเลขระหว่าง 0 ถึง 9
            random_number_work_receipt.append(digit); // เพิ่มตัวเลขลงในสตริง
        }
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10); // สุ่มตัวเลขระหว่าง 0 ถึง 9
            random_number_bill_payment.append(digit); // เพิ่มตัวเลขลงในสตริง
        }
        for (int i = 0; i < 10; i++) {
            int digit = random.nextInt(10); // สุ่มตัวเลขระหว่าง 0 ถึง 9
            random_number_receipt_payment.append(digit); // เพิ่มตัวเลขลงในสตริง
        }

        Console console = System.console();
        if (console == null) {
            System.out.println("Console not available");
            System.exit(1);
        }
        Scanner kb = new Scanner(System.in);

        // Object
        User user = new User();
        Admin admin = new Admin();
        Employee employee = new Employee();
        Bill_payment bill_payment = new Bill_payment();
        Receipt_payment receipt_payment = new Receipt_payment();
        Work_receipt work_receipt = new Work_receipt();

        try {
            user.load_from_file_user("User.json");
            work_receipt.load_from_file_work_receipt("Work_receipt.json");
            bill_payment.load_from_file_bill_payment("Bill_payment.json");
            receipt_payment.load_from_file_receipt_payment("Receipt_payment.json");
        } catch (IOException | ParseException e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        // Program
        int main_menu_choice = 0;
        while (main_menu_choice != 9) {
            // ล้างหน้าจอ
            clearScreen();
            // แสดงชื่อโปรแกรม
            programName();
            // แสดงบริการ
            programService();
            // แสดงบทบาทผู้ใช้
            programUserrole();
            // ส่วนเมนูหลัก
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-116s |\n", "Main Menu");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-116s |\n", "- [1] Login to authenticator from Admin");
            System.out.printf("| %-116s |\n", "- [2] Login to authenticator from Employee");
            System.out.printf("| %-116s |\n", "- [3] Register to account Member");
            System.out.printf("| %-116s |\n", "- [9] Exit Program");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("Please select main menu [1-2 or exit 9] : ");
            while (true) {
                if (kb.hasNextInt()) {
                    main_menu_choice = kb.nextInt();
                    kb.nextLine();
                    break;
                } else {
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("Please select main menu [1-2 or exit 9] : ");
                    kb.next();
                }
            }
            switch (main_menu_choice) {
                case 9: // ส่วนระบบออกจากโปรแกรม
                    // ล้างหน้าจอ
                    clearScreen();
                    // แสดงชื่อโปรแกรม
                    programName();
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("| %-116s |\n", "Exit Program");
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    // System.out.printf("Press enter key to continue ... ");
                    // console.readPassword();
                    System.out.printf("Please wait 1 second for processing ... \n");
                    delay1();
                break;
                case 1: // ส่วนระบบแอดมิน
                    String login_username_admin = null;
                    String login_password_admin = null;

                    int login_admin_choice = 0;
                    while (login_admin_choice != 9) {
                        // ล้างหน้าจอ
                        clearScreen();
                        // แสดงชื่อโปรแกรม
                        programName();
                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("| %-116s |\n", "Login to authenticator from Admin");
                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("Please input a Username : ");
                        login_username_admin = kb.nextLine();
                        System.out.printf("Please input a Password : ");
                        login_password_admin = kb.nextLine();

                        // ตรวจสอบการเข้าสู่ระบบ Admin
                        if (admin.authenticator_admin(login_username_admin, login_password_admin)) {
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            System.out.printf("| %-116s |\n", "Login complete a Admin");
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            // System.out.printf("Press enter key to Menu Admin ... ");
                            // console.readPassword();
                            System.out.printf("Please wait 1 second for processing ... \n");
                            delay1();

                            int admin_menu_choice = 0;
                            while (admin_menu_choice != 9) {
                                // ล้างหน้าจอ
                                clearScreen();
                                // แสดงชื่อโปรแกรม
                                programName();
                                // แสดงข้อมูลบัญชีผู้ใช้
                                admin.admin_profile_detail(login_username_admin, login_password_admin);
    
                                // Menu Admin
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Menu for Admin");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "- [1] View all Member");
                                System.out.printf("| %-116s |\n", "- [2] View all Admin");
                                System.out.printf("| %-116s |\n", "- [3] View all Employee");
                                System.out.printf("| %-116s |\n", "- [4] View all Work Receipt");
                                System.out.printf("| %-116s |\n", "- [5] View all Bill Payment");
                                System.out.printf("| %-116s |\n", "- [6] View all Reciept Payment");
                                System.out.printf("| %-116s |\n", "- [9] Log Out");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("Please select menu [1-6 or Log Out 9] : ");
                                while (true) {
                                    if (kb.hasNextInt()) {
                                        admin_menu_choice = kb.nextInt();
                                        kb.nextLine();
                                        break;
                                    } else {
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("Please select menu [1-6 or Log Out 9] : ");
                                        kb.next();
                                    }
                                }
                                switch (admin_menu_choice) {
                                    case 9:
                                        // ล้างหน้าจอ
                                        clearScreen();
                                        // แสดงชื่อโปรแกรม
                                        programName();
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "Log Out");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        // System.out.printf("Press enter key to continue ... ");
                                        // console.readPassword();
                                        System.out.printf("Please wait 1 second for processing ... \n");
                                        delay1();
                                        // ออกจาก admin_menu_choice เข้า login_admin_choice
                                        admin_menu_choice = 9;
                                        // ออกจาก login_admin_choice เข้า main_menu_choice
                                        login_admin_choice = 9;
                                    break;
                                    case 1:
                                        // ล้างหน้าจอ
                                        clearScreen();
                                        // แสดงชื่อโปรแกรม
                                        programName();
                                        // แสดงข้อมูลบัญชีผู้ใช้
                                        admin.admin_profile_detail(login_username_admin, login_password_admin);
            
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "View all Member");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");

                                        user.admin_view_all_member();

                                        System.out.printf("Press enter key to Back menu Admin ... ");
                                        console.readPassword();
                                    break;
                                    case 2:
                                        // ล้างหน้าจอ
                                        clearScreen();
                                        // แสดงชื่อโปรแกรม
                                        programName();
                                        // แสดงข้อมูลบัญชีผู้ใช้
                                        admin.admin_profile_detail(login_username_admin, login_password_admin);
            
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "View all Admin");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");

                                        user.admin_view_all_admin();

                                        System.out.printf("Press enter key to Back menu Admin ... ");
                                        console.readPassword();
                                    break;
                                    case 3:
                                        // ล้างหน้าจอ
                                        clearScreen();
                                        // แสดงชื่อโปรแกรม
                                        programName();
                                        // แสดงข้อมูลบัญชีผู้ใช้
                                        admin.admin_profile_detail(login_username_admin, login_password_admin);
            
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "View all Employee");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");

                                        user.admin_view_all_employee();

                                        System.out.printf("Press enter key to Back menu Admin ... ");
                                        console.readPassword();
                                    break;
                                    case 4:
                                        // ล้างหน้าจอ
                                        clearScreen();
                                        // แสดงชื่อโปรแกรม
                                        programName();
                                        // แสดงข้อมูลบัญชีผู้ใช้
                                        admin.admin_profile_detail(login_username_admin, login_password_admin);
            
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "View all Work Receipt");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");

                                        work_receipt.admin_view_all_work_receipt();

                                        System.out.printf("Press enter key to Back menu Admin ... ");
                                        console.readPassword();
                                    break;
                                    case 5:
                                        // ล้างหน้าจอ
                                        clearScreen();
                                        // แสดงชื่อโปรแกรม
                                        programName();
                                        // แสดงข้อมูลบัญชีผู้ใช้
                                        admin.admin_profile_detail(login_username_admin, login_password_admin);
            
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "View all Bill Payment");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");

                                        bill_payment.admin_view_all_bill_payment();

                                        System.out.printf("Press enter key to Back menu Admin ... ");
                                        console.readPassword();
                                    break;
                                    case 6:
                                        // ล้างหน้าจอ
                                        clearScreen();
                                        // แสดงชื่อโปรแกรม
                                        programName();
                                        // แสดงข้อมูลบัญชีผู้ใช้
                                        admin.admin_profile_detail(login_username_admin, login_password_admin);
            
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "View all Reciept Payment");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        
                                        receipt_payment.admin_view_all_receipt_payment();

                                        System.out.printf("Press enter key to Back menu Admin ... ");
                                        console.readPassword();
                                    break;
                                
                                    default:
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("| %-116s |\n", "Selected menu invalid. Please try again.");
                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                        System.out.printf("Press enter key to continue ... ");
                                        console.readPassword();
                                    break;
                                }
                            }
                        } else {
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            System.out.printf("| %-116s |\n", "Login failed. Username or Password is incorrect. Please try again.");
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            System.out.printf("Press enter key to Main Menu ... ");
                            console.readPassword();
                            // ออกจาก login_admin_choice เข้า main_menu_choice
                            login_admin_choice = 9;
                        }
                    }
                break;
                case 2: // ส่วนระบบพนักงาน
                    String login_username_employee = null;
                    String login_password_employee = null;

                    int login_employee_choice = 0;
                    while (login_employee_choice != 9) {

                        // ล้างหน้าจอ
                        clearScreen();
                        // แสดงชื่อโปรแกรม
                        programName();
                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("| %-116s |\n", "Login to authenticator from Employee");
                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("Please input a Username : ");
                        login_username_employee = kb.nextLine();
                        System.out.printf("Please input a Password : ");
                        login_password_employee = kb.nextLine();

                        // ตรวจสอบการเข้าสู่ระบบ Employee
                        if (employee.authenticator_employee(login_username_employee, login_password_employee)) {
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            System.out.printf("| %-116s |\n", "Login complete a Employee");
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            // System.out.printf("Press enter key to Menu Employee ... ");
                            // console.readPassword();
                            System.out.printf("Please wait 1 second for processing ... \n");
                            delay1();

                            JSONParser parser_user = new JSONParser();
                            try {
                                Reader reader_user = new FileReader("User.json");
                                JSONArray jsonArray_user = (JSONArray) parser_user.parse(reader_user);
    
                                for (Object obj : jsonArray_user) {
                                    JSONObject jsonObject_user = (JSONObject) obj;
                                    if (jsonObject_user.get("username").equals(login_username_employee) && jsonObject_user.get("password").equals(login_password_employee)) {
        
                                        String v_user_id = (String) jsonObject_user.get("user_id");
                                        String v_username = (String) jsonObject_user.get("username");
                                        String v_password = (String) jsonObject_user.get("password");
                                        String v_firstname = (String) jsonObject_user.get("firstname");
                                        String v_lastname = (String) jsonObject_user.get("lastname");
                                        String v_email = (String) jsonObject_user.get("email");
                                        String v_tel = (String) jsonObject_user.get("tel");
                                        String v_role = (String) jsonObject_user.get("role");

                                        int employee_menu_choice = 0;
                                        while (employee_menu_choice != 9) {
                                            // ล้างหน้าจอ
                                            clearScreen();
                                            // แสดงชื่อโปรแกรม
                                            programName();
                                            // แสดงข้อมูลบัญชีผู้ใช้
                                            employee.employee_profile_detail(login_username_employee, login_password_employee);
                
                                            // Menu Employee
                                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                            System.out.printf("| %-116s |\n", "Menu for Employee");
                                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                            System.out.printf("| %-116s |\n", "- [1] Accepting Work");
                                            System.out.printf("| %-116s |\n", "- [2] View Work Receipt");
                                            System.out.printf("| %-116s |\n", "- [3] View Bill Payment");
                                            System.out.printf("| %-116s |\n", "- [4] View Reciept Payment");
                                            System.out.printf("| %-116s |\n", "- [9] Log Out");
                                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                            System.out.printf("Please select menu [1-4 or Log Out 9] : ");
                                            while (true) {
                                                if (kb.hasNextInt()) {
                                                    employee_menu_choice = kb.nextInt();
                                                    kb.nextLine();
                                                    break;
                                                } else {
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("Please select menu [1-4 or Log Out 9] : ");
                                                    kb.next();
                                                }
                                            }
                                            switch (employee_menu_choice) {
                                                case 9:
                                                    // ล้างหน้าจอ
                                                    clearScreen();
                                                    // แสดงชื่อโปรแกรม
                                                    programName();
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "Log Out");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    // System.out.printf("Press enter key to continue ... ");
                                                    // console.readPassword();
                                                    System.out.printf("Please wait 1 second for processing ... \n");
                                                    delay1();
                                                    // ออกจาก employee_menu_choice เข้า login_employee_choice
                                                    employee_menu_choice = 9;
                                                    // ออกจาก login_employee_choice เข้า main_menu_choice
                                                    login_employee_choice = 9;
                                                break;
                                                case 1:
                                                    String work_receipt_id = null;
                                                    String bill_payment_id = null;
                                                    String receipt_payment_id = null;

                                                    int cat1 = 0;
                                                    int cat2 = 0;
                                                    int cat3 = 0;
                                                    int cat4 = 0;
                                                    int cat5 = 0;
            
                                                    int qt1 = 0;
                                                    int qt2 = 0;
                                                    int qt3 = 0;
                                                    int qt4 = 0;
                                                    int qt5 = 0;
            
                                                    Double pri1 = 0.00;
                                                    Double pri2 = 0.00;
                                                    Double pri3 = 0.00;
                                                    Double pri4 = 0.00;
                                                    Double pri5 = 0.00;
            
                                                    Double pri_t1 = 0.00;
                                                    Double pri_t2 = 0.00;
                                                    Double pri_t3 = 0.00;
                                                    Double pri_t4 = 0.00;
                                                    Double pri_t5 = 0.00;
            
                                                    Double total_price = 0.00;
                                                    Double discount = 0.00;
                                                    Double net_amount = 0.00;
                                                    Double net_change = 0.00;
            
                                                    String service_staff_name = v_firstname + " " + v_lastname;
                                                    String service_staff_id = v_user_id;
                                                    String transaction_date = null;
                                                    String customer_fullname = null;
                                                    String customer_tel = null;
                                                    String menu_cat_choice_cont = null;
                                                    Double get_money = 0.00;
            
                                                    // ล้างหน้าจอ
                                                    clearScreen();
                                                    // แสดงชื่อโปรแกรม
                                                    programName();
                                                    // แสดงข้อมูลบัญชีผู้ใช้
                                                    employee.employee_profile_detail(login_username_employee, login_password_employee);
                        
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "Accepting Work");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    
                                                    // 1# กรอกข้อมูลลุกค้า
                                                    System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "1# Customer Detail");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("Please input a full name : ");
                                                    customer_fullname = kb.nextLine();
                                                    System.out.printf("Please input a tel : ");
                                                    customer_tel = kb.nextLine();
            
                                                    int menu_cat_choice = 0;
                                                    while (menu_cat_choice != 9) {
                                                        // 2# เลือกหมวดหมู่งาน
                                                        System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                        System.out.printf("| %-116s |\n", "2# Category");
                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                        System.out.printf("| %-57s %-58s |\n", "Service Name", "Service Fee");
                                                        System.out.printf("| %-57s %-58s |\n", "- [1] Basic computer check", "- [1] 100 Baht / Computer");
                                                        System.out.printf("| %-57s %-58s |\n", "- [2] Computer repair", "- [2] 300 Baht / Computer (not including material costs)");
                                                        System.out.printf("| %-57s %-58s |\n", "- [3] Basic software installation", "- [3] 200 Baht / Device");
                                                        System.out.printf("| %-57s %-58s |\n", "- [4] Data recovery (in case of lost data)", "- [4] 200 Baht / Time");
                                                        System.out.printf("| %-57s %-58s |\n", "- [5] Others", "- [5] 100 Baht / Time");
                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                        System.out.printf("Please select menu category [1-5] : ");
                                                        while (true) {
                                                            if (kb.hasNextInt()) {
                                                                menu_cat_choice = kb.nextInt();
                                                                kb.nextLine();
                                                                break;
                                                            } else {
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please select menu category [1-5] : ");
                                                                kb.next();
                                                            }
                                                        }
                                                        switch (menu_cat_choice) {
                                                            case 1:
                                                                cat1 = 1;
                                                                pri1 = 100.00;
            
                                                                // 3# กรอกจำนวนอุปกรณ์หรือจำนวนเครื่อง
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "3# Quantity");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a quantity : ");
                                                                while (true) {
                                                                    if (kb.hasNextInt()) {
                                                                        qt1 = kb.nextInt();
                                                                        kb.nextLine();
                                                                        break;
                                                                    } else {
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("Please input a quantity : ");
                                                                        kb.next();
                                                                    }
                                                                }
                                                                
                                                                // 4# ต้องการเพิ่มรายการอื่นหรือไม่?
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "4# Do you want to add another list?");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a key [y/n] : ");
                                                                menu_cat_choice_cont = kb.nextLine();
                                                                // ตรวจสอบว่าต้องการทำรายการอื่นอีกมั้ย
                                                                if (menu_cat_choice_cont.equals("n") || menu_cat_choice_cont.equals("N")) {
                                                                    // ออก menu_cat_choice
                                                                    menu_cat_choice = 9;
                                                                } else if (menu_cat_choice_cont.equals("y") || menu_cat_choice_cont.equals("Y")) {
                                                                    break;
                                                                }
                                                            break;
                                                            case 2:
                                                                cat2 = 1;
                                                                pri2 = 300.00;
            
                                                                // 3# กรอกจำนวนอุปกรณ์หรือจำนวนเครื่อง
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "3# Quantity");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a quantity : ");
                                                                while (true) {
                                                                    if (kb.hasNextInt()) {
                                                                        qt2 = kb.nextInt();
                                                                        kb.nextLine();
                                                                        break;
                                                                    } else {
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("Please input a quantity : ");
                                                                        kb.next();
                                                                    }
                                                                }
                                                                
                                                                // 4# ต้องการเพิ่มรายการอื่นหรือไม่?
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "4# Do you want to add another list?");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a key [y/n] : ");
                                                                menu_cat_choice_cont = kb.nextLine();
                                                                // ตรวจสอบว่าต้องการทำรายการอื่นอีกมั้ย
                                                                if (menu_cat_choice_cont.equals("n") || menu_cat_choice_cont.equals("N")) {
                                                                    // ออก menu_cat_choice
                                                                    menu_cat_choice = 9;
                                                                } else if (menu_cat_choice_cont.equals("y") || menu_cat_choice_cont.equals("Y")) {
                                                                    break;
                                                                }
                                                            break;
                                                            case 3:
                                                                cat3 = 1;
                                                                pri3 = 200.00;
            
                                                                // 3# กรอกจำนวนอุปกรณ์หรือจำนวนเครื่อง
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "3# Quantity");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a quantity : ");
                                                                while (true) {
                                                                    if (kb.hasNextInt()) {
                                                                        qt3 = kb.nextInt();
                                                                        kb.nextLine();
                                                                        break;
                                                                    } else {
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("Please input a quantity : ");
                                                                        kb.next();
                                                                    }
                                                                }
                                                                
                                                                // 4# ต้องการเพิ่มรายการอื่นหรือไม่?
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "4# Do you want to add another list?");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a key [y/n] : ");
                                                                menu_cat_choice_cont = kb.nextLine();
                                                                // ตรวจสอบว่าต้องการทำรายการอื่นอีกมั้ย
                                                                if (menu_cat_choice_cont.equals("n") || menu_cat_choice_cont.equals("N")) {
                                                                    // ออก menu_cat_choice
                                                                    menu_cat_choice = 9;
                                                                } else if (menu_cat_choice_cont.equals("y") || menu_cat_choice_cont.equals("Y")) {
                                                                    break;
                                                                }
                                                            break;
                                                            case 4:
                                                                cat4 = 1;
                                                                pri4 = 200.00;
            
                                                                // 3# กรอกจำนวนอุปกรณ์หรือจำนวนเครื่อง
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "3# Quantity");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a quantity : ");
                                                                while (true) {
                                                                    if (kb.hasNextInt()) {
                                                                        qt4 = kb.nextInt();
                                                                        kb.nextLine();
                                                                        break;
                                                                    } else {
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("Please input a quantity : ");
                                                                        kb.next();
                                                                    }
                                                                }
                                                                
                                                                // 4# ต้องการเพิ่มรายการอื่นหรือไม่?
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "4# Do you want to add another list?");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a key [y/n] : ");
                                                                menu_cat_choice_cont = kb.nextLine();
                                                                // ตรวจสอบว่าต้องการทำรายการอื่นอีกมั้ย
                                                                if (menu_cat_choice_cont.equals("n") || menu_cat_choice_cont.equals("N")) {
                                                                    // ออก menu_cat_choice
                                                                    menu_cat_choice = 9;
                                                                } else if (menu_cat_choice_cont.equals("y") || menu_cat_choice_cont.equals("Y")) {
                                                                    break;
                                                                }
                                                            break;
                                                            case 5:
                                                                cat5 = 1;
                                                                pri5 = 100.00;
            
                                                                // 3# กรอกจำนวนอุปกรณ์หรือจำนวนเครื่อง
                                                                System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "3# Quantity");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a quantity : ");
                                                                while (true) {
                                                                    if (kb.hasNextInt()) {
                                                                        qt5 = kb.nextInt();
                                                                        kb.nextLine();
                                                                        break;
                                                                    } else {
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("Please input a quantity : ");
                                                                        kb.next();
                                                                    }
                                                                }
                                                                
                                                                // 4# ต้องการเพิ่มรายการอื่นหรือไม่?
                                                                while (true) {
                                                                    System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
                                                                    System.out.printf("| %-116s |\n", "4# Do you want to add another list?");
                                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                    System.out.printf("Please input a key [y/n] : ");
                                                                    menu_cat_choice_cont = kb.nextLine();
                                                                    
                                                                    // ตรวจสอบว่าต้องการทำรายการอื่นอีกมั้ย
                                                                    if (menu_cat_choice_cont.equalsIgnoreCase("n")) {
                                                                        // ออก menu_cat_choice
                                                                        menu_cat_choice = 9;
                                                                        break;
                                                                    } else if (menu_cat_choice_cont.equalsIgnoreCase("y")) {
                                                                        break;
                                                                    } else {
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                        System.out.printf("| %-116s |\n", "Invalid input. Please enter an [n/N] or [y/Y] ...");
                                                                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                    }
                                                                }
                                                                

                                                            break;
                                                        
                                                            default:
                                                            break;
                                                        }
                
                                                        
                                                    }

                                                    // คำนวนราคารวม
                                                    pri_t1 = pri1 * qt1;
                                                    pri_t2 = pri2 * qt2;
                                                    pri_t3 = pri3 * qt3;
                                                    pri_t4 = pri4 * qt4;
                                                    pri_t5 = pri5 * qt5;
                                                    total_price = pri_t1 + pri_t2 + pri_t3 + pri_t4 + pri_t5;

                                                    // คำนวนส่วนลด 2% เมื่อราคารวมมากกว่า 1 พันบาท
                                                    if (total_price > 1000.00) {
                                                        discount = total_price * 2 / 100;
                                                    } else {
                                                        discount = 0.00;
                                                    }

                                                    // คำนวนราคาสุทธิ
                                                    net_amount = total_price - discount;

                                                    
                                                    work_receipt_id = random_number_work_receipt.toString();
                                                    transaction_date = date_today;
                                                    // ตรวจสอบว่า randomNumber ถูกกำหนดค่าหรือไม่
                                                    if (random_number_work_receipt != null) {
                                                        work_receipt_id = random_number_work_receipt.toString();
                                                        transaction_date = date_today;

                                                        Work_receipt work_receipt_new = new Work_receipt();
                                                        work_receipt_new.setWork_id(work_receipt_id);
                                                        work_receipt_new.setService_staff_name(service_staff_name);
                                                        work_receipt_new.setService_staff_id(service_staff_id);
                                                        work_receipt_new.setTransaction_date(transaction_date);
                                                        work_receipt_new.setCustomer_fullname(customer_fullname);
                                                        work_receipt_new.setCustomer_tel(customer_tel);
                                                        work_receipt_new.setCat1(cat1);
                                                        work_receipt_new.setCat2(cat2);
                                                        work_receipt_new.setCat3(cat3);
                                                        work_receipt_new.setCat4(cat4);
                                                        work_receipt_new.setCat5(cat5);
                                                        work_receipt_new.setQt1(qt1);
                                                        work_receipt_new.setQt2(qt2);
                                                        work_receipt_new.setQt3(qt3);
                                                        work_receipt_new.setQt4(qt4);
                                                        work_receipt_new.setQt5(qt5);
                                                        work_receipt_new.setPri_t1(pri_t1);
                                                        work_receipt_new.setPri_t2(pri_t2);
                                                        work_receipt_new.setPri_t3(pri_t3);
                                                        work_receipt_new.setPri_t4(pri_t4);
                                                        work_receipt_new.setPri_t5(pri_t5);

                                                        work_receipt.add_work(work_receipt_new);
                                                        try {
                                                            work_receipt.save_to_file_work_receipt("Work_receipt.json");
                                                        } catch (IOException e) {
                                                            System.out.println("Error saving work receipt data: " + e.getMessage());
                                                        }
                                                    } else {
                                                        System.out.println("Error: random_number_work_receipt is not initialized");
                                                    }
            
                                                    System.out.printf("Please wait 1 second for processing ... \n");
                                                    delay1();
            
                                                    // 5# ใบรับงาน
                                                    work_receipt.printInfo();
                                                    
                                                    System.out.printf("Please wait 1 second for processing ... \n");
                                                    delay1();
            
                                                    if (random_number_bill_payment != null) {
                                                        bill_payment_id = random_number_bill_payment.toString();
                                                        transaction_date = date_today;

                                                        Bill_payment bill_payment_new = new Bill_payment();
                                                        bill_payment_new.setWork_id(work_receipt_id);
                                                        bill_payment_new.setBill_id(bill_payment_id);
                                                        bill_payment_new.setService_staff_name(service_staff_name);
                                                        bill_payment_new.setService_staff_id(service_staff_id);
                                                        bill_payment_new.setTransaction_date(transaction_date);
                                                        bill_payment_new.setCustomer_fullname(customer_fullname);
                                                        bill_payment_new.setCustomer_tel(customer_tel);
                                                        bill_payment_new.setCat1(cat1);
                                                        bill_payment_new.setCat2(cat2);
                                                        bill_payment_new.setCat3(cat3);
                                                        bill_payment_new.setCat4(cat4);
                                                        bill_payment_new.setCat5(cat5);
                                                        bill_payment_new.setQt1(qt1);
                                                        bill_payment_new.setQt2(qt2);
                                                        bill_payment_new.setQt3(qt3);
                                                        bill_payment_new.setQt4(qt4);
                                                        bill_payment_new.setQt5(qt5);
                                                        bill_payment_new.setPri_t1(pri_t1);
                                                        bill_payment_new.setPri_t2(pri_t2);
                                                        bill_payment_new.setPri_t3(pri_t3);
                                                        bill_payment_new.setPri_t4(pri_t4);
                                                        bill_payment_new.setPri_t5(pri_t5);
                                                        bill_payment_new.setTotal_price(total_price);
                                                        bill_payment_new.setDiscount(discount);
                                                        bill_payment_new.setNet_amount(net_amount);

                                                        bill_payment.add_bill_payment(bill_payment_new);
                                                        try {
                                                            bill_payment.save_to_file_bill_payment("Bill_payment.json");
                                                        } catch (IOException e) {
                                                            System.out.println("Error saving bill payment data: " + e.getMessage());
                                                        }
                                                    } else {
                                                        System.out.println("Error: random_number_bill_payment is not initialized");
                                                    }
                                                    // 6# ใบรับชำระเงิน
                                                    bill_payment.printInfo();

                                                    System.out.printf("Please input a get money : ");
                                                    while (true) {
                                                        if (kb.hasNextDouble()) {
                                                            get_money = kb.nextDouble();
                                                            if (get_money >= net_amount) {
                                                                break;
                                                            } else {
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("| %-116s |\n", "Invalid input. Please enter an amount greater than or equal to net amount ...");
                                                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                                System.out.printf("Please input a get money : ");
                                                            }
                                                        } else {
                                                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                            System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer or double ...");
                                                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                            System.out.printf("Please input a get money : ");
                                                            kb.next();
                                                        }
                                                    }

                                                    // คำนวนเงินจากลูกค้า
                                                    net_change = get_money - net_amount;
                                                    
                                                    System.out.printf("Please wait 1 second for processing ... \n");
                                                    delay1();

                                                    if (random_number_receipt_payment != null) {
                                                        receipt_payment_id = random_number_receipt_payment.toString();
                                                        transaction_date = date_today;

                                                        Receipt_payment receipt_payment_new = new Receipt_payment();
                                                        receipt_payment_new.setWork_id(work_receipt_id);
                                                        receipt_payment_new.setBill_id(bill_payment_id);
                                                        receipt_payment_new.setReceipt_id(receipt_payment_id);
                                                        receipt_payment_new.setService_staff_name(service_staff_name);
                                                        receipt_payment_new.setService_staff_id(service_staff_id);
                                                        receipt_payment_new.setTransaction_date(transaction_date);
                                                        receipt_payment_new.setCustomer_fullname(customer_fullname);
                                                        receipt_payment_new.setCustomer_tel(customer_tel);
                                                        receipt_payment_new.setCat1(cat1);
                                                        receipt_payment_new.setCat2(cat2);
                                                        receipt_payment_new.setCat3(cat3);
                                                        receipt_payment_new.setCat4(cat4);
                                                        receipt_payment_new.setCat5(cat5);
                                                        receipt_payment_new.setQt1(qt1);
                                                        receipt_payment_new.setQt2(qt2);
                                                        receipt_payment_new.setQt3(qt3);
                                                        receipt_payment_new.setQt4(qt4);
                                                        receipt_payment_new.setQt5(qt5);
                                                        receipt_payment_new.setPri_t1(pri_t1);
                                                        receipt_payment_new.setPri_t2(pri_t2);
                                                        receipt_payment_new.setPri_t3(pri_t3);
                                                        receipt_payment_new.setPri_t4(pri_t4);
                                                        receipt_payment_new.setPri_t5(pri_t5);
                                                        receipt_payment_new.setTotal_price(total_price);
                                                        receipt_payment_new.setDiscount(discount);
                                                        receipt_payment_new.setNet_amount(net_amount);
                                                        receipt_payment_new.setGet_money(get_money);
                                                        receipt_payment_new.setNet_change(net_change);

                                                        receipt_payment.add_receipt_payment(receipt_payment_new);
                                                        try {
                                                            receipt_payment.save_to_file_receipt_payment("Receipt_payment.json");
                                                        } catch (IOException e) {
                                                            System.out.println("Error saving receipt payment data: " + e.getMessage());
                                                        }
                                                    } else {
                                                        System.out.println("Error: random_number_receipt_payment is not initialized");
                                                    }
            
                                                    // 7# ใบเสร็จรับเงิน
                                                    receipt_payment.printInfo();
                                                    
                                                    System.out.printf("Transaction Complete ... \n");
                                                    System.out.printf("Press enter key to Back menu Employee ... ");
                                                    console.readPassword();
                                                break;
                                                case 2:
                                                    // ล้างหน้าจอ
                                                    clearScreen();
                                                    // แสดงชื่อโปรแกรม
                                                    programName();
                                                    // แสดงข้อมูลบัญชีผู้ใช้
                                                    employee.employee_profile_detail(login_username_employee, login_password_employee);
                        
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "View Work Receipt");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                
                                                    work_receipt.employee_view_work_receipt(v_user_id);

                                                    System.out.printf("Press enter key to Back menu Employee ... ");
                                                    console.readPassword();
                                                break;
                                                case 3:
                                                    // ล้างหน้าจอ
                                                    clearScreen();
                                                    // แสดงชื่อโปรแกรม
                                                    programName();
                                                    // แสดงข้อมูลบัญชีผู้ใช้
                                                    employee.employee_profile_detail(login_username_employee, login_password_employee);
                        
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "View Bill Payment");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                
                                                    bill_payment.employee_view_bill_payment(v_user_id);

                                                    System.out.printf("Press enter key to Back menu Employee ... ");
                                                    console.readPassword();
                                                break;
                                                case 4:
                                                    // ล้างหน้าจอ
                                                    clearScreen();
                                                    // แสดงชื่อโปรแกรม
                                                    programName();
                                                    // แสดงข้อมูลบัญชีผู้ใช้
                                                    employee.employee_profile_detail(login_username_employee, login_password_employee);
                        
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "View Reciept Payment");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                
                                                    receipt_payment.employee_view_receipt_payment(v_user_id);

                                                    System.out.printf("Press enter key to Back menu Employee ... ");
                                                    console.readPassword();
                                                break;
                                            
                                                default:
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("| %-116s |\n", "Selected menu invalid. Please try again.");
                                                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                                    System.out.printf("Press enter key to continue ... ");
                                                    console.readPassword();
                                                break;
                                            }
                                        }

                                    }
                                }
                            } catch (IOException | ParseException e) {
                                e.printStackTrace();
                            }

                        } else {
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            System.out.printf("| %-116s |\n", "Login failed. Username or Password is incorrect. Please try again.");
                            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            System.out.printf("Press enter key to Main Menu ... ");
                            console.readPassword();
                            // ออกจาก login_employee_choice เข้า main_menu_choice
                            login_employee_choice = 9;
                        }
                    }
                break;
                case 3: // ส่วนระบบสมัครสมาชิก
                    String register_user_id = null;
                    String register_username = null;
                    String register_password = null;
                    String register_firstname = null;
                    String register_lastname = null;
                    String register_email = null;
                    String register_tel = null;
                    String register_role = null;

                    int register_menu_choice = 0;
                    while (register_menu_choice != 9) {
                        // ล้างหน้าจอ
                        clearScreen();
                        // แสดงชื่อโปรแกรม
                        programName();
                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("| %-116s |\n", "Register to account Member");
                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("| %-116s |\n", "- [1] Register to account Admin");
                        System.out.printf("| %-116s |\n", "- [2] Register to account Employee");
                        System.out.printf("| %-116s |\n", "- [9] Main Menu");
                        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                        System.out.printf("Please select register menu [1-2 or main menu 9] : ");
                        while (true) {
                            if (kb.hasNextInt()) {
                                register_menu_choice = kb.nextInt();
                                kb.nextLine();
                                break;
                            } else {
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Invalid input. Please enter an integer ...");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("Please select register menu [1-2 or main menu 9] : ");
                                kb.next();
                            }
                        }
                        switch (register_menu_choice) {
                            case 9:
                                // ล้างหน้าจอ
                                clearScreen();
                                // แสดงชื่อโปรแกรม
                                programName();
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Main Menu");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                            break;
                            case 1:
                                // ล้างหน้าจอ
                                clearScreen();
                                // แสดงชื่อโปรแกรม
                                programName();
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Register to account Admin");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("Please input a Username : ");
                                register_username = kb.nextLine();
                                System.out.printf("Please input a Password : ");
                                register_password = kb.nextLine();
                                System.out.printf("Please input a First Name : ");
                                register_firstname = kb.nextLine();
                                System.out.printf("Please input a Last Name : ");
                                register_lastname = kb.nextLine();
                                System.out.printf("Please input a E-Mail : ");
                                register_email = kb.nextLine();
                                System.out.printf("Please input a Phone Number : ");
                                register_tel = kb.nextLine();
                                System.out.printf("Member Role : Admin\n");
                                register_role = "Admin";

                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Register complete a Admin");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("Press enter key to back Main Menu ... ");
                            break;
                            case 2:
                                // ล้างหน้าจอ
                                clearScreen();
                                // แสดงชื่อโปรแกรม
                                programName();
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Register to account Employee");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("Please input a Username : ");
                                register_username = kb.nextLine();
                                System.out.printf("Please input a Password : ");
                                register_password = kb.nextLine();
                                System.out.printf("Please input a First Name : ");
                                register_firstname = kb.nextLine();
                                System.out.printf("Please input a Last Name : ");
                                register_lastname = kb.nextLine();
                                System.out.printf("Please input a E-Mail : ");
                                register_email = kb.nextLine();
                                System.out.printf("Please input a Phone Number : ");
                                register_tel = kb.nextLine();
                                System.out.printf("Member Role : Employee\n");
                                register_role = "Employee";

                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Register complete a Employee");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("Press enter key to back Main Menu ... ");
                            break;
                        
                            default:
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("| %-116s |\n", "Selected menu invalid. Please try again.");
                                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                                System.out.printf("Press enter key to continue ... ");
                                console.readPassword();
                            break;
                        }

                        if (register_menu_choice == 1 || register_menu_choice == 2) {

                            StringBuilder random_number_user_id = new StringBuilder();
                            for (int i = 0; i < 10; i++) {
                                int digit = random.nextInt(10); // สุ่มตัวเลขระหว่าง 0 ถึง 9
                                random_number_user_id.append(digit); // เพิ่มตัวเลขลงในสตริง
                            }
                            
                            if (random_number_user_id != null) {
                                register_user_id = random_number_user_id.toString();

                                User new_user = new User();
                                new_user.setUser_id(register_user_id);
                                new_user.setUsername(register_username);
                                new_user.setPassword(register_password);
                                new_user.setFirstname(register_firstname);
                                new_user.setLastname(register_lastname);
                                new_user.setEmail(register_email);
                                new_user.setTel(register_tel);
                                new_user.setRole(register_role);
                                user.add_user(new_user);
                                
                                try {
                                    user.save_to_file_user("User.json");
                                } catch (IOException e) {
                                    System.out.println("Error saving user data: " + e.getMessage());
                                }
                                
                            } else {
                                System.out.println("Error: random_number_user_id is not initialized");
                            }
                            
                            // ออกจาก register_menu_choice เข้า main_menu_choice
                            console.readPassword();
                            register_menu_choice = 9;
                        }
                    }
                break;
            
                default:
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("| %-116s |\n", "Selected menu invalid. Please try again.");
                    System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                    System.out.printf("Press enter key to continue ... ");
                    console.readPassword();
                break;
            }
        }

        kb.close();
    }

    // ฟังก์ชันแสดง programName
    public static void programName() {
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| %-116s |\n", "                                       Computer Repair Notification Systems");
        System.out.printf("| %-116s |\n", "                         IT Service, Office of Digital Innovation and Intelligent Systems,");
        System.out.printf("| %-116s |\n", "                                    Prince of Songkla University Hatyai Campus");
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
    }

    // ฟังก์ชันแสดง programService
    public static void programService() {
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| %-116s |\n", "Our Service");
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| %-57s %-58s |\n", "Service Name", "Service Fee");
        System.out.printf("| %-57s %-58s |\n", "- [1] Basic computer check", "- [1] 100 Baht / Computer");
        System.out.printf("| %-57s %-58s |\n", "- [2] Computer repair", "- [2] 300 Baht / Computer (not including material costs)");
        System.out.printf("| %-57s %-58s |\n", "- [3] Basic software installation", "- [3] 200 Baht / Device");
        System.out.printf("| %-57s %-58s |\n", "- [4] Data recovery (in case of lost data)", "- [4] 200 Baht / Time");
        System.out.printf("| %-57s %-58s |\n", "- [5] Others", "- [5] 100 Baht / Time");
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
    }

    // ฟังก์ชันแสดง programUserrole
    public static void programUserrole() {
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| %-116s |\n", "Who has the right to use the program");
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
        System.out.printf("| %-116s |\n", "- [1] Admin");
        System.out.printf("| %-116s |\n", "- [2] Employee");
        System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
    }

    // ฟังก์ชันสำหรับล้างหน้าจอ
    public static void clearScreen() {  
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                new ProcessBuilder("clear").inheritIO().start().waitFor();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // ฟังก์ชันสำหรับดีเลย์ 1 วินาที
    public static void delay1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}