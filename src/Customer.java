import java.util.Scanner;

public class Customer extends User {

    public void displayCustomerMenu()
    {
        System.out.println("1. Search a hall");
        System.out.println("2. View all halls");
        System.out.println("3. Book a hall");
        System.out.println("4. Request a quotation");
        System.out.println("5. Cancel booking");
        System.out.println("6. Update booking");
        System.out.println("7. Update customer information");

        Scanner scanner = new Scanner(System.in);
        String customerInput = scanner.nextLine();
        int customerNumber = -1;
        do {
                if (isNumber(customerInput) == false)
                {
                    System.out.println("Please enter the number");
                }
                else if (customerInput.length() == 0)
                {
                    System.out.println("Please enter the option");
                }
                else {
                          customerNumber = Integer.parseInt(customerInput);
                         switch (customerNumber) {
                         case 1: searchHalls();
                         break;
                         case 2: System.out.println("View all halls page");
                         break;
                         case 3: bookHalls();
                         break;
                         case 4: System.out.println("Request a quotation page");
                         break;
                         case 5: System.out.println("Cancel booking page");
                         break;
                         case 6: System.out.println("Update page");
                         break;
                         case 7: System.out.println("Update customer information");
                         break;
                         default: System.out.println("Please enter the option correctly");
                         break;
                      }
            }
        }while (customerNumber < 1 || customerNumber > 7);
    }

    public void searchHalls()
    {
        System.out.println("------Search a hall page---------");
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

    public void bookHalls()
    {
        System.out.println("This is booking halls page");
        System.out.print("1. Pay deposit");
        System.out.print("2. Provide rating");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice)
        {
            case 1: payment();
            break;
            case 2: System.out.println("Rating page");
            break;
        }
    }

    public void payment()
    {
        System.out.println("Pay deposit page");
        System.out.println("1. View receipt");
        Scanner scanner = new Scanner(System.in);
        int payChoice = scanner.nextInt();
        switch(payChoice)
        {
            case 1: System.out.println("Receipt page ");
            break;
            default: System.out.println("Please enter the right option");
            break;
        }
    }

    public boolean isNumber(String inputLength)
    {
        for (int i = 0; i < inputLength.length();i++)
        {
            char inputCharacter = inputLength.charAt(i);
            if (inputCharacter < '0' || inputCharacter > '9')
            {
                return false;
            }
        }
        return true;
    }

}
