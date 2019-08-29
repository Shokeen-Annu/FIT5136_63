import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        System.out.println("      WELCOME TO PRIME EVENTS     ");
        System.out.println();
        System.out.println("1 Login");
        System.out.println("2 Register");
        System.out.println("3 Forgot Password");
        System.out.println();
        System.out.println("Enter your choice number:");

        Scanner scanner = new Scanner(System.in);
        int choiceNumber = scanner.nextInt();

        switch (choiceNumber)
        {
            case 1: System.out.println("Login page");
            break;
            case 2: System.out.println("Register page");
                break;
            case 3: System.out.println("Forgot password page");
                break;
            default: System.out.println("Please enter your choice correctly!");
                break;
        }

    }
}
