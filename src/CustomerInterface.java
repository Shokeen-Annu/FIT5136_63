import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
/**
 *  This is the a customer boundary class, which provides all the menu can be used by the customer.
 *
 * @author    Zhijie Li, YuWu
 * @version   20/10/2019
 */
public class CustomerInterface{

    private InputValidation validator = new InputValidation();
    private CommonController commonController = new CommonController();
    private CustomerController customerController = new CustomerController();

    /**
     * This method displays the customer menu.
     */
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
       // System.out.println("4 REQUEST A QUOTATION");
      //  System.out.println("5 VIEW QUOTATION");
        System.out.println("4 CANCEL BOOKING");
        System.out.println("5 UPDATE BOOKING");
        System.out.println("6 UPDATE CUSTOMER INFORMATION");
        System.out.println("7 LOG OUT");              // View booking history needs to be added.
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
                        /* case 4:
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
                         break;*/
                         case 4:
                             System.out.println("-------------- CANCEL BOOKING --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("Cancel booking page.");
                             flag = backMenu();
                         break;
                         case 5:
                             System.out.println("-------------- UPDATE BOOKING --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("Update booking page");
                             flag = backMenu();
                         break;
                         case 6:
                             System.out.println("-------------- UPDATE PROFILE --------------");
                             System.out.println();
                             System.out.println();
                             System.out.println("Update customer information page");
                             flag = backMenu();
                         break;
                         case 7:int choiceLogout;
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

    /**
     * This method is used to back to  previous page.
     *
     * @return boolean to back menu
     **/
    public boolean backMenu()
    {
        int admInput;
        boolean result;
        do {
            System.out.println("Press 0 to return to menu");
            admInput = validator.receiveInt();
            if (admInput == 0)
                result =  false;
            else
                result = true;
        }while(admInput == -1);
        return result;
    }
    /**
     * This method is used to back or to select hall menu
     *
     * @return boolean to back menu
     **/
    public boolean newBackMenu()
    {
        int admInput;
        boolean result;
        do {
            System.out.println("Press 0 to return to menu or press 9 to select the hall");
            admInput = validator.receiveInt();
            if (admInput == 0)
                result = false;
            else
                result = true;
        }while(admInput == -1);
        return result;
    }
    /**
     * This method displays the search hall menu.
     *
     * @return boolean returns to check whether the user want to back to previous page
     **/
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
            System.out.println("6 BACK TO MAIN MENU");
            System.out.println();
            System.out.println("Enter your choice number:");

            Scanner scanner = new Scanner(System.in);
            searchChoice = validator.receiveInt();
            String searchInput = " ";
            boolean specialChar = true;
            switch (searchChoice) {
                case -1:break;
                case 1:
                         do{
                               System.out.println("Please enter the name of hall");
                               searchInput = validator.receiveString().trim().toUpperCase();
                               specialChar = validator.validateSpecialChar(searchInput);
                               if(searchInput.isEmpty() == true || specialChar == false)
                               {
                                   System.out.println("Please enter the correct format!! Do not " +
                                           "enter $ or empty string.");
                               }
                         }while(searchInput.isEmpty() == true || specialChar == false);
                         commonController.viewHalls("NAME", searchInput);

                    if(isBookHall)
                        flag = newBackMenu();
                    else
                        flag = backMenu();
                    break;
               /* case 2:
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
                    break;*/
                case 6:
                    return false;
                default:
                    flag = false;
                    System.out.println("Please choose the option correctly");
                    break;
            }

        }while(searchChoice < 1 || searchChoice > 6 || !flag);
        return true;
    }

    /**
     * This method displays the booking hall menu.
     *
     * @return boolean returns to check whether the user want to back to previous page
     **/
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

