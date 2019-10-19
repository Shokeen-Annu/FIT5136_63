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
                         case 1: flag = displaySearchHallMenu(false,false);
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
    public boolean newBackMenu()
    {
        System.out.println("Press 0 to return to menu or press 9 to select the hall");
        int admInput = validator.receiveInt();
        if(admInput == 0)
            return false;
        else
            return true;
    }

    public boolean displaySearchHallMenu(boolean isMainMenu, boolean isBookHall)
    {
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
            boolean specialChar = true;
            switch (searchChoice) {
                case 1:
                         do{
                               System.out.println("Please enter the name of hall");
                               searchInput = validator.receiveString().trim().toUpperCase();
                               specialChar = validator.validateSpecialChar(searchInput);
                               if(searchInput.isEmpty() == true || specialChar == false)
                               {
                                   System.out.println("Please enter the correct format!!");
                               }
                         }while(searchInput.isEmpty() == true || specialChar == false);
                         commonController.viewHalls("NAME", searchInput);
                    System.out.println("Please enter the name of hall");
                     searchInput = validator.receiveString();
                    commonController.viewHalls("NAME", "searchInput");

                    if(isBookHall)
                        flag = newBackMenu();
                    else
                        flag = backMenu();
                    break;
                case 2:
                    System.out.println("Please enter the rating");
                    int searchRate = validator.receiveInt();
                    commonController.viewHalls("RATING", "searchRate");
                    if(isBookHall)
                        flag = newBackMenu();
                    else
                        flag = backMenu();
                    break;
                case 3:
                    System.out.println("Please enter a occasion type");
                    searchInput = validator.receiveString();
                    commonController.viewHalls("OCCASSION", "searchInput");
                    if(isBookHall)
                        flag = newBackMenu();
                    else
                        flag = backMenu();
                    break;
                case 4:
                    System.out.println("Please enter a Address");
                    searchInput = validator.receiveString();
                    commonController.viewHalls("ADDRESS", "searchInput");
                    if(isBookHall)
                        flag = newBackMenu();
                    else
                        flag = backMenu();
                    break;
                case 5:
                    System.out.println("Please enter a date");
                    if(isBookHall)
                        flag = newBackMenu();
                    else
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
        System.out.println("1 SELECT HALL & REQUEST QUOTATION");
        System.out.println("2 VIEW QUOTATION & BOOK HALL");
        System.out.println("3 PROVIDE RATING") ;
        System.out.println("4 BACK TO MAIN MENU");
        System.out.println();
        System.out.println("Enter your choice number:");
        Scanner scanner = new Scanner(System.in);
        choice = scanner.nextInt();
       switch (choice)
        {
            case 1: bookingMenu(false);
            flag = backMenu();
            break;
            case 2:
                viewQuotation(false);
                payDeposit(false);
                flag = backMenu();
            break;
            case 3: System.out.println("Please provide rating of hall here");
            flag = backMenu();
            break;
            case 4: return false;
            default:
                System.out.println("Please choose the option correctly");
                break;
        }
        }while(choice < 1 || choice > 4 || !flag);
        return true;
    }


    public boolean bookingMenu(boolean isMainMenu)
    {
             boolean flag = true;
            displaySearchHallMenu(false,true);
            do {
                System.out.println("Please enter the hall ID to select the hall");
                int hallId = validator.receiveInt();
                if (customerController.bookHall(hallId)) {
                    System.out.println("Are you sure you want to book this hall? Enter your choice number? (select 1 or 2)");
                    System.out.println("1 YES");
                    System.out.println("2 NO");
                    int choiceBook = validator.receiveInt();

                    if (customerController.askForConfirmation(choiceBook)) {

                        sendQuotation(hallId);
                        System.out.println("Do you want to request quotation? (select 1 or 2)");
                        System.out.println("1 YES");
                        System.out.println("2 NO");
                        int choice = validator.receiveInt();
                        switch (choice) {
                            case 1:
                                customerController.saveQuotation();
                                System.out.println("Quotation already sent to owner.");
                                break;
                            case 2:
                                return false; // ??????????????????????????????????????????????????????????????
                            default:
                                System.out.println("Please choose the option correctly");
                                break;
                        }
                    }
                    flag = true;
                }
                else {
                        System.out.println("The hall is not exist");
                        System.out.println("Do you want to re-enter or not");
                        System.out.println("1 YES");
                        System.out.println("2 NO");
                        int choose = validator.receiveInt();
                        switch (choose)
                        {
                            case 1: flag = false;
                                    break;
                            case 2: flag = true;
                                    break;
                            default: System.out.println("Please choose the option correctly");
                                    break;
                        }

                }

            } while(!flag );
           return true;
    }


