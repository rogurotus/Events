package com.example.events;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tx_lb1;
    Button button_lb1;

    TextView tx1_lb2;
    TextView tx2_lb2;

    TextView tx_lb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tx_lb1 = (TextView) findViewById(R.id.tx_lb1);
        button_lb1 = (Button) findViewById(R.id.button_lb1);
        button_lb1.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                tx_lb1.setText("Button clicked");
            }
        });
        button_lb1.setOnLongClickListener(new Button.OnLongClickListener() {
            public boolean onLongClick(View v) {
                tx_lb1.setText("Long button click");
                return false;
            }
        });

        tx1_lb2 = (TextView) findViewById(R.id.tx1_lb2);
        tx2_lb2 = (TextView) findViewById(R.id.tx2_lb2);

        tx_lb3 = (TextView) findViewById(R.id.tx_lb3);
        hide();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        hide();
        switch(id){
            case R.id.lb1 :
                tx_lb1.setVisibility(View.VISIBLE);
                button_lb1.setVisibility(View.VISIBLE);
                return true;
            case R.id.lb2:
                tx1_lb2.setVisibility(View.VISIBLE);
                tx2_lb2.setVisibility(View.VISIBLE);
                return true;
            case R.id.lb3:
                tx_lb3.setVisibility(View.VISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void hide()
    {
        tx_lb1.setVisibility(View.GONE);
        button_lb1.setVisibility(View.GONE);

        tx1_lb2.setVisibility(View.GONE);
        tx2_lb2.setVisibility(View.GONE);

        tx_lb3.setVisibility(View.GONE);
    }
}