package com.example.administrator.multicollistview;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;

public class SecondActivity extends ListViewGenerator implements ILeftToRight,IRightToLeft {

    private GestureDetector gestureDetector;
    private ArrayList<HashMap<String, Integer>> list;

    private int[] images={R.drawable.ic_one,R.drawable.ic_two,R.drawable.ic_three
            ,R.drawable.ic_four,R.drawable.ic_five,R.drawable.ic_six,R.drawable.ic_seven,R.drawable.ic_eight};


    private HashMap<String,Integer>currentRow=new HashMap<String,Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ListView listView=(ListView)findViewById(R.id.listView1);
        list=new ArrayList<HashMap<String,Integer>>();
        list=super.AddItemToList(currentRow,list,images);
        ListViewAdapters adapter=new ListViewAdapters(this, list);
        listView.setAdapter(adapter);

        gestureDetector = new GestureDetector(this, new OnSwipeGestureListener());
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_USER);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
    private class OnSwipeGestureListener extends GestureDetector.SimpleOnGestureListener {

        private static final int SWIPE_MIN_DISTANCE = 120;
        private static final int SWIPE_THRESHOLD_VELOCITY = 200;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float deltaX = e2.getX() - e1.getX();
            if ((Math.abs(deltaX) < SWIPE_MIN_DISTANCE) || (Math.abs(velocityX) < SWIPE_THRESHOLD_VELOCITY)) {
                return false;
            }
            else {
                if (deltaX > 0) {
                    handleSwipeLeftToRight();
                }
                if (deltaX < 0) {
                    handleSwipeRightToLeft();
                }
            }
            return true;
        }
    }

    @Override
    public void handleSwipeLeftToRight() {
        Intent i=new Intent(this,MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.xml.pull_in_right, R.xml.push_out_left);
    }

    @Override
    public void handleSwipeRightToLeft() {
        Intent i=new Intent(this,ThirdActivity.class);
        startActivity(i);
        overridePendingTransition(R.xml.pull_in_left, R.xml.push_out_right);
    }



}