import java.util.Date;
/**
 *  This is the a receipt entity class. This class contains all the get and set method about receipt.
 *
 * @author    Yuwu
 * @version   20/10/2019
 */

public class Receipt {

    private int receiptId;
    private Date receiptDate;
    private  int userId;
    private double finalPrice;
    private double restOfBill;
    private  String hallAddress;

    public int getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(int receipId) {
        this.receiptId = receipId;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(Double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public Double getRestOfBill() {
        return restOfBill;
    }

    public void setRestOfBill(Double restOfBill) {
        this.restOfBill = restOfBill;
    }

    public String getHallAddress() {
        return hallAddress;
    }

    public void setHallAddress(String hallAddress) {
        this.hallAddress = hallAddress;
    }

}
