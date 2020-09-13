package local.tin.tests.utils.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 *
 * @author benito.darder
 */
public class FileUtils {

    private static FileUtils instance;

    private FileUtils() {
    }

    public static FileUtils getInstance() {
        if (instance == null) {
            instance = new FileUtils();
        }
        return instance;
    }

    /**
     * Returns a BufferedReader for the specified file path string.
     *
     * @param filePath String
     * @return BufferedReader
     * @throws FileNotFoundException
     */
    public BufferedReader getBufferedReader(String filePath) throws FileNotFoundException {
        FileInputStream fileA = new FileInputStream(filePath);
        InputStreamReader inputStreamA = new InputStreamReader(fileA);
        return new BufferedReader(inputStreamA);
    }

    /**
     * Opens the specified file path, and returns a Properties with the included
     * properties.
     *
     * @param filePath String
     * @return Properties
     * @throws FileNotFoundException
     * @throws IOException
     */
    public Properties getPropertiesFile(String filePath) throws IOException {
        InputStream fileInputStream = new FileInputStream(filePath);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }

    /**
     * Returns a String containing the content of the file.
     *
     * @param filePath String
     * @return String
     * @throws java.io.IOException
     */
    public String getFileAsString(String filePath) throws IOException {
        BufferedReader bufferedReader = getBufferedReader(filePath);
        StringBuilder stringBuilder = new StringBuilder();
        String string = bufferedReader.readLine();
        while (string != null) {
            stringBuilder.append(string);
            string = bufferedReader.readLine();
            if (string != null) {
                stringBuilder.append(System.lineSeparator());
            }
        }
        return stringBuilder.toString();
    }

    /**
     * Saves a String as the stated filePath file
     *
     * @param filePath String
     * @param content String
     * @throws java.io.IOException
     */
    public void saveStringAsFile(String filePath, String content) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(content);
        } finally {
            if (writer != null) {
                 writer.close();       
            }
        }

    }
}
