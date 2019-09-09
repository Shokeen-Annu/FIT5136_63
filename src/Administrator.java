import java.util.Scanner;

public class Administrator extends User {

    public void displayAdminMenu()
    {
        System.out.println("      WELCOME TO ADMINISTRATOR MENU     ");
        System.out.println();
        System.out.println("1 VIEW BOOKING HISTORY");
        System.out.println("2 VIEW REVIEW OF HALLS");
        System.out.println("3 DELETE CUSTOMER");
        System.out.println("4 MANAGE ADMINISTRATOR DISCOUNT");
        System.out.println("5 VIEW ALL HALLS");

        Scanner scanner = new Scanner(System.in);
        int admInput = scanner.nextInt();

        switch(admInput)
        {
            case 1: viewBookingHis();
            break;
            case 2: System.out.println("View reviews of halls page");
            break;
            case 3: System.out.println("Delete customer page");
            break;
            case 4: manAdmDiscount();
            break;
            case 5: System.out.println("View all halls page");
            break;
            default: System.out.println("Re-enter your option!");
            break;
        }
    }

    public void viewBookingHis()
    {
        System.out.println("1 VIEW BY CUSTOMERS");
        System.out.println("2 VIEW BY OWNER");
        System.out.println("0 BACK TO ADMINISTRATOR MAIN MENU");

        Scanner scanner = new Scanner(System.in);
        int admView = scanner.nextInt();

        switch (admView)
        {
            case 1: System.out.println("View by customer page");
            break;
            case 2: System.out.println("View by owner page");
            break;
            case 0: displayAdminMenu();
            break;
            default: System.out.println("Re-enter your option!");
            break;
        }
    }

    public void manAdmDiscount()
    {
        System.out.println("1 ADD DISCOUNT");
        System.out.println("2 DELETE DISCOUNT");
        System.out.println("3 EDIT DISCOUNT");
        System.out.println("0 BACK TO ADMINISTRATOR MAIN MENU");

        Scanner scanner = new Scanner(System.in);
        int admDis = scanner.nextInt();

        switch (admDis)
        {
            case 1: System.out.println("Add discount page");
            break;
            case 2: System.out.println("Delete discount");
            break;
            case 3: System.out.println("Edit discount");
            break;
            case 0: displayAdminMenu();
            break;
            default: System.out.println("Re-enter your option!");
            break;
        }
    }
}