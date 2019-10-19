import java.util.ArrayList;
/**
 *  This is the an administrator entity class. This class inherits from the user class.
 *
 * @author    Annu Shokeen
 * @version   20/10/2019
 */

public class Administrator extends User {

    private ArrayList<Discount> discountList;

    public ArrayList<Discount> getDiscountList() {
        return discountList;
    }

    public void setDiscountList(Discount discount) {
        this.discountList.add(discount);
    }

}

