import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CustomerInterface{

    private InputValidation validator = new InputValidation();
    private CommonController commonController = new CommonController();
    private CustomerController customerController = new CustomerController();


    public void displayCustomerMenu()
    {
        commonController.createDatabase();
        int customerNumber = -1;
        boolean flag = true;
        do {
        System.out.println("      WELCOME TO CUSTOMER MENU     ");
        System.out.println();
        System.out.println("1 SEARCH A HALL");
        System.out.println("2 VIEW ALL HALLS");
        System.out.println("3 BOOK HALL");
        System.out.println("4 REQUEST A QUOTATION");
        System.out.println("5 VIEW QUOTATION");
        System.out.println("6 CANCEL BOOKING");
        System.out.println("7 UPDATE BOOKING");
        System.out.println("8 UPDATE CUSTOMER INFORMATION");
        System.out.println("9 LOG OUT");              // View booking history needs to be added.
        System.out.println();
        System.out.println("Enter your choice number:");

        Scanner scanner = new Scanner(System.in);
        String customerInput = scanner.nextLine();
        boolean isExit = false;

                if (validator.validateInt(customerInput) == false)
                {
                    System.out.println("Please enter integer value.");
                }
                else if (customerInput.length() == 0)
                {
                    System.out.println("Please enter the option");
                }
                else {
                          customerNumber = Integer.parseInt(customerInput);
                         switch (customerNumber) {
                         case 1: flag = displaySearchHallMenu(false);
                         break;
                         case 2: commonController.viewHalls("ALL","");
                         flag = backMenu();
                         break;
                         case 3: flag = displayBookHallMenu(false);
                         break;
                         case 4:
                             System.out.println("-------------- REQUEST QUOTATION --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("Request a quotation page");
                             flag = backMenu();
                         break;
                         case 5:
                             System.out.println("-------------- VIEW QUOTATIONS --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("View all quotations page");
                             flag = backMenu();
                         break;
                         case 6:
                             System.out.println("-------------- CANCEL BOOKING --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("Cancel booking page.");
                             flag = backMenu();
                         break;
                         case 7:
                             System.out.println("-------------- UPDATE BOOKING --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("Update booking page");
                             flag = backMenu();
                         break;
                         case 8:
                             System.out.println("-------------- UPDATE PROFILE --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("Update customer information page");
                             flag = backMenu();
                         break;
                         case 9:int choiceLogout;
                             do {
                                 System.out.println("Are you sure you want to logout? Enter your choice number");
                                 System.out.println("1 Yes");
                                 System.out.println("2 No");
                                 choiceLogout = validator.receiveInt();
                                 flag = commonController.logout(choiceLogout);
                             }while(choiceLogout == -1);

                         break;
                         default: System.out.println("Please enter your choice correctly!");
                         break;
                      }
            }

        }while (customerNumber < 1 || customerNumber > 9 || !flag);
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

    public boolean displaySearchHallMenu(boolean isMainMenu)
    {
        //commonController.createDatabase();
        boolean flag = true;
        int searchChoice;
        do {

            System.out.println("------SEARCH HALLS---------");
            System.out.println();
            System.out.println();
            System.out.println("Choose one way to search a hall");
            System.out.println("1 NAME OF HALL");
            System.out.println("2 STAR RATING");
            System.out.println("3 OCCASION TYPE");
            System.out.println("4 ADDRESS");
            System.out.println("5 DATE");
            System.out.println("6 BACK TO MAIN MENU");
            System.out.println();
            System.out.println("Enter your choice number:");

            Scanner scanner = new Scanner(System.in);
            searchChoice = scanner.nextInt();
            String searchInput = " ";
            switch (searchChoice) {
                case 1:
                         System.out.println("Please enter the name of hall");
                         searchInput = validator.receiveString().toUpperCase();
                         commonController.viewHalls("NAME", searchInput);
                        flag = backMenu();
                    break;
                case 2:
                        System.out.println("Please enter the rating");
                        String searchRate = Integer.toString(validator.receiveInt());
                        commonController.viewHalls("RATING", searchRate);
                        flag = backMenu();
                        break;
                case 3:
                    System.out.println("Please enter a occasion type");
                    searchInput = validator.receiveString().toUpperCase();
                    commonController.viewHalls("OCCASSION", searchInput);
                    flag = backMenu();
                    break;
                case 4:
                    System.out.println("Please enter a Address");
                    searchInput = validator.receiveString().toUpperCase();
                    commonController.viewHalls("ADDRESS", searchInput);
                    flag = backMenu();
                    break;
                case 5:
                    System.out.println("Please enter a date");
                    flag = backMenu();
                    break;
                case 6:
                    return false;
                default:
                    System.out.println("Please choose the option correctly");
                    break;
            }

        }while(searchChoice < 1 || searchChoice > 6 || !flag);
        return true;
    }


    public boolean displayBookHallMenu(boolean isMainMenu)
    {
        int choice;
        boolean flag = true;
        do {
        System.out.println("--------- BOOK HALL -----------");
        System.out.println();
        System.out.println("1 SELECT HALL");
        System.out.println("2 PROVIDE RATING");
        System.out.println("3 BACK TO MAIN MENU");
        System.out.println();
        System.out.println("Enter your choice number:");
        Scanner scanner = new Scanner(System.in);
       choice = scanner.nextInt();
       switch (choice)
        {
            case 1: bookingMenu(false);
            flag = backMenu();
            break;
            case 2: System.out.println("Please provide rating of hall here");
            flag = backMenu();
            break;
            case 3: return false;
            default:
                System.out.println("Please choose the option correctly");
                break;
        }
        }while(choice < 1 || choice > 3 || !flag);
        return true;
    }


    public boolean bookingMenu(boolean isMainMenu)
    {
        /*Scanner scanner = new Scanner(System.in);
        int select = scanner.nextInt();

            System.out.println("Do you want to view all halls or search hall");
            System.out.println("1 VIEW ALL HALLS");
            System.out.println("2 SEARCH HALLS");
            System.out.println("3 BACK TO MAIN MENU");*/

            /*switch (choice) {
                        case 1:
                            System.out.println("the methods of view halls");
                            flag = backMenu();
                            break;
                        case 2:
                            System.out.println("the methods of search halls");
                            flag = backMenu();
                            break;
                        case 3:
                            return false;
                        default:   System.out.println("Please choose the option correctly");
                            break;
                    }
            */
            System.out.println("Please enter the hall ID");
           int hallId = validator.receiveInt();
           if (customerController.bookHall(hallId)) {
                System.out.println("Are you sure you want to book this hall? Enter your choice number");
                System.out.println("1 YES");
                System.out.println("2 NO");
                int choiceBook = validator.receiveInt();
                if (customerController.askForConfirmation(choiceBook)) {
                    sendQuotation(hallId);
                    System.out.println("Do you want to send quotation?");
                    System.out.println("1 YES");
                    System.out.println("2 NO");

                    displayQuotation();
                }
                else
                {
                    System.out.println("The hall is not exist");
                }
            }
           return true;
    }


public void sendQuotation(int hallId){
    System.out.println("Now you need to write the quotation details");

    System.out.println("Today is: (dd-MM-yyyy)");
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    try {
        Date todayDate = dateFormat.parse(validator.receiveString());
        System.out.println("Which date you want to start (dd-MM-yyyy)");
        Date bookingStartDate = dateFormat.parse(validator.receiveString());
        System.out.println("Which date you want to finish (dd-MM-yyyy)");
        Date bookingFinishDate = dateFormat.parse(validator.receiveString());
        System.out.println("The number of Guest :");
        int numberOfGuest = validator.receiveInt();
        System.out.println("The price you want to pay :");
        double price = validator.receiveInt(); //不知道可以不可以int
        System.out.println("If you want to catering, please enter Yes or Not");
        String isCateringString = validator.receiveString();
        boolean isCatering = false;
        String typeOfMeal ="";
        if (isCateringString.equals("Yes"))
        {
            isCatering = true;
            System.out.println("What type of meal you want to :");
            typeOfMeal = validator.receiveString();
            customerController.requestForQuotation(hallId,todayDate, bookingStartDate,  bookingFinishDate,
                    numberOfGuest, price,isCatering, typeOfMeal);
        }
        else{

            customerController.requestForQuotation(hallId,todayDate, bookingStartDate,  bookingFinishDate,
                numberOfGuest, price,isCatering, typeOfMeal);
        }
    } catch (ParseException e) {
        System.out.println("Please enter right format of date: dd-MM-yyyy");
    }
}

public void displayQuotation()
{


}

    public boolean displayPaymentMenu()
    {
        int payChoice;
        boolean flag = true;
        do {
            System.out.println("------ PAY DEPOSIT -------");
            System.out.println();
            System.out.println("1 MAKE THE PAYMENT");
            System.out.println("2 VIEW RECEIPT");
            System.out.println("3 BACK TO MAIN MENU");
            System.out.println();
            System.out.println("Enter your choice number:");
            Scanner scanner = new Scanner(System.in);
            payChoice = scanner.nextInt();
            switch(payChoice)
            {
                case 1: System.out.println("Please provide card details for payment");
                    flag = backMenu();
                    break;
                case 2: System.out.println("You can view your receipt here.");
                    flag = backMenu();
                    break;
                case 3: return false;
                default: System.out.println("Please enter the right option");
                    break;
            }

        }while(payChoice < 1 || payChoice > 3 || !flag);
        return true;
    }
    public boolean displayManageAccountMenu()
    {
        return false;
    }
}

