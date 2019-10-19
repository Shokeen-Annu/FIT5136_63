import java.io.*;
import java.util.Scanner;

public class FileIO {

     public String readFile(String filePath)
    {
        String result = "";
        try {

            FileReader reader = new FileReader(filePath);
            Scanner scanner = new Scanner(reader);

            while(scanner.hasNextLine())
            {
                result += scanner.nextLine();
            }
            reader.close();
        }
        catch(FileNotFoundException ex)
        {
            System.out.println("File not found. Please contact the administrator.");
        }
        catch (Exception ex)
        {
            System.out.println("Some error occurred. Please contact the administrator.");
        }
        return result;
    }

    public void writeFile(String filename,String data) {

        BufferedWriter out = null;
        if (filename.trim().length() > 0) {
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));
                //PrintWriter output = new PrintWriter(filename);
                out.write(data);
                out.close();
            } catch (IOException e) {
                System.out.println("I/O Error");
            }
        } else {
            System.out.println("Enter a filename:");
        }
    }

    public void reWriteFile(String filename,String data) {

        if (filename.trim().length() > 0) {
            try {
                PrintWriter output = new PrintWriter(filename);

                output.write(data);

                output.close();
            } catch (IOException e) {
                System.out.println("I/O Error");
            }
        } else {
            System.out.println("Enter a filename:");
        }
    }

}
