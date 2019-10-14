import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PrimeEvents {

    public User getEventUser() {
        return eventUser;
    }

    public void setEventUser(User eventUser) {
        this.eventUser = eventUser;
    }

    private User eventUser;
    private ArrayList<Hall> hallList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();
    private ArrayList<Booking> bookingList = new ArrayList<>();
    private double veteranConcession;
    private double seniorCitizenConcession;
    private FileIO fileIO = new FileIO();
    private InputValidation validator = new InputValidation();


    public void createHallList(){
        String allHalls = fileIO.readFile("Halls");
        String[] hallDetailsArr = allHalls.split(Pattern.quote("$$"));
        for(int i = 0; i< hallDetailsArr.length; i++)
        {
            String[] specificHall = hallDetailsArr[i].split(Pattern.quote("$"));
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
        String allUsers = fileIO.readFile("Users");
        String[] userDetails = allUsers.split(Pattern.quote("$$"));
        for(int i = 0; i< userDetails.length;i++)
        {
            String[] userData = userDetails[i].split(Pattern.quote("$"));
            String role = userData[7];
            User user = null;

            switch (role)
            {
                case "administrator":
                    user = new Administrator();
                    break;
                case "customer":
                    user = new Customer();
                    ((Customer)user).setSeniorCitizen(Boolean.parseBoolean(userData[8]));
                    ((Customer)user).setVeteran(Boolean.parseBoolean(userData[9]));
                    ((Customer)user).setSecurityQuestion1(userData[10]);
                    ((Customer)user).setSecurityQuestion2(userData[11]);
                    ((Customer)user).setSecurityAnswer1(userData[12]);
                    ((Customer)user).setSecurityAnswer2(userData[13]);
                    break;
                case "owner":
                    user = new Owner();
                    ((Owner)user).setSecurityQuestion1(userData[8]);
                    ((Owner)user).setSecurityQuestion2(userData[9]);
                    ((Owner)user).setSecurityAnswer1(userData[10]);
                    ((Owner)user).setSecurityAnswer2(userData[11]);
                    break;
                default:
                        break;
            }
            user.setUserId(Integer.parseInt(userData[0]));
            user.setFirstName(userData[1]);
            user.setLastName(userData[2]);
            user.setPhoneNumber(userData[3]);
            user.setEmail(userData[4]);
            user.setPassword(userData[5]);
            user.setAddress(userData[6]);
            user.setRole(userData[7]);
            userList.add(user);
        }

    }

    public void createBookingList()
    {

    }
    public boolean deleteUser()
    {
        boolean result = false;

        //code here
        return result;
    }

    //did not connect to the menu
   /* public void viewHalls()
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

    }*/


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
