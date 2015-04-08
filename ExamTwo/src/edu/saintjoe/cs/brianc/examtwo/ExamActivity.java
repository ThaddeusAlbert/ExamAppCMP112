
package edu.saintjoe.cs.brianc.examtwo;
// App For computer science exam 2 
// App taken from saintjoe-cs git repository on 4/8/15
// App modified and commented on by Thaddeus Albert 

import com.google.devtools.simple.runtime.components.Component;
import com.google.devtools.simple.runtime.components.HandlesEventDispatching;
import com.google.devtools.simple.runtime.components.android.Form;

import com.google.devtools.simple.runtime.components.android.Button;
import com.google.devtools.simple.runtime.components.android.Label;
import com.google.devtools.simple.runtime.components.android.HorizontalArrangement;
import com.google.devtools.simple.runtime.components.android.TextBox;
import com.google.devtools.simple.runtime.components.android.AccelerometerSensor;

import com.google.devtools.simple.runtime.events.EventDispatcher;
// import tells git to send all the directives to eclipse
public class ExamActivity extends Form implements HandlesEventDispatching {
// public class defines the class for this app as public and an extention 
	
	
	
	// begins to bring in the buttons, or equivilent components from app inventor 
	
	private HorizontalArrangement line1, line2, line3, line4, line5;
	private Button incButton;
	private Label resultLabel;
	private Label promptLabel;
	private TextBox inputBox;
	private Label outputLabel;
	int temp;
	
	// bridger uses $define() instead of main
 void $define() {
 	// "this" implies activity on the main screen 
     this.BackgroundColor(COLOR_WHITE);
     // add some containers for the UI Widgets 
     line1 = new HorizontalArrangement(this);
     line2 = new HorizontalArrangement(this);
     line3 = new HorizontalArrangement(this);
     line4 = new HorizontalArrangement(this);

     // time to add the interface
     promptLabel = new Label(line1, "Enter a number:");
     inputBox = new TextBox(line1);
     inputBox.NumbersOnly(true);
   
     incButton = new Button(line2,"Times 2:"); 
     
     resultLabel = new Label(line3,"");
     
     outputLabel = new Label(line4, "");
 
     EventDispatcher.registerEventForDelegation(this, "ButtonClick", "Click");
    // End $define()
 } 
 @Override
 public boolean dispatchEvent(Component component, String id, String eventName,
         Object[] args) {
	// This is the "Blocks" part of App Inventor
	    if (component.equals(incButton) && eventName.equals("Click")){
	    	temp = Integer.parseInt(inputBox.Text());
	    	temp *= 2;
	    	resultLabel.Text(String.valueOf(temp));
	        return true;
	     } 
	    // end dispatch '*' press
	    if (component.equals(resultLabel) && eventName.equals("Click")) {
	    	outputLabel.Text("You pushed me!!");
	    	return true;
	    	// This line is required
	    }
    return true;
	}
 // no more activity 
} 
