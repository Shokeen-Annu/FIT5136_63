import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *  This is the FileIO entity. the method in this class is to read from txt file and write to txt file.
 *
 * @author    Annu Shokeen, Zhijie Li, YuWu
 * @version   20/10/2019
 */
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

    public ArrayList<String[]> readFileToArray(String txtFile )
    {
        try
        {
            FileReader inputFile = new FileReader(txtFile);
            Scanner parser = new Scanner(inputFile);
            ArrayList<String[]> txt = new ArrayList<String[]>();
            while(parser.hasNextLine())
            {
                String line = parser.nextLine();
                String[] strArray = line.split(",");
                txt.add(strArray);
            }
            inputFile.close();
            return txt;
        }
        catch(FileNotFoundException exception)
        {
            System.out.println(txtFile + "not found");
        }
        catch(IOException exception)
        {
            System.out.println("Unexpected I/O error occurred");
        }
        return null;
    }


}
