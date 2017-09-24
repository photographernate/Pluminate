package ece590.ksubandapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class Background extends AppCompatActivity{

    Button BackButton;
    Button StartButton;
    int time[] = {1000, 1000, 500, 500, 500, 250, 250, 250, 500, 500, 500};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_background);
        DemoButtonHandler();

        i = 0;

        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_background);
        final Random rand = new Random();
        final Handler handler = new Handler();

        Runnable r = new Runnable() {
            public void run() {
                int color = Color.argb(255, rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                layout.setBackgroundColor(color);
                handler.postDelayed(this, time[i]);
                incrementI();
            }
        };

        handler.postDelayed(r, 500);
    }

    public void DemoButtonHandler() {
        BackButton = (Button) findViewById(R.id.DemoButton);
        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backButtonPress = new Intent(Background.this,Main.class);
                startActivity(backButtonPress);
            }
        });
    }

    private void incrementI() {
        i++;
        if (i > 10)
            i = 0;
    }
}
