import java.util.ArrayList;

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
           System.out.println("The hall is not exist");
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

    public void requestForQuotation( )
    {


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
