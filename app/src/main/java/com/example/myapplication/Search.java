package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class Search extends AppCompatActivity {
//    List<Film> filmList;
    ArrayAdapter<String> resultsAdapter;
    ListView searchListView ;
    SearchView searchView;
    String[] a = {"thang","long","nam","toan","hai"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Search");
        List filmList = (ArrayList) getIntent().getParcelableArrayListExtra("filmList");
        searchListView = findViewById(R.id.searchResults);
        resultsAdapter = new ArrayAdapter<String>(Search.this,android.R.layout.simple_list_item_1,filmList);
        searchListView.setAdapter(resultsAdapter);
        searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                resultsAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}