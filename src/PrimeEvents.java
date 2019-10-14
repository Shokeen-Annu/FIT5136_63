import java.util.ArrayList;
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
    private InputValidation input = new InputValidation();


    public void createHallList(){
        String allHalls = fileIO.readFile("Halls");
        String[] hallDetailsArr = allHalls.split(Pattern.quote("$$"));
        for(int i = 0; i< hallDetailsArr.length; i++)
        {
            String[] specificHall = hallDetailsArr[i].split(Pattern.quote("$"));
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
            temdriHall.setUserId(Integer.parseInt(specificHall[11]));
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
                    int ownerId = Integer.parseInt(userData[0]);
                    ((Owner)user).setSecurityQuestion1(userData[8]);
                    ((Owner)user).setSecurityQuestion2(userData[9]);
                    ((Owner)user).setSecurityAnswer1(userData[10]);
                    ((Owner)user).setSecurityAnswer2(userData[11]);
                    ArrayList<Hall> ownerHalls = new ArrayList<>();
                    for(Hall hall : hallList)
                    {
                        if(hall.getUserId() == ownerId)
                            ownerHalls.add(hall);
                    }
                    ((Owner)user).createHallList(ownerHalls);
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
