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

public class Work_receipt extends Employee {
    // Attributes
    private JSONArray work_receipt;

    private String work_receipt_id;
    
    private String service_staff_name;
    private String service_staff_id;
    private String transaction_date;
    private String customer_fullname;
    private String customer_tel;

    private int cat1;
    private int cat2;
    private int cat3;
    private int cat4;
    private int cat5;

    private int qt1;
    private int qt2;
    private int qt3;
    private int qt4;
    private int qt5;

    private Double pri_t1;
    private Double pri_t2;
    private Double pri_t3;
    private Double pri_t4;
    private Double pri_t5;

    // Default contructor
    public Work_receipt() {
        this.work_receipt = new JSONArray();
    }
    
    // Overload constructor
    public Work_receipt(String work_receipt_id, String service_staff_name, String service_staff_id, String transaction_date, String customer_fullname, String customer_tel, int cat1, int cat2, int cat3, int cat4, int cat5, int qt1, int qt2, int qt3, int qt4, int qt5, double pri_t1, double pri_t2, double pri_t3, double pri_t4, double pri_t5) {
        this.work_receipt_id = work_receipt_id;

        this.service_staff_name = service_staff_name;
        this.service_staff_id = service_staff_id;
        this.transaction_date = transaction_date;
        this.customer_fullname = customer_fullname;
        this.customer_tel = customer_tel;

        this.cat1 = cat1;
        this.cat2 = cat2;
        this.cat3 = cat3;
        this.cat4 = cat4;
        this.cat5 = cat5;

        this.qt1 = qt1;
        this.qt2 = qt2;
        this.qt3 = qt3;
        this.qt4 = qt4;
        this.qt5 = qt5;

        this.pri_t1 = pri_t1;
        this.pri_t2 = pri_t2;
        this.pri_t3 = pri_t3;
        this.pri_t4 = pri_t4;
        this.pri_t5 = pri_t5;
    }

    // Overload Methods

    // Methods
    public void add_work(Work_receipt work_receipt) {
        JSONObject new_work = new JSONObject();
        new_work.put("work_receipt_id", work_receipt.getWork_id());
        new_work.put("service_staff_name", work_receipt.getService_staff_name());
        new_work.put("service_staff_id", work_receipt.getService_staff_id());
        new_work.put("transaction_date", work_receipt.getTransaction_date());
        new_work.put("customer_fullname", work_receipt.getCustomer_fullname());
        new_work.put("customer_tel", work_receipt.getCustomer_tel());
        new_work.put("cat1", work_receipt.getCat1());
        new_work.put("cat2", work_receipt.getCat2());
        new_work.put("cat3", work_receipt.getCat3());
        new_work.put("cat4", work_receipt.getCat4());
        new_work.put("cat5", work_receipt.getCat5());
        new_work.put("qt1", work_receipt.getQt1());
        new_work.put("qt2", work_receipt.getQt2());
        new_work.put("qt3", work_receipt.getQt3());
        new_work.put("qt4", work_receipt.getQt4());
        new_work.put("qt5", work_receipt.getQt5());
        new_work.put("pri_t1", work_receipt.getPri_t1());
        new_work.put("pri_t2", work_receipt.getPri_t2());
        new_work.put("pri_t3", work_receipt.getPri_t3());
        new_work.put("pri_t4", work_receipt.getPri_t4());
        new_work.put("pri_t5", work_receipt.getPri_t5());
        this.work_receipt.add(new_work);
    }
    
    public void save_to_file_work_receipt(String filename) throws IOException {
        try (FileWriter file = new FileWriter(filename)) {
            file.write(this.work_receipt.toJSONString());
        }
    }

