package com.example.anon.tracnghiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemQuest> itemQuestArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // custom array list
        itemQuestArrayList = new ArrayList<>();
        setDataQuest();

        // custom adapter
        TracNghiemAdapter tracNghiemAdapter = new TracNghiemAdapter(this, R.layout.item_listview,
                itemQuestArrayList);

        // set adapter
        ListView tracNghiemListView = findViewById(R.id.tracNghiemListView);
        tracNghiemListView.setAdapter(tracNghiemAdapter);
    }

    private void setDataQuest() {
        String[] ans = new String[]{"Itachi", "Sasuke", "Naruto", "Kakashi"};

        String[] list_que = {
                "Who is a Good Boy ?",
                "Who is a Bad Boy ?",
                "Who is the Boss ?",
                "Who is the Teacher ?"
        };
        int[] list_img = {
                R.drawable.naruto,
                R.drawable.sasuke,
                R.drawable.itachi,
                R.drawable.kakashi
        };

        for (int i = 0; i < 4; ++i) {
            ItemQuest itemQuest = new ItemQuest(list_que[i], ans, list_img[i]);
            itemQuestArrayList.add(itemQuest);
        }
    }
}