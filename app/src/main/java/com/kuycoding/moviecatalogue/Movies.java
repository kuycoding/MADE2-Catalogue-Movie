package com.kuycoding.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class Movies implements Parcelable {
    private String title, overview, status, runtime, genre, release_information, language, revenue, cover, poster, user_score, imdb;
    private int rating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRelease_information() {
        return release_information;
    }

    public void setRelease_information(String release_information) {
        this.release_information = release_information;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.title);
        dest.writeString(this.overview);
        dest.writeString(this.status);
        dest.writeString(this.runtime);
        dest.writeString(this.genre);
        dest.writeString(this.release_information);
        dest.writeString(this.language);
        dest.writeString(this.revenue);
        dest.writeString(this.cover);
        dest.writeString(this.poster);
        dest.writeString(this.user_score);
        dest.writeString(this.imdb);
        dest.writeInt(this.rating);
    }

    public Movies() {
    }

    protected Movies(Parcel in) {
        this.title = in.readString();
        this.overview = in.readString();
        this.status = in.readString();
        this.runtime = in.readString();
        this.genre = in.readString();
        this.release_information = in.readString();
        this.language = in.readString();
        this.revenue = in.readString();
        this.cover = in.readString();
        this.poster = in.readString();
        this.user_score = in.readString();
        this.imdb = in.readString();
        this.rating = in.readInt();
    }

    public static final Creator<Movies> CREATOR = new Creator<Movies>() {
        @Override
        public Movies createFromParcel(Parcel source) {
            return new Movies(source);
        }

        @Override
        public Movies[] newArray(int size) {
            return new Movies[size];
        }
    };
}
