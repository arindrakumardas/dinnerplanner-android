package se.kth.csc.iprog.dinnerplanner.android.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class MenuView implements Observer{

	View view;
	int imageSize = 140;
	int textSize = 10;
	DinnerModel model;

	public MenuView(final View view, final DinnerModel model) {
		this.model = model;
		// store in the class the reference to the Android View
		this.view = view;
		//Subscribe to retrieve notifications when the model is updated.
		model.addObserver(this);

		// Fill the view of the spinner
		List<Integer> guestArray = new ArrayList<Integer>();
		for(int i = 1; i <= 10; i++) {
			guestArray.add(i);
		}
		ArrayAdapter<Integer> numberOfGuestsAdapter = new ArrayAdapter<Integer>(view.getContext(), 
				android.R.layout.simple_spinner_item, guestArray);
		Spinner spinner = (Spinner) view.findViewById(R.id.numberOfGuests);
		spinner.setAdapter(numberOfGuestsAdapter);
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int num = (Integer) arg0.getSelectedItem();
				model.setNumberOfGuests(num); //Update the number of guests in the model
				TextView totalCost = (TextView) view.findViewById(R.id.totalCost);
				totalCost.setText("Total Cost: " + model.getTotalMenuPrice() + " kr");
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
		spinner.setSelection(model.getNumberOfGuests()-1); //-1 for the index, not the number
		
		// Setup the dishes
		LinearLayout starters = (LinearLayout) view.findViewById(R.id.starters);
		LinearLayout mains = (LinearLayout) view.findViewById(R.id.mains);
		LinearLayout desserts = (LinearLayout) view.findViewById(R.id.desserts);

		//Add the images from the model
		loadDishesOfType(starters, Dish.STARTER);
		loadDishesOfType(mains, Dish.MAIN);
		loadDishesOfType(desserts, Dish.DESERT);
	}
	
	/**
	 * Loads all dishes of the selected type from our DinnerModel into the specified LinearLayout.
	 * Inserts the specified image and name of the dish.
	 * @param ll The LinearLayout to insert the images into
	 * @param type The dish type (for example Dish.STARTER)
	 */
	private void loadDishesOfType(LinearLayout ll, int type) {
		for(Dish dish : model.getDishesOfType(type)) {
			RelativeLayout layout = new RelativeLayout(view.getContext());
			
			//Load the image from resources
			ImageView image = new ImageView(view.getContext());
			int imgID = view.getResources().getIdentifier(dish.getImage(), "drawable", view.getContext().getPackageName());
			image.setImageResource(imgID);
			
			//Create a textView
			TextView text = new TextView(view.getContext());
			text.setText(dish.getName());
			text.setTextSize(textSize);
			text.setGravity(Gravity.CENTER_HORIZONTAL); 
			
			//Add the views to the RelativeLayout
			ll.addView(layout);
			RelativeLayout.LayoutParams imageParams = new RelativeLayout.LayoutParams(imageSize, imageSize);
			RelativeLayout.LayoutParams textParams = new RelativeLayout.LayoutParams(imageSize, LayoutParams.WRAP_CONTENT);
			image.setId(1);
			text.setId(2);
			textParams.addRule(RelativeLayout.BELOW, image.getId());
			layout.addView(image, imageParams);
			layout.addView(text, textParams);
		}
	}

	@Override
	public void update(Observable obs, Object o) {
		if(o instanceof Integer) {
			int arg = (Integer) o;
			if(arg == DinnerModel.STARTER) {
				//Mark the dish as selected (DONT KNOW IF THIS IS NECESSARY)
			} else if(arg == DinnerModel.MAIN) {
				//Mark the dish as selected
			} else if(arg == DinnerModel.DESSERT) {
				//Mark the dish as selected
			} if(arg == DinnerModel.GUESTS) {
				//Update the number of guests in the view
				Spinner spinner = (Spinner) view.findViewById(R.id.numberOfGuests);
				spinner.setSelection(model.getNumberOfGuests()-1); //-1 for the index, not the number
			}
		}
		
	}

}
