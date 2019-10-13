import java.util.Scanner;

public class CommonController {

    private PEInterface peInterface = new PEInterface();
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

            // verify login details
            String userDetails = readFile("loginDetails");
            String[] userDetailsArr = userDetails.split(";");
            boolean isUserAuthentic = false;
            for(String item: userDetailsArr)
            {
                if(item.equals(auth_string)) {
                    isUserAuthentic = true;
                }
            }
            isUserAuthorized = isUserAuthentic;

            if (isUserAuthorized) {
                System.out.println("Login successful!");

                // Display menu as per role
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
                peInterface.displayUserMenu(role);
            } else {
                System.out.println("Either email id or password is wrong....");
                tryAgain = logout("Do you want to try again ?");

            }
        }
    }

    public boolean logout(String message)
    {
        boolean tryAgain = false;
        System.out.println(message);
        System.out.println("1 Yes!");
        System.out.println("2 No, Send me to main menu!");
        int choice = validator.receiveInt();
        if(choice == 2) {
            tryAgain = false;
            peInterface.displayMainMenu();
        }
        else if(choice == 1)
            tryAgain = true;
        else if(choice == 3) {
            tryAgain = false;
            System.out.println("You are logged out!!!");
            System.out.println("You can close the window...");
        }

        return tryAgain;
    }

    public  boolean viewHalls()
    {
        System.out.println("-------------- VIEW HALLS --------------");
        System.out.println();
        System.out.println();
        System.out.println("View all halls page");
        System.out.println("Press 0 to return");
        int admInput = new Scanner(System.in).nextInt();
        if(admInput == 0)
            return false;
        else
            return true;
    }
}
