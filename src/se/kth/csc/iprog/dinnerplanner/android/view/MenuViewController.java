package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;

public class MenuViewController implements OnClickListener {

	DinnerModel model;
	MenuView view;
	
	public MenuViewController(final DinnerModel model, final MenuView view) {
		this.model = model;
		this.view = view;
		
		//Set up the spinner
		Spinner spinner = (Spinner) view.view.findViewById(R.id.numberOfGuests);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
			
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int num = (Integer) arg0.getSelectedItem();
				model.setNumberOfGuests(num); //Update the number of guests in the model
				TextView totalCost = (TextView) findViewById(R.id.totalCost);
				totalCost.setText("Total Cost: " + model.getTotalMenuPrice() + " kr");
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {}
			
		});
		//Initiate the spinner
		spinner.setSelection(model.getNumberOfGuests()-1); //-1 for the index, not the number
		
		//Listen to clicks on the dishes
		LinearLayout starters = (LinearLayout) findViewById(R.id.starters);
		LinearLayout mains = (LinearLayout) findViewById(R.id.mains);
		LinearLayout desserts = (LinearLayout) findViewById(R.id.desserts);
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Put listeners for the imageViews or the RelativeLayout containing dish image/names
		
	}
	
	private View findViewById(int id) {
		return view.view.findViewById(id);
	}

}
