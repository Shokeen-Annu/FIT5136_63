import java.util.Scanner;

public class CommonController {

    //private PEInterface peInterface = new PEInterface();
    private PrimeEvents primeEvents = new PrimeEvents();
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

    public  boolean viewHalls()
    {
        System.out.println("-------------- VIEW HALLS --------------");
        System.out.println();
        System.out.println();
        System.out.println("View all halls page");
        System.out.println("Press 0 to return");
        int admInput = new Scanner(System.in).nextInt();
        if(admInput == 0)
            return false;
        else
            return true;
    }

    public void createDatabase()
    {
        primeEvents.createUserList();
        primeEvents.createBookingList();
        primeEvents.createHallList();
    }
}
