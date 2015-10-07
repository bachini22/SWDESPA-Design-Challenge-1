
import java.awt.Color;
import sms.SMSView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mico
 */
public class SMSAdapter implements ViewInterface{

    SMSView sms;
    
    public SMSAdapter(SMSView newsms){
        sms = newsms;
    }
    
    @Override
    public void initScreen() {
       // sms.initScreen();
    }

    @Override
    public void displayData(Events event) {
        String name = event.getEventName();
        int day = event.getDay();     
        int month = event.getMonth();
        int year = event.getYear();
        Color color = event.getColor();

        Calendar date= day + month + year;   //will convert day, month, year into "Calendar" type date
        
        SMS datasms(name, date, color);  //will instantiate from SMS java. NOTE: note SMSView but SMS java
        
        sms.sendSMS(datasms);   //rem sms is from SMSView, datasms is from SMS
    
}
