package com.example.administrator.multicollistview;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewGenerator extends Activity {

    protected ArrayList<HashMap<String, Integer>> AddItemToList(HashMap<String,
            Integer>currentRow,ArrayList<HashMap<String,Integer>> list,int[] images){
        for(int i=0;i<4;i++){
            currentRow=new HashMap<String,Integer>();
            currentRow.put("First", images[i]);
            currentRow.put("Second",images[i+4]);
            list.add(currentRow);
        }
        return list;

    }
}
