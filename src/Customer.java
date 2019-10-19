import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Customer extends User {

    private boolean isSeniorCitizen;
    private boolean isVeteran;
    private String securityQuestion1;
    private String securityQuestion2;
    private String securityAnswer1;
    private String securityAnswer2;
    private ArrayList<String> cardDetails;
    private ArrayList<Booking> bookingList;
    private ArrayList<Quotation> quotationList;
    private Booking booking;


    public boolean getIsSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }

    public boolean getIsVeteran() {
        return isVeteran;
    }

    public void setVeteran(boolean veteran) {
        isVeteran = veteran;
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

    public ArrayList<String> getCardDetails() {
        return cardDetails;
    }

    public void setCardDetails(ArrayList<String> cardDetails) {
        this.cardDetails = cardDetails;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void setBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

    public ArrayList<Quotation> getQuotationList() {
        return quotationList;
    }

    public void setQuotationList(ArrayList<Quotation> quotationList) {
        this.quotationList = quotationList;
    }

    public void quotationAdd(Date newDate, Date newBookingStartDate, Date newBookingFinishDate, int newNumberOfGuest,int customerId, int newHallId, double newPrice,
                              boolean newIsCatering, String newTypeOfMeal)
    {
        /*int quotationId = 1;
        quotationId= quotationId+1;*/


        Quotation newQuotation =new Quotation(  newDate, newBookingStartDate,newBookingFinishDate,
                                                newNumberOfGuest,customerId,newHallId,newPrice,
                                                newIsCatering, newTypeOfMeal);
         quotationList.add(newQuotation);
    }

    public Quotation getLastQuotation()
    {
        int index =  quotationList.size()-1;
        return quotationList.get(index);
    }
    public Quotation getSpecificQuotation(int index)
    {
        return quotationList.get(index);
    }




    @Override
    public String toString() {
        return getUserId() +
                "$" + getFirstName() +
                "$" + getLastName() +
                "$" + getPhoneNumber() +
                "$" + getEmail() +
                "$" + getPassword() +
                "$" + getAddress() +
                "$" + getRole() +
                "$" + isVeteran +
                "$" + isSeniorCitizen +
                "$" + securityQuestion1 +
                "$" + securityQuestion2 +
                "$" + securityAnswer1 +
                "$" + securityAnswer2 + "$$";
    }
}

