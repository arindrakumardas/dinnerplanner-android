package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.AdapterView.OnItemSelectedListener;
import se.kth.csc.iprog.dinnerplanner.android.DinnerPlannerApplication;
import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import se.kth.csc.iprog.dinnerplanner.model.Dish;
import se.kth.csc.iprog.dinnerplanner.model.Ingredient;

public class SummaryViewController implements OnClickListener {

	DinnerModel model;
	SummaryView view;
	Dish dish;
	
	public SummaryViewController(final DinnerModel model, final SummaryView view) {
		this.model = model;
		this.view = view;
		
		findViewById(R.id.selected_starter).setOnClickListener(this);
		findViewById(R.id.selected_main).setOnClickListener(this);
		findViewById(R.id.selected_dessert).setOnClickListener(this);
		
		

	}
	@Override
	public void onClick(View v) {
		// Put listeners for the imageViews or the RelativeLayout containing dish image/names
		

	if (v == findViewById(R.id.selected_instructions)){
		System.err.println("clicked_ingredients");
/*			TextView ingredients = (TextView) findViewById(R.id.selected_instructions);
			StringBuilder sb = new StringBuilder();
			for(Ingredient i : model.getAllIngredients()) {
	    		sb.append(i.getName()).append("    ").append(i.getQuantity()).append(" ").append(i.getUnit()).append("\n");
	    	}
			ingredients.setText(sb.toString());*/
		}

		if (v == findViewById(R.id.selected_starter)){
			System.err.println("clicked_starter");
			TextView instructions = (TextView) findViewById(R.id.instructions);
			instructions.setText(dish.getDescription());
//			TextView description = new TextView(view.view.getContext());
//			description.setText(dish.description);
		}
		if (v == findViewById(R.id.selected_main)){
			System.err.println("clicked_main");
//			TextView description = new TextView(view.view.getContext());
//			description.setText(dish.description);
		}
		if (v == findViewById(R.id.selected_dessert)){
			System.err.println("clicked_dessert");
//			TextView description = new TextView(view.view.getContext());
//			description.setText(dish.description);
		}
	}
	
	private View findViewById(int id) {
		return view.view.findViewById(id);
	}
	


}
