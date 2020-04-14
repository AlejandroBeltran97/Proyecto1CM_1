package com.example.proyecto1cm;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    private TextInputEditText get_name;
    private TextInputEditText get_apellidos;
    private TextInputLayout name_input;
    private TextInputLayout last_name_input;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] data_date = new String[1];

        confInfoButton();

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        get_name = (TextInputEditText) findViewById(R.id.get_name);
        get_apellidos = (TextInputEditText) findViewById(R.id.get_apellidos);
        name_input = (TextInputLayout) findViewById(R.id.name_input);
        last_name_input = (TextInputLayout) findViewById(R.id.last_name_input);
        btn = (Button) findViewById(R.id.button);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        //get_name.addTextChangedListener(loginTextWatcher);
        //get_apellidos.addTextChangedListener(loginTextWatcher);

        mDisplayDate = (TextView) findViewById(R.id.birth);
        //mDisplayDate.addTextChangedListener(loginTextWatcher);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        R.style.dateTheme,
                        mDateSetListener,
                        year, month, day);

                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: date: " + year + "/" + month + "/" + day);
                String date = day + "/" + month + "/" + year;
                data_date[0] = date;
                mDisplayDate.setText(date);
            }
        };

        get_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    get_name.setError(null);
                }
            }
        });

        get_apellidos.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    get_apellidos.setError(null);
                }
            }
        });

        setButtonCal();
    }

    private boolean validateEmpty(String a, String b, String c){
        if(!a.isEmpty() && !b.isEmpty() && !c.isEmpty()){
            return true;
        }
        else{
            return false;
        }
    }

    private void confInfoButton(){
        ImageButton infoButton = (ImageButton) findViewById(R.id.info_button);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InfoApp.class));
            }
        });
    }

    private boolean validateText(String s){
        if(s.matches(".*\\d.*")){
            return false;
        }
        else{
            name_input.setError(null);
            return true;
        }
    }

    private boolean validateLastName(String s){
        if(s.matches(".*\\d.*")){
            return false;
        }
        else{
            last_name_input.setError(null);
            return true;
        }
    }

    private boolean validateNumberLastName(String s){
        String[] arr_lst = s.split(" ", 5);
        if(arr_lst.length < 2){
            return false;
        }
        else{
            last_name_input.setError(null);
            return true;
        }
    }

    private void setButtonCal(){
        //btn.setEnabled(validateText(nameInput) &&
        //        validateLastName(lstnameInput) &&
        //        validateNumberLastName(lstnameInput) &&
        //        !date_info.equals(getString(R.string.birth_edit)));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameInput = get_name.getText().toString().trim();
                String lstnameInput = get_apellidos.getText().toString().trim();
                Log.d(TAG, mDisplayDate.getText().toString());
                String date_info = mDisplayDate.getText().toString().trim();
                Log.d(TAG, date_info);
                if(validateEmpty(nameInput, lstnameInput, date_info)){
                    if(validateText(nameInput) &&
                            validateLastName(lstnameInput) &&
                            validateNumberLastName(lstnameInput) &&
                            !date_info.equals(getString(R.string.birth_edit))){
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("UserName", nameInput);
                        intent.putExtra("LastName", lstnameInput);
                        intent.putExtra("Date", date_info);
                        startActivity(intent);
                    }
                    else{
                        if(!validateText(nameInput)){
                            get_name.setError(getString(R.string.error_numbers_name));
                        }
                        if(!validateLastName(lstnameInput)){
                            get_apellidos.setError(getString(R.string.error_numbers_lstname));
                        }
                        if(!validateNumberLastName(lstnameInput)){
                            get_apellidos.setError(getString(R.string.error_1lstname));
                        }
                        if(date_info.equals(getString(R.string.birth_edit)) &&
                                validateText(nameInput) &&
                                validateLastName(lstnameInput) &&
                                validateNumberLastName(lstnameInput)){
                            Toast.makeText(getApplicationContext(), getString(R.string.error_emptyDate), Toast.LENGTH_LONG).show();
                        }
                    }
                }
                else{
                    if(nameInput.isEmpty()){
                        get_name.setError(getString(R.string.error_empty_name));
                    }
                    if(lstnameInput.isEmpty()){
                        get_apellidos.setError(getString(R.string.error_empty_lstname));
                    }
                }
                Log.d(TAG, "Data sent");
            }
        });
    }
}

