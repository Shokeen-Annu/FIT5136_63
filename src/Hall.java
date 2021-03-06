import java.util.ArrayList;
/**
 *  This is the hall entity, which contains the get, set and display methods about hall.
 *
 * @author    Annu Shokeen, Zhijie Li
 * @version   20/10/2019
 */

public class Hall {
    private int hallId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId;
    private String name;
    private String address;
    private String contactNumber;
    private double rating;
    private String description;
    private boolean availability;
    private String foodMenu;
    private String typeOfOccassion;
    private boolean isCatering;
    private boolean isPhotography;
    private  ArrayList<Quotation> quotation;
    private ArrayList<Review> review;

    public ArrayList<Quotation> getQuotation() {
        return quotation;
    }

    public void setQuotation(ArrayList<Quotation> quotation) {
        this.quotation = quotation;
    }

/**
* This method converts the information into this format in order to write into the txt file
*
*  @return String this convert value into this format
*/
    @Override
    public String toString() {
        return hallId +
                "$" + name +
                "$" + address +
                "$" + contactNumber +
                "$" + rating +
                "$" + description +
                "$" + availability +
                "$" + foodMenu +
                "$" + typeOfOccassion +
                "$" + isCatering +
                "$" + isPhotography +
                "$" + userId +"$$";
    }

    public ArrayList<Review> getReview() {
        return review;
    }

    public void setReview(ArrayList<Review> review) {
        this.review = review;
    }

    public int getHallId() {
        return hallId;
    }

    public String getHallName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public double getRating() {
        return rating;
    }

    public String getDescription() {
        return description;
    }

    public boolean getAvailability() {
        return availability;
    }

    public String getFoodMenu() {
        return foodMenu;
    }

    public String getTypeOfOccassion() {
        return typeOfOccassion;
    }

    public boolean getIsCatering() {
        return isCatering;
    }

    public boolean getIsPhotography() {
        return isPhotography;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public void setHallName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public void setFoodMenu(String foodMenu) {
        this.foodMenu = foodMenu;
    }

    public void setTypeOfOccassion(String typeOfOccassion) {
        this.typeOfOccassion = typeOfOccassion;
    }

    public void setIsCatering(boolean catering) {
        isCatering = catering;
    }

    public void setIsPhotography(boolean photography) {
        isPhotography = photography;
    }

/**
* This method displays all the hall details
 *
 *  @return String for display all the hall details
*/
    public String displayHall()
    {
        return "Hall id: " +  hallId + "\n" +
                "Hall name: " + name + "\n" +
                "Hall address: " + address + "\n" +
                "Contact number: " + contactNumber + "\n" +
                "Rating: " + rating + "\n" +
                "Description: " + description + "\n" +
                "Availability: " + displayAvailability() + "\n" +
                "Food menu: " + foodMenu + "\n" +
                "Occassion type: " + typeOfOccassion + "\n";
    }

 /**
  * This method displays the availability of the hall
  *
  * @return String to show the availability for the customer
*/
    public String displayAvailability()
    {
        if(getAvailability())
        {
            return "The hall is availability";
        }
        return "Tne hall is not availability";
    }
    public double calculateAverageRating()
    {
        return rating;
    }


}
