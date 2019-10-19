import java.util.ArrayList;
import java.util.Date;

public class Owner extends User {

    private String securityQuestion1;
    private String securityQuestion2;
    private String securityAnswer1;
    private String securityAnswer2;
    private ArrayList<Hall> hallList;



    private ArrayList <Quotation> quotationList;
    private ArrayList<Discount> discountList;
    private ArrayList<Booking> bookingList;
    private FileIO fileIO = new FileIO();


    public ArrayList<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotatinList(ArrayList<Quotation> quotationList) {
        this.quotationList = quotationList;
    }
    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    public ArrayList<Hall> getHallList() {
        return hallList;
    }

    public void createHallList(ArrayList<Hall> hallList) {
        this.hallList = hallList;
    }


    public ArrayList<Discount> getDiscountList() {
        return discountList;
    }

    public ArrayList<Discount> createDiscountList(int userId)
    {
        String allDiscount = fileIO.readFile("D:\\2019 monash S2\\FIT5136_Project\\FIT5136_ActualProject\\Discounts.txt");
        String[] discountDetail = allDiscount.split("$$");
        if(getUserId() == userId) {
            for (int i = 0; i < discountDetail.length; i++) {
                String[] specificDiscount = discountDetail[i].split("$");
                Discount temdriDiscount = new Discount();
                temdriDiscount.setDiscountId(Integer.parseInt(specificDiscount[0]));
                temdriDiscount.setDiscountName(specificDiscount[1]);
                temdriDiscount.setValue(Double.parseDouble(specificDiscount[2]));
                temdriDiscount.setComments(specificDiscount[3]);
                discountList.add(temdriDiscount);
            }
        }
        return discountList;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void createBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }



    public int HallsCount()
    {
        return hallList.size();
    }

    public void quotationAdd(Date newDate, Date newBookingStartDate, Date newBookingFinishDate, int newNumberOfGuest, int customerId, int newHallId, double newPrice,
                             boolean newIsCatering, String newTypeOfMeal)
    {
        Quotation newQuotation =new Quotation(  newDate, newBookingStartDate,newBookingFinishDate,
                newNumberOfGuest,customerId,newHallId,newPrice,
                newIsCatering, newTypeOfMeal);
        quotationList.add(newQuotation);
    }
}
