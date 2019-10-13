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
    private InputValidation validator = new InputValidation();


    public void createHallList(){
        String allHalls = fileIO.readFile("Halls");
        String[] hallDetailsArr = allHalls.split(";");
        for(int i = 0; i< hallDetailsArr.length; i++)
        {
            String[] specificHall = hallDetailsArr[i].split(",");
            Hall temdriHall = new Hall();
            temdriHall.setHallId(Integer.parseInt(specificHall[0]));
            temdriHall.setName(specificHall[1]);
            temdriHall.setAddress(specificHall[2]);
            temdriHall.setContactNumber(specificHall[3]);
            temdriHall.setRating(Double.parseDouble(specificHall[4]));
            temdriHall.setDescription(specificHall[5]);
            temdriHall.setAvailability(Boolean.parseBoolean(specificHall[6]));
            temdriHall.setFoodMenu(specificHall[7]);
            temdriHall.setTypeOfOccassion(specificHall[8]);
            temdriHall.setCatering(Boolean.parseBoolean(specificHall[9]));
            temdriHall.setPhotography(Boolean.parseBoolean(specificHall[10]));
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

    //did not connect to the menu
    public void viewHalls()
    {
        boolean flag = true;
        displayHallList();
        System.out.println("-------------------");
        System.out.println();
        System.out.println("1 SEARCH HALL BY NAME");
        System.out.println("2 SEARCH Hall BY OCCASION TYPE");
        System.out.println("3 SEARCH HALL BY ADDRESS");
        System.out.println("4 SEARCH HALL BY RATING");
        int chooseNumber = -1;
        chooseNumber = validator.receiveInt();
        switch(chooseNumber)
        {
            case 1: flag = searchName();
            break;
            case 2: flag = searchType();
            break;
            case 3: flag = searchAddress();
            break;
            case 4: flag = searchRating();
            break;
            default: System.out.println("Please enter the option correctly");
            break;
        }

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

    public void displayHallList()
    {
        for(int i = 0; i < hallList.size(); i++)
        {
            System.out.println(hallList.get(i).displayHall());
        }
    }

}
