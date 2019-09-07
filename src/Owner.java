import java.util.Scanner;
public class Owner extends User {
    private int choiceNumber;

    public static void main(String[] args)
    {
        Owner owner = new Owner ();

        System.out.println("      WELCOME TO OWNER MENU     ");
        System.out.println();
        System.out.println("1 Create halls");
        System.out.println("2 Manage halls");
        System.out.println("3 Manage booking");
        System.out.println("4 View booking history of owner's halls");
        System.out.println("5 manage owner discount");
        System.out.println("6 login out");
        System.out.println();
        System.out.println("Enter your choice number:");
        boolean flag = true;
        do {
            System.out.println("      WELCOME TO OWNER MENU     ");
            System.out.println();
            System.out.println("1 Create halls");
            System.out.println("2 Manage halls");
            System.out.println("3 Manage booking");
            System.out.println("4 View booking history of owner's halls");
            System.out.println("5 manage owner discount");
            System.out.println("6 login out");
            System.out.println();
            System.out.println("Enter your choice number:");
             Scanner scanner = new Scanner(System.in);
             owner.choiceNumber = scanner.nextInt();
                  if (owner.choiceNumber == 1) {
                      flag = owner.creatHall();
                  }
                  else if (owner.choiceNumber == 2) {
                      flag = owner.manageHall();
                           }
                  else if (owner.choiceNumber == 3) {
                      flag = owner.manageBooking();
                  }
                  else if (owner.choiceNumber == 4) {
                      flag = owner.viewReview();
                  }
                  else if (owner.choiceNumber == 5) {
                      flag = owner.manageOwnerDiscount();
                       }
                  else if (owner.choiceNumber == 6) {

                  }
                  else {
                      System.out.println();
                      System.out.println("Re-enter your option!");
                      System.out.println();
                  }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >5 || !flag);
    }
    public boolean creatHall()
    {
        System.out.println("please enter information");
        return false;

    }
    public boolean manageHall()
    {
        Owner owner = new Owner();
        System.out.println("      Manage Hall      ");
        System.out.println();
        System.out.println("1 View owner halls");
        System.out.println("2 Update halls");
        System.out.println("3 Delete halls");
        System.out.println("4 View review of halls");
        System.out.println("5 Return to the previous menu");
        System.out.println("Enter your choice number:");
        do {
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

            if (owner.choiceNumber == 1) {
                System.out.println("View owner halls");
            }
            else if (owner.choiceNumber == 2) {
                System.out.println(" Update halls");
            }
            else if (owner.choiceNumber == 3) {
                System.out.println(" Delete halls");
            }
            else if (owner.choiceNumber == 4) {
                System.out.println("View review of halls" );
            }
            else if (owner.choiceNumber == 5)
            {
                return false;
            }
            else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >4);
        return true;
          }
    public boolean manageBooking()
    {
        Owner owner = new Owner();
        System.out.println("      Manage Booking     ");
        System.out.println();
        System.out.println("1 view receipt");
        System.out.println("2 provide quotation");
        System.out.println("3 cancel booking");
        System.out.println("4 Return to the previous menu");
        do {
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

             if (owner.choiceNumber == 1) {
                System.out.println("view receipt");
            }
            else if (owner.choiceNumber == 2) {
                System.out.println("provide quotation");
            }
            else if (owner.choiceNumber == 3) {
                System.out.println("cancel booking");
            }
             else if (owner.choiceNumber == 4) {
                 return false;
             }
            else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >3);
        return true;
    }

    public boolean viewReview()
    {
        System.out.println("view Review of Halls");
        return false;
    }
    public boolean manageOwnerDiscount ()
    {
        Owner owner = new Owner();
        System.out.println("      Manage Owner Discount    ");
        System.out.println();
        System.out.println("1 Add discount");
        System.out.println("2 Delete discount");
        System.out.println("3 Edit discount");
        System.out.println("4 Return to the previous menu");
         do {
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

            if (owner.choiceNumber == 1) {
                System.out.println("Add discount");

            }
            else if (owner.choiceNumber == 2) {
                System.out.println("Delete discount");
            }
            else if (owner.choiceNumber == 3) {
                System.out.println("Edit discount");
            }
            else if (owner.choiceNumber == 4) {
               return false;
            }
             else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >3);

        return true;
    }

}
