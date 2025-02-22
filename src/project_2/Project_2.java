/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project_2;

import core.CustomerList;
import core.Order;
import core.OrderList;
import core.SetMenuList;
import tools.ConsoleInputter;

/**
 *
 * @author baodu
 */
public class Project_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CustomerList rList = new CustomerList();
        rList.loadFromFile("CustomerData.txt");
//        rList.displayMenus();
        SetMenuList s = new SetMenuList();
        s.loadFromFile("FeastMenu.csv");
//        s.displayMenus();
//        int choice;
//        do {
//            choice = ConsoleInputter.intMenu("Add regist", "Updates", 
//                    "search name", "save file");
//            switch (choice) {
//                case 1: rList.register();break;
//                case 2: rList.updateCust();break;
//                case 3: rList.searchName();break;
////                case 4: rList.saveFile(fname);break;
//            }
//        } while (choice < 4);

        OrderList oL = new OrderList(s, rList);
        oL.inputInfo_print();
    }
    
}
