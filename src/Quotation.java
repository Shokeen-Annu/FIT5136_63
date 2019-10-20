import java.text.SimpleDateFormat;
import java.util.Date;

public class Quotation {

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    private int quotationId;
    private Date date;
    private Date bookingStartDate;
    private Date bookingFinishDate;
    private int numberOfGuest;
    private int userId;
    private int hallId;
    private double price;
    private boolean isCatering;
    private String typeOfMeal;

    @Override
    public String toString() {
        SimpleDateFormat dateFormat =   new SimpleDateFormat( "dd-MM-yyyy" );
        return dateFormat.format(date) +
                "$" + dateFormat.format(bookingStartDate) +
                "$" + dateFormat.format(bookingFinishDate) +
                "$" + numberOfGuest +
                "$" + userId +
                "$" + hallId +
                "$" + price +
                "$" + isCatering +
                "$" + typeOfMeal +
                "$" + quotationId + "$$";
    }

    public Quotation(Date newDate, Date newBookingStartDate, Date newBookingFinishDate, int newNumberOfGuest, int newUserId, int newHallId, double newPrice,
                     boolean newIsCatering, String newTypeOfMeal, int id)
    {
        date = newDate;
        bookingStartDate= newBookingStartDate;
        bookingFinishDate = newBookingFinishDate;
        numberOfGuest =newNumberOfGuest;
        userId = newUserId;
        hallId = newHallId;
        price = newPrice;
        isCatering = newIsCatering;
        typeOfMeal=newTypeOfMeal;
        quotationId = id;

    }
    public Quotation()
    {}
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getHallId() {
        return hallId;
    }
    public int getUserId() {
        return userId;
    }
    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

/*    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumberOfGuest() {
        return numberOfGuest;
    }

    public void setNumberOfGuest(int numberOfGuest) {
        this.numberOfGuest = numberOfGuest;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public boolean isCatering() {
        return isCatering;
    }

    public void setCatering(boolean catering) {
        isCatering = catering;
    }
    public String getTypeOfMeal() {
        return typeOfMeal;
    }

    public void setTypeOfMeal(String typeOfMeal) {
        this.typeOfMeal = typeOfMeal;
    }
    public Date getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public Date getBookingFinishDate() {
        return bookingFinishDate;
    }

    public void setBookingFinishDate(Date bookingFinishDate) {
        this.bookingFinishDate = bookingFinishDate;
    }

}
