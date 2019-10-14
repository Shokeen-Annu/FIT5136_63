import java.util.ArrayList;
import java.util.Scanner;
public class Owner extends User {
    private int choiceNumber;
    private String securityQuestion1;
    private String securityQuestion2;
    private String securityAnswer1;
    private String securityAnswer2;
    private ArrayList<Hall> hallList;
    private  String address;
    private ArrayList<Discount> discountList;
    private ArrayList<Booking> bookingList;
    private FileIO fileIO = new FileIO();
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
                      flag = owner.viewHistory();
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
        System.out.println("Enter 0 to go back to the Owner Menu");
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
                System.out.println("Enter 0 to go back to the Manage Halls Menu");
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
                System.out.println("Enter 0 to go back to the Manage Halls Menu");
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
                System.out.println("Please provide information to delete hall");
                System.out.println("Enter 0 to go back to the Manage Halls Menu");
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
                System.out.println("Enter 0 to go back to the Manage Halls Menu");
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
            System.out.println("      MANAGE BOOKING     ");
            System.out.println();
            System.out.println("1 VIEW RECEIPT");
            System.out.println("2 PROVIDE QUOTATION");
            System.out.println("3 CANCEL BOOKING");
            System.out.println("4 RETURN TO OWNER MENU");
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

             if (owner.choiceNumber == 1) {
                System.out.println("You can view receipts here");
                 System.out.println("Enter 0 to go back to the Manage Booking Menu");
                 Scanner console = new Scanner(System.in);
                 owner.choiceNumber = console.nextInt();
                 if(choiceNumber==0)
                 {
                    manageBookingFlag = false;
                 }
            }
            else if (owner.choiceNumber == 2) {
                 System.out.println("Please provide quotation to customer here");
                 System.out.println("Enter 0 to go back to the Manage Booking Menu");
                 Scanner console = new Scanner(System.in);
                 owner.choiceNumber = console.nextInt();
                 if(choiceNumber==0)
                 {
                     manageBookingFlag = false;
                 }
            }
            else if (owner.choiceNumber == 3) {
                 System.out.println("You can cancel a booking here");
                 System.out.println("Enter 0 to go back to the Manage Booking Menu");
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

    public boolean viewHistory()
    {
        Owner owner = new Owner ();
        System.out.println("View booking history of Halls");
        System.out.println("Enter 0 to go back to the Owner Menu");
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
             System.out.println("      MANAGE OWNER DISCOUNTS    ");
             System.out.println();
             System.out.println("1 ADD DISCOUNT");
             System.out.println("2 DELETE DISCOUNT");
             System.out.println("3 EDIT DISCOUNT");
             System.out.println("4 RETURN TO OWNER MENU");
            Scanner scanner = new Scanner(System.in);
            owner.choiceNumber = scanner.nextInt();

            if (owner.choiceNumber == 1) {
                System.out.println("Please add discount information");
                System.out.println("Enter 0 to go back to the  Manage Owner Discount Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageOwnerDiscountFlag = false;
                }

            }
            else if (owner.choiceNumber == 2) {
                System.out.println("You can delete discount here");
                System.out.println("Enter 0 to go back to the  Manage Owner Discount Menu");
                Scanner console = new Scanner(System.in);
                owner.choiceNumber = console.nextInt();
                if(choiceNumber==0)
                {
                    manageOwnerDiscountFlag = false;
                }
            }
            else if (owner.choiceNumber == 3) {
                System.out.println("You can edit discount here");
                System.out.println("Enter 0 to go back to the  Manage Owner Discount Menu");
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


    public String getSecurityQuestion1() {
        return securityQuestion1;
    }

    public void setSecurityQuestion1(String securityQuestion1) {
        this.securityQuestion1 = securityQuestion1;
    }

    public String getSecurityQuestion2() {
        return securityQuestion2;
    }

    public void setSecurityQuestion2(String securityQuestion2) {
        this.securityQuestion2 = securityQuestion2;
    }

    public String getSecurityAnswer1() {
        return securityAnswer1;
    }

    public void setSecurityAnswer1(String securityAnswer1) {
        this.securityAnswer1 = securityAnswer1;
    }

    public String getSecurityAnswer2() {
        return securityAnswer2;
    }

    public void setSecurityAnswer2(String securityAnswer2) {
        this.securityAnswer2 = securityAnswer2;
    }

    public ArrayList<Hall> getHallList() {
        return hallList;
    }

    public void createHallList(ArrayList<Hall> hallList) {
        this.hallList = hallList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<Discount> getDiscountList() {
        return discountList;
    }

    public ArrayList<Discount> createDiscountList()
    {
        String allDiscount = fileIO.readFile("Halls");
        String[] discountDetail = allDiscount.split(";");
        for(int i = 0; i< discountDetail.length; i++)
        {
            String[] specificDiscount = discountDetail[i].split(",");
            Discount temdriDiscount = new Discount();
            temdriDiscount.setDiscountId(Integer.parseInt(specificDiscount[0]));
            temdriDiscount.setDiscountName(specificDiscount[1]);
            temdriDiscount.setValue(Double.parseDouble(specificDiscount[2]));
            temdriDiscount.setComments(specificDiscount[3]);
            discountList.add(temdriDiscount);
        }
        return discountList;
    }

    public ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public void createBookingList(ArrayList<Booking> bookingList) {
        this.bookingList = bookingList;
    }

}