    public void load_from_file_work_receipt(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader file = new FileReader(filename)) {
            Object obj = parser.parse(file);
            this.work_receipt = (JSONArray) obj;
        }
    }

    public void setWork_id(String work_receipt_id) {
        this.work_receipt_id = work_receipt_id;
    }
    public String getWork_id() {
        return work_receipt_id;
    }

    public void setService_staff_name(String service_staff_name) {
        this.service_staff_name = service_staff_name;
    }
    public String getService_staff_name() {
        return service_staff_name;
    }

    public void setService_staff_id(String service_staff_id) {
        this.service_staff_id = service_staff_id;
    }
    public String getService_staff_id() {
        return service_staff_id;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }
    public String getTransaction_date() {
        return transaction_date;
    }

    public void setCustomer_fullname(String customer_fullname) {
        this.customer_fullname = customer_fullname;
    }
    public String getCustomer_fullname() {
        return customer_fullname;
    }

    public void setCustomer_tel(String customer_tel) {
        this.customer_tel = customer_tel;
    }
    public String getCustomer_tel() {
        return customer_tel;
    }

    public void setCat1(Integer cat1) {
        this.cat1 = cat1;
    }
    public Integer getCat1() {
        return cat1;
    }

    public void setCat2(Integer cat2) {
        this.cat2 = cat2;
    }
    public Integer getCat2() {
        return cat2;
    }

    public void setCat3(Integer cat3) {
        this.cat3 = cat3;
    }
    public Integer getCat3() {
        return cat3;
    }

    public void setCat4(Integer cat4) {
        this.cat4 = cat4;
    }
    public Integer getCat4() {
        return cat4;
    }

    public void setCat5(Integer cat5) {
        this.cat5 = cat5;
    }
    public Integer getCat5() {
        return cat5;
    }

    public void setQt1(Integer qt1) {
        this.qt1 = qt1;
    }
    public Integer getQt1() {
        return qt1;
    }

    public void setQt2(Integer qt2) {
        this.qt2 = qt2;
    }
    public Integer getQt2() {
        return qt2;
    }

    public void setQt3(Integer qt3) {
        this.qt3 = qt3;
    }
    public Integer getQt3() {
        return qt3;
    }

    public void setQt4(Integer qt4) {
        this.qt4 = qt4;
    }
    public Integer getQt4() {
        return qt4;
    }

    public void setQt5(Integer qt5) {
        this.qt5 = qt5;
    }
    public Integer getQt5() {
        return qt5;
    }

    public void setPri_t1(Double pri_t1) {
        this.pri_t1 = pri_t1;
    }
    public Double getPri_t1() {
        return pri_t1;
    }

    public void setPri_t2(Double pri_t2) {
        this.pri_t2 = pri_t2;
    }
    public Double getPri_t2() {
        return pri_t2;
    }

    public void setPri_t3(Double pri_t3) {
        this.pri_t3 = pri_t3;
    }
    public Double getPri_t3() {
        return pri_t3;
    }

    public void setPri_t4(Double pri_t4) {
        this.pri_t4 = pri_t4;
    }
    public Double getPri_t4() {
        return pri_t4;
    }

    public void setPri_t5(Double pri_t5) {
        this.pri_t5 = pri_t5;
    }
    public Double getPri_t5() {
        return pri_t5;
    }

    // PrintInfo
    public void printInfo() {
        // ตรวจสอบว่า JSONArray work_receipt มีข้อมูลหรือไม่
        if (!this.work_receipt.isEmpty()) {
            // ดึงข้อมูลล่าสุดจาก JSONArray
            JSONObject work_receipt = (JSONObject) this.work_receipt.get(this.work_receipt.size() - 1);
            
            System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-116s |\n", "5# Work Receipt");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %58s |\n", "Computer Repair Notification Systems", "Work Receipt No. : #" + work_receipt.get("work_receipt_id"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %-58s |\n", "Service Staff : " + work_receipt.get("service_staff_name") + " (#" + work_receipt.get("service_staff_id") + ")", "Transaction date : " + work_receipt.get("transaction_date"));
            System.out.printf("| %-57s %-58s |\n", "Customer Name : " + work_receipt.get("customer_fullname"), "Customer Tel : " + work_receipt.get("customer_tel"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-10s | %-57s | %-20s | %-20s |\n", "    No.   ", "                    List Service Name                   ", "      Quantity      ", "        Price       ");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            String cat1_t = null;
            if (work_receipt.get("cat1").equals(1)) {
                cat1_t = "/";
            } else if (work_receipt.get("cat1").equals(0)) {
                cat1_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "1", "[" + cat1_t + "]" + " " + "Basic computer check", "x" + work_receipt.get("qt1"), work_receipt.get("pri_t1") + " Baht");
            String cat2_t = null;
            if (work_receipt.get("cat2").equals(1)) {
                cat2_t = "/";
            } else if (work_receipt.get("cat2").equals(0)) {
                cat2_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "2", "[" + cat2_t + "]" + " " + "Computer repair", "x" + work_receipt.get("qt2"), work_receipt.get("pri_t2") + " Baht");
            String cat3_t = null;
            if (work_receipt.get("cat3").equals(1)) {
                cat3_t = "/";
            } else if (work_receipt.get("cat3").equals(0)) {
                cat3_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "3", "[" + cat3_t + "]" + " " + "Basic software installation", "x" + work_receipt.get("qt3"), work_receipt.get("pri_t3") + " Baht");
            String cat4_t = null;
            if (work_receipt.get("cat4").equals(1)) {
                cat4_t = "/";
            } else if (work_receipt.get("cat4").equals(0)) {
                cat4_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "4", "[" + cat4_t + "]" + " " + "Data recovery", "x" + work_receipt.get("qt4"), work_receipt.get("pri_t4") + " Baht");
            String cat5_t = null;
            if (work_receipt.get("cat5").equals(1)) {
                cat5_t = "/";
            } else if (work_receipt.get("cat5").equals(0)) {
                cat5_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "5", "[" + cat5_t + "]" + " " + "Others", "x" + work_receipt.get("qt5"), work_receipt.get("pri_t5") + " Baht");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
        } else {
            System.out.println("No work receipt available.");
        }
    }

    public void employee_view_work_receipt(String v_user_id) {
        for (Object obj : this.work_receipt) {
            JSONObject work_receipt = (JSONObject) obj;

            if (work_receipt.get("service_staff_id").equals(v_user_id)) {
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-57s %58s |\n", "Computer Repair Notification Systems", "Work Receipt No. : #" + work_receipt.get("work_receipt_id"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-57s %-58s |\n", "Service Staff : " + work_receipt.get("service_staff_name") + " (#" + work_receipt.get("service_staff_id") + ")", "Transaction date : " + work_receipt.get("transaction_date"));
                System.out.printf("| %-57s %-58s |\n", "Customer Name : " + work_receipt.get("customer_fullname"), "Customer Tel : " + work_receipt.get("customer_tel"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-10s | %-57s | %-20s | %-20s |\n", "    No.   ", "                    List Service Name                   ", "      Quantity      ", "        Price       ");
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                String cat1_t = null;
                if (work_receipt.get("cat1").equals(1)) {
                    cat1_t = "/";
                } else if (work_receipt.get("cat1").equals(0)) {
                    cat1_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "1", "[" + cat1_t + "]" + " " + "Basic computer check", "x" + work_receipt.get("qt1"), work_receipt.get("pri_t1") + " Baht");
                String cat2_t = null;
                if (work_receipt.get("cat2").equals(1)) {
                    cat2_t = "/";
                } else if (work_receipt.get("cat2").equals(0)) {
                    cat2_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "2", "[" + cat2_t + "]" + " " + "Computer repair", "x" + work_receipt.get("qt2"), work_receipt.get("pri_t2") + " Baht");
                String cat3_t = null;
                if (work_receipt.get("cat3").equals(1)) {
                    cat3_t = "/";
                } else if (work_receipt.get("cat3").equals(0)) {
                    cat3_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "3", "[" + cat3_t + "]" + " " + "Basic software installation", "x" + work_receipt.get("qt3"), work_receipt.get("pri_t3") + " Baht");
                String cat4_t = null;
                if (work_receipt.get("cat4").equals(1)) {
                    cat4_t = "/";
                } else if (work_receipt.get("cat4").equals(0)) {
                    cat4_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "4", "[" + cat4_t + "]" + " " + "Data recovery", "x" + work_receipt.get("qt4"), work_receipt.get("pri_t4") + " Baht");
                String cat5_t = null;
                if (work_receipt.get("cat5").equals(1)) {
                    cat5_t = "/";
                } else if (work_receipt.get("cat5").equals(0)) {
                    cat5_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "5", "[" + cat5_t + "]" + " " + "Others", "x" + work_receipt.get("qt5"), work_receipt.get("pri_t5") + " Baht");
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            }

        }
    }

    public void admin_view_all_work_receipt() {
        for (Object obj : this.work_receipt) {
            JSONObject work_receipt = (JSONObject) obj;

            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %58s |\n", "Computer Repair Notification Systems", "Work Receipt No. : #" + work_receipt.get("work_receipt_id"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %-58s |\n", "Service Staff : " + work_receipt.get("service_staff_name") + " (#" + work_receipt.get("service_staff_id") + ")", "Transaction date : " + work_receipt.get("transaction_date"));
            System.out.printf("| %-57s %-58s |\n", "Customer Name : " + work_receipt.get("customer_fullname"), "Customer Tel : " + work_receipt.get("customer_tel"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-10s | %-57s | %-20s | %-20s |\n", "    No.   ", "                    List Service Name                   ", "      Quantity      ", "        Price       ");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            String cat1_t = null;
            if (work_receipt.get("cat1").equals(1)) {
                cat1_t = "/";
            } else if (work_receipt.get("cat1").equals(0)) {
                cat1_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "1", "[" + cat1_t + "]" + " " + "Basic computer check", "x" + work_receipt.get("qt1"), work_receipt.get("pri_t1") + " Baht");
            String cat2_t = null;
            if (work_receipt.get("cat2").equals(1)) {
                cat2_t = "/";
            } else if (work_receipt.get("cat2").equals(0)) {
                cat2_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "2", "[" + cat2_t + "]" + " " + "Computer repair", "x" + work_receipt.get("qt2"), work_receipt.get("pri_t2") + " Baht");
            String cat3_t = null;
            if (work_receipt.get("cat3").equals(1)) {
                cat3_t = "/";
            } else if (work_receipt.get("cat3").equals(0)) {
                cat3_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "3", "[" + cat3_t + "]" + " " + "Basic software installation", "x" + work_receipt.get("qt3"), work_receipt.get("pri_t3") + " Baht");
            String cat4_t = null;
            if (work_receipt.get("cat4").equals(1)) {
                cat4_t = "/";
            } else if (work_receipt.get("cat4").equals(0)) {
                cat4_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "4", "[" + cat4_t + "]" + " " + "Data recovery", "x" + work_receipt.get("qt4"), work_receipt.get("pri_t4") + " Baht");
            String cat5_t = null;
            if (work_receipt.get("cat5").equals(1)) {
                cat5_t = "/";
            } else if (work_receipt.get("cat5").equals(0)) {
                cat5_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "5", "[" + cat5_t + "]" + " " + "Others", "x" + work_receipt.get("qt5"), work_receipt.get("pri_t5") + " Baht");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            
        }
    }
    
}
