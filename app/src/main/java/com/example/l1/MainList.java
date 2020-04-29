package com.example.l1;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainList extends AppCompatActivity {
    ListView countriesList;
    private List<Enumeration> numbers = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setInitialData();
        countriesList = findViewById(R.id.countriesList);
        NumberAdapter numberAdapter = new NumberAdapter(this, R.layout.list_item, numbers);
        countriesList.setAdapter(numberAdapter);
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Enumeration selectedNumber = (Enumeration) parent.getItemAtPosition(position);
            }
        };
        countriesList.setOnItemClickListener(itemListener);
    }

    private void setInitialData() {
        for (int i = 1; i <= 1000000; i++) {
            if (i % 2 == 0) {
                numbers.add(new Enumeration(Transleter.fromIntToString(i), R.drawable.emblem, 0xFFCCCCCC));
            } else {
                numbers.add(new Enumeration(Transleter.fromIntToString(i), R.drawable.emblem, 0xFFFFFFFF));
            }
        }
    }
}

