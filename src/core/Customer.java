/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.io.Serializable;

/**
 *
 * @author baodu
 */

/*
    Lớp mô tả 1 khách hàng
    Customer code: A unique 5-characters string, "C0000", "G0000" or "K0000"
    Name: A non-empty string between 2 and 25 characters long
    Phone number: A 10-digit number belonging to a network operator in Vietnam
    Email: A valid email address in  standard format
*/
public class Customer implements Serializable{
    String code, name, phone, email;
    // Constructor tạo customer 4 tham số - tự code
    public Customer(String code, String name, String phone, String email) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }
    
    // Constructor 1 tham số là code, phục vụ cơ chế tìm theo mã - tự code
    public Customer(String code) {
        this.code = code;
    }
    
    public Customer() {

    }

    // Hành vi đọc 2 customer dựa trên code. Phục vụ cơ chế tìm kiếm
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); // tự code
    }
    // getters, setters - nhớ kiểm tra tình huống hợp lệ của tham số trong các setters
    // tự code

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        code = code.trim();
        if (code.matches("[.]{5}")) {
            this.code = code;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.trim();
        if (name.matches("[A-Za-z\\s]{2,25}")) {
            this.name = name;
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        phone = phone.trim();
        if (phone.matches("[\\d]{10}")) {
            this.phone = phone;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        email = email.trim();
        if (email.matches("[.]+@[.]+.[.]+")) {
            this.email = email;
        }
    }
    
    
    // Giúp xuất cust theo dạng bảng, dùng hành vi format - tự code, đếm độ dài trong đề 
    @Override
    public String toString() {
//        System.out.println("-------------------------------------------");
//        System.out.format("%-10s|%-30s|%-13s|%-30s\n", code, name, phone, email);
//        System.out.println("-------------------------------------------");
        return code + ", " + name + ", " + phone + ", " + email;
    }
} // class Customer
