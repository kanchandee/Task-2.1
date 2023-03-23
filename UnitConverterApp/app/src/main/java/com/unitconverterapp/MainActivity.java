package com.unitconverterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //Definig global variables

    //Variable to display the final result
    TextView textView;

    //Button component
    Button convertBtn;

    //Text box for taking input from user
    EditText editText1;

    //Spinners for displaying dropdown value for main category and their sub-category
    Spinner mainCategory, subCategoryFrom, subCategoryTo;

    //Different adaptor to populate sub-categories
    ArrayAdapter<CharSequence> mainAdaptor, lengthAdaptor, weightAdaptor, temperatureAdaptor;

    //Variable to get the selected values from the spinners
    String selectedMainCategory, selectedFromSubCategory, selectedToSubCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting view components to variables
        mainCategory = findViewById(R.id.mainCategory);
        subCategoryFrom = findViewById(R.id.subCategoryFrom);
        subCategoryTo = findViewById(R.id.subCategoryTo);
        editText1 = findViewById(R.id.textBox1);
        textView = findViewById(R.id.textView1);
        convertBtn = findViewById(R.id.convertButton);

        //Setting main category adaptor
        mainAdaptor = ArrayAdapter.createFromResource(this, R.array.mainCategories, R.layout.spinner_item);
        mainCategory.setAdapter(mainAdaptor);

        //Setting length sub-category adaptor
        lengthAdaptor = ArrayAdapter.createFromResource(this, R.array.lengthSubCategories, R.layout.spinner_sub_item);
        //Setting weight sub-category adaptor
        weightAdaptor = ArrayAdapter.createFromResource(this, R.array.weightSubCategories, R.layout.spinner_sub_item);
        //Setting temperature sub-category adaptor
        temperatureAdaptor = ArrayAdapter.createFromResource(this, R.array.temperatureSubCategories, R.layout.spinner_sub_item);

        //Initializing sub-categories for length
        subCategoryFrom.setAdapter(lengthAdaptor);
        subCategoryTo.setAdapter(lengthAdaptor);

        //Setting focus to edit text box
        editText1.requestFocus();

        //Added listeners to spinners
        mainCategory.setOnItemSelectedListener(this);
        subCategoryFrom.setOnItemSelectedListener(this);
        subCategoryTo.setOnItemSelectedListener(this);

        //Click listener when user will chick on convert button
        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onConvertButtonClick();
            }
        });
    }

    //Function to compute the entered value according to the units selected.
    String calculateValue(double value) {
        double result = 0;
        Toast.makeText(editText1.getContext(), "Converting entered value from: " + selectedFromSubCategory + " to: " + selectedToSubCategory, Toast.LENGTH_SHORT).show();
        if (selectedFromSubCategory.equalsIgnoreCase(selectedToSubCategory)) {
            result = value;
        } else if (selectedFromSubCategory.equalsIgnoreCase("inch") && selectedToSubCategory.equalsIgnoreCase("cm")) {
            result = value * 2.54;
        } else if (selectedFromSubCategory.equalsIgnoreCase("inch") && selectedToSubCategory.equalsIgnoreCase("foot")) {
            result = value / 12;
        } else if (selectedFromSubCategory.equalsIgnoreCase("inch") && selectedToSubCategory.equalsIgnoreCase("yard")) {
            result = value / 36;
        } else if (selectedFromSubCategory.equalsIgnoreCase("inch") && selectedToSubCategory.equalsIgnoreCase("mile")) {
            result = value / 63360;
        } else if (selectedFromSubCategory.equalsIgnoreCase("inch") && selectedToSubCategory.equalsIgnoreCase("km")) {
            result = value / 39370;
        } else if (selectedFromSubCategory.equalsIgnoreCase("foot") && selectedToSubCategory.equalsIgnoreCase("cm")) {
            result = value * 30.48;
        } else if (selectedFromSubCategory.equalsIgnoreCase("foot") && selectedToSubCategory.equalsIgnoreCase("inch")) {
            result = value * 12;
        } else if (selectedFromSubCategory.equalsIgnoreCase("foot") && selectedToSubCategory.equalsIgnoreCase("yard")) {
            result = value / 3;
        } else if (selectedFromSubCategory.equalsIgnoreCase("foot") && selectedToSubCategory.equalsIgnoreCase("mile")) {
            result = value / 5280;
        } else if (selectedFromSubCategory.equalsIgnoreCase("foot") && selectedToSubCategory.equalsIgnoreCase("km")) {
            result = value / 3281;
        } else if (selectedFromSubCategory.equalsIgnoreCase("yard") && selectedToSubCategory.equalsIgnoreCase("cm")) {
            result = value * 91.44;
        } else if (selectedFromSubCategory.equalsIgnoreCase("yard") && selectedToSubCategory.equalsIgnoreCase("inch")) {
            result = value * 36;
        } else if (selectedFromSubCategory.equalsIgnoreCase("yard") && selectedToSubCategory.equalsIgnoreCase("foot")) {
            result = value * 3;
        } else if (selectedFromSubCategory.equalsIgnoreCase("yard") && selectedToSubCategory.equalsIgnoreCase("mile")) {
            result = value / 1760;
        } else if (selectedFromSubCategory.equalsIgnoreCase("yard") && selectedToSubCategory.equalsIgnoreCase("km")) {
            result = value / 1094;
        } else if (selectedFromSubCategory.equalsIgnoreCase("mile") && selectedToSubCategory.equalsIgnoreCase("cm")) {
            result = value * 160900;
        } else if (selectedFromSubCategory.equalsIgnoreCase("mile") && selectedToSubCategory.equalsIgnoreCase("inch")) {
            result = value * 63360;
        } else if (selectedFromSubCategory.equalsIgnoreCase("mile") && selectedToSubCategory.equalsIgnoreCase("yard")) {
            result = value * 1760;
        } else if (selectedFromSubCategory.equalsIgnoreCase("mile") && selectedToSubCategory.equalsIgnoreCase("foot")) {
            result = value * 5280;
        } else if (selectedFromSubCategory.equalsIgnoreCase("mile") && selectedToSubCategory.equalsIgnoreCase("km")) {
            result = value * 1.609;
        } else if (selectedFromSubCategory.equalsIgnoreCase("cm") && selectedToSubCategory.equalsIgnoreCase("foot")) {
            result = value / 30.48;
        } else if (selectedFromSubCategory.equalsIgnoreCase("cm") && selectedToSubCategory.equalsIgnoreCase("inch")) {
            result = value / 2.54;
        } else if (selectedFromSubCategory.equalsIgnoreCase("cm") && selectedToSubCategory.equalsIgnoreCase("yard")) {
            result = value / 91.44;
        } else if (selectedFromSubCategory.equalsIgnoreCase("cm") && selectedToSubCategory.equalsIgnoreCase("mile")) {
            result = value / 160900;
        } else if (selectedFromSubCategory.equalsIgnoreCase("cm") && selectedToSubCategory.equalsIgnoreCase("km")) {
            result = value / 100000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("km") && selectedToSubCategory.equalsIgnoreCase("cm")) {
            result = value * 100000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("km") && selectedToSubCategory.equalsIgnoreCase("inch")) {
            result = value * 39370;
        } else if (selectedFromSubCategory.equalsIgnoreCase("km") && selectedToSubCategory.equalsIgnoreCase("yard")) {
            result = value * 1094;
        } else if (selectedFromSubCategory.equalsIgnoreCase("km") && selectedToSubCategory.equalsIgnoreCase("mile")) {
            result = value / 1.609;
        } else if (selectedFromSubCategory.equalsIgnoreCase("km") && selectedToSubCategory.equalsIgnoreCase("foot")) {
            result = value * 3281;
        } else if (selectedFromSubCategory.equalsIgnoreCase("kg") && selectedToSubCategory.equalsIgnoreCase("pound")) {
            result = value * 2.205;
        } else if (selectedFromSubCategory.equalsIgnoreCase("kg") && selectedToSubCategory.equalsIgnoreCase("ounce")) {
            result = value * 35.274;
        } else if (selectedFromSubCategory.equalsIgnoreCase("kg") && selectedToSubCategory.equalsIgnoreCase("ton")) {
            result = value / 1000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("kg") && selectedToSubCategory.equalsIgnoreCase("g")) {
            result = value * 1000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("pound") && selectedToSubCategory.equalsIgnoreCase("kg")) {
            result = value / 2.205;
        } else if (selectedFromSubCategory.equalsIgnoreCase("pound") && selectedToSubCategory.equalsIgnoreCase("ounce")) {
            result = value * 16;
        } else if (selectedFromSubCategory.equalsIgnoreCase("pound") && selectedToSubCategory.equalsIgnoreCase("ton")) {
            result = value / 2205;
        } else if (selectedFromSubCategory.equalsIgnoreCase("pound") && selectedToSubCategory.equalsIgnoreCase("g")) {
            result = value * 453.6;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ounce") && selectedToSubCategory.equalsIgnoreCase("kg")) {
            result = value / 35.274;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ounce") && selectedToSubCategory.equalsIgnoreCase("pound")) {
            result = value / 16;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ounce") && selectedToSubCategory.equalsIgnoreCase("ton")) {
            result = value / 35270;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ounce") && selectedToSubCategory.equalsIgnoreCase("g")) {
            result = value * 28.35;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ton") && selectedToSubCategory.equalsIgnoreCase("kg")) {
            result = value * 1000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ton") && selectedToSubCategory.equalsIgnoreCase("pound")) {
            result = value * 2205;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ton") && selectedToSubCategory.equalsIgnoreCase("ounce")) {
            result = value * 35270;
        } else if (selectedFromSubCategory.equalsIgnoreCase("ton") && selectedToSubCategory.equalsIgnoreCase("g")) {
            result = value * 1000000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("g") && selectedToSubCategory.equalsIgnoreCase("kg")) {
            result = value / 1000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("g") && selectedToSubCategory.equalsIgnoreCase("pound")) {
            result = value / 453.6;
        } else if (selectedFromSubCategory.equalsIgnoreCase("g") && selectedToSubCategory.equalsIgnoreCase("ounce")) {
            result = value * 28.35;
        } else if (selectedFromSubCategory.equalsIgnoreCase("g") && selectedToSubCategory.equalsIgnoreCase("ton")) {
            result = value / 1000000;
        } else if (selectedFromSubCategory.equalsIgnoreCase("Celsius") && selectedToSubCategory.equalsIgnoreCase("Fahrenheit")) {
            result = (value * 1.8) + 32;
        } else if (selectedFromSubCategory.equalsIgnoreCase("Celsius") && selectedToSubCategory.equalsIgnoreCase("Kelvin")) {
            result = value + 273.15;
        } else if (selectedFromSubCategory.equalsIgnoreCase("Fahrenheit") && selectedToSubCategory.equalsIgnoreCase("Celsius")) {
            result = (value - 32) / 1.8;
        } else if (selectedFromSubCategory.equalsIgnoreCase("Fahrenheit") && selectedToSubCategory.equalsIgnoreCase("Kelvin")) {
            result = ((value - 32) * 5 / 9) + 273.15;
        } else if (selectedFromSubCategory.equalsIgnoreCase("Kelvin") && selectedToSubCategory.equalsIgnoreCase("Celsius")) {
            result = value - 273.15;
        } else if (selectedFromSubCategory.equalsIgnoreCase("Kelvin") && selectedToSubCategory.equalsIgnoreCase("Fahrenheit")) {
            result = ((value - 273.15) * 9 / 5) + 32;
        }
        return (result != 0) ? String.format("%.2f", result) : "";
    }

    void onConvertButtonClick() {
        //Getting value from edit text box
        String value = editText1.getText().toString();
        String result = "";
        //If condition to validate the entered value is numeric or not by passing the entered value
        if (isEnteredValueNumeric(value)) {
            //Calling calculateValue() function to do the calculation and return result.
            result = calculateValue(Double.parseDouble(value));
        } else {
            //If entered value is not numeric the this message will be popped
            Toast.makeText(editText1.getContext(), "Please enter valid number.", Toast.LENGTH_SHORT).show();
            editText1.requestFocus();
        }
        //Setting the final result on the text view
        textView.setText(result);
    }

    //Function to validate the entered value is numeric or not
    public static boolean isEnteredValueNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    //Handling the spinners selection
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if (adapterView.getId() == R.id.mainCategory) {
            String category = adapterView.getItemAtPosition(i).toString();
            Toast.makeText(adapterView.getContext(), "Selected category: " + category, Toast.LENGTH_SHORT).show();
            editText1.setText("");
            textView.setText("");
            if (category.equalsIgnoreCase("Length")) {
                selectedMainCategory = "Length";
                subCategoryFrom.setAdapter(lengthAdaptor);
                subCategoryTo.setAdapter(lengthAdaptor);
            } else if (category.equalsIgnoreCase("Weight")) {
                selectedMainCategory = "Weight";
                subCategoryFrom.setAdapter(weightAdaptor);
                subCategoryTo.setAdapter(weightAdaptor);
            } else {
                selectedMainCategory = "Temperature";
                subCategoryFrom.setAdapter(temperatureAdaptor);
                subCategoryTo.setAdapter(temperatureAdaptor);
            }
        } else if (adapterView.getId() == R.id.subCategoryFrom) {
            selectedFromSubCategory = adapterView.getItemAtPosition(i).toString();
        } else if (adapterView.getId() == R.id.subCategoryTo) {
            selectedToSubCategory = adapterView.getItemAtPosition(i).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}