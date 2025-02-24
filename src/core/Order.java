/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author baodu
 */
public class Order {
    // int id; không cần field này vì chỉ là số thứ tự khi trình bày ra màn hình
    int id;
    String custCode, setMenuCode;
    int numberOfTables;
    Date preferedDate;

    // Constructor 4 tham số để tạo 1 order - tự code
    public Order(String custCode, String setMenuCode, int numberOfTables, Date preferedDate) {
        this.custCode = custCode;
        this.setMenuCode = setMenuCode;
        this.numberOfTables = numberOfTables;
        this.preferedDate = preferedDate;
    }

    public Order(Customer cust, SetMenu setMenu) {
        super();
    }

    // Constructor 3 tham số giúp tìm kiểm tra trùng: costCode, setMenuCode, preferedDate
    // tự code
    public Order(String custCode, String setMenuCode, Date preferedDate) {
        this.custCode = custCode;
        this.setMenuCode = setMenuCode;
        this.preferedDate = preferedDate;
    }
    
    
    // Hàm tra bằng nhau dựa trên 3 yếu tố costCode, setMenuCode, preferedDate
    // tự code - dùng toán tử AND: &&
//    @Override 
//    public boolean equals(Object obj) {
//        Order order = (Order) obj;
//        return custCode.equals(order.custCode) && setMenuCode.equals(order.setMenuCode)
//            && preferedDate.equals(order.preferedDate);
//            // tự code
//    }
}
