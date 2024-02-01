package com.hspedu.qqclient.view;
import com.hspedu.qqclient.service.UserClientService;
import com.hspedu.qqclient.utils.Utility;
import java.util.Scanner;

public class QQView {
    private boolean loop = true;//control whether to loop the menu
    private String key = "";//accept user input
    private UserClientService userClientService = new UserClientService();//for user login and register

    public static void main(String[] args) {
        QQView qqView = new QQView();
        qqView.mainMenu();
        System.out.println("Exit QQ System");
    }
    private void mainMenu() {
        while (loop) {
            System.out.println("======Welcome to QQ System======");
            System.out.println("\t 1. Login QQ System");
            System.out.println("\t 9. Exit QQ System");
            System.out.print("Please select(1-9): ");

            //accept user input
            String key = Utility.readString(1);
            //use switch to select
            switch (key) {
                case "1":
                    System.out.println("Login QQ System");
                    String userId = Utility.readString(50);
                    System.out.print("Please enter your password: ");
                    String passwd = Utility.readString(50);
                    //send userId and passwd to server
                    if (userClientService.checkUser(userId, passwd)) {
                        System.out.println("=====" + userId + " Login successfully=====");
                        //show the second menu
                        while (loop) {
                            System.out.println("======Welcome to QQ System======");
                            System.out.println("\t 1. Show Online User List");
                            System.out.println("\t 2. Send Group Message");
                            System.out.println("\t 3. Send Private Message");
                            System.out.println("\t 4. Send File");
                            System.out.println("\t 9. Exit QQ System");
                            System.out.print("Please select(1-4 or 9): ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    System.out.println("Show Online User List");
                                    break;
                                case "2":
                                    System.out.println("Send Group Message");
                                    break;
                                case "3":
                                    System.out.println("Send Private Message");
                                    break;
                                case "4":
                                    System.out.println("Send File");
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Login failed");
                    }
                    break;
                case "9":
                    loop = false;
                    break;

            }
        }
    }
}