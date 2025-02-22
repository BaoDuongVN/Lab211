/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author baodu
 */
public class SetMenuList extends ArrayList<SetMenu>{
    // Constructor chuẩn
    public SetMenuList() {
        super();
    }
    
    // Đọc các set menu từ file văn bản theo dạng: code, name, price, ingredients
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
            bf.readLine(); // Bỏ qua dòng đầu tiên vì thường là tiêu đề cột

            String line;
            // Đọc từng dòng cho đến hết file
            while ((line = bf.readLine()) != null) {
                line = line.trim(); // Xóa khoảng trắng dư thừa ở đầu và cuối dòng
                if (!line.isEmpty()) { // Chỉ xử lý những dòng có dữ liệu
                    // Cắt dòng thành các phần nhỏ theo dấu phẩy
                    StringTokenizer stk = new StringTokenizer(line, ",");
                    String code = stk.nextToken().trim();
                    String name = stk.nextToken().trim();
                    int price = Integer.parseInt(stk.nextToken().trim());
                    String ingredients = stk.nextToken().trim();

                    // Tạo một đối tượng Mountain từ dữ liệu đã lấy
                    SetMenu setMenu = new SetMenu(code, name, price, ingredients);

                    // Thêm đối tượng vào danh sách
                    this.add(setMenu);
                }
            }

            // Đóng file sau khi đọc xong
            fr.close();
            bf.close();
        } catch (Exception e) { // Bắt lỗi nếu có ngoại lệ xảy ra
            System.out.println(e); // In thông báo lỗi ra màn hình
        }
    } // void loadFromFile
    
    // Hiển thị feast menus- tự code
    public void displayMenus() {
        for (SetMenu s : this) {
            System.out.println(s);
        }
    }
    
    public ArrayList<SetMenu> getMenu() {
        return this;
    }
} // class SetMenuList
