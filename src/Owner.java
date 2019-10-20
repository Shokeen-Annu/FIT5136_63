import java.util.ArrayList;
import java.util.Date;
/**
 *  This is the a owner entity class. This class inherits from the user class.
 *
 * @author    Zhijie Li, YuWu
 * @version   20/10/2019
 */

import java.util.regex.Pattern;

public class Owner extends User {

    private String securityQuestion1;
    private String securityQuestion2;
    private String securityAnswer1;
    private String securityAnswer2;
    private ArrayList<Hall> hallList;
    private ArrayList <Quotation> quotationList = new ArrayList<>();


    private ArrayList<Discount> discountList = new ArrayList<>();




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

    /**
     * This method converts the information into this format in order to write into the txt file.
     *
     * @param userId The integer indicates the user id.
     *  @return String this convert value into this format
     */
    public ArrayList<Discount> createDiscountList(int userId)
    {
        String allDiscount = fileIO.readFile("Discounts");
        String[] discountDetail = allDiscount.split(Pattern.quote("$$"));

            for (int i = 0; i < discountDetail.length; i++) {
                String[] specificDiscount = discountDetail[i].split(Pattern.quote("$"));
                if(userId == Integer.parseInt(specificDiscount[0])) {
                    Discount temdriDiscount = new Discount();
                    temdriDiscount.setUserId(Integer.parseInt(specificDiscount[0]));
                    temdriDiscount.setDiscountId(Integer.parseInt(specificDiscount[1]));
                    temdriDiscount.setDiscountName(specificDiscount[2]);
                    temdriDiscount.setValue(Double.parseDouble(specificDiscount[3]));
                    temdriDiscount.setComments(specificDiscount[4]);
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
                             boolean newIsCatering, String newTypeOfMeal, int quotationId)
    {
        Quotation newQuotation =new Quotation(  newDate, newBookingStartDate,newBookingFinishDate,
                newNumberOfGuest,customerId,newHallId,newPrice,
                newIsCatering, newTypeOfMeal,quotationId);
        quotationList.add(newQuotation);
    }
    @Override
/**
 * This method converts the information into this format in order to write into the txt file
 *
 *  @return String this convert value into this format
 */
    public String toString() {
        return getUserId() +
                "$" + getFirstName() +
                "$" + getLastName() +
                "$" + getPhoneNumber() +
                "$" + getEmail() +
                "$" + getPassword() +
                "$" + getAddress() +
                "$" + getRole() +
                "$" + securityQuestion1 +
                "$" + securityQuestion2 +
                "$" + securityAnswer1 +
                "$" + securityAnswer2 + "$$";
    }
}
