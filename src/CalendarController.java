
import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ian
 */
public class CalendarController {
    
    ArrayList<Events> events = new ArrayList<Events>();
    EventView e;
    CalendarProgram p;
    
    
    public CalendarController(){
        this.e = new EventView(this);
        this.p = new CalendarProgram(this);
        //set cp visible right away (calendar)
        
        
        
        
        
    }
    
    public void viewDay(){
        //will make eventview visible
        
        
    }
    
    public void addEvent(String n, int day, int month, int year, Color color){  //called by eventview to add event
        events.add(new Events(n,day,month,year,color));
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
