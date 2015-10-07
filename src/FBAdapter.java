
import facebook.FBView;
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mico
 */
public class FBAdapter extends FBView implements ViewInterface {

    FBView fb;
    
    public FBAdapter(FBView newfb){
        fb = newfb;
    }
    

    @Override
    public void initScreen() {
       // fb.initScreen();
    }

    @Override
    public void displayData(Events event) {   //assume(will create) Event class have getter for "EventName", "Day", "Month", "Year", "Color"
        String name = event.getEventName();
        int day = event.getDay();     
        int month = event.getMonth();
        int year = event.getYear();
        Color color = event.getColor();
        
        
        fb.showNewEvent(name, day, month, year , color);
    }
    
}
