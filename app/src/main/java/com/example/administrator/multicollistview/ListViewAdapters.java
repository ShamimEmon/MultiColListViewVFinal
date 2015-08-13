package com.example.administrator.multicollistview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapters extends BaseAdapter{

    private ArrayList<HashMap<String, Integer>> list;
    private Activity activity;
    private ImageView colx_two;
    private ImageView colx_one;

    public ListViewAdapters(Activity activity,ArrayList<HashMap<String, Integer>> list){
        super();
        this.activity=activity;
        this.list=list;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater=activity.getLayoutInflater();

        if(convertView == null){

            convertView=inflater.inflate(R.layout.colmn_row, null);

            colx_one =(ImageView) convertView.findViewById(R.id.col_1);
            colx_two =(ImageView) convertView.findViewById(R.id.col_2);


        }

        HashMap<String, Integer> map=list.get(position);

        this.colx_one.setImageResource(map.get("First"));
        this.colx_two.setImageResource(map.get("Second"));

        return convertView;
    }

}
