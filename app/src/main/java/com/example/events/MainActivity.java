package com.example.events;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GestureDetectorCompat;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    ConstraintLayout constraintLayout;

    TextView tx_lb1;
    Button button_lb1;

    TextView tx1_lb2;
    TextView tx2_lb2;

    boolean lb2_switch = false;

    TextView tx_lb3;
    GestureDetectorCompat gDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        constraintLayout = (ConstraintLayout) findViewById(R.id.cl);

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
        constraintLayout.setOnTouchListener(new ConstraintLayout.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                handleTouch(m);
                return lb2_switch;
            }
        });

        tx_lb3 = (TextView) findViewById(R.id.tx_lb3);
        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);

        hide();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    void handleTouch(MotionEvent m)
    {
        int pointerCount = m.getPointerCount();

        for (int i = 0; i < pointerCount; i++)
        {
            int x = (int) m.getX(i);
            int y = (int) m.getY(i);
            int id = m.getPointerId(i);
            int action = m.getActionMasked();
            int actionIndex = m.getActionIndex();
            String actionString;


            switch (action)
            {
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PNTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PNTR UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }

            String touchStatus = "Action: " + actionString + " Index: " +
                    actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
            if (id == 0)
                tx1_lb2.setText(touchStatus);
            else
                tx2_lb2.setText(touchStatus);
        }
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
                lb2_switch = true;
                return true;
            case R.id.lb3:
                tx_lb3.setVisibility(View.VISIBLE);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        tx_lb3.setText ("onDown");
        return true;
    }

    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
        tx_lb3.setText("onFling");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent event) {
        tx_lb3.setText("onLongPress");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        tx_lb3.setText("onScroll");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent event) {
        tx_lb3.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        tx_lb3.setText("onSingleTapUp");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent event) {
        tx_lb3.setText("onDoubleTap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        tx_lb3.setText("onDoubleTapEvent");
        return true;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        tx_lb3.setText("onSingleTapConfirmed");
        return true;
    }

    private void hide()
    {
        tx_lb1.setVisibility(View.GONE);
        button_lb1.setVisibility(View.GONE);

        tx1_lb2.setVisibility(View.GONE);
        tx2_lb2.setVisibility(View.GONE);
        lb2_switch = false;

        tx_lb3.setVisibility(View.GONE);
    }
}