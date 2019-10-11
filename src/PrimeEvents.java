import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeEvents {

    private User eventUser;
    private ArrayList<Hall> halls;

    public void displayMainMenu()
    {
        int choiceNumber = -1;
        boolean flag = true;
        do {

            System.out.println("      WELCOME TO PRIME EVENTS     ");
            System.out.println();
            System.out.println("1 VIEW HALLS");
            System.out.println("2 SEARCH HALLS");
            System.out.println("3 LOGIN");
            System.out.println("4 REGISTER");
            System.out.println("5 FORGOT PASSWORD");
            System.out.println("6 EXIT");
            System.out.println();
            System.out.println("Enter your choice number:");


            choiceNumber = receiveInt();
            eventUser = new Customer();
            switch (choiceNumber) {
                case 1:
                    flag = eventUser.viewHalls();
                    break;
                case 2:
                    flag = ((Customer) eventUser).searchHalls(true);
                    break;
                case 3:
                    flag = true;
                    primeEventsLogin();
                    break;
                case 4:
                    flag = registerNewUser();
                    break;
                case 5:
                    flag = forgotPassword();
                    break;
                case 6:
                    flag = true;
                    System.out.println("You exited the system...");
                    break;
                default:
                    System.out.println("Please enter your choice correctly!");
                    break;
            }
        }while(choiceNumber<1 || choiceNumber>6 || !flag);
    }

    public boolean repeat()
    {
        System.out.println("Press 0 to return to menu");
        int admInput = new Scanner(System.in).nextInt();
        if(admInput == 0)
            return false;
        else
            return true;
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
                eventUser = new Administrator();
                ((Administrator)eventUser).displayAdminMenu();
            break;
            case "CUSTOMER":

                ((Customer) eventUser).displayCustomerMenu();
            break;
            case "OWNER":
                eventUser = new Owner();
                ((Owner) eventUser).displayOwnerMenu();
            break;
            default: System.out.println("You do not have a verified role. Contact Administrator.");
            break;
        }
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

    private boolean registerNewUser()
    {
            System.out.println("-------------- REGISTER --------------");
            System.out.println();
            System.out.println();
            System.out.println("Please provide details to register yourself.");
            return repeat();

    }

    private  boolean forgotPassword()
    {

            System.out.println("-------------- RESET PASSWORD --------------");
            System.out.println();
            System.out.println();
            System.out.println("Please provide details to reset your password.");
            return repeat();
    }

    public static void logout()
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
    public void createHallList(ArrayList<String[]> newHall){
        for(int i = 0; i < newHall.size(); i++)
        {
            Hall temdriHall = new Hall();


        }

    }
}
