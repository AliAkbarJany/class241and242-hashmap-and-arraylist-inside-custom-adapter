package com.rafsan.class241and242hashmapandarraylistinsidecustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    ListView myListView;

    ArrayList< HashMap< String, String > > arrayList = new ArrayList<>();

    HashMap< String, String > hashMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myListView = findViewById(R.id.myListView);

        hashMap = new HashMap<>();
        hashMap.put("Name","Rafsan");
        hashMap.put("Number","01764rrrrrrr");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Name","Morshad");
        hashMap.put("Number","01764MMMMMMM");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Name","Sazzad");
        hashMap.put("Number","01764SSSSSSS");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("Name","Belal");
        hashMap.put("Number","01764BBBBBB");
        arrayList.add(hashMap);

        MyAdapter myAdapter = new MyAdapter();
        myListView.setAdapter(myAdapter);


    }

    //======================== Custom Adapter========================

    private class MyAdapter extends BaseAdapter{

        LayoutInflater layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {


        View myView = layoutInflater.inflate(R.layout.list,parent,false);

            TextView textViewName =myView.findViewById(R.id.textViewName);
            TextView textViewNumber =myView.findViewById(R.id.textViewNumber);

            HashMap< String, String > hashMap = arrayList.get(position);

            ImageView imageView = myView.findViewById(R.id.imageView);
            textViewName.setText(hashMap.get("Name"));
            textViewNumber.setText(hashMap.get("Number"));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Toast.makeText(MainActivity.this , "Hello \n"+hashMap.get("Name"),Toast.LENGTH_LONG).show();

                }
            });

            return myView;
        }
    }


}