import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class PrimeEvents {


    private User eventUser;
    private ArrayList<Hall> hallList;
    private ArrayList<User> userList;
    private ArrayList<Booking> bookingList;
    private double veteranConcession;
    private double seniorCitizenConcession;
    private FileIO fileIO = new FileIO();
    private InputValidation input = new InputValidation();


    public void createHallList(){
        String allHalls = fileIO.readFile("Halls");
        String[] hallDetailsArr = allHalls.split(";");
        for(int i = 0; i< hallDetailsArr.length; i++)
        {
            String[] specificHall = hallDetailsArr[i].split(",");
            Hall temdriHall = new Hall();
            temdriHall.setHallId(Integer.parseInt(specificHall[0]));
            temdriHall.setHallName(specificHall[1]);
            temdriHall.setAddress(specificHall[2]);
            temdriHall.setContactNumber(specificHall[3]);
            temdriHall.setRating(Double.parseDouble(specificHall[4]));
            temdriHall.setDescription(specificHall[5]);
            temdriHall.setAvailability(Boolean.parseBoolean(specificHall[6]));
            temdriHall.setFoodMenu(specificHall[7]);
            temdriHall.setTypeOfOccassion(specificHall[8]);
            temdriHall.setIsCatering(Boolean.parseBoolean(specificHall[9]));
            temdriHall.setIsPhotography(Boolean.parseBoolean(specificHall[10]));
            hallList.add(temdriHall);
        }
    }
    public void createUserList()
    {

    }

    public void createBookingList()
    {

    }
    public boolean deleteUser()
    {

    }

    public ArrayList<Hall> getHallList() {
        return hallList;
    }

    public ArrayList<User> getUserList() {
        return userList;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public double getVeteranConcession() {
        return veteranConcession;
    }

    public void setVeteranConcession(double veteranConcession) {
        this.veteranConcession = veteranConcession;
    }

    public double getSeniorCitizenConcession() {
        return seniorCitizenConcession;
    }

    public void setSeniorCitizenConcession(double seniorCitizenConcession) {
        this.seniorCitizenConcession = seniorCitizenConcession;
    }

}
