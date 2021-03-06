import java.util.ArrayList;
import java.util.Date;

/**
 *  This is the a owner controller class which contains all the methods can be used by owner.
 *
 * @author    Annu Shokeen, zhijie li, Yuwu
 * @version   20/10/2019
 */
public class OwnerController {

    private InputValidation input = new InputValidation();
    private FileIO io = new FileIO();
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

    /**
     * This method is for deleting hall
     *
     * @return boolean check the user deletes the hall or not.
     **/
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
        int max = -1;
        do{
            if(ownerDiscount.size() == 0)
            {
                System.out.println("Now, there is no discount in the database");
                System.out.println("Please add some discount.");
                discountId = 1;
            }
            else
            {
                for(Discount item: ownerDiscount)
                    if(max < item.getDiscountId())
                        max = item.getDiscountId();
                discountId = max + 1;
            }
            boolean isNameValid = true;
            System.out.println("Please enter discount name");
            String discountName ="";
            do {
                if(!isNameValid)
                    System.out.println("Please enter name correctly. It should be less than 15 characters");
                discountName = input.receiveString().trim();
                isNameValid = !input.isStringNullOrEmpty(discountName) && input.validateLengthOfString(discountName,15,1)
                        && input.isDollarSign(discountName);
            }while(!isNameValid);


            System.out.println("Please enter discount value");
            double discountValue;
            do{
                discountValue = input.validateDiscountValue();
            } while(discountValue > 1 || discountValue <= Double.parseDouble("0"));

            boolean isCommentValid = true;
            System.out.println("Please enter comments for the discount");
            String discountComments ="";
            do{
                if(!isCommentValid)
                    System.out.println("Please enter comments less than 50 characters.");
                discountComments = input.receiveString().trim();
                isCommentValid = input.validateLengthOfString(discountComments,50,0)
                                && input.isDollarSign(discountComments);
            } while(!isCommentValid);
            System.out.println("You entered the following discount: \n Id: "+discountId + ",Name: " + discountName + ",Value: " + discountValue + ",Comments:" + discountComments + ";");
            if(discountComments.equals(""))
                discountComments = " ";
            String contents = owner.getUserId() + "$" + discountId + "$" + discountName + "$" + discountValue + "$" + discountComments + "$$";
            boolean isConfirm = false;
            do {
                System.out.println("Do you add the discount into system");
                System.out.println("1 YES     2 NO  (Please enter number)");
                choose = input.receiveInt();
                if (choose == 1) {
                    io.writeFile("Discounts", contents);
                    owner.createDiscountList(owner.getUserId());
                    System.out.println("Discount is created successfully.");
                    isConfirm = false;
                }
                else if(choose == -1)
                    isConfirm = true;
                else if(choose == 2) {
                    isConfirm = false;
                    choose = 1;
                    System.out.println("Discount is not created.");
                }
                else {
                    System.out.println("Please enter choice correctly");
                    isConfirm = false;
                }
                System.out.println();
            }while(isConfirm);
        }while(choose != 1);
    }
    private boolean isHallPresent(int hallId)
    {
        boolean result=false;

        //code here
        return result;
    }

    /**
     * This method read quotations from txt file.
     * Print these quotations.
     **/
    public void readQuotationFromTxt( )
    {
        FileIO fileIO = new FileIO();
        ArrayList<Quotation> allQuotationList = PrimeEvents.getQuotationList();
        ArrayList<Hall> allHalls = PrimeEvents.getHallList();
        //match quotation to owner's hall
        boolean isNoQuotation = true;

        for(Quotation quotation: allQuotationList)
        {
            for(Hall hall:allHalls)
            {
                int ownerId = hall.getUserId();
                Owner owner = (Owner)PrimeEvents.getEventUser();
                if( hall.getHallId() == quotation.getHallId() && ownerId == owner.getUserId() && quotation.getPrice()==0.0) {
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
                    owner.quotationAdd(date, bookingStartDate, bookingFinishDate, numberOfGuest, customerId, hallId, price,
                            isCatering, typeOfMeal,quotation.getQuotationId());

                    System.out.println("Request Id :"+ quotation.getQuotationId());
                    System.out.println("Hall ID : " + hallId);
                    System.out.println("Customer ID : " + customerId);
                    System.out.println("Quotation date : " + date);
                    System.out.println("Booking Start Date : " + bookingStartDate);
                    System.out.println("Booking Finish Date : " + bookingFinishDate);
                    System.out.println("Number Of Guests : " + numberOfGuest);
                    System.out.println("Price : " + price);
                    System.out.println("IsCatering : " + isCatering);
                    System.out.println("Type Of Meal : " + typeOfMeal);
                    System.out.println("----------------------------");

                }
            }
        }
        if(isNoQuotation)
        {
            System.out.println("You do not have any quotation");
        }

    }

    /**
     * This method read quotation from this owner quotation list,
     * Check the owner input if it equals to quotation Id or not.
     * Ask owner to enter the price.
     * @return boolean returns to check whether the user want to back to previous page
     **/
    public boolean readQuotationFromOwner (int requestId)
    {
        Owner owner = (Owner)PrimeEvents.getEventUser();
        ArrayList <Quotation> quotations = owner.getQuotationList();
        boolean isQuotationExist = false;
        for(int i=0; i < quotations.size();i++) {
            if (  requestId == quotations.get(i).getQuotationId()) {
                System.out.println("You are verified to create quotation. Enter quotation price:");
                isQuotationExist = true;
                return true;
            }
        }
        if (!isQuotationExist) {
        System.out.println("Sorry, the quotation does not exist.");
    }
        return false;
    }

    /**
     * This method store price to owner's quotations.
     *
     * @return boolean returns to check whether the user want to back to previous page
     **/
    public void changePrice(int requestId,int changePrice) {
        Owner owner = (Owner)PrimeEvents.getEventUser();
        boolean isQuotationUpdated = false;
        ArrayList<Quotation> quotations = owner.getQuotationList();
        for (int i = 0; i < quotations.size(); i++) {
            if (requestId == quotations.get(i).getQuotationId()) {
                quotations.get(i).setPrice(changePrice);
                isQuotationUpdated = true;
            }
        }


        ArrayList <Quotation> allQuotationList = PrimeEvents.getQuotationList();
        //Update quotation text file
        if(isQuotationUpdated) {
            owner.setQuotatinList(quotations);

            for (Quotation quotation : allQuotationList) {
                if (quotation.getQuotationId() == requestId) {
                    quotation.setPrice(changePrice);
                }

            }
            String content = "";
            for(Quotation quotation: allQuotationList)
            {
                content += quotation.toString();
            }
            io.reWriteFile("Quotations",content);
            System.out.println("Quotation is sent to the customer.");
        }

    }
}

