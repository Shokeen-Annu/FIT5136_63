import java.util.ArrayList;

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

    public String displayHall()
    {
        return hallId + " " + name + " " + address + " " + contactNumber + " " + rating
                + " " + description + " " + availability + " " + foodMenu + " " + typeOfOccassion;

    }
    public double calculateAverageRating()
    {
        return rating;
    }

}
