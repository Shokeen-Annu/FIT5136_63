import java.util.ArrayList;
/**
 *  This is the common controller which contains the common methods. The primeEventLogin, logout and viewHall method, createDataBase
 *  can be used by different role, and the deleteDiscount and editDiscount can be used by administrator and owner.
 *
 * @author    Annu Shokeen, Zhijie Li, YuWu
 * @version   20/10/2019
 */

public class CommonController {

    // Do not add any interface class object here
    private InputValidation validator = new InputValidation();
    private FileIO io = new FileIO();

    /**
     * This method is for user to login and verify user.
     *
     *   @param email user email address
     *   @param password user password
     */
    public String primeEventsLogin(String email,String password)
    {
        String role = "";
        for(User user: PrimeEvents.getUserList())
            {
                if(user.getEmail().equals(email) && user.getPassword().equals(password)) {

                    System.out.println("Login successful!");
                    role = user.getRole();
                    PrimeEvents.setEventUser(user);
                }
            }

        return role;
    }

    /**
     * This method is for user to logout from the system.
     *
     *   @param choice
     *   @return boolean This is to check the user, if they want to log out
     */
    public boolean logout(int choice)
    {
        boolean tryAgain = false;
        if(choice == 1) {
            tryAgain = true;
        }
        else if(choice == 2)
            tryAgain = false;

        return tryAgain;
    }

    /**
     * This method is for user to choose the type to view halls.
     *
     *   @param type The String indicates the type of choose.
     *   @param searchInput The String indicates the input from the customer.
     */
    public void viewHalls(String type, String searchInput)
    {
        ArrayList<Hall> allHalls = PrimeEvents.getHallList();
        switch (type) {
            case "ALL": {
                for (int i = 0; i < allHalls.size(); i++) {
                    System.out.println(allHalls.get(i).displayHall());
                }
            }
            break;
            case "NAME": {
                for (int i = 0; i < allHalls.size(); i++) {
                    if (allHalls.get(i).getHallName().toUpperCase().contains(searchInput)) {
                        System.out.println(allHalls.get(i).displayHall());
                    }
                }
            }
            break;
            case "ADDRESS": {
                for (int i = 0; i < allHalls.size(); i++) {
                    if (allHalls.get(i).getAddress().toUpperCase().equals(searchInput)) {
                        System.out.println(allHalls.get(i).displayHall());
                    }
                }
            }
            break;
            case "RATING": {
                int searchRate = Integer.parseInt(searchInput);
                ;
                do {
                    if (searchRate < 1 || searchRate > 5)
                    {
                        System.out.println("Please enter the number between 1 and 5 !!");
                        searchRate = validator.receiveInt();
                    }

                } while (searchRate < 1 || searchRate > 5);
                for (int i = 0; i < allHalls.size(); i++) {
                    if (allHalls.get(i).getRating() > searchRate) {
                        System.out.println(allHalls.get(i).displayHall());
                    }
                }
            }
            break;
            case "OCCASSION":
                for (int i = 0; i < allHalls.size(); i++) {
                    if (allHalls.get(i).getTypeOfOccassion().toUpperCase().equals(searchInput)) {
                        System.out.println(allHalls.get(i).displayHall());
                    }
                }
                break;
            case "OWNER":
                int ownerId = Integer.parseInt(searchInput);
                for(Hall hall : allHalls)
                {
                    if(hall.getUserId() == ownerId)
                        System.out.println(hall.displayHall());
                }
                default: break;
        }

    }

    /**
     * This method is for user to delete the discount
     *
     */
    public void deleteDiscount()
    {

        ArrayList<User> allUsers = PrimeEvents.getUserList();
        for(int i = 0; i < allUsers.size(); i++)
        {
            if(allUsers.get(i) == PrimeEvents.getEventUser())
            {
                Owner owner = (Owner)allUsers.get(i);
                owner.createDiscountList(owner.getUserId());
                ArrayList<Discount> ownerDiscount = owner.getDiscountList();
                if(ownerDiscount == null)
                {
                    System.out.println("Now, there is no discount in the database, so you can not delete any discount.");
                }
                else {
                        for (int index = 0; index < ownerDiscount.size(); index++) {
                         System.out.println(ownerDiscount.get(index).displayDiscount());
                    }
                    System.out.println("Please enter the choice");
                       int discountId = validator.receiveInt();
                       validator.validateRange(discountId,1,ownerDiscount.size());
                    ownerDiscount.remove(discountId - 1);
                    System.out.println("Now, the system delete the discount.");
                    String discountContent = "";
                    for (Discount item : ownerDiscount) {
                        discountContent += item.disFile();
                    }
                    io.reWriteFile("Discounts", discountContent);
                }
            }
        }
    }

