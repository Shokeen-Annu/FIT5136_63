import java.util.Date;
/**
 *  This is the a booking class. This class contains all the get and set methods of booking .
 *
 * @author    Annu Shokeen
 * @version   20/10/2019
 */

public class Booking {

    private int bookingId;
    private int hallId;
    private Date bookingStartDate;
    private Date bookingFinishDate;
    private int quotationId;
    private int customerId;
    private int receiptId;
    private Hall hall;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
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

    public int getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(int quotationId) {
        this.quotationId = quotationId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
    }


}
