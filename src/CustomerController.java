import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *  This is the an administrator controller. The method in this class is for administrator to realize their function.
 *
 * @author    Yuwu
 * @version   20/10/2019
 */

public class CustomerController {
    //private Customer customer = new Customer();
    private  Booking booking = new Booking();
    private PrimeEvents primeEvents = new PrimeEvents();
    private  Hall hall = new Hall();

    /**
     * This method check customer's input hall id exist or not.
     *
     * @return boolean returns to customerInterface to check the hall exist or not.
     **/
    public boolean bookHall(int id)
    {
        int checkId = 0;
        boolean result = false;
        for(Hall hall :primeEvents.getHallList() ) {
            checkId = hall.getHallId();

            if (id == checkId) {
                result = true;
                break;
            }
        }
       return result;
    }

    /**
     * This method ask customer to confirm customer want to book this hall or not.
     *
     * @return boolean returns to customerInterface to check customer want to confirm or not.
     **/
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

    /**
     * This method add what customer inputs the details quotation to quotation list of the customer.

     **/
    public void requestForQuotation(int hallId,Date date,Date bookingStartDate, Date bookingFinishDate, int numberOfGuest,double price,
                                    boolean isCatering, String typeOfMeal)
    {

        Customer customer = (Customer) PrimeEvents.getEventUser();
        int customerId = primeEvents.getEventUser().getUserId();
        customer.quotationAdd(date,bookingStartDate, bookingFinishDate,numberOfGuest,customerId,hallId, price,
                                isCatering, typeOfMeal);

        // save quotation into customer quotation list

    }

    /**
     * This method save quotation to txt file.
     **/
    public void saveQuotation()
    {
        FileIO fileIO = new FileIO();
        String message = "";
        Customer customer = (Customer) PrimeEvents.getEventUser();
        SimpleDateFormat sdf =   new SimpleDateFormat( " dd-MM-yyyy " );

        int customerId = PrimeEvents.getEventUser().getUserId();
        int hallId = customer.getLastQuotation().getHallId();

        Date date =  customer.getLastQuotation().getDate();
        String dateString = sdf.format(date);

        Date bookingStartDate = customer.getLastQuotation().getBookingStartDate();
        String  bookingStartDateString = sdf.format(bookingStartDate);

        Date bookingFinishDate = customer.getLastQuotation().getBookingFinishDate();
        String bookingFinishDateString = sdf.format(bookingFinishDate);
        int numberOfGuest = customer.getLastQuotation().getNumberOfGuest();
        double price = customer.getLastQuotation().getPrice();
        boolean isCatering = customer.getLastQuotation().isCatering();
        String typeOfMeal = " ";
        typeOfMeal = customer.getLastQuotation().getTypeOfMeal();

        // Create quotation id
        int maxId = 0;
        for(Quotation quotation:PrimeEvents.getQuotationList())
        {
            int id = quotation.getQuotationId();
            if(maxId < id)
                maxId = id;
        }
        message +=  dateString.trim() + "$" + bookingStartDateString.trim() + "$" +  bookingFinishDateString.trim() + "$"+ numberOfGuest + "$" + customerId + "$"
                    + hallId + "$"  + price + "$" +isCatering + "$"+ typeOfMeal + "$"+(maxId+1)+"$$";
        fileIO.writeFile("Quotations",message);
        PrimeEvents.createQuotationList();
    }

    /**
     * This method read "Quotations" txt file to read quotation's information and display.
     **/
    public void readQuotationFromTxt( ) {
        FileIO fileIO = new FileIO();
        System.out.println("---------There are your quotations:---------");
        ArrayList<Quotation> allQuotationList = PrimeEvents.getQuotationList();
        boolean isNoQuotation = true;
        for (Quotation quotation : allQuotationList) {

                Customer customer = (Customer) PrimeEvents.getEventUser();
                if (customer.getUserId() == quotation.getUserId() && quotation.getPrice()!=0.0) {
                    isNoQuotation = false;
                    Date date = quotation.getDate();
                    Date bookingStartDate = quotation.getBookingStartDate();
                    Date bookingFinishDate = quotation.getBookingFinishDate();
                    int numberOfGuest = quotation.getNumberOfGuest();
                    int customerId = quotation.getUserId();
                    int hallId = quotation.getHallId();
                    double price = quotation.getPrice();
                    boolean isCatering = quotation.isCatering();
                    String typeOfMeal = quotation.getTypeOfMeal();
                    customer.quotationAddFromText(date, bookingStartDate, bookingFinishDate, numberOfGuest, customerId, hallId, price,
                            isCatering, typeOfMeal, quotation.getQuotationId());
                    SimpleDateFormat dateFormat =   new SimpleDateFormat( "dd-MM-yyyy" );
                    System.out.println("Request Id :" + quotation.getQuotationId());
                    System.out.println("Hall ID : " + hallId);
                    System.out.println("Customer ID : " + customerId);
                    System.out.println("Quotation date : " + dateFormat.format(date));
                    System.out.println("Booking Start Date : " + dateFormat.format(bookingStartDate));
                    System.out.println("Booking Finish Date : " + dateFormat.format(bookingFinishDate));
                    System.out.println("Number Of Guests : " + numberOfGuest);
                    System.out.println("Price : " + price);
                    System.out.println("Deposit : " + price/2);
                    System.out.println("IsCatering : " + isCatering);
                    System.out.println("Type Of Meal : " + typeOfMeal);
                    System.out.println("----------------------------");
                }

        }
    }

    /**
     * This method read quotation from this customer quotation list,
     * Check the customer input if it equals to quotation Id or not.
     * Check the quotation which price is provided
     *
     * @return boolean returns to check whether the user want to back to previous page
     **/
    public boolean readQuotationFromCustomer(int whichQuotation)
    {

        Customer customer = (Customer) PrimeEvents.getEventUser();
        ArrayList <Quotation> quotations = customer.getQuotationList();
        boolean isQuotationExist = false;
        for(int i=0; i < quotations.size();i++) {
            if (  whichQuotation == quotations.get(i).getQuotationId()) {
                if (quotations.get(i).getPrice() != 0)
                {
                    System.out.println("The owner answered the quotation, you can pay the deposit now:");
                    return true;
                }
                else
                {
                    System.out.println("Sorry, please wait owner to answer the quotation.");

                }
                isQuotationExist = true;

            }
        }
        if (!isQuotationExist) {
            System.out.println("Sorry, the quotation does not exist.");
        }
        return false;
    }

    /**
     * This method print Receipt of customer.
     **/
    public void printReceipt(int whichQuotation, String cardNumber)
    {
        Customer customer = (Customer) PrimeEvents.getEventUser();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date todayDate = new Date();

        String date = dateFormat.format(todayDate);
        int i = whichQuotation -1;
        System.out.println("Customer Id: " + customer.getSpecificQuotation(i).getUserId());
        System.out.println("Hall Id: " + customer.getSpecificQuotation(i).getHallId());
        System.out.println("Card number: " + cardNumber);
        System.out.println("Receipt Date: " + date);
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





    private boolean updateAccount(String email, String password)
    {
        boolean result = false;
        //code here
        return result;
    }

    public void provideReview(int bookingId)
    {

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
