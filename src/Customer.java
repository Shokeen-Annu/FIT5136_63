import java.util.ArrayList;
import java.util.Scanner;

public class Customer extends User {

    private boolean isSeniorCitizen;
    private boolean isVeteran;
    private String securityQuestion1;
    private String securityQuestion2;
    private String securityAnswer1;
    private String securityAnswer2;
    private ArrayList<String> cardDetails;
    private ArrayList<Booking> bookingList;
    private ArrayList<Quotation> quotationList;

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
                         case 1: flag = searchHalls(false);
                         break;
                         case 2: flag = viewHalls();
                         break;
                         case 3: flag = bookHalls();
                         break;
                         case 4: flag = requestQuotation();
                         break;
                         case 5: flag = viewQuotation();
                         break;
                         case 6: flag = cancelBooking();
                         break;
                         case 7: flag = updateBooking();
                         break;
                         case 8: flag = updateCustInfo();
                         break;
                         case 9:
                             flag = true;
                             PrimeEvents.logout();
                         break;
                         default: System.out.println("Please enter the option correctly");
                         break;
                      }
            }

        }while (customerNumber < 1 || customerNumber > 9 || !flag);
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

    public  boolean viewQuotation()
    {
        System.out.println("-------------- VIEW QUOTATIONS --------------");
        System.out.println();
        System.out.println();
        System.out.println("View all quotations page");
        boolean flag = repeat();
        return flag;
    }
    public  boolean requestQuotation()
    {
        System.out.println("-------------- REQUEST QUOTATION --------------");
        System.out.println();
        System.out.println();
        System.out.println("Request a quotation page");
        boolean flag = repeat();
        return flag;
    }
    public  boolean cancelBooking()
    {
        System.out.println("-------------- CANCEL BOOKING --------------");
        System.out.println();
        System.out.println();
        System.out.println("Cancel booking page.");
        boolean flag = repeat();
        return flag;
    }
    public  boolean updateBooking()
    {
        System.out.println("-------------- UPDATE BOOKING --------------");
        System.out.println();
        System.out.println();
        System.out.println("Update booking page");
        boolean flag = repeat();
        return flag;
    }
    public  boolean updateCustInfo()
    {
        System.out.println("-------------- UPDATE PROFILE --------------");
        System.out.println();
        System.out.println();
        System.out.println("Update customer information page");
        boolean flag = repeat();
        return flag;
    }
    public boolean searchHalls(boolean isMainMenu)
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
            System.out.println("4 LOCATION");
            System.out.println("5 DATE");
            System.out.println("6 BACK TO MAIN MENU");
            System.out.println();
            System.out.println("Enter your choice number:");

            Scanner scanner = new Scanner(System.in);
            searchChoice = scanner.nextInt();

            switch (searchChoice) {
                case 1:
                    System.out.println("Please enter the name of hall");
                    flag = repeat();
                    break;
                case 2:
                    System.out.println("Please enter the rating");
                    flag = repeat();
                    break;
                case 3:
                    System.out.println("Please enter a occasion type");
                    flag = repeat();
                    break;
                case 4:
                    System.out.println("Please enter a location");
                    break;
                case 5:
                    System.out.println("Please enter a date");
                    flag = repeat();
                    break;
                case 6:
                   // if(isMainMenu)
                   //     new PrimeEvents().displayMainMenu();
                   // else
                   //     displayCustomerMenu();
                    return false;
                default:
                    System.out.println("Please choose the option correctly");
                    break;
            }

        }while(searchChoice < 1 || searchChoice > 6 || !flag);
        return true;
    }

    public boolean bookHalls()
    {
        int choice;
        boolean flag = true;
        do {
        System.out.println("--------- BOOK HALL -----------");
        System.out.println();
        System.out.println("1 PAY DEPOSIT");
        System.out.println("2 PROVIDE RATING");
        System.out.println("3 BACK TO MAIN MENU");
        System.out.println();
        System.out.println("Enter your choice number:");
        Scanner scanner = new Scanner(System.in);
         choice = scanner.nextInt();
        switch (choice)
        {
            case 1: payDeposit();
            flag = repeat();
            break;
            case 2: provideRating();
                //System.out.println("Please provide rating of hall here");
            flag = repeat();
            break;
            case 3: return false;

        }

        }while(choice < 1 || choice > 3 || !flag);
        return true;
    }

    public boolean payDeposit()
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
            flag = repeat();
            break;
            case 2: System.out.println("You can view your receipt here.");
                flag = repeat();
            break;
            case 3: return false;
            default: System.out.println("Please enter the right option");
            break;
        }

        }while(payChoice < 1 || payChoice > 3 || !flag);
        return true;
    }

    public boolean provideRating()
    {
        int payChoice;
        int rating;
        boolean flag = true;
        System.out.println("Please enter your rating for this booking");
        Scanner scanner = new Scanner(System.in);
        rating = scanner.nextInt();
        System.out.println("Thanks for your rating");
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
    public boolean getIsSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }

    public boolean getIsVeteran() {
        return isVeteran;
    }

    public void setVeteran(boolean veteran) {
        isVeteran = veteran;
    }

    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    public ArrayList<String> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(ArrayList<String> cardDetails) {
        this.cardDetails = cardDetails;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public ArrayList<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotationList(ArrayList<Quotation> quotationList) {
        this.quotationList = quotationList;
    }
}
