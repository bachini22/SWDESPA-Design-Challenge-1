/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mico
 */
public interface ViewInterface {
    
    //the idea, Mayroong "Event" class na laman lahat ng Events(eventname, day, month ,year , color) pati getter and setters. Event rin ata Model natin for MVC
    
    public void initScreen(); //not sure if still needed 
    public void displayData(Events events); //Events contain all the data of events. Events is our Model for MVC pattern?
    
}
