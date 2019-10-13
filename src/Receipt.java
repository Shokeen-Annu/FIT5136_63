import java.text.DecimalFormat;
import java.util.Date;

public class Receipt {

    private int receipId;
    private Date receiptDate;
    private  int userId;
    private double finalPrice;
    private double restOfBill;
    private  String hallAddress;

    public int getReceipId() {
        return receipId;
    }

    public void setReceipId(int receipId) {
        this.receipId = receipId;
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
