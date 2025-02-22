/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
// import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import tools.ConsoleInputter;
/**
 *
 * @author baodu
 */
public class CustomerList extends ArrayList<Customer>{
    // các hành vi quản lý costumer
    // thêm 1 khách hàng - tự code
    public CustomerList() {
        super();
    }

    public void register() {
        // Nhập data cho khách hàng mới
        // tạo Customer từ dữ liệu vừa nhập
        // thêm vào danh sách
        String code, name, phone, email;
        int pos;
        do {
            code = ConsoleInputter.getStr("Enter a customer code (5 characters): ", "^(C|G|K|c|g|k)\\d{4}$", "Invalid code. Please enter again");
            pos = indexOf(new Customer(code));
        } while (pos >= 0);
        name = ConsoleInputter.getStr("Enter a customer name (From 2 - 25 characters):", "[A-Za-z\\s]{2,25}", "Invalid name. Please enter again!");
        phone = ConsoleInputter.getStr("Enter a phone number (10 digits): ", "[\\d]{10}", "Invalid phone. Please enter again");
        email = ConsoleInputter.getStr("Enter a customer email (any@any.any): ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", "Error input! Please enter again");
        Customer cust = new Customer(code, name, phone, email);
        this.add(cust);
    }
    
    // Sửa thông tin khách hàng (name, phone, email) - tự code
    public void updateCust() {
        String code = ConsoleInputter.getStr("Enter the customer code: ", "^(C|G|K|c|g|k)\\d{4}$", "").trim();
        int pos = 0;
        for (int i = 0; i < this.size(); i++) {
            if (this.get(i).getCode().equalsIgnoreCase(code)) {
                pos = i;
                break;
            }
        }
//        for (Customer cust : this) {
//            System.out.println(cust);
//        }
        Customer cust = (pos >= 0) ? this.get(pos) : null;
        if (cust != null) {
            String name, phone, email;
            name = ConsoleInputter.getStr("Enter a customer name (From 2 - 25 characters):", "[A-Za-z\\s]{2,25}", "Invalid name. Please enter again!");
            phone = ConsoleInputter.getStr("Enter a phone number (10 digits): ", "[\\d]{10}", "Invalid phone. Please enter again");
            email = ConsoleInputter.getStr("Enter a customer email (any@any.any): ", "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", "Error input! Please enter again");
            cust.setCode(code);
            cust.setName(name);
            cust.setPhone(phone);
            cust.setEmail(email);
            System.out.println("The registration has been successfully");
        } else {
            System.out.println("This customer does not exist.");
        }
    }
    
    // tìm khách hàng theo tên - tự code
    public void searchName() {
        String name = ConsoleInputter.getStr("Enter a customer name: ", ".*", "").trim().toUpperCase();
        List<Customer> matchingCust = new ArrayList<>();
        for (Customer cust : this) {
            if (cust.name.toUpperCase().contains(name)) {
                matchingCust.add(cust);
            }
            if (!matchingCust.isEmpty()) {
                System.out.println("---------------------------------------");
                System.out.format("%-10s|%-30s|%-13s|%-30s\n", cust.code, cust.name, cust.phone, cust.email);
                System.out.println("---------------------------------------");
            } else {
                System.out.println("No one matches the search criteria!");
            }
        }
    }
    
    // lưu costumers lên file objects
    public void saveFile(String fname) {
        try {
            PrintWriter pw = new PrintWriter(fname);
            File file = new File(fname);
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line;
                while ((line = br.readLine()) != null) {
                    String [] tokens = line.split(",");
                    String code = tokens[0].trim();
                    String name = tokens[1].trim();
                    String phone = tokens[2].trim();
                    String email = tokens[3].trim();
                    Customer cust = new Customer(code, name, phone, email);
                    this.add(cust);
                }
                br.close();
            }
        } catch (Exception e) {
            System.out.println("Error!!!!" + e.getMessage());
        }
    }
        
        public void loadFromFile(String fName) {
        // Tạo đối tượng File với tên file đầu vào
        File f = new File(fName);
        // Kiểm tra file có tồn tại hay không
        if (!f.exists()) {
            System.out.println("File of mountains does not exist!"); // Thông báo lỗi
            System.exit(0); // Thoát chương trình mà không báo lỗi
        }

        try {
            // Nếu file tồn tại, tiến hành mở file để đọc
            FileReader fr = new FileReader(f); // Đọc file theo từng ký tự
            BufferedReader bf = new BufferedReader(fr); // Đọc file theo từng dòng
//            bf.readLine(); // Bỏ qua dòng đầu tiên vì thường là tiêu đề cột

            String line;
            // Đọc từng dòng cho đến hết file
            while ((line = bf.readLine()) != null) {
                line = line.trim(); // Xóa khoảng trắng dư thừa ở đầu và cuối dòng
                if (!line.isEmpty()) { // Chỉ xử lý những dòng có dữ liệu
                    // Cắt dòng thành các phần nhỏ theo dấu phẩy
                    StringTokenizer stk = new StringTokenizer(line, ",");
                    String code = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    String phone = stk.nextToken().trim();
                    String email = stk.nextToken().trim();
                    Customer customer = new Customer(code, name, phone, email);

                    // Thêm đối tượng vào danh sách
                    this.add(customer);
                }
            }

            // Đóng file sau khi đọc xong
            fr.close();
            bf.close();
        } catch (Exception e) { // Bắt lỗi nếu có ngoại lệ xảy ra
            System.out.println(e); // In thông báo lỗi ra màn hình
        }
    } // void loadFromFile
    
    public void displayMenus() {
        for (Customer cust : this) {
            System.out.println(cust);
        }
    }
    
    public ArrayList<Customer> getCust() {
        return this;
    }
}// class CustomerList
