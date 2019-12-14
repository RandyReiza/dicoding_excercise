package com.example.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title, year, userScore, overview, director, cast;
    private int poster;

    protected Movie(Parcel in) {
        title = in.readString();
        year = in.readString();
        userScore = in.readString();
        overview = in.readString();
        director = in.readString();
        cast = in.readString();
        poster = in.readInt();
    }

    public Movie() {

    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(year);
        dest.writeString(userScore);
        dest.writeString(overview);
        dest.writeString(director);
        dest.writeString(cast);
        dest.writeInt(poster);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getUserScore() {
        return userScore;
    }

    public void setUserScore(String userScore) {
        this.userScore = userScore;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}
