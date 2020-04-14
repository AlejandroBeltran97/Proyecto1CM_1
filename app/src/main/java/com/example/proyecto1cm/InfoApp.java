package com.example.proyecto1cm;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class InfoApp extends AppCompatActivity {

    ConstraintLayout myLayoutInfo;
    AnimationDrawable animationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_app);

        myLayoutInfo = (ConstraintLayout) findViewById(R.id.activity_info_app);

        animationDrawable = (AnimationDrawable) myLayoutInfo.getBackground();
        animationDrawable.setEnterFadeDuration(4500);
        animationDrawable.setExitFadeDuration(4500);
        animationDrawable.start();

        confBackMainButton();
    }

    private void confBackMainButton(){
        ImageButton backMainButton = (ImageButton) findViewById(R.id.back_main);
        backMainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
