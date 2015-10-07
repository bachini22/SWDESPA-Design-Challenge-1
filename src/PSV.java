
import java.awt.Color;
import java.lang.reflect.Field;
import java.util.Calendar;
import java.util.regex.Pattern;
import sms.SMS;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author asus
 */
public class PSV extends FileRead{

    @Override
    SMS parse(String textData) {
        String[] values = textData.split(Pattern.quote("|"));
        values[1] = values[1].trim();
        String[] date = values[1].split("/");
        Calendar date1 = Calendar.getInstance();
        
        System.out.println("Date: " + date[0] + "/" + date[1] + "/" + date[2]);
        System.out.println("Event name: " + values[0]);
        System.out.println("Color: " + values[2]);
        
        date1.set(Integer.parseInt(date[2]), Integer.parseInt(date[0]), Integer.parseInt(date[1]));
        String eventName = values[1];
        Color color;
        try {
            Field field = Class.forName("java.awt.Color").getField(values[2]);
            color = (Color)field.get(null);
        } catch (Exception e) {
            color = null; // Not defined
        }

        SMS event = new SMS(eventName, date1, color);
        return event;
    }

}
