import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidation {


    public boolean validateInt(String input)
    {
        for (int i = 0; i < input.length();i++)
        {
            char inputCharacter = input.charAt(i);
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
        String inputString = "";
        try{
            inputString = scanner.nextLine();
        }
        catch (Exception ex)
        {
            System.out.println("Please enter correct value.");
        }
        return inputString;
    }
    public boolean isStringNullOrEmpty(String input)
    {
        if(input.trim().isEmpty() || input == null)
            return true;
        else
            return false;
    }
    public boolean validateLengthOfString(String input,int maxLength, int minLength)
    {
        if(input.length() >= minLength && input.length() <= maxLength)
            return true;
        else
            return false;
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

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");

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
                !password.matches("(.*[,~,!,@,#,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)") ||
                (password.length()<5 || password.length()>12))
            return false;

        return true;
    }

    public boolean isPhoneNumUnique(String input)
    {
        ArrayList<User> allUsers=  PrimeEvents.getUserList();
        for(User user: allUsers)
        {
            if(user.getPhoneNumber().equals(input))
                return false;
        }
        return true;
    }

    public boolean isEmailUnique(String input)
    {
        ArrayList<User> allUsers=  PrimeEvents.getUserList();
        for(User user: allUsers)
        {
            if(user.getEmail().equals(input))
                return false;
        }
        return true;
    }

    public boolean isDollarSign(String input)
    {
        for (int i = 0; i < input.length();i++)
        {
            char inputCharacter = input.charAt(i);
            if (inputCharacter == '$')
            {
                return false;
            }
        }
        return true;
    }

    public boolean validateSpecialChar(String input)
    {
        if(input.matches("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)"))
        {
            return false;
        }
        return true;
    }

    public double validateDiscountValue()
    {
            Scanner scanner = new Scanner(System.in);
            double input = 0.0;
            try {
                input = scanner.nextDouble();
                if(input > 1)
                {
                    System.out.println("Please enter the value smaller than 1");
                }
            }
            catch (Exception ex)
            {
                System.out.println("Please enter double value.");
            }
            return input;
    }
    public int validateRange(int number, int small, int big)
    {
        do{
            if(number < small || number > big )
            {
                System.out.println("Please enter correct value.");
                number = receiveInt();
            }
        }while(number < small || number > big);
        return number;
    }
}
