import java.util.ArrayList;

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
    public boolean deleteHall(int hallId)
    {
        boolean result=false;
        try {
            Owner owner = (Owner) PrimeEvents.getEventUser();
            ArrayList<Hall> allHalls = PrimeEvents.getHallList();
            Hall hall = null;
            for(Hall item: allHalls)
            {
                if(item.getHallId() == hallId) {
                    hall = item;
                    result = true;
                }
            }
            if(hall == null)
                return result;
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
    public void addDiscount()
    //String name, double value, int id, String comments
    {
        //commonController.createDatabase();

        Owner owner = (Owner)PrimeEvents.getEventUser();// the user in the owner is null
        ArrayList<Discount> ownerDiscount = owner.getDiscountList();
        int choose = -1;
        do{
            if(ownerDiscount == null)
            {
                System.out.println("Now, there is no discount in the database");
                System.out.println("Please add some discount.");
            }
            for(int i = 0; i < owner.getDiscountList().size(); i++)
            {
                Discount ownerDisDetail = owner.getDiscountList().get(i);
                if (ownerDisDetail == null)
                {
                    System.out.println("Now, there is no discount in the database");
                }
            }
            System.out.println("Please enter discount name");
            String discountName = input.receiveString().trim();
            System.out.println("Please enter discount value");
            double discountValue = Double.parseDouble(input.receiveString().trim());
            System.out.println("Please enter comments for the discount");
            String discountComments = input.receiveString().trim();
            int discountId = ownerDiscount.size() + 1;
            System.out.println(discountId + "," + discountName + "," + discountValue + "," + discountComments + ";");
            System.out.println("Do you add the discount into system");
            System.out.println("1 YES     2 NO  (PLEASE ENTER NUMBER)");
            choose = input.receiveInt();
            String contents = owner.getUserId() + "$" + discountId + "$" + discountName + "$" + discountValue + "$" + discountComments + "$$";
            if(choose == 1)
            {
                io.writeFile("Discounts", "contents");
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

}

