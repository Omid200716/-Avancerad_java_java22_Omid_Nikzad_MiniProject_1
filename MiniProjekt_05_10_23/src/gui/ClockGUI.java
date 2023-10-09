package gui;
import main.Clock;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import enums.State;

public class ClockGUI {
	
	private JFrame frame;
	private JButton changeStateButton;
	private JComboBox<State> stateList;
	private Clock clock;
	private JLabel currentStateLabel;
	
	private JTextField hourField, minuteField;
	private JTextField dayField, monthField, yearField;
	private JButton setTimeButton, setDataButton;
	
	
	public ClockGUI() {
		frame = new JFrame("Clock Interface");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900, 500);
		frame.setLayout( new FlowLayout());
		clock = new Clock();
		
		hourField = new JTextField(2);
		minuteField = new JTextField(2); // 2 tecken bred, för minuter 00-59
		dayField = new JTextField(2);    // 2 tecken bred, för dagar 01-31
		monthField = new JTextField(2);  // 2 tecken bred, för månader 01-12
		yearField = new JTextField(4);
		
		
		setTimeButton = new JButton("Set Time");
		setDataButton = new JButton("Set Data");
		
		
		
		stateList = new JComboBox<>(State.values());
		
		changeStateButton = new JButton("Change State");
		
		currentStateLabel = new JLabel("Current State:" + clock.getCurrentState().toString());
		
		
		setTimeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				   try {
			            int hour = Integer.parseInt(hourField.getText());
			            int minute = Integer.parseInt(minuteField.getText());
			            clock.setTime(hour, minute);
			            currentStateLabel.setText("Current Time: " + clock.getCurrentTime());
			        } catch(NumberFormatException ex) {
			            currentStateLabel.setText("Please enter valid values for hour and minute.");
			        }
			    }
			
			
		});
		
		
	setDataButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    try {
		            int day = Integer.parseInt(dayField.getText());
		            int month = Integer.parseInt(monthField.getText());
		            int year = Integer.parseInt(yearField.getText());
		            clock.setDate(day, month, year);
		            currentStateLabel.setText("Current Date: " + clock.getCurrentData());
		        } catch(NumberFormatException ex) {
		            currentStateLabel.setText("Please enter valid values for day, month, and year.");
		        }
		    }
			
			
		});
		
		
		changeStateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			    State selectedState = (State) stateList.getSelectedItem();
			    clock.changeState(selectedState);
			    
			    switch (selectedState) {
			        case DISPLAY_TIME:
			            currentStateLabel.setText("Current Time: " + clock.getCurrentTime());
			            break;
			            
			        case DISPLAY_DATE:
			            currentStateLabel.setText("Current Date: " + clock.getCurrentData());
			            System.out.println(clock.getCurrentData() + clock.getCurrentTime());
			            break;
			            
			        case CHANGE_TIME:
			        	 try {
			                    int hour = Integer.parseInt(hourField.getText());
			                    int minute = Integer.parseInt(minuteField.getText());
			                    clock.setTime(hour, minute);
			                    currentStateLabel.setText("Current Time: " + clock.getCurrentTime());
			                } catch(NumberFormatException ex) {
			                    currentStateLabel.setText("Please enter valid values for hour and minute.");
			                }
			            break;
			            
			        case CHANGE_DATE:
			        	  try {
			                    int day = Integer.parseInt(dayField.getText());
			                    int month = Integer.parseInt(monthField.getText());
			                    int year = Integer.parseInt(yearField.getText());
			                    clock.setDate(day, month, year);
			                    currentStateLabel.setText("Current Date: " + clock.getCurrentData());
			                } catch(NumberFormatException ex) {
			                    currentStateLabel.setText("Please enter valid values for day, month, and year.");
			                }
			            break;
			            
			        default:
			            currentStateLabel.setText("Current State: " + clock.getCurrentState().toString());
			            break;
			    }
			}

			
			
			
		});
		
		frame.add(stateList);
		frame.add(changeStateButton);
		frame.add(currentStateLabel);
		frame.add(hourField);
		frame.add(minuteField);
		frame.add(setTimeButton);
		frame.add(dayField);
		frame.add(monthField);
		frame.add(yearField);
		frame.add(setDataButton);
		
		
		frame.setVisible(true);
		
		
	}
	

}
