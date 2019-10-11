public class Hall {
    private int hallId;
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
    //private  ArrayList<Quotation> quotation;
    //private ArrayList<Review> review;


    public int getHallId() {
        return hallId;
    }

    public String getName() {
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

    public boolean isAvailability() {
        return availability;
    }

    public String getFoodMenu() {
        return foodMenu;
    }

    public String getTypeOfOccassion() {
        return typeOfOccassion;
    }

    public boolean isCatering() {
        return isCatering;
    }

    public boolean isPhotography() {
        return isPhotography;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public void setName(String name) {
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

    public void setCatering(boolean catering) {
        isCatering = catering;
    }

    public void setPhotography(boolean photography) {
        isPhotography = photography;
    }
}
