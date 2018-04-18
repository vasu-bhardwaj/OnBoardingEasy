package com.fivemin.chief.onboardingeasy;

import android.os.Bundle;
import android.widget.Toast;

import com.fivemin.chief.easyonboarding.activity.EasyOnBoarding;
import com.fivemin.chief.easyonboarding.pages.IntroCards;

public class BasicIntro extends EasyOnBoarding {


    @Override
    public void setupSkipButton() {
        super.setupSkipButton();
        Toast.makeText(this,"Skip",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupFinishButton() {
        super.setupFinishButton();
        Toast.makeText(this,"Start",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        IntroCards card1 = new IntroCards("Intelligent",
                "First Wallpaper with Artificial Intelligence Capabilities");

        card1.setBackground(R.color.full_transparent);
        IntroCards card2 = new IntroCards("Hankpicked Images", "Every Image is carefully selected");

        card2.setBackground(R.color.full_transparent);

        IntroCards card3 = new IntroCards("Automatic Wallpaper",
                "Wallpaper are changed automatically");

        card3.setBackground(R.color.full_transparent);

        addPage(card1);
        addPage(card2);
        addPage(card3);
        setGradient(true, R.drawable.gradient_flow_list,2500,5000);

        setupIntro();

    }


}
