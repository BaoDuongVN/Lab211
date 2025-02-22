/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

/**
 *
 * @author baodu
 */
public class SetMenu {
    String code;
    String name;
    int price;
    String ingredients;
    
    // Constructor 4 tham số để tạo 1 set menu

    public SetMenu(String code, String name, int price, String ingredients) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
    }
    

    @Override
    public String toString() {
        ingredients = ingredients.replaceAll("#", "\n").replaceAll("\"", "");
        return code + ", " + name + ", " + price + "\n" + ingredients;
        // Chặt ingredients theo dấu # nối thêm vào, tự code theo mẫu của đề bài
    }
    
    public String getCode() {
        return code;
    }
}// class SetMenu
