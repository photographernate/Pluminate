package ece590.ksubandapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    public Button TicketButton;
    public Button DemoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TicketButtonHandler();
        DemoButtonHandler();
    }

    public void TicketButtonHandler(){
        TicketButton= (Button) findViewById(R.id.TicketButton);
        TicketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ticketButtonPress = new Intent(Main.this,TicketInfo.class);
                startActivity(ticketButtonPress);
            }
        });

    }

    public void DemoButtonHandler() {
        DemoButton = (Button) findViewById(R.id.DemoButton);
        DemoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent demoButtonPress = new Intent(Main.this,Background.class);
                startActivity(demoButtonPress);
            }
        });
    }
}
