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

public class Receipt_payment extends Employee {
    // Attributes
    private JSONArray receipt_payment;

    private String work_receipt_id;
    private String bill_payment_id;
    private String receipt_payment_id;
    
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

    private Double total_price;
    private Double discount;
    private Double net_amount;
    private Double get_money;
    private Double net_change;

    // Default contructor
    public Receipt_payment() {
        this.receipt_payment = new JSONArray();
    }

    // Overload constructor
    public Receipt_payment(String work_receipt_id, String bill_payment_id, String receipt_payment_id, String service_staff_name, String service_staff_id, String transaction_date, String customer_fullname, String customer_tel, int cat1, int cat2, int cat3, int cat4, int cat5, int qt1, int qt2, int qt3, int qt4, int qt5, double pri_t1, double pri_t2, double pri_t3, double pri_t4, double pri_t5, Double total_price, Double discount, Double net_amount, Double get_money, Double net_change) {
        this.work_receipt_id = work_receipt_id;
        this.bill_payment_id = bill_payment_id;
        this.receipt_payment_id = receipt_payment_id;

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

        this.total_price = total_price;
        this.discount = discount;
        this.net_amount = net_amount;
        this.get_money = get_money;
        this.net_change = net_change;
    }

    // Overload Methods

    // Methods
    public void add_receipt_payment(Receipt_payment receipt_payment) {
        JSONObject receipt_payment_new = new JSONObject();
        receipt_payment_new.put("work_receipt_id", receipt_payment.getWork_id());
        receipt_payment_new.put("bill_payment_id", receipt_payment.getBill_id());
        receipt_payment_new.put("receipt_payment_id", receipt_payment.getReceipt_id());
        receipt_payment_new.put("service_staff_name", receipt_payment.getService_staff_name());
        receipt_payment_new.put("service_staff_id", receipt_payment.getService_staff_id());
        receipt_payment_new.put("transaction_date", receipt_payment.getTransaction_date());
        receipt_payment_new.put("customer_fullname", receipt_payment.getCustomer_fullname());
        receipt_payment_new.put("customer_tel", receipt_payment.getCustomer_tel());
        receipt_payment_new.put("cat1", receipt_payment.getCat1());
        receipt_payment_new.put("cat2", receipt_payment.getCat2());
        receipt_payment_new.put("cat3", receipt_payment.getCat3());
        receipt_payment_new.put("cat4", receipt_payment.getCat4());
        receipt_payment_new.put("cat5", receipt_payment.getCat5());
        receipt_payment_new.put("qt1", receipt_payment.getQt1());
        receipt_payment_new.put("qt2", receipt_payment.getQt2());
        receipt_payment_new.put("qt3", receipt_payment.getQt3());
        receipt_payment_new.put("qt4", receipt_payment.getQt4());
        receipt_payment_new.put("qt5", receipt_payment.getQt5());
        receipt_payment_new.put("pri_t1", receipt_payment.getPri_t1());
        receipt_payment_new.put("pri_t2", receipt_payment.getPri_t2());
        receipt_payment_new.put("pri_t3", receipt_payment.getPri_t3());
        receipt_payment_new.put("pri_t4", receipt_payment.getPri_t4());
        receipt_payment_new.put("pri_t5", receipt_payment.getPri_t5());
        receipt_payment_new.put("total_price", receipt_payment.getTotal_price());
        receipt_payment_new.put("discount", receipt_payment.getDiscount());
        receipt_payment_new.put("net_amount", receipt_payment.getNet_amount());
        receipt_payment_new.put("get_money", receipt_payment.getGet_money());
        receipt_payment_new.put("net_change", receipt_payment.getNet_change());
        this.receipt_payment.add(receipt_payment_new);
    }
    
    public void save_to_file_receipt_payment(String filename) throws IOException {
        try (FileWriter file = new FileWriter(filename)) {
            file.write(this.receipt_payment.toJSONString());
        }
    }

