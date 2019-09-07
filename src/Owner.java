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

             Scanner scanner = new Scanner(System.in);
             owner.choiceNumber = scanner.nextInt();
                  if (owner.choiceNumber == 1) {
                      owner.creatHall();
                  }
                  else if (owner.choiceNumber == 2) {


                      flag = owner.manageHall();

                           }
                  else if (owner.choiceNumber == 3) {
                     owner.manageBooking();
                  }
                  else if (owner.choiceNumber == 4) {
                      owner.viewReview();
                  }
                  else if (owner.choiceNumber == 5) {
                      owner.manageOwnerDiscount();
                       }
                  else if (owner.choiceNumber == 6) {
                  }
                  else {
                      System.out.println("re-enter your option");
                  }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >5 || !flag);
    }
    public void creatHall()
    {
        System.out.println("please enter information");

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
        System.out.println("5 Exit");
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
                System.exit(0);
                return false;
            }
            else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >4);
        return true;
          }
    public void manageBooking()
    {
        Owner owner = new Owner();
        System.out.println("      Manage Booking     ");
        System.out.println();
        System.out.println("1 view receipt");
        System.out.println("2 provide quotation");
        System.out.println("3 cancel booking");

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
            else {
                System.out.println("re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >3);

    }

    public void viewReview()
    {
        System.out.println("view Review of Halls");
    }
    public void manageOwnerDiscount ()
    {
        Owner owner = new Owner();
        System.out.println("      Manage Owner Discount    ");
        System.out.println();
        System.out.println("1 add discount");
        System.out.println("2 delete discount");
        System.out.println("3 edit discount");

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
             else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >3);

    }

}
