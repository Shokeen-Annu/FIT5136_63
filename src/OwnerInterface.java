import java.util.ArrayList;
/**
 *  This is the a owner boundary class. The method in this class is to display all the menu about owner.
 *
 * @author    Annu Shokeen, zhijie li, Yuwu
 * @version   20/10/2019
 */

public class OwnerInterface {
    private int choiceNumber;
    private InputValidation validator = new InputValidation();
    private CommonController commonController = new CommonController();
    private OwnerController ownerController = new OwnerController();
    public void displayOwnerMenu()
    {
        boolean flag = true;
        commonController.createOwnerDiscountList();
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

            choiceNumber = validator.receiveInt();

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
                int choiceLogout;
                do {
                    System.out.println("Are you sure you want to logout? Enter your choice number");
                    System.out.println("1 Yes");
                    System.out.println("2 No");
                    choiceLogout = validator.receiveInt();
                    flag = commonController.logout(choiceLogout);
                }while(choiceLogout == -1);
            }
            else {
                System.out.println();
                System.out.println("Please enter your choice correctly!");
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

            choiceNumber = validator.receiveInt();

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
                boolean repeat = false;
                boolean isDeleteConfirmed = true;
                System.out.println("-------------- DELETE HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println("Please select hall from the list below:");
                commonController.viewHalls("OWNER",
                        Integer.toString(PrimeEvents.getEventUser().getUserId()));
                do {
                    boolean isDeleteSuccess = false;
                    System.out.println("Enter hall number to delete:");
                    int hallId = validator.receiveInt();
                    if (hallId == -1)
                        repeat = true;
                    else {
                        ArrayList<Hall> allHalls = PrimeEvents.getHallList();
                        Hall hall = null;
                        for(Hall item: allHalls)
                        {
                            if(item.getHallId() == hallId) {
                                hall = item;
                                repeat = false;
                            }
                        }
                        if(hall == null) {
                            System.out.println("No such hall exist.");
                            repeat = true;
                        }
                        if(!repeat) {
                            boolean confirmationRepeat = false;
                            do {
                                System.out.println("Are you sure you want to delete the hall?");
                                System.out.println("Enter your choice number");
                                System.out.println("1 Yes");
                                System.out.println("2 No");
                                int isConfirmation = validator.receiveInt();
                                if (isConfirmation == -1)
                                    confirmationRepeat = true;
                                else if (isConfirmation == 2) {
                                    isDeleteConfirmed = false;
                                    System.out.println("Hall is not deleted.");
                                    System.out.println("Do you want to select hall again?");
                                    boolean isSelectHallAgain = false;
                                    do {
                                        System.out.println("Enter your choice number");
                                        System.out.println("1 Yes");
                                        System.out.println("2 No");
                                        int userSelection = validator.receiveInt();
                                        if (userSelection == -1) {
                                            isSelectHallAgain = true;
                                            repeat = false;
                                        }
                                        else if (userSelection == 1) {
                                            repeat = true;
                                            isSelectHallAgain = false;
                                        }
                                        else
                                        {
                                            repeat = false;
                                            isSelectHallAgain = false;
                                        }
                                    }while(isSelectHallAgain);

                                }
                                else if (isConfirmation == 1)
                                    isDeleteConfirmed = true;
                            } while (confirmationRepeat);
                            if (isDeleteConfirmed) {
                                isDeleteSuccess = ownerController.deleteHall(hall);
                                if (isDeleteSuccess)
                                    System.out.println("Hall is deleted successfully");
                                else {
                                    System.out.println("Please enter correct hall number from the list provided.");
                                    repeat = true;
                                }
                            }
                        }
                    }
                }while(repeat);

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
            System.out.println("2 VIEW QUOTATION");
            System.out.println("3 CANCEL BOOKING");
            System.out.println("4 RETURN TO OWNER MENU");

            choiceNumber = validator.receiveInt();

            if (choiceNumber == 1) {
                System.out.println("You can view receipts here");
                manageBookingFlag = backMenu();
            }
            else if (choiceNumber == 2) {
                ownerController.readQuotationFromTxt();
                changeQuotation(false);

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
            System.out.println("PLEASE ENTER A CHOICE");
            choiceNumber = validator.receiveInt();

            if (choiceNumber == 1) {
                System.out.println("Please add discount information");
                ownerController.addDiscount();
                manageOwnerDiscountFlag = backMenu();

            }
            else if (choiceNumber == 2) {
                System.out.println("You can delete discount here");
                commonController.deleteDiscount();
                manageOwnerDiscountFlag = backMenu();
            }
            else if (choiceNumber == 3) {
                System.out.println("You can edit discount here");
                commonController.editDiscount();
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

    /**
     * This method is used to back to  previous page.
     *
     * @return boolean to back menu
     **/
    public boolean backMenu()
    {
        System.out.println("Press 0 to return to menu");
        int input = validator.receiveInt();
        if(input == 0)
            return false;
        else
            return true;
    }

    public boolean changeQuotation (boolean isMainMenu)
    {

        System.out.println("Please Enter hall Id you want to change quotation a");
        int hallId = validator.receiveInt();
        System.out.println("Please Enter Customer Id you want to change quotation ");
        int customerId = validator.receiveInt();

        if(ownerController.readQuotationFromOwner(hallId,customerId))
        {
            int price =validator.receiveInt();
            ownerController.changePrice(hallId,customerId,price);

        }
        else
        {
            return false;
        }

        return true;
    }
}
