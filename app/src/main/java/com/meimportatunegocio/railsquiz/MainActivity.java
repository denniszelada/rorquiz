package com.meimportatunegocio.railsquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int correct = 0;
    int incorrect = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void question_three_rails(View view){
        correct += 1;
    }

    public void question_three_ruby(View view){
        incorrect +=1;
    }

    public void question_four_rails(View view){
        correct +=1;
    }

    public void answersSubmit(View view){
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        CheckBox rubyBox = (CheckBox) findViewById(R.id.ruby_checkbox);
        CheckBox railsBox = (CheckBox) findViewById(R.id.rails_checkbox);
        boolean rubySelect = rubyBox.isChecked();
        boolean railsSelect = railsBox.isChecked();
        RadioButton rubyTwo = (RadioButton) findViewById(R.id.rubyTwo);
        RadioButton railsTwo = (RadioButton) findViewById(R.id.railsTwo);
        boolean rubyTwoSelect = rubyTwo.isChecked();
        boolean railsTwoSelect = railsTwo.isChecked();
        RadioButton rubyThree = (RadioButton) findViewById(R.id.rubyThree);
        RadioButton railsThree = (RadioButton) findViewById(R.id.railsThree);
        boolean rubyThreeSelect = rubyThree.isChecked();
        boolean railsThreeSelect = railsThree.isChecked();
        RadioButton rubyFour = (RadioButton) findViewById(R.id.rubyFour);
        RadioButton railsFour = (RadioButton) findViewById(R.id.railsFour);
        boolean rubyFourSelect = rubyFour.isChecked();
        boolean railsFourSelect = railsFour.isChecked();
        String results = verifyResults(name, rubySelect, railsSelect, rubyTwoSelect, railsTwoSelect, rubyThreeSelect, railsThreeSelect, rubyFourSelect, railsFourSelect);
        displayMessage(results);
    }

    private String verifyResults(String name, boolean rubySelect, boolean railsSelect, boolean rubyTwoSelect, boolean railsTwoSelect, boolean rubyThreeSelect, boolean railsThreeSelect, boolean rubyFourSelect, boolean railsFourSelect) {
        if (rubySelect & railsSelect)   {
            incorrect += 1;
        } else if (railsSelect) {
            correct +=1;
        } else if (rubySelect) {
            incorrect +=1;
        }
        if (rubyTwoSelect)  {
            correct += 1;
        }
        if (railsTwoSelect) {
            incorrect += 1;
        }
        if (rubyThreeSelect)  {
            incorrect += 1;
        }
        if (railsThreeSelect) {
            correct += 1;
        }
        if (rubyFourSelect)  {
            incorrect += 1;
        }
        if (railsFourSelect) {
            correct += 1;
        }
        String results = "Hello " + name;
        results += "\nYou got " + correct +  " answers correct";
        results += "\nYou got " + incorrect +  " answers incorrect";
        return results;
    }


    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.summary_text_view);
        orderSummaryTextView.setText(message);
    }
}
