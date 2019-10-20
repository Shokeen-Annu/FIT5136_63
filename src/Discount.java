/**
 *  This is the discount entity, which contains the get, set and display methods about discount.
 *
 * @author    Annu Shokeen, Zhijie Li
 * @version   20/10/2019
 */
public class Discount {

    private int discountId;
    private int userId;
    private double value;
    private String discountName;
    private String comments;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDiscountId() {
        return discountId;
    }

    public void setDiscountId(int discountId) {
        this.discountId = discountId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * This method displays all the discount details
     *
     *  @return String This is discount detail
     */
    public String displayDiscount()
    {
        return "Discount id: " + discountId + "\n" + "Name: " + discountName + "\n" + "Discount value: "+ value + "\n" + "Discount: " + comments + "\n";
    }

    /**
     * This method converts the information into this format in order to write into the txt file
     *
     *  @return String this convert value into this format
     */
    public String disFile()
    {
        return userId + "$" + discountId + "$" + discountName + "$" + value + "$" + comments + "$$";
    }
}
