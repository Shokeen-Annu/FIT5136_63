import java.util.Scanner;

public class Customer extends User {

    public void cusMenu()
    {
        System.out.println("1. Search a hall");
        System.out.println("2. View all halls");
        System.out.println("3. Book a hall");
        System.out.println("4. Request a quotation");
        System.out.println("5. Cancel booking");
        System.out.println("6. Update booking");

        Scanner scanner = new Scanner(System.in);
        int customerNumber = scanner.nextInt();

        switch (customerNumber)
        {
            case 1: System.out.println("Search a hall page");
            break;
            case 2: System.out.println("View all halls page");
            break;
            case 3: System.out.println("Book a hall page");
            break;
            case 4: System.out.println("Request a quotation page");
            break;
            case 5: System.out.println("Cancel booking page");
            break;
            case 6: System.out.println("Update page");
            break;
            default: System.out.println("Please enter the option correctly");
            break;

        }
    }

    public void searchHalls()
    {
        System.out.println("Choose one way to search a hall");
        System.out.println("1. name of hall ");
        System.out.println("2. Star rating");
        System.out.println("3. Occassion type");
        System.out.println("4. location");
        System.out.println("5. date");

        Scanner scanner = new Scanner(System.in);
        int searchChoice = scanner.nextInt();

        switch (searchChoice)
        {
            case 1: System.out.println("Please enter the name of hall");
            break;
            case 2: System.out.println("Please enter the rating");
            break;
            case 3: System.out.println("Please enter a occassion type");
            break;
            case 4: System.out.println("Please enter a location");
            break;
            case 5: System.out.println("Please enter a date");
            break;
            default: System.out.println("Please choose the option correctly");
            break;
        }

    }
}
