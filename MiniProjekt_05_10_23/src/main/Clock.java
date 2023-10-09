package main;
import java.time.LocalDateTime;

import enums.State;
import main.Device;
import interfaces.StateChangeInterface;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;






public class Clock extends Device implements StateChangeInterface {
	private State currentState;
	 private LocalDateTime dateTime;
	
	public Clock() {
		currentState = State.READY;
		dateTime = LocalDateTime.now();
	}
	
	public State getCurrentState() {
	    return currentState;
	}

	
	
	 @Override
	    public State changeState(State newState) {
	       
	        currentState = newState;
	        return currentState;
	    }
	 
	 
	 public String getCurrentTime() {
		 
		 DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		 return dateTime.format(formatter);
	 }
	 
	 
	 public String getCurrentData() {
		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		 return dateTime.format(formatter);
		 
	 }
	 
	 
	 public void setTime(int hour, int minute) {
		 
		 dateTime = dateTime.withHour(hour).withMinute(minute);
		 
		 
	 }
	 
	 public void setDate(int day, int month, int year) {
		 
		 dateTime = dateTime.withYear(year).withMonth(month).withDayOfMonth(day);
		 
		 
	 }
	
	

}
