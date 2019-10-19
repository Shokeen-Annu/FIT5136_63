import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 *  This is the a owner controller class which contains all the methods can be used by owner.
 *
 * @author    Annu Shokeen, zhijie li, Yuwu
 * @version   20/10/2019
 */
public class OwnerController {
    private Owner owner;
    private InputValidation input = new InputValidation();
    private FileIO io = new FileIO();
    //private PrimeEvents primeEvents = new PrimeEvents();
    private CommonController commonController = new CommonController();
    private boolean addHall(Hall hall)
    {
        boolean result=false;

        //code here
        return result;
    }

    private Hall generateHallObject()
    {
        return new Hall();
    }


    public boolean deleteHall(Hall hall)
    {
        boolean result=false;
        try {
            Owner owner = (Owner) PrimeEvents.getEventUser();
            ArrayList<Hall> allHalls = PrimeEvents.getHallList();
            // verify hall exists for owner
            ArrayList<Hall> ownerHalls = owner.getHallList();
            boolean isHallVerified = false;
            for (Hall ownerHall : ownerHalls) {
                if (ownerHall.getHallId() == hall.getHallId())
                    isHallVerified = true;
            }
            if (isHallVerified) {
                ownerHalls.remove(hall);
                owner.createHallList(ownerHalls);

                allHalls.remove(hall);

                //rewrite file
                String hallContent = "";
                for (Hall item : allHalls) {
                    hallContent += item.toString();
                }
                io.reWriteFile("Halls", hallContent);
                result = true;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Some error occurred.");
            result = false;
        }
        return result;
    }
    private boolean updateHall(Hall hall)
    {
        boolean result=false;

        //code here
        return result;
    }
    private void viewHalls(String type)
    {

    }
    private void viewReviewOfHall(int hallId)
    {

    }
    private Quotation provideQuotation(int quotationId)
    {
     return new Quotation();
    }
    private boolean cancelBooking(int bookingId)
    {
        boolean result=false;

        //code here
        return result;
    }
    private void viewBookingHistory(int bookingId)
    {

    }

    /**
     * This method is for adding discounts
     *
     **/
    public void addDiscount()
    {
        Owner owner = (Owner)PrimeEvents.getEventUser();
        ArrayList<Discount> ownerDiscount = owner.getDiscountList();
        int choose = -1;
        int discountId;
        do{
            if(ownerDiscount.size() == 0)
            {
                System.out.println("Now, there is no discount in the database");
                System.out.println("Please add some discount.");
                discountId = 1;
            }
            else
            {
                discountId = ownerDiscount.size() + 1;
            }
            System.out.println("Please enter discount name");
            String discountName = input.receiveString().trim();
            System.out.println("Please enter discount value");
            double discountValue = input.validateDiscountValue();
            System.out.println("Please enter comments for the discount");
            String discountComments = input.receiveString().trim();
            System.out.println(discountId + "," + discountName + "," + discountValue + "," + discountComments + ";");
            System.out.println("Do you add the discount into system");
            System.out.println("1 YES     2 NO  (PLEASE ENTER NUMBER)");
            choose = input.receiveInt();
            String contents = owner.getUserId() + "$" + discountId + "$" + discountName + "$" + discountValue + "$" + discountComments + "$$";
            if(choose == 1)
            {
                io.writeFile("Discounts", contents);
            }
            else
                System.out.println("Please re-add the discount");
                System.out.println();
        }while(choose != 1);
    }
    private boolean isHallPresent(int hallId)
    {
        boolean result=false;

        //code here
        return result;
    }

    public void readQuotationFromTxt( )
    {
        FileIO fileIO = new FileIO();
        ArrayList<String[]> quotaionTxt = fileIO.readFileToArray("Quotations");
        ArrayList <Hall> ownersHalls = owner.getHallList();


        System.out.println("---------There are your quotations:---------");
        for(int i = 0 ; i< quotaionTxt.size(); i++)
        {
            for(int n=0;n< owner.HallsCount();n++)
            {
            int hallId =  ownersHalls.get(n).getUserId(); ;
            if (hallId == Integer.parseInt( quotaionTxt.get(i)[5]))
            {
                DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = dateFormat.parse(quotaionTxt.get(i)[0]);
                    Date bookingStartDate = dateFormat.parse(quotaionTxt.get(i)[1]);
                    Date bookingFinishDate = dateFormat.parse(quotaionTxt.get(i)[2]);
                    int numberOfGuest = Integer.parseInt( quotaionTxt.get(i)[3]);
                    int customerId = Integer.parseInt( quotaionTxt.get(i)[4]);
                    hallId = Integer.parseInt( quotaionTxt.get(i)[5]);
                    double price = Double.parseDouble( quotaionTxt.get(i)[6]);
                    boolean isCatering = Boolean.parseBoolean(quotaionTxt.get(i)[7]);
                    String typeOfMeal = quotaionTxt.get(i)[8];
                    owner.quotationAdd(date,bookingStartDate, bookingFinishDate,numberOfGuest,customerId,hallId, price,
                           isCatering, typeOfMeal);
                    int j =1;
                    System.out.println(j);
                    System.out.println("Hall ID : "+ hallId);
                    System.out.println("Customer ID : "+ customerId);
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
    }

    public boolean readQuotationFromOwner (int hallId,int customerId)
    {
        ArrayList <Quotation> quotations = owner.getQuotationList();
        for(int i=0; i < quotations.size();i++) {
            if (  hallId == quotations.get(i).getHallId() && customerId == quotations.get(i).getUserId()) {
                System.out.println("Now you can change quotation price:");
                return true;
            } else {
                System.out.println("Sorry, the quotation is not exist.");
            }
        }
        return false;
    }


    public void changePrice(int theHallId, int theCustomerId,int changePrice) {
        ArrayList<Quotation> quotations = owner.getQuotationList();
        for (int i = 0; i < quotations.size(); i++) {
            if (theHallId == quotations.get(i).getHallId() && theCustomerId == quotations.get(i).getUserId()) {
                quotations.get(i).setPrice(changePrice);
            }
        }
        FileIO fileIO = new FileIO();
        ArrayList<String[]> quotationTxt = fileIO.readFileToArray("Quotations");
        ArrayList <Quotation> allQuotationList = new ArrayList<>();

        // read all quotation from txt
        for (int i = 0; i < quotationTxt.size(); i++) {
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                Date date = dateFormat.parse(quotationTxt.get(i)[0]);
                Date bookingStartDate = dateFormat.parse(quotationTxt.get(i)[1]);
                Date bookingFinishDate = dateFormat.parse(quotationTxt.get(i)[2]);
                int numberOfGuest = Integer.parseInt(quotationTxt.get(i)[3]);
                int customerID = Integer.parseInt(quotationTxt.get(i)[4]);
                int hallId = Integer.parseInt(quotationTxt.get(i)[5]);
                double price = Double.parseDouble(quotationTxt.get(i)[6]);
                boolean isCatering = Boolean.parseBoolean(quotationTxt.get(i)[7]);
                String typeOfMeal = quotationTxt.get(i)[8];

                Quotation newQuotation =new Quotation(  date, bookingStartDate, bookingFinishDate, numberOfGuest, customerID, hallId, price,
                        isCatering, typeOfMeal);
                allQuotationList.add(newQuotation);
            } catch (ParseException e) {
                System.out.println("The date format is wrong !");
            }
        }

        // write quotation price
        String message = "";
        for(int j=0;j< allQuotationList.size();j++) {
            int customerId = allQuotationList.get(j).getUserId();
            int hallId = allQuotationList.get(j).getHallId();
            Date date = allQuotationList.get(j).getDate();
            Date bookingStartDate = allQuotationList.get(j).getBookingStartDate();
            Date bookingFinishDate = allQuotationList.get(j).getBookingFinishDate();
            int numberOfGuest = allQuotationList.get(j).getNumberOfGuest();
            boolean isCatering = allQuotationList.get(j).isCatering();
            String typeOfMeal = allQuotationList.get(j).getTypeOfMeal();
            if(theCustomerId == allQuotationList.get(j).getUserId() && theHallId == allQuotationList.get(j).getHallId())
            {
                double price = changePrice;
                message += date + "," + bookingStartDate + "," + bookingFinishDate + "," + numberOfGuest + "," + customerId + ""
                        + hallId + "," + price + "," + isCatering + "," + typeOfMeal + "\r\n";
                fileIO.writeFile("Quotations", message);
            }
            else
            {
                 double price = allQuotationList.get(j).getPrice();
                message += date + "," + bookingStartDate + "," + bookingFinishDate + "," + numberOfGuest + "," + customerId + ""
                        + hallId + "," + price + "," + isCatering + "," + typeOfMeal + "\r\n";
                fileIO.writeFile("Quotations", message);
            }
        }
    }
}

