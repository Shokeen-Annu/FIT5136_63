

public class PEInterface {

    private AdministratorInterface administratorInterface = new AdministratorInterface();
    private CustomerInterface customerInterface = new CustomerInterface();
    private OwnerInterface ownerInterface = new OwnerInterface();
    private InputValidation validator = new InputValidation();
    private CommonController commonController = new CommonController();

    public void displayMainMenu()
    {
        CommonController.createDatabase();
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


            choiceNumber = validator.receiveInt();
            switch (choiceNumber) {
                case -1: break;
                case 1:
                    commonController.viewHalls("ALL"," ");
                    break;
                case 2:
                    flag = customerInterface.displaySearchHallMenu(true, false);
                    break;
                case 3:

                    System.out.println("---------------- LOGIN ---------------");
                    System.out.println("Provide your login details to login.....");
                    System.out.println();
                    System.out.println();
                    boolean tryAgain = true;
                    boolean isUserAuthorized = false;
                    while(!isUserAuthorized && tryAgain) {
                        System.out.println("Enter your email id:");

                        String emailId = validator.receiveString().trim();

                        System.out.println();
                        System.out.println("Enter your password:");
                        String password = validator.receiveString();
                        String role = commonController.primeEventsLogin(emailId,password);
                        if(!role.isEmpty()) {
                            isUserAuthorized = true;
                            displayUserMenu(role);
                            flag = false;
                        }
                        if(!isUserAuthorized)
                        {
                            System.out.println("Either email id or password is wrong....");
                            int choiceLogout;
                            do {
                                System.out.println("Do you want to try again? Enter your choice number");
                                System.out.println("1 Yes");
                                System.out.println("2 No");
                                choiceLogout = validator.receiveInt();
                                tryAgain = commonController.logout(choiceLogout);
                            }while(choiceLogout == -1);
                            flag = tryAgain;
                        }
                    }

                    break;
                case 4:
                    System.out.println("-------------- REGISTER --------------");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please provide details to register yourself.");
                    flag = backMenu();
                    break;
                case 5:
                    System.out.println("-------------- RESET PASSWORD --------------");
                    System.out.println();
                    System.out.println();
                    System.out.println("Please provide details to reset your password.");
                    flag = backMenu();
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
    public void displayUserMenu(String role)
    {
        role = role.toUpperCase();
        switch (role)
        {
            case "ADMINISTRATOR":
                System.out.println("Welcome Administrator!!");
                administratorInterface.displayAdminMenu();
                break;
            case "CUSTOMER":
                customerInterface.displayCustomerMenu();
                break;
            case "OWNER":
                ownerInterface.displayOwnerMenu();
                break;
            default: System.out.println("You do not have a verified role. Contact Administrator.");
                break;
        }
    }

    public boolean backMenu()
    {
        System.out.println("Press 0 to return to menu");
        int admInput = validator.receiveInt();
        if(admInput == 0)
            return false;
        else
            return true;
    }
}
