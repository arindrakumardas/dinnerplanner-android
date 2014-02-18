package se.kth.csc.iprog.dinnerplanner.android.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
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
		
		findViewById(R.id.selected_instructions).setOnClickListener(this);
		findViewById(R.id.selected_starter).setOnClickListener(this);
		findViewById(R.id.selected_main).setOnClickListener(this);
		findViewById(R.id.selected_dessert).setOnClickListener(this);

	}
	
	@Override
	public void onClick(View v) {
		// Put listeners for the imageViews or the RelativeLayout containing dish image/names
		TextView description = (TextView) findViewById(R.id.selected_ingredients_summary);
		
		if (v == findViewById(R.id.selected_instructions)){
			StringBuilder sb = new StringBuilder();
			for(Ingredient i : model.getAllIngredients()) {
				sb.append(i.getName()).append("    ").append(i.getQuantity()).append(" ").append(i.getUnit()).append("\n");
			}
			description.setText(sb.toString());
		}

		if (v == findViewById(R.id.selected_starter)){
			description.setText("starter");
/* The problem is here	*
 * We need to load getDescription() from model.dish, but it crashes when I call it	*			
 */			
//			description.setText(dish.getDescription());
		}
		if (v == findViewById(R.id.selected_main)){
			description.setText("main");
//			TextView description = new TextView(view.view.getContext());
//			description.setText(dish.description);
		}
		if (v == findViewById(R.id.selected_dessert)){
			description.setText("dessert");
//			TextView description = new TextView(view.view.getContext());
//			description.setText(dish.description);
		}
	}
	
	private View findViewById(int id) {
		return view.view.findViewById(id);
	}
	
}
