import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OwnerController {
    private Owner owner;
    private InputValidation input = new InputValidation();
    private OwnerInterface ownerinterface = new OwnerInterface();
    private FileIO io = new FileIO();
    private boolean addHall(Hall hall)
    {

    }

    private Hall generateHallObject()
    {

    }
    private boolean deleteHall(Hall hall)
    {

    }
    private boolean updateHall(Hall hall)
    {

    }
    private void viewHalls(String type)
    {

    }
    private void viewReviewOfHall(int hallId)
    {

    }
    private Quotation provideQuotation(int quotationId)
    {

    }
    private boolean cancelBooking(int bookingId)
    {

    }
    private void viewBookingHistory(int bookingId)
    {

    }
    public void addDiscount()
    //String name, double value, int id, String comments
    {
        int choose = -1;
        do{
            System.out.println("Please enter discount name");
            String discountName = input.receiveString().trim();
            System.out.println("Please enter discount value");
            double discountValue = Double.parseDouble(input.receiveString().trim());
            System.out.println("Please enter comments for the discount");
            String discountComments = input.receiveString().trim();
            int discountId = owner.getDiscountList().size() + 1;
            System.out.println(discountId + "," + discountName + "," + discountValue + "," + discountComments + ";");
            System.out.println("Do you add the discount into system");
            System.out.println("1 YES     2 NO  (PLEASE ENTER NUMBER)");
            choose = input.receiveInt();
            if(choose == 1)
            {
                io.writeFile("Discounts", "contents");
            }
            else
                System.out.println("Please re-add the discount");
                System.out.println();
        }while(choose == 1);
    }


}