    /**
     * This method to display booking process step by step.
     *
     * @return boolean returns to check whether the user want to back to previous page
     **/
    public boolean bookingMenu(boolean isMainMenu) {
        boolean flag = true;
        //displaySearchHallMenu(false, true);
        do {
            boolean isSelectHallIdAgain = false;
            do{
            System.out.println("Please enter the hall ID to select the hall");
            int hallId = validator.receiveInt();
            if(hallId == -1)
            {
                isSelectHallIdAgain = true;
            }
            else {
                if (customerController.bookHall(hallId))
                {
                    System.out.println("Are you sure you want to book this hall? Enter your choice number? (select 1 or 2)");
                    System.out.println("1 YES");
                    System.out.println("2 NO");
                    int choiceBook = validator.receiveInt();
                    if (customerController.askForConfirmation(choiceBook))
                    {
                        sendQuotation(hallId);
                        System.out.println("Do you want to request quotation? (select 1 or 2)");
                        System.out.println("1 YES");
                        System.out.println("2 NO");
                        boolean isSelectAgain = false;
                        do {
                            int choice = validator.receiveInt();
                            if (choice == -1) {
                                isSelectAgain = true;
                                } else {
                                switch (choice) {
                                    case 1:
                                        customerController.saveQuotation();
                                        System.out.println("Quotation already sent to owner.");
                                        break;
                                    case 2:
                                        return false;
                                    default:
                                        System.out.println("Please choose the option correctly");
                                        break;
                                    }
                                }
                            } while (isSelectAgain);
                        flag = true;
                    }
                } else {
                    System.out.println("The hall is not exist");
                    System.out.println("Do you want to re-enter or not");
                    System.out.println("1 YES");
                    System.out.println("2 NO");
                    boolean selectAgain = false;
            do{
                    int choose = validator.receiveInt();
                    if (choose == -1)
                    {
                        selectAgain =true;
                    }
                    else {
                        switch (choose) {
                            case 1:
                                flag = false;
                                break;
                            case 2:
                                flag = true;
                                break;
                            default:
                                System.out.println("Please choose the option correctly");
                                break;
                        }
                    }
            }while(selectAgain );
                    }
                }
            }while (isSelectHallIdAgain);
        } while (!flag) ;
        return true;

    }

    /**
     * This method will pass the quotation details which customer inputs to customerController
     **/
public void sendQuotation(int hallId){
    Date todayDate = new Date();
    Date bookingStartDate = new Date();
    Date bookingFinishDate = new Date();
    boolean temp = true;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    dateFormat.setLenient(false);
    System.out.println("Now you need to write the quotation details");

    while(temp) {
        try {
            System.out.println("Which date you want to start (dd-MM-yyyy)");
            boolean flag = true;
            while(flag) {
                bookingStartDate = dateFormat.parse(validator.receiveString());
                if (bookingStartDate.compareTo(todayDate) < 0) {
                    System.out.println("Booking start date should not be earlier than today date");
                    flag = true;
                }
               else{
                  break;
                }
            }
            temp = false;
        } catch (ParseException e) {
            System.out.println("Please enter right format of date: dd-MM-yyyy");
        }
    }

    boolean temp2 = true;
    while(temp2) {
        try {
            System.out.println("Which date you want to finish (dd-MM-yyyy)");
            boolean flag2 = true;
            while(flag2) {
                bookingFinishDate = dateFormat.parse(validator.receiveString());
                if (bookingFinishDate.compareTo(bookingStartDate) < 0) {
                    System.out.println("Booking finish date should not be earlier than booking start date date");
                    flag2 = true;
                }
                else{
                    break;
                }
            }

            temp2 = false;
        } catch (ParseException e) {
            System.out.println("Please enter right format of date: dd-MM-yyyy");
        }
    }

        System.out.println("The number of Guest :");
        boolean selectAgain = true;
        int numberOfGuest = 0;
        do {
         numberOfGuest =validator.receiveInt();
         if(numberOfGuest==-1)
         {
          selectAgain = true;
         }
         else{
             selectAgain=false;
         }
        }while(selectAgain) ;
        double price = 0;
        System.out.println("If you want to catering, please enter 'Yes' or 'No' (select 1 or 2)");
        System.out.println("1 YES");
        System.out.println("2 NO");

        boolean isCatering = false;
        String typeOfMeal =" ";
        boolean isEnterAgain = true;
       do {
           int isCateringInt = validator.receiveInt();
           if (isCateringInt == 1) {
               isCatering = true;
               System.out.println("What type of meal you want to :");
               boolean isSelectMealAgain = false;
               do {
                   typeOfMeal = validator.receiveString();

                   if (typeOfMeal.isEmpty() && !validator.isDollarSign(typeOfMeal)) {
                       System.out.println("Please enter what type of meal you want to :");
                       isSelectMealAgain = false;
                   }
               } while (isSelectMealAgain);
               //validate that string should not be empty
               isEnterAgain=false;
               customerController.requestForQuotation(hallId, todayDate, bookingStartDate, bookingFinishDate,
                       numberOfGuest, price, isCatering, typeOfMeal);
           }
           else if(isCateringInt == 2){
               customerController.requestForQuotation(hallId, todayDate, bookingStartDate, bookingFinishDate,
                       numberOfGuest, price, isCatering, typeOfMeal);
                 isEnterAgain=false;
           }
           else{
               isEnterAgain=true;
           }
       }while (isEnterAgain);
    System.out.println("--------- Your quotation ---------");
    System.out.println("Hall ID : "+ hallId);
    System.out.println("Quotation date : "+ dateFormat.format(todayDate));
    System.out.println("Booking Start Date : "+ dateFormat.format(bookingStartDate));
    System.out.println("Booking Finish Date : "+dateFormat.format(bookingFinishDate));
    System.out.println("Number Of Guests : "+ numberOfGuest);
    System.out.println("Price : "+ price);
    System.out.println("IsCatering : "+ isCatering);
    System.out.println("Type Of Meal : "+ typeOfMeal);
}

