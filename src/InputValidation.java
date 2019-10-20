import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *  This is the entity to save all the validate method.
 *
 * @author    Annu Shokeen, Zhijie Li
 * @version   20/10/2019
 */
public class InputValidation {

    /**
     * This method for validating the integer from the input.
     *
     * @param input This indicates the inputs from other method.
     * @return boolean This returns whether their input is an integer.
     */
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

    /**
     * This method for validating the String from the input.
     *
     * @return String This returns the input from the users
     */
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

    /**
     * This method for validating the string is empty or not.
     *
     * @param input This indicates the inputs from other method.
     * @return boolean This returns for result of check
     */
    public boolean isStringNullOrEmpty(String input)
    {
        if(input.trim().isEmpty() || input == null)
            return true;
        else
            return false;
    }

    /**
     * This method for validating the length of input of string from the input
     *
     * @param input This indicates the inputs from other method.
     * @param maxLength This indicates the max length of input string.
     * @param minLength This indicates the min length of input string
     * @return boolean This returns for result of check
     */
    public boolean validateLengthOfString(String input,int maxLength, int minLength)
    {
        if(input.length() >= minLength && input.length() <= maxLength)
            return true;
        else
            return false;
    }

    /**
     * This method for validating the length of input of string from the input
     *
     * @return int This returns the input integer
     */
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

    /**
     * This method for validating the format of the input email.
     *
     * @param email This is for the input email
     * @return boolean This returns for result of check
     */
    public boolean validateEmail(String email){

        if(email.trim().isEmpty() || email == null)
            return false;

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$");

        if(pattern.matcher(email).matches() == true)
            return true;
        else
            return false;

    }
    /**
     * This method for validating the password
     *
     * @param password This is indicates the password from the user input.
     * @return boolean This returns for result of check
     */
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

    /**
     * This method for validating the phone number is unique or not.
     *
     * @param input This indicates the inputs of user's phone number
     * @return boolean This returns for result of check
     */
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

    /**
     * This method for validating the email is unique or not.
     *
     * @param input This indicates the inputs of user's email
     * @return boolean This returns for result of check
     */
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

    /**
     * This method for validating the input of dollar sign.
     *
     * @param input This indicates the inputs of dollar sign.
     * @return boolean This returns for result of check
     */
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

    /**
     * This method for validating the inout of special character.
     *
     * @param input This indicates the inputs of special character
     * @return boolean This returns for result of check
     */
    public boolean validateSpecialChar(String input)
    {
        if(input.matches("(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)"))
        {
            return false;
        }
        return true;
    }

    /**
     * This method for validating the format and value of discount
     *
     * @return double This returns for value of discount
     */
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
    /**
     * This method for validating the length of input of string from the input
     *
     * @param small This the minimum value of the range.
     * @param  big This is the maximum value of the range.
     * @return int This returns the value of the correct choose.
     */
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
