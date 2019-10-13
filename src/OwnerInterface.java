public class OwnerInterface {
   private int choiceNumber;

   public void displayManageDiscountMenu()
   {
       System.out.println("1 ADD DISCOUNT");
       System.out.println("2 EDIT DISCOUNT");
       System.out.println("3 DELETE DISCOUNT");
       choiceNumber = PrimeEvents.receiveInt();
       switch(choiceNumber)
       {
           case 1:
               break;
           case 2:
               break;
           case 3:
               break;
           default: System.out.println("Please enter the option correctly");
           break;
       }
   }
}
