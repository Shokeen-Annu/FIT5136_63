import java.util.Scanner;

public class OwnerInterface {
    private int choiceNumber;
    private InputValidation validator = new InputValidation();
    private CommonController commonController = new CommonController();
    public void displayOwnerMenu()
    {
        boolean flag = true;
        do {
            System.out.println("      WELCOME TO OWNER MENU     ");
            System.out.println();
            System.out.println("1 CREATE HALL");
            System.out.println("2 MANAGE HALL");
            System.out.println("3 MANAGE BOOKING");
            System.out.println("4 VIEW BOOKING HISTORY OF OWNER HALLS");
            System.out.println("5 MANAGE OWNER DISCOUNT");
            System.out.println("6 LOG OUT");
            System.out.println();
            System.out.println("Enter your choice number:");
            //Test
            Scanner scanner = new Scanner(System.in);
            choiceNumber = scanner.nextInt();

            if (choiceNumber == 1) {
                System.out.println("-------------- CREATE HALL --------------");
                System.out.println();
                System.out.println();
                System.out.println("please provide information");
                flag = backMenu();

            }
            else if (choiceNumber == 2) {

                flag = displayManageHallMenu();
            }
            else if (choiceNumber == 3) {
                flag = displayManageBookingMenu();
            }
            else if (choiceNumber == 4) {
                System.out.println("View booking history of Halls");
                flag = backMenu();
            }
            else if (choiceNumber == 5) {
                flag = displayManageDiscountMenu();
            }
            else if (choiceNumber == 6) {
                flag = true;
                commonController.logout("Do you want to logout");
            }
            else {
                System.out.println();
                System.out.println("Re-enter your option!");
                System.out.println();
            }
        } while (choiceNumber < 1 || choiceNumber >6 || !flag);
    }
    public boolean displayManageHallMenu()
    {
        boolean manageHallFlag = true;

        do {
            System.out.println("------------- MANAGE HALLS ----------------");
            System.out.println();
            System.out.println("1 VIEW OWNER HALLS");
            System.out.println("2 UPDATE HALLS");
            System.out.println("3 DELETE HALLS");
            System.out.println("4 VIEW REVIEW OF HALLS");
            System.out.println("5 RETURN TO OWNER MENU");
            System.out.println("Enter your choice number:");
            Scanner scanner = new Scanner(System.in);
            choiceNumber = scanner.nextInt();

            if (choiceNumber == 1) {
                System.out.println("-------------- VIEW OWNER HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println("The page of View owner halls");
                manageHallFlag = backMenu();
            }
            else if (choiceNumber == 2) {
                System.out.println("-------------- UPDATE HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println(" Provide information to update halls");
                manageHallFlag = backMenu();
            }
            else if (choiceNumber == 3) {
                System.out.println("-------------- DELETE HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println("Please provide information to delete hall");
                manageHallFlag = backMenu();
            }
            else if (choiceNumber == 4) {
                System.out.println("-------------- VIEW REVIEWS OF HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println("This is the view review of halls page" );
                manageHallFlag = backMenu();
            }
            else if (choiceNumber == 5)
            {
                return false;
            }
            else {
                System.out.println("Re-enter your option");
            }
        } while (choiceNumber < 1 || choiceNumber >4 || !manageHallFlag);
        return true;
    }
    public boolean displayManageBookingMenu()
    {
        boolean manageBookingFlag = true;

        do {
            System.out.println("      MANAGE BOOKING     ");
            System.out.println();
            System.out.println("1 VIEW RECEIPT");
            System.out.println("2 PROVIDE QUOTATION");
            System.out.println("3 CANCEL BOOKING");
            System.out.println("4 RETURN TO OWNER MENU");
            Scanner scanner = new Scanner(System.in);
            choiceNumber = scanner.nextInt();

            if (choiceNumber == 1) {
                System.out.println("You can view receipts here");
                manageBookingFlag = backMenu();
            }
            else if (choiceNumber == 2) {
                System.out.println("Please provide quotation to customer here");
                manageBookingFlag = backMenu();
            }
            else if (choiceNumber == 3) {
                System.out.println("You can cancel a booking here");
                manageBookingFlag = backMenu();
            }
            else if (choiceNumber == 4) {
                return false;
            }
            else {
                System.out.println("Re-enter your option");
            }
        } while (choiceNumber < 1 || choiceNumber >4 || !manageBookingFlag);
        return true;
    }

    public boolean displayManageDiscountMenu ()
    {
        boolean manageOwnerDiscountFlag = true;

        do {
            System.out.println("      MANAGE OWNER DISCOUNTS    ");
            System.out.println();
            System.out.println("1 ADD DISCOUNT");
            System.out.println("2 DELETE DISCOUNT");
            System.out.println("3 EDIT DISCOUNT");
            System.out.println("4 RETURN TO OWNER MENU");
            Scanner scanner = new Scanner(System.in);
            choiceNumber = scanner.nextInt();

            if (choiceNumber == 1) {
                System.out.println("Please add discount information");
                manageOwnerDiscountFlag = backMenu();

            }
            else if (choiceNumber == 2) {
                System.out.println("You can delete discount here");
                manageOwnerDiscountFlag = backMenu();
            }
            else if (choiceNumber == 3) {
                System.out.println("You can edit discount here");
                manageOwnerDiscountFlag = backMenu();
            }
            else if (choiceNumber == 4) {
                return false;
            }
            else {
                System.out.println("Re-enter your option");
            }
        } while (choiceNumber < 1 || choiceNumber >4 || !manageOwnerDiscountFlag );

        return true;
    }
    public boolean backMenu()
    {
        System.out.println("Press 0 to return to menu");
        int input = validator.receiveInt();
        if(input == 0)
            return false;
        else
            return true;
    }
}
