import java.util.Scanner;

public class Customer extends User {

    public void displayCustomerMenu()
    {
        int customerNumber = -1;
        do {
        System.out.println("1 SEARCH A HALL");
        System.out.println("2 VIEW ALL HALLS");
        System.out.println("3 BOOK HALL");
        System.out.println("4 REQUEST A QUOTATION");
        System.out.println("5 VIEW QUOTATION");
        System.out.println("6 CANCEL BOOKING");
        System.out.println("7 UPDATE BOOKING");
        System.out.println("8 UPDATE CUSTOMER INFORMATION");
        System.out.println("9 LOG OUT");

        Scanner scanner = new Scanner(System.in);
        String customerInput = scanner.nextLine();
        boolean isExit = false;

                if (isNumber(customerInput) == false)
                {
                    System.out.println("Please enter the number");
                }
                else if (customerInput.length() == 0)
                {
                    System.out.println("Please enter the option");
                }
                else {
                          customerNumber = Integer.parseInt(customerInput);
                         switch (customerNumber) {
                         case 1: searchHalls(false);
                         break;
                         case 2: viewHalls(false);
                         break;
                         case 3: bookHalls();
                         break;
                         case 4: requestQuotation();
                         break;
                         case 5: viewQuotation();
                         break;
                         case 6: cancelBooking();
                         break;
                         case 7: updateBooking();
                         break;
                         case 8: updateCustInfo();
                         break;
                         case 9:
                             isExit = true;
                             new PrimeEvents().logout();
                         break;
                         default: System.out.println("Please enter the option correctly");
                         break;
                      }
            }
                if(!isExit) {
                    System.out.println("Enter 0 to go back to main menu");
                    customerNumber = scanner.nextInt();
                }
        }while (customerNumber < 1 || customerNumber > 9);
    }
    public  void viewHalls(boolean isMainMenu)
    {
        System.out.println("-------------- VIEW HALLS --------------");
        System.out.println();
        System.out.println();
        System.out.println("View all halls page");
    }
    public  void viewQuotation()
    {
        System.out.println("-------------- VIEW QUOTATIONS --------------");
        System.out.println();
        System.out.println();
        System.out.println("View all quotations page");
    }
    public  void requestQuotation()
    {
        System.out.println("-------------- REQUEST QUOTATION --------------");
        System.out.println();
        System.out.println();
        System.out.println("Request a quotation page");
    }
    public  void cancelBooking()
    {
        System.out.println("-------------- CANCEL BOOKING --------------");
        System.out.println();
        System.out.println();
        System.out.println("Cancel booking page.");
    }
    public  void updateBooking()
    {
        System.out.println("-------------- UPDATE BOOKING --------------");
        System.out.println();
        System.out.println();
        System.out.println("Update booking page");
    }
    public  void updateCustInfo()
    {
        System.out.println("-------------- UPDATE PROFILE --------------");
        System.out.println();
        System.out.println();
        System.out.println("Update customer information page");
    }
    public void searchHalls(boolean isMainMenu)
    {
        //boolean flag = true;
        int searchChoice;
        do {

            System.out.println("------Search a hall page---------");
            System.out.println("Choose one way to search a hall");
            System.out.println("1 NAME OF HALL");
            System.out.println("2 STAR RATING");
            System.out.println("3 OCCASION TYPE");
            System.out.println("4 LOCATION");
            System.out.println("5 DATE");
            System.out.println("6 BACK TO MAIN MENU");


            Scanner scanner = new Scanner(System.in);
            searchChoice = scanner.nextInt();

            switch (searchChoice) {
                case 1:
                    System.out.println("Please enter the name of hall");
                    break;
                case 2:
                    System.out.println("Please enter the rating");
                    break;
                case 3:
                    System.out.println("Please enter a occasion type");
                    break;
                case 4:
                    System.out.println("Please enter a location");
                    break;
                case 5:
                    System.out.println("Please enter a date");
                    break;
                case 6:
                    if(isMainMenu)
                        new PrimeEvents().displayMainMenu();
                    else
                        displayCustomerMenu();
                    break;
                default:
                    System.out.println("Please choose the option correctly");
                    break;
            }
            System.out.println("Enter 0 to go back to main menu");
            searchChoice = scanner.nextInt();

        }while(searchChoice == 0);
    }

    public void bookHalls()
    {
        int choice;
        do {
        System.out.println("--------- BOOK HALL -----------");
        System.out.println();
        System.out.println("1 PAY DEPOSIT");
        System.out.println("2 PROVIDE RATING");
        System.out.println("3 BACK TO MAIN MENU");
        Scanner scanner = new Scanner(System.in);
         choice = scanner.nextInt();
        switch (choice)
        {
            case 1: payment();
            break;
            case 2: System.out.println("Rating page");
            break;
            case 3: displayCustomerMenu();
            break;
        }
            System.out.println("Enter 0 to go back to main menu");
            choice = scanner.nextInt();

        }while(choice == 0);
    }

    public void payment()
    {
        int payChoice;
        do {
        System.out.println("------ PAY DEPOSIT -------");
        System.out.println("1 PAY PAYMENT");
        System.out.println("2 VIEW RECEIPT");
        System.out.println("3 BACK TO MAIN MENU");
        Scanner scanner = new Scanner(System.in);
        payChoice = scanner.nextInt();
        switch(payChoice)
        {
            case 1: System.out.println("Please provide card details for payment");
            break;
            case 2: System.out.println("Receipt page ");
            break;
            case 3: displayCustomerMenu();
            break;
            default: System.out.println("Please enter the right option");
            break;
        }
            System.out.println("Enter 0 to go back to main menu");
            payChoice = scanner.nextInt();

        }while(payChoice == 0);
    }

    public boolean isNumber(String inputLength)
    {
        for (int i = 0; i < inputLength.length();i++)
        {
            char inputCharacter = inputLength.charAt(i);
            if (inputCharacter < '0' || inputCharacter > '9')
            {
                return false;
            }
        }
        return true;
    }

}
