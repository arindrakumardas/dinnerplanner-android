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

public class SummaryViewController implements OnClickListener {

	DinnerModel model;
	SummaryView view;
	
	public SummaryViewController(final DinnerModel model, final SummaryView view) {
		this.model = model;
		this.view = view;
		
		
	}
	@Override
	public void onClick(View v) {
		// TODO Put listeners for the imageViews or the RelativeLayout containing dish image/names
		
	}
	
	private View findViewById(int id) {
		return view.view.findViewById(id);
	}

}
