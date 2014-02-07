package se.kth.csc.iprog.dinnerplanner.android;

import se.kth.csc.iprog.dinnerplanner.android.view.ExampleView;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	Button aButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Default call to load previous state
    	super.onCreate(savedInstanceState);
    	
    	// Set the view for the main activity screen
    	// it must come before any call to findViewById method
        setContentView(R.layout.activity_main);
        
    	// Creating the view class instance
    	//ExampleView mainView = new ExampleView(findViewById(R.id.this_is_example_view_id));

        // From the Dinner package
        // setContentView(R.layout.activity_main);
        
    	//Button in activity_main view
    	aButton = (Button) this.findViewById(R.id.button1);
    	aButton.setOnClickListener(new OnClickListener() {
    		public void onClick(View v) {
    		//aButton.setText("You Clicked Me");
    			Intent intent = new Intent(getBaseContext(), MainActivity2.class);
                startActivity(intent); 	
    		}}); 

    	
    	
    }

}
