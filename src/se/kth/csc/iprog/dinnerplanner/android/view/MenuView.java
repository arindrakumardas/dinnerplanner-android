package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.ScrollView;
import android.widget.TextView;

public class MenuView {

	View view;

	public MenuView(View view, DinnerModel model) {

		// store in the class the reference to the Android View
		this.view = view;

		// Setup the rest of the view layout
		LinearLayout starters = (LinearLayout) view.findViewById(R.id.starters);
		LinearLayout mains = (LinearLayout) view.findViewById(R.id.mains);
		LinearLayout desserts = (LinearLayout) view.findViewById(R.id.desserts);

		//Add the images from the model

		//STARTERS
		for(Dish dish : model.getDishesOfType(Dish.STARTER)) {
			ImageView image = new ImageView(view.getContext());
			int imgID = view.getResources().getIdentifier(dish.getImage(), "drawable", view.getContext().getPackageName());
			//image.setBackgroundResource(R.drawable.bakedbrie);
			image.setImageResource(imgID);
			starters.addView(image);
			LayoutParams params = image.getLayoutParams();
			params.height = 160;
			params.width = 160;
			image.setLayoutParams(params);
		}

		//MAIN COURSES
		for(Dish dish : model.getDishesOfType(Dish.MAIN)) {
			ImageView image = new ImageView(view.getContext());
			int imgID = view.getResources().getIdentifier(dish.getImage(), "drawable", view.getContext().getPackageName());
			//image.setBackgroundResource(R.drawable.bakedbrie);
			image.setImageResource(imgID);
			mains.addView(image);
			LayoutParams params = image.getLayoutParams();
			params.height = 160;
			params.width = 160;
			image.setLayoutParams(params);
		}

		//DESSERTS
		for(Dish dish : model.getDishesOfType(Dish.DESERT)) {
			ImageView image = new ImageView(view.getContext());
			int imgID = view.getResources().getIdentifier(dish.getImage(), "drawable", view.getContext().getPackageName());
			//image.setBackgroundResource(R.drawable.bakedbrie);
			image.setImageResource(imgID);
			desserts.addView(image);
			LayoutParams params = image.getLayoutParams();
			params.height = 160;
			params.width = 160;
			image.setLayoutParams(params);
		}

		//		ImageView image = new ImageView(view.getContext());
		//		image.setBackgroundResource(R.drawable.bakedbrie);
		//		starters.addView(image);
	}

}
