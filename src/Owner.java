import java.util.Scanner;
public class Owner extends User {
    private int choiceNumber;

    public void displayOwnerMenu()
    {
        Owner owner = new Owner ();


        boolean flag = true;
        do {
            System.out.println("      WELCOME TO OWNER MENU     ");
            System.out.println();
            System.out.println("1 CREATE HALL");
            System.out.println("2 MANAGE HALL");
            System.out.println("3 MANAGE BOOKING");
            System.out.println("4 VIEW BOOKING HISTORY OF OWNER HALLS");
            System.out.println("5 MANAGE OWNER DISCOUNT");
            System.out.println("6 LOG OUT");
            System.out.println();
            System.out.println("Enter your choice number:");
            //Test
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
                      flag = true;
                      new PrimeEvents().logout();
                  }
                  else {
                      System.out.println();
                      System.out.println("Re-enter your option!");
                      System.out.println();
                  }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >6 || !flag);
    }
    public boolean creatHall()
    {
        Owner owner = new Owner();
        System.out.println("-------------- CREATE HALL --------------");
        System.out.println();
        System.out.println();
        System.out.println("please provide information");
        System.out.println("Enter 0 to return to the Owner Menu");
        Scanner scanner = new Scanner(System.in);
        owner.choiceNumber = scanner.nextInt();

        if ( owner.choiceNumber == 0)
        {
        return false;
        }
        return true;
    }

    public boolean manageHall()
    {
        Owner owner = new Owner();
        boolean manageHallFlag = true;

        do {
            System.out.println("------------- MANAGE HALLS ----------------");
            System.out.println();
            System.out.println("1 VIEW OWNER HALLS");
            System.out.println("2 UPDATE HALLS");
            System.out.println("3 DELETE HALLS");
            System.out.println("4 VIEW REVIEW OF HALLS");
            System.out.println("5 RETURN TO OWNER MENU");
            System.out.println("Enter your choice number:");
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

            if (owner.choiceNumber == 1) {
                System.out.println("-------------- VIEW OWNER HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println("The page of View owner halls");
                System.out.println("Enter 0 to return to the Manage Halls Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageHallFlag = false;
                }
            }
            else if (owner.choiceNumber == 2) {
                System.out.println("-------------- UPDATE HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println(" Provide information to update halls");
                System.out.println("Enter 0 to return to the Manage Halls Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageHallFlag = false;
                }
            }
            else if (owner.choiceNumber == 3) {
                System.out.println("-------------- DELETE HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println(" DPlease provide information to delete hall");
                System.out.println("Enter 0 to return to the Manage Halls Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageHallFlag = false;
                }
            }
            else if (owner.choiceNumber == 4) {
                System.out.println("-------------- VIEW REVIEWS OF HALLS --------------");
                System.out.println();
                System.out.println();
                System.out.println("This is the view review of halls page" );
                System.out.println("Enter 0 to return to the Manage Halls Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageHallFlag = false;
                }
            }
            else if (owner.choiceNumber == 5)
            {
                return false;
            }
            else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >4 || !manageHallFlag);
        return true;
          }

    public boolean manageBooking()
    {
        Owner owner = new Owner();
        boolean manageBookingFlag = true;

        do {
            System.out.println("      Manage Booking     ");
            System.out.println();
            System.out.println("1 VIEW RECEIPT");
            System.out.println("2 PROVIDE QUOTATION");
            System.out.println("3 CANCEL BOOKING");
            System.out.println("4 RETURN TO OWNER MENU");
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

             if (owner.choiceNumber == 1) {
                System.out.println("view receipt");
                 System.out.println("Enter 0 to return to the  Manage Booking  Menu");
                 Scanner console = new Scanner(System.in);
                 owner.choiceNumber = console.nextInt();
                 if(choiceNumber==0)
                 {
                    manageBookingFlag = false;
                 }
            }
            else if (owner.choiceNumber == 2) {
                 System.out.println("provide quotation");
                 System.out.println("Enter 0 to return to the  Manage Booking  Menu");
                 Scanner console = new Scanner(System.in);
                 owner.choiceNumber = console.nextInt();
                 if(choiceNumber==0)
                 {
                     manageBookingFlag = false;
                 }
            }
            else if (owner.choiceNumber == 3) {
                 System.out.println("cancel booking");
                 System.out.println("Enter 0 to return to the  Manage Booking  Menu");
                 Scanner console = new Scanner(System.in);
                 owner.choiceNumber = console.nextInt();
                 if(choiceNumber==0)
                 {
                     manageBookingFlag = false;
                 }
            }
             else if (owner.choiceNumber == 4) {
                 return false;
             }
            else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >4 || !manageBookingFlag);
        return true;
    }

    public boolean viewReview()
    {
        Owner owner = new Owner ();
        System.out.println("view Review of Halls");
        System.out.println("Enter 0 to return to the Owner Menu");
        Scanner scanner = new Scanner(System.in);
        owner.choiceNumber = scanner.nextInt();
        if ( owner.choiceNumber == 0)
        {
            return false;
        }
        return false;
    }

    public boolean manageOwnerDiscount ()
    {
        Owner owner = new Owner();
        boolean manageOwnerDiscountFlag = true;

         do {
             System.out.println("      Manage Owner Discount    ");
             System.out.println();
             System.out.println("1 ADD DISCOUNT");
             System.out.println("2 DELETE DISCOUNT");
             System.out.println("3 EDIT DISCOUNT");
             System.out.println("4 RETURN TO OWNER MENU");
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

            if (owner.choiceNumber == 1) {
                System.out.println("Please Add discount information");
                System.out.println("Enter 0 to return to the  Manage Owner Discount Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageOwnerDiscountFlag = false;
                }

            }
            else if (owner.choiceNumber == 2) {
                System.out.println("Delete discount");
                System.out.println("Enter 0 to return to the  Manage Owner Discount Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageOwnerDiscountFlag = false;
                }
            }
            else if (owner.choiceNumber == 3) {
                System.out.println("Edit discount");
                System.out.println("Enter 0 to return to the  Manage Owner Discount Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageOwnerDiscountFlag = false;
                }
            }
            else if (owner.choiceNumber == 4) {
               return false;
            }
             else {
                System.out.println("Re-enter your option");
            }
        } while (owner.choiceNumber < 1 || owner.choiceNumber >4 || !manageOwnerDiscountFlag );

        return true;
    }

}
