package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SummaryView {

	View view;
	DinnerModel model;

	public SummaryView(final View view, final DinnerModel model) {
		this.model = model;
		// store in the class the reference to the Android View
		this.view = view;

		insertImage(model.getSelectedDish(Dish.STARTER), (ImageView) view.findViewById(R.id.selected_starter));
		insertImage(model.getSelectedDish(Dish.MAIN), (ImageView) view.findViewById(R.id.selected_main));
		insertImage(model.getSelectedDish(Dish.DESERT), (ImageView) view.findViewById(R.id.selected_dessert));

	}
	
	/**
	 * Insert the image from the dish to the ImageView
	 */
	private void insertImage(Dish dish, ImageView image) {
			
			//Load the image from resources
			int imgID = view.getResources().getIdentifier(dish.getImage(), "drawable", view.getContext().getPackageName());
			image.setImageResource(imgID);
			image.getLayoutParams().height = 120;
			image.getLayoutParams().width = 120;
	}

}
