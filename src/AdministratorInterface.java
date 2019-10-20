import java.util.Scanner;
/**
 *  This is the an administrator boundary class. The method in this class tis to display the  menu administrator.
 *
 * @author    Annu Shokeen
 * @version   20/10/2019
 */

public class AdministratorInterface{
    private InputValidation validator = new InputValidation();
    private CommonController commonController = new CommonController();

/**
* This method displays the administrator main menu.
*/
    public void displayAdminMenu()
    {
        int admInput = -1;
        boolean flag = true;
        do {
        System.out.println("      WELCOME TO ADMINISTRATOR MENU     ");
        System.out.println();
        System.out.println("1 VIEW BOOKING HISTORY");
        System.out.println("2 VIEW REVIEW OF HALLS");
        System.out.println("3 DELETE CUSTOMER");
        System.out.println("4 MANAGE ADMINISTRATOR DISCOUNT");
        System.out.println("5 VIEW ALL HALLS");
        System.out.println("6 LOG OUT");
        System.out.println();
        System.out.println("Enter your choice number:");
        Scanner scanner = new Scanner(System.in);
        admInput = scanner.nextInt();

        switch(admInput)
        {
            case 1: flag = viewBookingHistoryMenu();
            break;
            case 2: System.out.println();
                System.out.println("View reviews of halls here");
                flag = backMenu();
            break;
            case 3: System.out.println();
                manageCustomerMenu();
                flag = backMenu();
            break;
            case 4: flag = manageDiscountMenu();
            break;
            case 5: commonController.viewHalls("ALL","");
                    flag = backMenu();
            break;
            case 6:int choiceLogout;
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

    }while(admInput<1 || admInput>6 || !flag);
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
        do{
            System.out.println("Press 0 to return to menu");
            admInput = validator.receiveInt();
            if (admInput == 0)
                result = false;
            else
                result = true;
        }while(admInput == -1);
        return result;
    }

/**
 * This method displays the menu for viewing booking history.
 *
 *@return boolean This is for the back to previous menu
**/
    public boolean viewBookingHistoryMenu() {
        boolean flag = true;
        int admView = -1;
        do {
            System.out.println("      VIEW BOOKING HISTORY     ");
            System.out.println();
            System.out.println("1 VIEW BY CUSTOMERS");
            System.out.println("2 VIEW BY OWNER");
            System.out.println("3 BACK TO ADMINISTRATOR MAIN MENU");
            System.out.println();
            System.out.println("Enter your choice number:");
            Scanner scanner = new Scanner(System.in);
            admView = scanner.nextInt();

            switch (admView) {
                case 1:
                    System.out.println("View history for customers");
                    flag = backMenu();
                    break;
                case 2:
                    System.out.println("View history for owners");
                    flag = backMenu();
                    break;
                case 3:
                    return false;
                default:
                    System.out.println("Re-enter your option!");
                    break;
            }
        }while(admView < 1 || admView > 3 || !flag);

        return true;
    }

/**
 * This method displays the menu for managing discount
 *
 * @return boolean This is for the back to  previous Menu
**/
    public boolean manageDiscountMenu()
    {
        int admDis = -1;
        boolean flag = true;
        do {
        System.out.println("      MANAGE ADMINISTRATOR DISCOUNTS     ");
        System.out.println();
        System.out.println("1 ADD DISCOUNT");
        System.out.println("2 DELETE DISCOUNT");
        System.out.println("3 EDIT DISCOUNT");
        System.out.println("4 BACK TO ADMINISTRATOR MAIN MENU");
        System.out.println();
        System.out.println("Enter your choice number:");
        Scanner scanner = new Scanner(System.in);
        admDis = scanner.nextInt();

        switch (admDis)
        {
            case 1: System.out.println("Please add new discount here");
            flag = backMenu();
            break;
            case 2: System.out.println("Please delete discount here");
                flag = backMenu();
            break;
            case 3: System.out.println("Please edit discount here");
                flag = backMenu();
            break;
            case 4: return false;
            default: System.out.println("Re-enter your option!");
            break;
        }

        }while(admDis < 1 || admDis > 4 || !flag);
        return true;
    }

    public boolean manageCustomerMenu()
    {
        return false;
    }

}