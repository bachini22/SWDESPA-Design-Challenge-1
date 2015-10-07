
import facebook.FBView;
import java.util.Calendar;
import sms.SMS;
import sms.SMSView;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */

//Observer Class if SMSView and FBView can be edited
public class View {
    FBView fb = new FBView();
    SMSView sms = new SMSView();
    
    public void printEventDetails(SMS event) {
        sms.sendSMS(event);
        fb.showNewEvent(event.getEventName(), 
                event.getDate().get(Calendar.YEAR),
                event.getDate().get(Calendar.MONTH),
                event.getDate().get(Calendar.DAY_OF_MONTH), 
                event.getColor());
        
    }
    
}
