package se.kth.csc.iprog.dinnerplanner.android.view;

import se.kth.csc.iprog.dinnerplanner.android.R;
import se.kth.csc.iprog.dinnerplanner.model.DinnerModel;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;

public class ExampleView {

	View view;

	public ExampleView(View view) {

		// store in the class the reference to the Android View
		this.view = view;

		NumberPicker example = (NumberPicker) view.findViewById(R.id.numberPicker1);
		//example.setText("Hello world");
		example.setMaxValue(9);
		example.setMinValue(0);
        example.setValue(3);
        example.setOnValueChangedListener((OnValueChangeListener) this);
		
		
		// Setup the rest of the view layout
	}

}
