import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;

/**
 * This is the common controller which contains the common methods. The primeEventLogin, logout and viewHall method, createDataBase
 * can be used by different role, and the deleteDiscount and editDiscount can be used by administrator and owner.
 *
 * @author Annu Shokeen, Zhijie Li, YuWu
 * @version 20/10/2019
 */

public class CommonController {

    // Do not add any interface class object here
    private InputValidation validator = new InputValidation();
    private FileIO io = new FileIO();

    /**
     * This method is for user to login and verify user.
     *
     * @param email    user email address
     * @param password user password
     */
    public String primeEventsLogin(String email, String password) {
        String role = "";
        for (User user : PrimeEvents.getUserList()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {

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
     * @param choice
     * @return boolean This is to check the user, if they want to log out
     */
    public boolean logout(int choice) {
        boolean tryAgain = false;
        if (choice == 1) {
            tryAgain = true;
        } else if (choice == 2)
            tryAgain = false;

        return tryAgain;
    }

    /**
     * This method is for user to choose the type to view halls.
     *
     * @param type        The String indicates the type of choose.
     * @param searchInput The String indicates the input from the customer.
     */
    public void viewHalls(String type, String searchInput) {
        ArrayList<Hall> allHalls = PrimeEvents.getHallList();
        switch (type) {
            case "ALL": {
                for (int i = 0; i < allHalls.size(); i++) {
                    System.out.println(allHalls.get(i).displayHall());
                }
            }
            break;
            case "NAME": {
                boolean isNoHall = true;
                for (int i = 0; i < allHalls.size(); i++) {
                    if (allHalls.get(i).getHallName().toUpperCase().contains(searchInput)) {
                        System.out.println(allHalls.get(i).displayHall());
                        isNoHall = false;
                    }
                }
                if (isNoHall)
                    System.out.println("No such hall is present.");
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
                    if (searchRate < 1 || searchRate > 5) {
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
                for (Hall hall : allHalls) {
                    if (hall.getUserId() == ownerId)
                        System.out.println(hall.displayHall());
                }
            default:
                break;
        }

    }

    /**
     * This method is for user to delete the discount
     */
    public void deleteDiscount() {

        ArrayList<User> allUsers = PrimeEvents.getUserList();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i) == PrimeEvents.getEventUser()) {
                Owner owner = (Owner) allUsers.get(i);
                //owner.createDiscountList(owner.getUserId());
                ArrayList<Discount> ownerDiscount = owner.getDiscountList();
                if (ownerDiscount == null) {
                    System.out.println("Now, there is no discount in the database, so you can not delete any discount.");
                } else {
                    for (int index = 0; index < ownerDiscount.size(); index++) {
                        System.out.println(ownerDiscount.get(index).displayDiscount());
                    }
                    boolean isRepeat;
                    do {
                        isRepeat = false;
                        System.out.println("Please enter the choice");
                        int discountId = validator.receiveInt();
                        validator.validateRange(discountId, 1, ownerDiscount.size());
                        boolean discountIdValid = false;

                        for (Discount dis : ownerDiscount) {
                            if (dis.getDiscountId() == discountId) {
                                discountIdValid = true;
                                break;
                            }
                        }

                        if (!discountIdValid) {
                            System.out.println("Please enter correct option.");
                            isRepeat = true;
                        }
                        else {
                            boolean confirmationRepeat = false;
                            boolean isDelete = false;
                            do {
                                System.out.println("Are you sure you want to delete the discount?");
                                System.out.println("Enter your choice number");
                                System.out.println("1 Yes");
                                System.out.println("2 No");
                                int isConfirmation = validator.receiveInt();
                                if (isConfirmation == -1)
                                    confirmationRepeat = true;
                                else if (isConfirmation == 2) {
                                    System.out.println("Hall is not deleted.");
                                    confirmationRepeat = false;
                                } else if (isConfirmation == 1) {
                                    isDelete = true;
                                    confirmationRepeat = false;
                                } else {
                                    confirmationRepeat = true;
                                }
                            } while (confirmationRepeat);
                            if (isDelete) {
                                for (Discount dis : ownerDiscount) {
                                    if (dis.getDiscountId() == discountId) {
                                        ownerDiscount.remove(dis);
                                        break;
                                    }
                                }

                                String discountContent = "";
                                for (Discount item : ownerDiscount) {
                                    discountContent += item.disFile();
                                }
                                io.reWriteFile("Discounts", discountContent);
                                owner.createDiscountList(owner.getUserId());
                                System.out.println("Discount is deleted.");
                            }
                        }
                    }while(isRepeat);

                }
            }
        }
    }

    /**
     * This method is for user to edit the discount. They can edit discount from its name, value and comment.
     */
    public void editDiscount() {
        ArrayList<User> allUsers = PrimeEvents.getUserList();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).getUserId() == PrimeEvents.getEventUser().getUserId()) {
                Owner owner = (Owner) allUsers.get(i);
                ArrayList<Discount> ownerDiscount = owner.getDiscountList();
                System.out.println();
                int disAttribute = -1;
                if (ownerDiscount.size() == 0) {
                    System.out.println("Now, there is no discount in the database, so you can not edit any discount.");
                } else {
                    for(Discount discount:ownerDiscount)
                    {
                        System.out.println(discount.displayDiscount());
                    }

                    boolean flag = false;
                    do {
                            System.out.println("Please choose a discount id");
                            int discountId = validator.receiveInt();
                            int correctDiscountId = validator.validateRange(discountId, 1, ownerDiscount.size());
                        boolean discountIdValid = false;

                        for (Discount dis : ownerDiscount) {
                            if (dis.getDiscountId() == discountId) {
                                discountIdValid = true;
                                break;
                            }
                        }
                        if(discountIdValid) {

                            boolean isRepeat;
                            do {
                                isRepeat = false;
                                System.out.println("Which attribute you want to modify?");
                                System.out.println("1 NAME");
                                System.out.println("2 VALUE");
                                System.out.println("3 COMMENT");
                                disAttribute = validator.receiveInt();

                                for (Discount discount : ownerDiscount) {
                                    if (discount.getDiscountId() == discountId) {
                                        boolean isEdit = true;
                                        switch (disAttribute) {
                                            case 1:
                                                System.out.println("Please enter the name:");
                                                boolean isNameValid = true;
                                                String discountName ="";
                                                do {
                                                    if(!isNameValid)
                                                        System.out.println("Please enter name correctly. It should be less than 15 characters");
                                                    discountName = validator.receiveString().trim();
                                                    isNameValid = !validator.isStringNullOrEmpty(discountName) && validator.validateLengthOfString(discountName,15,1)
                                                            && validator.isDollarSign(discountName);
                                                }while(!isNameValid);

                                                discount.setDiscountName(discountName);
                                                isEdit = true;
                                                break;
                                            case 2:
                                                double disEditValue;

                                                System.out.println("Please enter the value");
                                                do{
                                                    disEditValue = validator.validateDiscountValue();
                                                } while(disEditValue > 1 || disEditValue <= Double.parseDouble("0"));

                                                discount.setValue(disEditValue);
                                                isEdit = true;
                                                break;
                                            case 3:
                                                System.out.println("Please change the comments");
                                                boolean isCommentValid = true;
                                                String disEditComment = "";

                                                do{
                                                    if(!isCommentValid)
                                                        System.out.println("Please enter comments less than 50 characters without $ character.");
                                                    disEditComment = validator.receiveString().trim();
                                                    isCommentValid = validator.validateLengthOfString(disEditComment,50,0)
                                                            && validator.isDollarSign(disEditComment);
                                                } while(!isCommentValid);

                                                if(disEditComment.equals(""))
                                                    disEditComment = " ";

                                                discount.setComments(disEditComment);
                                                isEdit = true;
                                                break;
                                            default: isRepeat = true;
                                                System.out.println("Choose correct option");
                                                isEdit = false;
                                                break;
                                        }
                                        if(isEdit)
                                            System.out.println("Discount edited successfully.");
                                    }
                                }
                            }while (isRepeat);
                        }
                        else
                        {
                            System.out.println("Enter correct discount id.");
                           flag = true;
                        }
                        }
                        while (disAttribute < 1 || disAttribute > 3 || flag) ;

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
     */
    public static void createDatabase() {
        PrimeEvents.createHallList();
        PrimeEvents.createUserList();
        PrimeEvents.createBookingList();
        PrimeEvents.createQuotationList();

    }

    /**
     * This method is used to register new user and save into database.
     */
    public boolean registerNewUser(String firstName, String lastName, String phoneNum, String email,
                                   String password, String sq1, String sq1Ans, String sq2, String sq2Ans, boolean isVeteran, boolean isSenior, String role) {
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
        } catch (Exception ex) {
            System.out.println("User is not created. Some error occurred.");
            return false;
        }
    }

    /**
     * This method creates the discount database for owner.
     */
    public void createOwnerDiscountList() {
        int ownerId = PrimeEvents.getEventUser().getUserId();
        ArrayList<User> allUsers = PrimeEvents.getUserList();
        for (User user : allUsers) {
            if (user.getUserId() == ownerId)
                ((Owner) user).createDiscountList(ownerId);
        }
    }
}

