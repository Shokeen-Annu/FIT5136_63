import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OwnerController {
    private ArrayList<Discount> ownerDiscount;
    private InputValidation input = new InputValidation();
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
    private boolean addDiscount(String name, double value, int id, String comments)
    {

        System.out.println("Please enter discount name");
        String discountName = input.receiveString().trim();



    }
    public void writeFile(String filename) {

        if (filename.trim().length() > 0) {
            try {
                PrintWriter output = new PrintWriter(filename);
                for (int i = 0; i < ownerDiscount.size(); i++) {
                    String contents =  ownerDiscount.get(i).getDiscountId()+ "," + ownerDiscount.get(i).getDiscountName() + "," + ownerDiscount.get(i).getValue() + ","
                            + ownerDiscount.get(i).getComments() + ";";
                    output.print(contents);
                }
                output.close();
            } catch (IOException e) {
                System.out.println("I/O Error");
            }
        } else {
            System.out.println("Enter a filename:");
        }
    }
    private boolean isHallPresent(int hallId)
    {

    }

}