    /**
     * This method displays the quotations the customer has.
     *
     * @return boolean returns to check whether the user want to back to previous page
     **/
public boolean viewQuotation (boolean isMainMenu )
{
    customerController.readQuotationFromTxt();
    return true;
}
    /**
     * This method displays the pay deposit process step by step.
     *
     * @return boolean returns to check whether the user want to back to previous page
     **/
public boolean payDeposit (boolean isMainMenu)
    {
        boolean flag = true ;
        System.out.println("Do you want to pay deposit or not? (select 1 or 2)");
        System.out.println("1 YES");
        System.out.println("2 NO");
        boolean selectChoiceAgain = false;
        do {
            int choice = validator.receiveInt();
            switch (choice) {
                case 1:
                    System.out.println("Please choose which quotation you want to pay: (enter Quotation Id)");
                    boolean chooseAgain = false;
                    do {
                        int whichQuotation = validator.receiveInt();
                        if (whichQuotation == -1) {
                            chooseAgain = true;
                        } else {
                            if (customerController.readQuotationFromCustomer(whichQuotation)) {
                                System.out.println("--------- Paying Deposit ---------");
                                System.out.println("Enter your card number: ");
                                String cardNumber = validator.receiveString();
                                System.out.println("Enter your security code: ");
                                boolean isSelectAgain = false;
                                do {
                                    int code = validator.receiveInt();
                                    if (code == -1) {
                                        isSelectAgain = true;
                                    } else {
                                        isSelectAgain = false;
                                    }
                                } while (isSelectAgain);
                                System.out.println("Successful payment !");
                                System.out.println("Do you want to print receipt or not (select 1 or 2)");
                                System.out.println("1 YES");
                                System.out.println("2 NO");
                                int printOrNot = validator.receiveInt();
                                if (printOrNot == 1) {
                                    customerController.printReceipt(whichQuotation, cardNumber);
                                    return false;
                                } else if (printOrNot == 2) {
                                    return false;
                                }
                            }
                            else
                            {
                                selectChoiceAgain = false;
                            }
                        }
                    } while (chooseAgain);
                    break;
                case 2:
                    return false;
                default:
                    selectChoiceAgain = true;
                    System.out.println("Please choose the option correctly");
            }
        }while(selectChoiceAgain);
        return true;
    }
}

