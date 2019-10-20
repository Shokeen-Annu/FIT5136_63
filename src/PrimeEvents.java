import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Pattern;
/**
 *  This is the a prime event entity class. This class is used to create the database.
 *  And some methods to get and set user list, hall list, and booking list.
 *
 * @author    Annu Shokeen, Zhijie Li, YuWu
 * @version   20/10/2019
 */
public class PrimeEvents {
    private static User eventUser;
    private static ArrayList<Hall> hallList = new ArrayList<>();
    private static ArrayList<User> userList = new ArrayList<>();
    private static ArrayList<Booking> bookingList = new ArrayList<>();
    private static ArrayList<Quotation> quotationList = new ArrayList<>();
    private static double veteranConcession;
    private static double seniorCitizenConcession;
    private static FileIO fileIO = new FileIO();
    private InputValidation input = new InputValidation();

    /**
     * This method is to create a hall list and get all the hall information from the txt file.
     *
     */
    public static void createHallList(){
        String allHalls = fileIO.readFile("Halls");
        if(allHalls.isEmpty())
        {
            System.out.println("Halls file is not found!");
            return;
        }
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

    /**
     * This method is to create a user list and get all the users information from the txt file
     *
     */
    public static void createUserList()
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

    public static void createBookingList()
    {

    }

    /**
     * This method is to create quotation list.
     *
     */
    public static void createQuotationList()
    {
        String allQuotation = fileIO.readFile("Quotations");
        if(allQuotation.isEmpty())
            return;
        String[] quotationDetails = allQuotation.split(Pattern.quote("$$"));
        //read all quotation
        // read all quotation from txt
        for (int i = 0; i < quotationDetails.length; i++) {
            String[] specificQuotation = quotationDetails[i].split(Pattern.quote("$"));
            Quotation temdriQuotation = new Quotation();

            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            try {
                temdriQuotation.setDate(dateFormat.parse(specificQuotation[0]));
            }catch (ParseException e) {
                System.out.println("The date format is wrong !");
            }
            try{
                temdriQuotation.setBookingStartDate(dateFormat.parse(specificQuotation[1]));
            } catch (ParseException e) {
                System.out.println("The date format is wrong !");
            }
            try {
                temdriQuotation.setBookingFinishDate(dateFormat.parse(specificQuotation[2]));
            }
            catch (ParseException e) {
                System.out.println("The date format is wrong !");
            }
            temdriQuotation.setNumberOfGuest(Integer.parseInt(specificQuotation[3]));
            temdriQuotation.setUserId(Integer.parseInt(specificQuotation[4]));
            temdriQuotation.setHallId(Integer.parseInt(specificQuotation[5]));
            temdriQuotation.setPrice(Double.parseDouble(specificQuotation[6]));
            temdriQuotation.setCatering(Boolean.parseBoolean(specificQuotation[7]));
            temdriQuotation.setTypeOfMeal(specificQuotation[8]);
            temdriQuotation.setQuotationId(Integer.parseInt(specificQuotation[9]));
            quotationList.add(temdriQuotation);
        }
    }
    public static User getEventUser() {
        return eventUser;
    }

    public static void setEventUser(User user) {
        eventUser = user;
    }
    public boolean deleteUser()
    {
        boolean result = false;

        //code here
        return result;
    }

    public static ArrayList<Hall> getHallList() {
        return hallList;
    }

    public static ArrayList<Quotation> getQuotationList() {
        return quotationList;
    }
    public static ArrayList<User> getUserList() {
        return userList;
    }

    public static ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public static double getVeteranConcession() {
        return veteranConcession;
    }

    public static void setVeteranConcession(double concession) {
        veteranConcession = concession;
    }

    public static double getSeniorCitizenConcession() {
        return seniorCitizenConcession;
    }

    public static void setSeniorCitizenConcession(double senCitizenConcession) {
        seniorCitizenConcession = senCitizenConcession;
    }
    public Hall getSpecificHall(int hallID)
    {

        return hallList.get(hallID-1);
    }

}