    /**
     * This method is for user to edit the discount. They can edit discount from its name, value and comment.
     *
     */
    public void editDiscount() {
       ArrayList<User> allUsers = PrimeEvents.getUserList();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUserId() == PrimeEvents.getEventUser().getUserId()) {
                Owner owner = (Owner) allUsers.get(i);
                ArrayList<Discount> ownerDiscount = owner.getDiscountList();
                System.out.println();
                int disAttribute = -1;
                if(ownerDiscount.size() == 0)
                {
                    System.out.println("Now, there is no discount in the database, so you can not edit any discount.");
                }
                else{
                    do {
                        for(int index = 0; index < ownerDiscount.size();index++)
                        {
                            System.out.println(ownerDiscount.get(index).displayDiscount());
                        }
                        System.out.println("Please choose a discount id");
                        int discountId = validator.receiveInt();
                       int correctDiscountId =  validator.validateRange(discountId,1,ownerDiscount.size());
                        System.out.println("Which attribute you want to ");
                        System.out.println("1 NAME");
                        System.out.println("2 VALUE");
                        System.out.println("3 COMMENT");
                        disAttribute = validator.receiveInt();
                        switch (disAttribute) {
                            case 1:
                                System.out.println("Please enter the name:");
                                String disEditName = validator.receiveString();
                                ownerDiscount.get(correctDiscountId - 1).setDiscountName(disEditName);

                                break;
                            case 2:
                                System.out.println("Please enter the value");
                                double disEditValue = validator.validateDiscountValue();
                                ownerDiscount.get(correctDiscountId - 1).setValue(disEditValue);
                                break;
                            case 3:
                                System.out.println("Please change the comments");
                                String disEditComment = validator.receiveString();
                                ownerDiscount.get(correctDiscountId - 1).setComments(disEditComment);
                                break;
                            default:
                                break;
                        }
                    } while (disAttribute < 1 || disAttribute > 3);
                    String discountContent = "";
                    for (Discount item : ownerDiscount) {
                        discountContent += item.disFile();
                    }
                    io.reWriteFile("Discounts", discountContent);
                }
            }
        }
    }

    /**
     * This method is used to save the value into database i.e. arraylists in Primeevents class
     *
     */
    public static void createDatabase()
    {
        PrimeEvents.createHallList();
        PrimeEvents.createUserList();
        PrimeEvents.createBookingList();
        PrimeEvents.createQuotationList();

    }

    /**
     * This method is used to register new user and save into database.
     *
     */
    public boolean registerNewUser(String firstName, String lastName, String phoneNum, String email,
    String password,String sq1,String sq1Ans,String sq2,String sq2Ans,boolean isVeteran,boolean isSenior,String role)
    {
        try {
            User user = null;
            if (role.equals("customer")) {
                user = new Customer();
                ((Customer) user).setSeniorCitizen(isSenior);
                ((Customer) user).setVeteran(isVeteran);
                ((Customer) user).setSecurityQuestion1(sq1);
                ((Customer) user).setSecurityQuestion2(sq2);
                ((Customer) user).setSecurityAnswer1(sq1Ans);
                ((Customer) user).setSecurityAnswer2(sq2Ans);
            } else if (role.equals("owner")) {
                user = new Owner();
                ((Owner) user).setSecurityQuestion1(sq1);
                ((Owner) user).setSecurityQuestion2(sq2);
                ((Owner) user).setSecurityAnswer1(sq1Ans);
                ((Owner) user).setSecurityAnswer2(sq2Ans);
            }

            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setPhoneNumber(phoneNum);
            user.setEmail(email);
            user.setPassword(password);
            user.setAddress(" ");
            user.setRole(role);
            int maxUserId = -1;
            for (User item : PrimeEvents.getUserList()) {
                if (maxUserId < item.getUserId())
                    maxUserId = item.getUserId();
            }
            user.setUserId(maxUserId + 1);
            String userContent = "";
            userContent = user.toString();

            io.writeFile("Users", userContent);
            PrimeEvents.createUserList();
            return true;
        }
        catch(Exception ex)
        {
            System.out.println("User is not created. Some error occurred.");
            return false;
        }
    }

    /**
     * This method creates the discount database for owner.
     *
     */
    public void createOwnerDiscountList()
    {
        int ownerId = PrimeEvents.getEventUser().getUserId();
        ArrayList<User> allUsers = PrimeEvents.getUserList();
        for(User user:allUsers)
        {
            if(user.getUserId() == ownerId)
                ((Owner)user).createDiscountList(ownerId);
        }
    }
}

