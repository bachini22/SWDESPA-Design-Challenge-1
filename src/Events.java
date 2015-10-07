
import java.awt.Color;
import java.util.Calendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mico
 */
public class Events {
    private String eventName;
    private int day;
    private int month;
    private int year;      
    private Color Color;   
   // private Calendar date;     //naiisip ko na int nalang kasi SMS lang naman gumagamit ng Calendar. Also convert to calendar nalang sa SMSAdapter?

    public Events(String eventName, int day, int month, int year, Color Color) {
        this.eventName = eventName;
        this.day = day;
        this.month = month;
        this.year = year;
        this.Color = Color;
    }

    
    
    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Color getColor() {
        return Color;
    }

    public void setColor(Color Color) {
        this.Color = Color;
    }
    
    
    
}
