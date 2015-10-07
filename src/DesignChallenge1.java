
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sms.SMS;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Arturo III
 */
public class DesignChallenge1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<SMS> events = new ArrayList<SMS>();
        View v = new View();;
        
        PSV psv = new PSV();
        psv.ReadFile("C:\\Users\\asus\\Desktop\\SWDESPA\\DC1\\Sample Files\\DLSU Unicalendar.psv");
        try {
            events.addAll(psv.OpenFile());
        } catch (IOException ex) {
            Logger.getLogger(DesignChallenge1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CSV csv = new CSV();
        csv.ReadFile("C:\\Users\\asus\\Desktop\\SWDESPA\\DC1\\Sample Files\\Philippine Holidays.csv");
        try {
            events.addAll(csv.OpenFile());
        } catch (IOException ex) {
            Logger.getLogger(DesignChallenge1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CalendarProgram cp = new CalendarProgram(events, v);
    }
}
