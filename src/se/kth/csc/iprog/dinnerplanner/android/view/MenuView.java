package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

public class MenuView {

	View view;
	DinnerModel dm;

	public MenuView() {
		dm = new DinnerModel();

		// store in the class the reference to the Android View
		this.view = view.findViewById(R.id.menu_view);

		NumberPicker np = (NumberPicker) view.findViewById(R.id.numberPicker1);
		np.setMaxValue(9);
		np.setMinValue(0);
        np.setValue(dm.numberOfGuests);
        np.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
			
			@Override
			public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
				if(picker.getMaxValue() >= newVal && picker.getMinValue() <= newVal) {
					picker.setValue(newVal);
					dm.numberOfGuests = newVal;
				}
			}
		});
		
		
		// Setup the rest of the view layout
	}

}
