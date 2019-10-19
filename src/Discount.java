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

    public String displayDiscount()
    {
        return "Discount id: " + discountId + "\n" + "Name: " + discountName + "\n" + "Discount value: "+ value + "\n" + "Discount: " + comments + "\n";
    }
    public String disFile()
    {
        return userId + "$" + discountId + "$" + discountName + "$" + value + "$" + comments + "$$";
    }
}
