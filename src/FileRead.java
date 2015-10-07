
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public abstract class FileRead {
    
    String path;

    public final void ReadFile(String file_path) {
            path = file_path;
    }
        //changes ArrayList<SMS> to ArrayList<Events>
    public final ArrayList<Events> OpenFile() throws IOException {
		FileReader fr = new FileReader(path);
		BufferedReader textReader = new BufferedReader(fr);

		int numberOfLines = readLines();
		String[] textData = new String[numberOfLines];
                ArrayList<Events> events = new ArrayList<Events>();
		int i;

		for(i = 0; i < numberOfLines; i++) {
			textData[i] = textReader.readLine();
                        events.add(parse(textData[i]));
                }
                
		textReader.close();
		return events;
    }
    
    //Get number of lines
    int readLines() throws IOException {
            FileReader file_to_read = new FileReader(path);
            BufferedReader bf = new BufferedReader(file_to_read);

            String aLine;
            int numberOfLines = 0;

            while((aLine = bf.readLine()) != null) {
                    numberOfLines++;
            }
            bf.close();

            return numberOfLines;
    }
    
    abstract Events parse(String textData);
}
