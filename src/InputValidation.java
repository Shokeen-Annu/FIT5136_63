import java.util.Scanner;

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
        return scanner.nextInt();
    }
    public boolean validateString(String input)
    {
        if(input.toUpperCase().equals("YES"))
        {  return true;}
        return false;
    }
}
