import java.util.ArrayList;

public class Administrator extends User {

    private ArrayList<Discount> discountList;

    public ArrayList<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(Discount discount) {
        this.discountList.add(discount);
    }

}

