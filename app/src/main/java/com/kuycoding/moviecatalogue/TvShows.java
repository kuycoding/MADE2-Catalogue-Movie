package com.kuycoding.moviecatalogue;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShows implements Parcelable {
    private String title, overview, status, type, language, runtime, genre, imdb, cover, poster, user_score;
    private float rating;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
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

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getUser_score() {
        return user_score;
    }

    public void setUser_score(String user_score) {
        this.user_score = user_score;
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
        dest.writeString(this.type);
        dest.writeString(this.language);
        dest.writeString(this.runtime);
        dest.writeString(this.genre);
        dest.writeString(this.imdb);
        dest.writeString(this.cover);
        dest.writeString(this.poster);
        dest.writeString(this.user_score);
        dest.writeFloat(this.rating);
    }

    public TvShows() {
    }

    protected TvShows(Parcel in) {
        this.title = in.readString();
        this.overview = in.readString();
        this.status = in.readString();
        this.type = in.readString();
        this.language = in.readString();
        this.runtime = in.readString();
        this.genre = in.readString();
        this.imdb = in.readString();
        this.cover = in.readString();
        this.poster = in.readString();
        this.user_score = in.readString();
        this.rating = in.readFloat();
    }

    public static final Creator<TvShows> CREATOR = new Creator<TvShows>() {
        @Override
        public TvShows createFromParcel(Parcel source) {
            return new TvShows(source);
        }

        @Override
        public TvShows[] newArray(int size) {
            return new TvShows[size];
        }
    };
}
