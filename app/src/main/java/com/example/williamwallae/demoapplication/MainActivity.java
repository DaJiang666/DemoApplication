package com.example.williamwallae.demoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Person> list = new ArrayList<>();
        list.add(new Person(1, "a"));
        list.add(new Person(2, "b"));
        list.add(new Person(3,"c"));
        list.add(new Person(4,"d"));
        list.add(new Person(5,"e"));
        list.add(new Person(6,"f"));
        mRecyclerView = (RecyclerView) findViewById(R.id.recycleview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(new MyRecycleViewAdapter(this, list));
    }



}
