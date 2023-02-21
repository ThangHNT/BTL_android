package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FilmAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Film> list;

    public FilmAdapter(Context context, int layout, List<Film> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);
        ImageView avatar = view.findViewById(R.id.filmAvatar);
        TextView name = view.findViewById(R.id.filmName);
        TextView director = view.findViewById(R.id.filmDirector);
        TextView duration = view.findViewById(R.id.filmDuration);
        TextView releaseDate = view.findViewById(R.id.filmReleaseDate);
        Film film = list.get(position);
        avatar.setImageResource(film.getAvatar());
        name.setText(film.getName());
        director.setText(film.getDirector());
        duration.setText(film.getDuration());
        releaseDate.setText(film.getReleaseDate());
        return view;
    }

    public void setList(String nameOfFilm, List<Film> ds){
        if(nameOfFilm.length() == 0){
            this.list = ds;
            return;
        }
        List<Film> films = new ArrayList<>();
        for(int i = 0; i < this.list.size(); i++){
            String title = list.get(i).getName().toLowerCase(Locale.ROOT);
            if(title.contains(nameOfFilm.toLowerCase(Locale.ROOT))){
                films.add(list.get(i));
//                System.out.println("===========================" + list.get(i).getName());
            }
        }
        this.list = films;
    }
}
