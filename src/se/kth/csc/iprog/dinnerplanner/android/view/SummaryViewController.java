package se.kth.csc.iprog.dinnerplanner.android.view;

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
	
	public SummaryViewController(final DinnerModel model, final SummaryView view) {
		this.model = model;
		this.view = view;
		
		findViewById(R.id.selected_starter).setOnClickListener(this);
		findViewById(R.id.selected_main).setOnClickListener(this);
		findViewById(R.id.selected_dessert).setOnClickListener(this);

		StringBuilder sb = new StringBuilder();
		for(Ingredient i : model.getAllIngredients()) {
    		sb.append(i.getName()).append("    ").append(i.getQuantity()).append(" ").append(i.getUnit()).append("\n");
    	}
	}
	@Override
	public void onClick(View v) {
		// TODO Put listeners for the imageViews or the RelativeLayout containing dish image/names
		System.err.println("clicked");
		if (v == findViewById(R.id.selected_instructions)){
			TextView ingredients = (TextView) findViewById(R.id.selected_instructions);
			ingredients.setText(sb.toString());
		}
		if (v == findViewById(R.id.selected_starter)){
			TextView description = (TextView) findViewById(R.id.instructions);
			description.setText(sb.toString());
		}
		if (v == findViewById(R.id.selected_main)){
			TextView description = (TextView) findViewById(R.id.instructions);
			description.setText(sb.toString());
		}
		if (v == findViewById(R.id.selected_dessert)){
			TextView description = (TextView) findViewById(R.id.instructions);
			description.setText(sb.toString());
		}
	}
	
	private View findViewById(int id) {
		return view.view.findViewById(id);
	}
	


}
