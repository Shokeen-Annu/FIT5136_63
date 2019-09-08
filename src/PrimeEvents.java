

import java.io.*;
import java.util.Scanner;

public class PrimeEvents {

    public void displayMainMenu()
    {
        System.out.println("      WELCOME TO PRIME EVENTS     ");
        System.out.println();
        System.out.println("1 View Halls");
        System.out.println("2 Login");
        System.out.println("3 Register");
        System.out.println("4 Forgot Password");
        System.out.println("5 Exit");
        System.out.println();
        System.out.println("Enter your choice number:");


        int choiceNumber = receiveInt();

        switch (choiceNumber)
        {
            case 1: System.out.println("View Halls page and Search hall option");
                break;
            case 2: primeEventsLogin();
                break;
            case 3: registerNewUser();
                break;
            case 4: System.out.println("Forgot password page");
                break;
            case 5: System.out.println("You exited the system...");
                break;
            default: System.out.println("Please enter your choice correctly!");
                break;
        }
    }

    private void primeEventsLogin()
    {
        System.out.println("---------------- LOGIN ---------------");
        System.out.println("Provide your login details to login.....");
        System.out.println();
        System.out.println();
        boolean isUserAuthorized = false;
        boolean tryAgain = true;
        while(!isUserAuthorized && tryAgain) {
            System.out.println("Enter your email id:");

            String emailId = receiveString().trim();
            System.out.println();
            System.out.println("Enter your password:");
            String password = receiveString();

            String auth_string = emailId + "," + password;

            isUserAuthorized = verifyLoginDetails(auth_string);
            if (isUserAuthorized) {
                System.out.println("Login successful!");

                // Display menu as per role
                String role = findUserRole(emailId);
                displayUserMenu(role);
            } else {
                System.out.println("Either email id or password is wrong....");
                tryAgain = exitMenu("Do you want to try again ?");

            }
        }
    }
    private String receiveString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private int receiveInt()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    private boolean verifyLoginDetails(String auth_string)
    {
        String userDetails = readFile("loginDetails");
        String[] userDetailsArr = userDetails.split(";");
        boolean isUserAuthentic = false;
        for(String item: userDetailsArr)
        {
            if(item.equals(auth_string)) {
                isUserAuthentic = true;
            }
        }
         return isUserAuthentic;
    }
    private String findUserRole(String emailId)
    {
        String userRoles_string = readFile("usersRole");
        String[] userRoles = userRoles_string.split(";");
        String role = "";
        for (String item: userRoles) {
            String[] user_role_arr = item.split(",");
            if(user_role_arr[0].equals(emailId)) {
                role = user_role_arr[1];
                break;
            }
        }
        return role;
    }
    private void displayUserMenu(String role)
    {
        role = role.toUpperCase();
        switch (role)
        {
            case "ADMINISTRATOR":
                System.out.println("Welcome Administrator!!");
               // Administrator admin = new Administrator();
               // admin.displayAdminMenu();
            break;
            case "CUSTOMER":
                System.out.println("Welcome to Prime Events System to book halls!!");
               // Customer cust = new Customer();
               // cust.displayCustomerMenu();
            break;
            case "OWNER":
                System.out.println("Welcome Owner of halls!");
               // Owner owner = new Owner();
              //  owner.displayOwnerMenu();
            break;
            default: System.out.println("You do not have a verified role. Contact Administrator.");
            break;
        }

        // Only to check logout
        System.out.println("Enter 9 to logout");
        int choice = receiveInt();
        if(choice == 9)
            logout();
        else
            System.out.println("Wrong input");
    }
    private String readFile(String filePath)
    {
        String result = "";
        try {

            FileReader reader = new FileReader(filePath);
            Scanner scanner = new Scanner(reader);

            while(scanner.hasNextLine())
            {
                result += scanner.nextLine();
            }
            reader.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found. Please contact the administrator.");
        }
        catch (Exception ex)
        {
            System.out.println("Some error occurred. Please contact the administrator.");
        }
        return result;
    }

    private void registerNewUser()
    {
        boolean tryAgain = true;
        while(tryAgain) {
            System.out.println("-------------- REGISTER PAGE --------------");
            System.out.println();
            System.out.println();
            System.out.println("Please provide details to register yourself.");
            tryAgain = exitMenu("Do you want to register again?");
        }

    }

    public void logout()
    {
        System.out.println("You are logged out!!!");
        System.out.println("You can close the window...");

    }
    private boolean exitMenu(String message)
    {
        boolean tryAgain = false;
        System.out.println(message);
        System.out.println("1 Yes!");
        System.out.println("2 No, Send me to main menu!");
        System.out.println("3 Logout");
        int choice = receiveInt();
        if(choice == 2) {
            tryAgain = false;
            displayMainMenu();
        }
        else if(choice == 1)
            tryAgain = true;
        else if(choice == 3) {
            tryAgain = false;
            logout();
        }

        return tryAgain;
    }
}
