import java.util.ArrayList;
import java.util.Date;

public class CustomerController {
    private Customer customer = new Customer();
    private  Booking booking = new Booking();
    private PrimeEvents primeEvents = new PrimeEvents();

    public boolean bookHall(int id)
    {
        boolean result = true;
        int checkId = primeEvents.getSpecificHall(id-1).getHallId() +1;
        if (id != checkId)
       {
            result = false;
       }
       return result;
    }

    public boolean askForConfirmation(int choice)
    {
        boolean tryAgain = false;
        if (choice == 1 )
        {
            tryAgain = true;
         }
        else  {
            tryAgain = false;
        }
        return tryAgain;
    }

    public void requestForQuotation(int hallId,Date date,Date bookinStartDate, Date bookingFinishDate, int numberOfGuest,double price,
                                    boolean isCatering, String typeOfMeal)
    {

        int customerId = customer.getUserId();
        customer.quoatationAdd(date,bookinStartDate, bookingFinishDate,numberOfGuest,customerId,hallId, price,
       isCatering, typeOfMeal);
        // save quotation into customer quotation list
    }
    private boolean cancelBooking(int bookingId)
    {
        boolean result = false;
        //code here
        return result;

    }

    private boolean updateBooking(int bookingId)
    {
        boolean result = false;
        //code here
        return result;
    }



    public void viewQuotation(int quotationId)
    {

    }

    private boolean updateAccount(String email, String password)
    {
        boolean result = false;
        //code here
        return result;
    }

    public void provideReview(int bookingId)
    {

    }

    private boolean payDeposit(int hallId,double price)
    {
        boolean result = false;
        //code here
        return result;
    }

    private void viewReceipt(int bookingId)
    {

    }
    public ArrayList<String> setCardDetails(String accountName,String cardNo,String cardPin)
    {
        ArrayList<String> cardDetails = new ArrayList<>();
        //code here
        return  cardDetails;
    }




}
