
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
    
    
    public CalendarController(){
        EventView ev = new EventView(this);
        CalendarProgram cp = new CalendarProgram(this);
        
        
        
        
        
    }
    
    public void addEvent(String n, int day, int month, int year, Color color){
        events.add(new Events(n,day,month,year,color));
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}