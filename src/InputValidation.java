import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {


    public boolean validateInt(String inputLength)
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
    public String receiveString()
    {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public int receiveInt()
    {
        Scanner scanner = new Scanner(System.in);
        int input = -1;
        try {
            input = scanner.nextInt();
        }
        catch (Exception ex)
        {
            System.out.println("Please enter integer value.");
        }
        return input;
    }
    public boolean validateString(String input)
    {
        if(input.toUpperCase().equals("YES"))
        {  return true;}
        return false;
    }
    public boolean validateEmail(String email){

        if(email.trim().isEmpty() || email == null)
            return false;

        Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

        if(pattern.matcher(email).matches() == true)
            return true;
        else
            return false;

    }
    public boolean validatePassword(String password){

        if(password.trim().isEmpty() || password == null)
            return false;

        if(!password.matches("(.*[A-Z].*)") ||
                !password.matches("(.*[0-9].*)") ||
                !password.matches("(.*[a-z].*)") ||
                !password.matches("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)") ||
                !(password.length()<5 || password.length()>12))
            return false;

        return true;
    }
}
