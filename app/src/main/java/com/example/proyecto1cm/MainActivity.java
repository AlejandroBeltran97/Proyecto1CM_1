package com.example.proyecto1cm;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout myLayout;
    AnimationDrawable animationDrawable;

    private TextInputEditText get_name;
    private TextInputEditText get_apellidos;
    private TextInputLayout name_input;
    private TextInputLayout last_name_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLayout = (ConstraintLayout) findViewById(R.id.myLayout);

        animationDrawable = (AnimationDrawable) myLayout.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        get_name = (TextInputEditText) findViewById(R.id.get_name);
        get_apellidos = (TextInputEditText) findViewById(R.id.get_apellidos);
        name_input = (TextInputLayout) findViewById(R.id.name_input);
        last_name_input = (TextInputLayout) findViewById(R.id.last_name_input);
    }
}

