import java.lang.reflect.Field;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;


public class CustomerController {
    private Customer customer = new Customer();
    private  Booking booking = new Booking();
    private PrimeEvents primeEvents = new PrimeEvents();
    private  Hall hall = new Hall();

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

    public void requestForQuotation(int hallId,Date date,Date bookingStartDate, Date bookingFinishDate, int numberOfGuest,double price,
                                    boolean isCatering, String typeOfMeal)
    {
        int customerId = customer.getUserId();
        customer.quotationAdd(date,bookingStartDate, bookingFinishDate,numberOfGuest,customerId,hallId, price,
                                isCatering, typeOfMeal);

        // save quotation into customer quotation list

    }

    public void saveQuotation()
    {
        FileIO fileIO = new FileIO();
        String message = "";

        int customerId = customer.getUserId();
        int hallId = customer.getLastQuotation().getHallId();
        Date date =  customer.getLastQuotation().getDate();
        Date bookingStartDate = customer.getLastQuotation().getBookingStartDate();
        Date bookingFinishDate = customer.getLastQuotation().getBookingFinishDate();
        int numberOfGuest = customer.getLastQuotation().getNumberOfGuest();
        double price = customer.getLastQuotation().getPrice();
        boolean isCatering = customer.getLastQuotation().isCatering();
        String typeOfMeal = customer.getLastQuotation().getTypeOfMeal();
        message +=  date + "," + bookingStartDate + "," +  bookingFinishDate + ","+ numberOfGuest + "," + customerId + ""
                    + hallId + ","  + price + "," +isCatering + ","+ typeOfMeal + "\r\n";
        fileIO.writeFile("Quotations",message);
    }

    public void readQuotationFromTxt( )
    {
        FileIO fileIO = new FileIO();
        ArrayList<String[]> quotaionTxt = fileIO.readFileToArray("Quotations");
        int customerId = customer.getUserId();
        System.out.println("---------There are your quotations:---------");
        for(int i = 0 ; i< quotaionTxt.size(); i++)
        {
            if (customerId== Integer.parseInt( quotaionTxt.get(i)[4]))
            {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
               try {
                   Date date = dateFormat.parse(quotaionTxt.get(i)[0]);
                   Date bookingStartDate = dateFormat.parse(quotaionTxt.get(i)[1]);
                   Date bookingFinishDate = dateFormat.parse(quotaionTxt.get(i)[2]);
                   int numberOfGuest = Integer.parseInt( quotaionTxt.get(i)[3]);
                   customerId = Integer.parseInt( quotaionTxt.get(i)[4]);
                   int hallId = Integer.parseInt( quotaionTxt.get(i)[5]);
                   double price = Double.parseDouble( quotaionTxt.get(i)[6]);
                   boolean isCatering = Boolean.parseBoolean(quotaionTxt.get(i)[7]);
                   String typeOfMeal = quotaionTxt.get(i)[8];
                   customer.quotationAdd(date,bookingStartDate, bookingFinishDate,numberOfGuest,customerId,hallId, price,
                           isCatering, typeOfMeal);
                   int j =1;
                   System.out.println(j);
                   System.out.println("Hall ID : "+ hallId);
                   System.out.println("Quotation date : "+ date);
                   System.out.println("Booking Start Date : "+ bookingStartDate);
                   System.out.println("Booking Finish Date : "+ bookingFinishDate);
                   System.out.println("Number Of Guests : "+ numberOfGuest);
                   System.out.println("Price : "+ price);
                   System.out.println("IsCatering : "+ isCatering);
                   System.out.println("Type Of Meal : "+ typeOfMeal);
                   System.out.println("----------------------------");
                   j++;
               }
               catch (ParseException e) {
                   System.out.println("The date format is wrong !");
               }
            }
        }
    }

    public boolean readQuotationFromCustomer(int whichQuotation)
    {
        int i = whichQuotation-1;
        if (customer.getSpecificQuotation(i).getPrice() != 0)
        {
            System.out.println("The owner answered the quotation, you can pay the deposit now:");
            return true;
        }
        else
        {
            System.out.println("Sorry, please wait owner to answer the quotation.");
        }
        return false;
    }

    public void printReceipt(int whichQuotation, int cardNumber)
    {
        Date todayDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(todayDate);
        int i = whichQuotation -1;
        System.out.println("Customer Id:" + customer.getSpecificQuotation(i).getUserId());
        System.out.println("Hall Id:" + customer.getSpecificQuotation(i).getHallId());
        System.out.println("Card number:" + cardNumber);
        System.out.println("Receipt Date" + date);
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