    public void load_from_file_receipt_payment(String filename) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try (FileReader file = new FileReader(filename)) {
            Object obj = parser.parse(file);
            this.receipt_payment = (JSONArray) obj;
        }
    }

    public void setWork_id(String work_receipt_id) {
        this.work_receipt_id = work_receipt_id;
    }
    public String getWork_id() {
        return work_receipt_id;
    }

    public void setBill_id(String bill_payment_id) {
        this.bill_payment_id = bill_payment_id;
    }
    public String getBill_id() {
        return bill_payment_id;
    }

    public void setReceipt_id(String receipt_payment_id) {
        this.receipt_payment_id = receipt_payment_id;
    }
    public String getReceipt_id() {
        return receipt_payment_id;
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

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }
    public Double getTotal_price() {
        return total_price;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }
    public Double getDiscount() {
        return discount;
    }

    public void setNet_amount(Double net_amount) {
        this.net_amount = net_amount;
    }
    public Double getNet_amount() {
        return net_amount;
    }

    public void setGet_money(Double get_money) {
        this.get_money = get_money;
    }
    public Double getGet_money() {
        return get_money;
    }

    public void setNet_change(Double net_change) {
        this.net_change = net_change;
    }
    public Double getNet_change() {
        return net_change;
    }

    // PrintInfo
    public void printInfo() {
        // ตรวจสอบว่า JSONArray receipt_payment มีข้อมูลหรือไม่
        if (!this.receipt_payment.isEmpty()) {
            // ดึงข้อมูลล่าสุดจาก JSONArray
            JSONObject receipt_payment = (JSONObject) this.receipt_payment.get(this.receipt_payment.size() - 1);
            
            System.out.printf("\n------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-116s |\n", "7# Receipt Payment");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %58s |\n", "Computer Repair Notification Systems", "Work Receipt No. : #" + receipt_payment.get("work_receipt_id"));
            System.out.printf("| %116s |\n", "Bill Payment No. : #" + receipt_payment.get("bill_payment_id"));
            System.out.printf("| %116s |\n", "Receipt Payment No. : #" + receipt_payment.get("receipt_payment_id"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %-58s |\n", "Service Staff : " + receipt_payment.get("service_staff_name") + " (#" + receipt_payment.get("service_staff_id") + ")", "Transaction date : " + receipt_payment.get("transaction_date"));
            System.out.printf("| %-57s %-58s |\n", "Customer Name : " + receipt_payment.get("customer_fullname"), "Customer Tel : " + receipt_payment.get("customer_tel"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-10s | %-57s | %-20s | %-20s |\n", "    No.   ", "                    List Service Name                   ", "      Quantity      ", "        Price       ");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            String cat1_t = null;
            if (receipt_payment.get("cat1").equals(1)) {
                cat1_t = "/";
            } else if (receipt_payment.get("cat1").equals(0)) {
                cat1_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "1", "[" + cat1_t + "]" + " " + "Basic computer check", "x" + receipt_payment.get("qt1"), receipt_payment.get("pri_t1") + " Baht");
            String cat2_t = null;
            if (receipt_payment.get("cat2").equals(1)) {
                cat2_t = "/";
            } else if (receipt_payment.get("cat2").equals(0)) {
                cat2_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "2", "[" + cat2_t + "]" + " " + "Computer repair", "x" + receipt_payment.get("qt2"), receipt_payment.get("pri_t2") + " Baht");
            String cat3_t = null;
            if (receipt_payment.get("cat3").equals(1)) {
                cat3_t = "/";
            } else if (receipt_payment.get("cat3").equals(0)) {
                cat3_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "3", "[" + cat3_t + "]" + " " + "Basic software installation", "x" + receipt_payment.get("qt3"), receipt_payment.get("pri_t3") + " Baht");
            String cat4_t = null;
            if (receipt_payment.get("cat4").equals(1)) {
                cat4_t = "/";
            } else if (receipt_payment.get("cat4").equals(0)) {
                cat4_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "4", "[" + cat4_t + "]" + " " + "Data recovery", "x" + receipt_payment.get("qt4"), receipt_payment.get("pri_t4") + " Baht");
            String cat5_t = null;
            if (receipt_payment.get("cat5").equals(1)) {
                cat5_t = "/";
            } else if (receipt_payment.get("cat5").equals(0)) {
                cat5_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "5", "[" + cat5_t + "]" + " " + "Others", "x" + receipt_payment.get("qt5"), receipt_payment.get("pri_t5") + " Baht");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Total Price :", receipt_payment.get("total_price") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Discount :", receipt_payment.get("discount") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Net Amount :", receipt_payment.get("net_amount") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s %24s\n", "", "", "", "------------------------");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Get Money :", receipt_payment.get("get_money") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Change :", receipt_payment.get("net_change") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s %24s\n", "", "", "", "------------------------");
        } else {
            System.out.println("No bill payment available.");
        }
    }

    public void employee_view_receipt_payment(String v_user_id) {
        for (Object obj : this.receipt_payment) {
            JSONObject receipt_payment = (JSONObject) obj;

            if (receipt_payment.get("service_staff_id").equals(v_user_id)) {
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-57s %58s |\n", "Computer Repair Notification Systems", "Work Receipt No. : #" + receipt_payment.get("work_receipt_id"));
                System.out.printf("| %116s |\n", "Bill Payment No. : #" + receipt_payment.get("bill_payment_id"));
                System.out.printf("| %116s |\n", "Receipt Payment No. : #" + receipt_payment.get("receipt_payment_id"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-57s %-58s |\n", "Service Staff : " + receipt_payment.get("service_staff_name") + " (#" + receipt_payment.get("service_staff_id") + ")", "Transaction date : " + receipt_payment.get("transaction_date"));
                System.out.printf("| %-57s %-58s |\n", "Customer Name : " + receipt_payment.get("customer_fullname"), "Customer Tel : " + receipt_payment.get("customer_tel"));
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("| %-10s | %-57s | %-20s | %-20s |\n", "    No.   ", "                    List Service Name                   ", "      Quantity      ", "        Price       ");
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                String cat1_t = null;
                if (receipt_payment.get("cat1").equals(1)) {
                    cat1_t = "/";
                } else if (receipt_payment.get("cat1").equals(0)) {
                    cat1_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "1", "[" + cat1_t + "]" + " " + "Basic computer check", "x" + receipt_payment.get("qt1"), receipt_payment.get("pri_t1") + " Baht");
                String cat2_t = null;
                if (receipt_payment.get("cat2").equals(1)) {
                    cat2_t = "/";
                } else if (receipt_payment.get("cat2").equals(0)) {
                    cat2_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "2", "[" + cat2_t + "]" + " " + "Computer repair", "x" + receipt_payment.get("qt2"), receipt_payment.get("pri_t2") + " Baht");
                String cat3_t = null;
                if (receipt_payment.get("cat3").equals(1)) {
                    cat3_t = "/";
                } else if (receipt_payment.get("cat3").equals(0)) {
                    cat3_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "3", "[" + cat3_t + "]" + " " + "Basic software installation", "x" + receipt_payment.get("qt3"), receipt_payment.get("pri_t3") + " Baht");
                String cat4_t = null;
                if (receipt_payment.get("cat4").equals(1)) {
                    cat4_t = "/";
                } else if (receipt_payment.get("cat4").equals(0)) {
                    cat4_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "4", "[" + cat4_t + "]" + " " + "Data recovery", "x" + receipt_payment.get("qt4"), receipt_payment.get("pri_t4") + " Baht");
                String cat5_t = null;
                if (receipt_payment.get("cat5").equals(1)) {
                    cat5_t = "/";
                } else if (receipt_payment.get("cat5").equals(0)) {
                    cat5_t = "X";
                }
                System.out.printf("| %10s | %-57s | %20s | %20s |\n", "5", "[" + cat5_t + "]" + " " + "Others", "x" + receipt_payment.get("qt5"), receipt_payment.get("pri_t5") + " Baht");
                System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
                System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Total Price :", receipt_payment.get("total_price") + " Baht");
                System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Discount :", receipt_payment.get("discount") + " Baht");
                System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Net Amount :", receipt_payment.get("net_amount") + " Baht");
                System.out.printf("  %-10s   %-57s   %20s %24s\n", "", "", "", "------------------------");
                System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Get Money :", receipt_payment.get("get_money") + " Baht");
                System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Change :", receipt_payment.get("net_change") + " Baht");
                System.out.printf("  %-10s   %-57s   %20s %24s\n", "", "", "", "------------------------");
            }
            
        }
    }

    public void admin_view_all_receipt_payment() {
        for (Object obj : this.receipt_payment) {
            JSONObject receipt_payment = (JSONObject) obj;

            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %58s |\n", "Computer Repair Notification Systems", "Work Receipt No. : #" + receipt_payment.get("work_receipt_id"));
            System.out.printf("| %116s |\n", "Bill Payment No. : #" + receipt_payment.get("bill_payment_id"));
            System.out.printf("| %116s |\n", "Receipt Payment No. : #" + receipt_payment.get("receipt_payment_id"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-57s %-58s |\n", "Service Staff : " + receipt_payment.get("service_staff_name") + " (#" + receipt_payment.get("service_staff_id") + ")", "Transaction date : " + receipt_payment.get("transaction_date"));
            System.out.printf("| %-57s %-58s |\n", "Customer Name : " + receipt_payment.get("customer_fullname"), "Customer Tel : " + receipt_payment.get("customer_tel"));
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("| %-10s | %-57s | %-20s | %-20s |\n", "    No.   ", "                    List Service Name                   ", "      Quantity      ", "        Price       ");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            String cat1_t = null;
            if (receipt_payment.get("cat1").equals(1)) {
                cat1_t = "/";
            } else if (receipt_payment.get("cat1").equals(0)) {
                cat1_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "1", "[" + cat1_t + "]" + " " + "Basic computer check", "x" + receipt_payment.get("qt1"), receipt_payment.get("pri_t1") + " Baht");
            String cat2_t = null;
            if (receipt_payment.get("cat2").equals(1)) {
                cat2_t = "/";
            } else if (receipt_payment.get("cat2").equals(0)) {
                cat2_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "2", "[" + cat2_t + "]" + " " + "Computer repair", "x" + receipt_payment.get("qt2"), receipt_payment.get("pri_t2") + " Baht");
            String cat3_t = null;
            if (receipt_payment.get("cat3").equals(1)) {
                cat3_t = "/";
            } else if (receipt_payment.get("cat3").equals(0)) {
                cat3_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "3", "[" + cat3_t + "]" + " " + "Basic software installation", "x" + receipt_payment.get("qt3"), receipt_payment.get("pri_t3") + " Baht");
            String cat4_t = null;
            if (receipt_payment.get("cat4").equals(1)) {
                cat4_t = "/";
            } else if (receipt_payment.get("cat4").equals(0)) {
                cat4_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "4", "[" + cat4_t + "]" + " " + "Data recovery", "x" + receipt_payment.get("qt4"), receipt_payment.get("pri_t4") + " Baht");
            String cat5_t = null;
            if (receipt_payment.get("cat5").equals(1)) {
                cat5_t = "/";
            } else if (receipt_payment.get("cat5").equals(0)) {
                cat5_t = "X";
            }
            System.out.printf("| %10s | %-57s | %20s | %20s |\n", "5", "[" + cat5_t + "]" + " " + "Others", "x" + receipt_payment.get("qt5"), receipt_payment.get("pri_t5") + " Baht");
            System.out.printf("------------------------------------------------------------------------------------------------------------------------\n");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Total Price :", receipt_payment.get("total_price") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Discount :", receipt_payment.get("discount") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Net Amount :", receipt_payment.get("net_amount") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s %24s\n", "", "", "", "------------------------");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Get Money :", receipt_payment.get("get_money") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s | %20s |\n", "", "", "Change :", receipt_payment.get("net_change") + " Baht");
            System.out.printf("  %-10s   %-57s   %20s %24s\n", "", "", "", "------------------------");
            
        }
    }
}
