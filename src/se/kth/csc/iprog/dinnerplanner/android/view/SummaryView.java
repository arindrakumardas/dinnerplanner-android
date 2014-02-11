package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;

public class SummaryView {

	View view;
	DinnerModel model;

	public SummaryView(final View view, final DinnerModel model) {
		this.model = model;
		// store in the class the reference to the Android View
		this.view = view;

	}

}
