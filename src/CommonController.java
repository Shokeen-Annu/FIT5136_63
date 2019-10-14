public class CommonController {

    // Do not add any interface class object here
    private PrimeEvents primeEvents = new PrimeEvents();
    private InputValidation validator = new InputValidation();

    public String primeEventsLogin(String email,String password)
    {
        String role = "";
        for(User user: primeEvents.getUserList())
            {
                if(user.getEmail().equals(email) && user.getPassword().equals(password)) {

                    System.out.println("Login successful!");
                    role = user.getRole();
                    primeEvents.setEventUser(user);
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
        switch (type) {
            case "ALL": {
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    System.out.println(primeEvents.getHallList().get(i).displayHall());
                }
            }
            break;
            case "NAME": {
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getHallName().equals(searchInput)) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
            }
            break;
            case "ADDRESS": {
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getAddress().equals(searchInput)) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
            }
            break;
            case "RATING": {
                int searchRate = Integer.parseInt(searchInput);
                ;
                do {

                    if (searchRate < 1 || searchRate > 5)
                        System.out.println("Please enter the number between 1 and 5 !!");
                    searchRate = validator.receiveInt();
                } while (searchRate > 1 && searchRate < 5);
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getRating() > searchRate) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
            }
            break;
            case "OCCASSION":
                for (int i = 0; i < primeEvents.getHallList().size(); i++) {
                    if (primeEvents.getHallList().get(i).getTypeOfOccassion().equals(searchInput)) {
                        System.out.println(primeEvents.getHallList().get(i).displayHall());
                    }
                }
                break;
                default: break;
        }

    }
    // take hardcoded email id
    public void deleteDiscount(int discountId)
    {
        for(int i = 0; i < primeEvents.getUserList().size(); i++)
        {
            if(primeEvents.getUserList().get(i) == primeEvents.getEventUser())
            {
                Owner owner = (Owner)primeEvents.getUserList().get(i);
                owner.getDiscountList().remove(discountId - 1);
            }
        }
    }



    public void createDatabase()
    {
        primeEvents.createUserList();
        primeEvents.createBookingList();
        primeEvents.createHallList();
    }
}
