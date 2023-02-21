package com.example.myapplication;

public class Film {
    private int avatar;
    private String name;
    private String director;
    private String duration;
    private String releaseDate;
    private int video;

    public Film(int avatar, String name, String director, String duration, String releaseDate) {
        this.avatar = avatar;
        this.name = name;
        this.director = director;
        this.duration = duration;
        this.releaseDate = releaseDate;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Film{" +
                "avatar=" + avatar +
                ", name='" + name + '\'' +
                ", director='" + director + '\'' +
                ", duration='" + duration + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
