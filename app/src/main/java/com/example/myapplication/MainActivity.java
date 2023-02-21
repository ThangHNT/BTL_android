package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Film> filmList;
    FilmAdapter filmAdapter;
    ListView listView;
    Button categoryBtn;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Home");
//        actionBar.setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.filmList);
        filmList = new ArrayList<>();
        filmList.add(new Film(R.drawable.one_piece,"Ngay mai anh den","Thang Hoang","250p","10/02/2023"));
        filmList.add(new Film(R.drawable.one_piece,"Con ac mong kinh hoang","Thang Hoang","250p","10/02/2023"));
        filmList.add(new Film(R.drawable.one_piece,"Chu cho dang iu","Thang Hoang","250p","10/02/2023"));
        filmAdapter = new FilmAdapter(MainActivity.this,R.layout.film_item_layout,filmList);
        listView.setAdapter(filmAdapter);

        selectFilm();
        categoryBtn = findViewById(R.id.categoryBtn);
        categoryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCategoryMenu();
            }
        });

    }

    private void showCategoryMenu(){
        PopupMenu popupMenu = new PopupMenu(this,categoryBtn);
        popupMenu.getMenuInflater().inflate(R.menu.category_popup_menu, popupMenu.getMenu());
        popupMenu.show();
    }

    // khi chon film bat ki trong ds
    private void selectFilm() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openFilmDetail(position);
            }
        });
    }

//    set up menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu,menu);

        MenuItem  menuItem = menu.findItem(R.id.searchBtn);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filmAdapter.setList(newText, filmList);
                filmAdapter.notifyDataSetChanged();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    // khi chon item trong menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.profile:
                Toast.makeText(this,"Ban chon profile",Toast.LENGTH_LONG).show();

                break;
            case R.id.favoriteFilm:
                Toast.makeText(this,"Ban chon favorite",Toast.LENGTH_LONG).show();

                break;
            case R.id.logOutBtn:
                Toast.makeText(this,"Ban chon log out",Toast.LENGTH_LONG).show();

                break;
            case R.id.searchBtn:
//                Toast.makeText(this,"Ban chon search",Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void openFilmDetail(int position){
        Intent intent = new Intent(MainActivity.this, FilmDetail.class);
        Film film = filmList.get(position);
        intent.putExtra("name",film.getName());
        startActivity(intent);
    }


}