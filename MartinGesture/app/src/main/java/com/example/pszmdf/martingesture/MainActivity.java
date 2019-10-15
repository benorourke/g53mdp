package com.example.pszmdf.martingesture;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.imageView2);
        iv.setScaleX(0.5f);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // get pointer index from the event object
        int pointerIndex = event.getActionIndex();

        // get pointer ID
        int pointerId = event.getPointerId(pointerIndex);

        // get masked (not specific to a pointer) action
        int maskedAction = event.getActionMasked();

        switch (maskedAction) {

            case MotionEvent.ACTION_DOWN:
                Log.d("g53mdp", "action ACTION_DOWN");
                break;
            case MotionEvent.ACTION_POINTER_DOWN: {
                Log.d("g53mdp", "action ACTION_POINTER_DOWN");
                break;
            }
            case MotionEvent.ACTION_MOVE: { // a pointer was moved
                Log.d("g53mdp", "action ACTION_MOVE");
                // TODO use data
                break;
            }
            case MotionEvent.ACTION_UP:
                Log.d("g53mdp", "action ACTION_UP");
                break;
            case MotionEvent.ACTION_POINTER_UP:

                Log.d("g53mdp", "action ACTION_POINTER_UP");
                break;
            case MotionEvent.ACTION_CANCEL: {
                // TODO use data
                break;
            }
        }
        //invalidate();

        return true;
        //return super.onTouchEvent(event);
    }
}
