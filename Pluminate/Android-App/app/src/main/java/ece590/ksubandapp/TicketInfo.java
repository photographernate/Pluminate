package ece590.ksubandapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.Random;

public class TicketInfo extends AppCompatActivity {

    Button OkButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_info);
        OKButtonHandler();
    }

    public void OKButtonHandler(){
        OkButton = (Button)findViewById(R.id.OkButton);
        OkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OKButtonPress = new Intent(TicketInfo.this, Main.class);
                startActivity(OKButtonPress);
            }
        });
    }


}