public void sendQuotation(int hallId){
    Date todayDate = new Date();
    Date bookingStartDate = new Date();
    Date bookingFinishDate = new Date();
    boolean temp = true;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    System.out.println("Now you need to write the quotation details");

    while(temp) {
        try {
            System.out.println("Which date you want to start (dd-MM-yyyy)");
            bookingStartDate = dateFormat.parse(validator.receiveString());
            temp = false;
        } catch (ParseException e) {
            System.out.println("Please enter right format of date: dd-MM-yyyy");
        }
    }

    while(temp) {
        try {
            System.out.println("Which date you want to finish (dd-MM-yyyy)");
            bookingFinishDate = dateFormat.parse(validator.receiveString());
            temp = false;
        } catch (ParseException e) {
            System.out.println("Please enter right format of date: dd-MM-yyyy");
        }
    }

        System.out.println("The number of Guest :");
        int numberOfGuest = validator.receiveInt();

        double price = 0;
        System.out.println("If you want to catering, please enter 'Yes' or 'Not'");
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


    System.out.println("--------- Your quotation ---------");
    System.out.println("Hall ID : "+ hallId);
    System.out.println("Quotation date : "+ todayDate);
    System.out.println("Booking Start Date : "+ bookingStartDate);
    System.out.println("Booking Finish Date : "+ bookingFinishDate);
    System.out.println("Number Of Guests : "+ numberOfGuest);
    System.out.println("Price : "+ price);
    System.out.println("IsCatering : "+ isCatering);
    System.out.println("Type Of Meal : "+ typeOfMeal);

}


public boolean viewQuotation (boolean isMainMenu )
{
    customerController.readQuotationFromTxt();
    return true;
}
public boolean payDeposit (boolean isMainMenu)
    {
        boolean flag = true ;
        System.out.println("Do you want to pay deposit or not? (select 1 or 2)");
        System.out.println("1 YES");
        System.out.println("2 NO");
        int choice = validator.receiveInt();
        switch (choice) {
            case 1: System.out.println("Please choose which quotation you want to pay:");
                    int whichQuotation = validator.receiveInt();
                    if (customerController.readQuotationFromCustomer(whichQuotation) )
                    {
                        System.out.println("--------- Paying Deposit ---------");
                        System.out.println("Enter your card number: ");
                        int cardNumber = validator.receiveInt();
                        System.out.println("Enter your security code: ");
                        int code = validator.receiveInt();
                        System.out.println("Successful payment !");
                        System.out.println("Do you want to print receipt or not (select 1 or 2)");
                        System.out.println("1 YES");
                        System.out.println("2 NO");
                        int printOrNot =validator.receiveInt();
                        if (printOrNot == 1){
                            customerController.printReceipt(whichQuotation,cardNumber);
                        }
                        else if (printOrNot == 2)
                        {
                        return false;
                        }
                    }
                    else
                    {

                    }
                    break;
            case 2: return false;
            default:  System.out.println("Please choose the option correctly");
        }
        return true;
    }




/*public boolean displayPaymentMenu()
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
    }*/
}

