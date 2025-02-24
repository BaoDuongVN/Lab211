/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

// import java.util.StringTokenizer;
import tools.ConsoleInputter;

/**
 *
 * @author baodu
 */
public class OrderList extends ArrayList<Order>{
    SetMenuList s;
    CustomerList rList;
    List<Order> orderList;
    List<Customer> custList = new ArrayList<>();    
    List<SetMenu> sList = new ArrayList<>();
    public OrderList(SetMenuList s, CustomerList rList) {
        super();
        this.s = s;
        this.rList = rList;
    }

    public SetMenuList getS() {
        return s;
    }
    
    public CustomerList getC() {
        return rList;
    }
    
    public void printFeastOrder(Customer cus, SetMenu menu) {
        System.out.println(cus);
        System.out.println(menu);
    }
    
    public void inputInfo_print() {
//        System.out.println(rList);
        String custCode = ConsoleInputter.getStr("Enter the customer code", "^(C|G|K|c|g|k)\\d{4}$", "The entered code is invalid. Please enter again!");
        String setMenuCode = ConsoleInputter.getStr("Enter the set menu code", ".{5}$", "Invalid!");
        int numberOfTables = ConsoleInputter.getInt("Enter the number of tables", 0, 100);
        Date preferedDate = new Date();
        preferedDate = ConsoleInputter.getDate("Enter the date (dd-MM-yyyy)", "dd-MM-yyyy");
        Order o = new Order(custCode, setMenuCode, numberOfTables, preferedDate);
        this.add(o);
        Customer cus = null;
        SetMenu menu = null;
        for (int i = 0; i < rList.size(); i++) {
            if (rList.get(i).getCode().equalsIgnoreCase(custCode)) {
                cus = rList.get(i);
                break;
            }
        }
        if (cus == null) {
            return;
        }
        
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).getCode().equalsIgnoreCase(setMenuCode)) {
                menu = s.get(i);
                break;
            }
        }
        if (menu == null) {
            return;
        }

        custList.add(cus);
        sList.add(menu);       
        Random random = new Random();
        o.id = random.nextInt(100);
        System.out.println("---------------------------------------------------");
        System.out.println("Customer order information [Order ID: " + o.id + "]");
        System.out.println("---------------------------------------------------");
        for (Customer cust : custList) {
            if (!custList.isEmpty()) {
                // System.out.format("%-10s|%-20s|%-30s|%-13s\n", cust.code, cust.name, cust.phone, cust.email);
                System.out.format("%-30s: %s\n", "Code", cust.code);
                System.out.format("%-30s: %s\n", "Customer name", cust.name);
                System.out.format("%-30s: %s\n", "Phone number", cust.phone);
                System.out.format("%-30s: %s\n", "Email", cust.email);
                System.out.println("---------------------------------------------------");
            } else {
                System.out.println("No one matches the search criteria!");
            }
        }
        for (SetMenu sMenu : sList) {
            if (!sList.isEmpty()) {
                // System.out.format("%-10s|%-20s|%-30s|%-13s\n", cust.code, cust.name, cust.phone, cust.email);
                System.out.format("%-30s: %s\n", "Code of Set Menu", sMenu.code);
                System.out.format("%-30s: %s\n", "Set menu name", sMenu.name);
                System.out.format("%-30s: %s\n", "Event date", preferedDate);
                System.out.format("%-30s: %s\n", "Number of tables", numberOfTables);
                System.out.format("%-30s: %s %-3s\n", "Price", sMenu.price, "VND");
                System.out.println("Ingredients:");
                System.out.println(sMenu.ingredients.replaceAll("#", "\n").replaceAll("\"", ""));
                System.out.println("---------------------------------------------------");
                System.out.format("%-30s: %s %-3s\n", "Total", sMenu.price * numberOfTables, "VND");
            } else {
                System.out.println("No one matches the search criteria!");
            }
        }
    }
    
    public void updateOrder() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Bill.dat"))) {
            out.writeObject(custList);
            out.writeObject(sList);
            System.out.println("ArrayList đã được lưu vào file arraylist.dat");
        } catch (IOException e) {
            System.err.println("Có lỗi xảy ra khi lưu file: " + e.getMessage());
        }
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("Bill.dat"))) {
            ArrayList<String> savedList = (ArrayList<String>) in.readObject();
            System.out.println("ArrayList đã được đọc từ file:");
            for (String item : savedList) {
                System.out.println(item);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Có lỗi xảy ra khi đọc file: " + e.getMessage());
        }
        // String id = ConsoleInputter.getStr("Enter the order ID", "^(?:[1-9][0-9]?|100)$", "This number is out of the bound");
        // String custCode = ConsoleInputter.getStr("Enter the customer code", "^(C|G|K|c|g|k)\\d{4}$", "The entered code is invalid. Please enter again!");
        // String setMenuCode = ConsoleInputter.getStr("Enter the set menu code", ".{5}$", "Invalid!");
        // int numberOfTables = ConsoleInputter.getInt("Enter the number of tables", 0, 100);
        // Date preferedDate = new Date();
        // preferedDate = ConsoleInputter.getDate("Enter the date (dd-MM-yyyy)", "dd-MM-yyyy");
        // Order o = new Order(custCode, setMenuCode, numberOfTables, preferedDate);  
    }

    
}
