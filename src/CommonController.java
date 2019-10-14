import java.util.Scanner;

public class CommonController {

    private PEInterface peInterface = new PEInterface();
    private PrimeEvents primeEvents = new PrimeEvents();
    private InputValidation validator = new InputValidation();
    private CustomerInterface customerInterface = new CustomerInterface();
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

    public void viewHalls(String type, String searchInput)
    {
        switch (type) {
            case "ALL": {
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    System.out.println(primeEvents.getHallList().get(i).displayHall());
                }
            }
            break;
            case "NAME": {
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getHallName().equals(searchInput)) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
            }
            break;
            case "ADDRESS": {
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getAddress().equals(searchInput)) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
            }
            break;
            case "RATING": {
                int searchRate = Integer.parseInt(searchInput);
                ;
                do {

                    if (searchRate < 1 || searchRate > 5)
                        System.out.println("Please enter the number between 1 and 5 !!");
                    searchRate = validator.receiveInt();
                } while (searchRate > 1 && searchRate < 5);
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getRating() > searchRate) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
            }
            break;
            case "OCCASSION":
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getTypeOfOccassion().equals(searchInput)) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
                break;
                default: {
                            System.out.println("Press 0 to return");
                            int admInput = new Scanner(System.in).nextInt();
                            if (admInput == 0)
                            customerInterface.displaySearchHallMenu(true);
                        }
        }
        // System.out.println("-------------- VIEW HALLS --------------");
        // System.out.println();
        //  System.out.println();
        // System.out.println("View all halls page");

    }
    // take hardcoded email id
    public void deleteDiscount(int discountId)
    {
        for(int i = 0; i < primeEvents.getUserList().size(); i++)
        {
            if(primeEvents.getUserList().get(i).getEmail().equals("asho0007@student.monash.edu"))
            {
                Owner owner = (Owner)primeEvents.getUserList().get(i);
                owner.getDiscountList().remove(discountId - 1);
            }
        }
    }


}
