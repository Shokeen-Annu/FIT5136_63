import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private int phoneNo;
    private String emailAdd;
    private String passWord;


    public User()
    {
        firstName = " ";
        lastName = " ";
        phoneNo = 0 ;
        emailAdd = " ";
        passWord = " ";
    }


    public User (String newFirstName, String newLastName, int newPhoneNo, String newEmailAdd, String newPassWord)
    {
        firstName = newFirstName;
        lastName = newLastName;
        phoneNo = newPhoneNo;
        emailAdd = newEmailAdd;
        passWord = newPassWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String displayUser()
    {
        return firstName + " " + lastName  + "\r\n" + "phone number: " + phoneNo + "\r\n" + "email address: "+ emailAdd;
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
}
