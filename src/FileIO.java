import java.io.*;
import java.util.Scanner;
/**
 *  This is the FileIO entity. the method in this class is to read from txt file and write to txt file.
 *
 * @author    Annu Shokeen, Zhijie Li, YuWu
 * @version   20/10/2019
 */
public class FileIO {

    /**
     * This method read the content from the file.
     *
     * @param filePath The string indicates the file name
     *  @return String  return the content of file
     */
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

    /**
     * This method is to append the information into txt file
     *
     * @param filename This indicates the file name.
     * @param data This indicates the data which need to append.
     */
    public void writeFile(String filename,String data) {

        BufferedWriter out = null;
        if (filename.trim().length() > 0) {
            try {
                out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename,true)));
                out.write(data);
                out.close();
            } catch (IOException e) {
                System.out.println("I/O Error");
            }
        } else {
            System.out.println("Enter a filename:");
        }
    }

    /**
     * This method is overwrite information into txt file.
     *
     * @param filename This indicates the file name.
     * @param data This indicates the data which need to write into file
     */
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
