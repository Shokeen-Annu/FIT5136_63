import java.util.ArrayList;

public class CommonController {

    // Do not add any interface class object here
    private InputValidation validator = new InputValidation();
    private FileIO io = new FileIO();

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
                default: break;
        }

    }
    // take hardcoded email id
    public void deleteDiscount(int discountId)
    {
        ArrayList<User> allUsers = PrimeEvents.getUserList();
        for(int i = 0; i < allUsers.size(); i++)
        {
            if(allUsers.get(i) == PrimeEvents.getEventUser())
            {
                Owner owner = (Owner)allUsers.get(i);
                owner.getDiscountList().remove(discountId - 1);
                System.out.println("Now, the system delete the discount.");
                for(int index = 0; i < owner.getDiscountList().size(); i++)
                {
                    String contents = owner.getUserId() + "$" + owner.getDiscountList().get(index).getDiscountName() + "$" +
                                    owner.getDiscountList().get(index).getValue() + "$" + owner.getDiscountList().get(index).getComments()
                                    + "$$";
                    io.reWriteFile("Discounts", contents);
                }

            }
        }


    }

    public void editDiscount(int discountId) {
       ArrayList<User> allUsers = PrimeEvents.getUserList();
        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i) == PrimeEvents.getEventUser()) {
                Owner owner = (Owner) allUsers.get(i);
                System.out.println(owner.getDiscountList().get(discountId - 1).displayDiscount());
                System.out.println();
                int disAttribute = -1;
                do {
                    System.out.println("Which attribute you want to ");
                    System.out.println("1 NAME");
                    System.out.println("2 VALUE");
                    System.out.println("3 COMMENT");
                    disAttribute = validator.receiveInt();
                    switch (disAttribute) {
                        case 1: {
                            System.out.println("Please enter the name:");
                            String disEditName = validator.receiveString();
                            owner.getDiscountList().get(discountId - 1).setDiscountName(disEditName);
                        }
                        break;
                        case 2: {
                            System.out.println("Please enter the value");
                            double disEditValue = Double.parseDouble(validator.receiveString());
                            owner.getDiscountList().get(discountId - 1).setValue(disEditValue);
                        }
                        break;
                        case 3: {
                            System.out.println("Please change the comments");
                            String disEditComment = validator.receiveString();
                            owner.getDiscountList().get(discountId - 1).setComments(disEditComment);
                        }
                        break;
                        default:
                            break;
                    }

                } while (disAttribute < 1 || disAttribute > 3);
            }
        }
    }

    public static void createDatabase()
    {
        PrimeEvents.createHallList();
        PrimeEvents.createUserList();
        PrimeEvents.createBookingList();

    }
}

