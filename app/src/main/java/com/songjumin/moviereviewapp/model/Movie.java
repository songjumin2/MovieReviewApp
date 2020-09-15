package com.songjumin.moviereviewapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Movie {
    @SerializedName("popularity")
    @Expose
    private Double popularity;

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("video")
    @Expose
    private Boolean video;

    @SerializedName("vote_count")
    @Expose
    private Integer vote_count;

    @SerializedName("vote_average")
    @Expose
    private Double vote_average;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("release_date")
    @Expose
    private String release_date;

    @SerializedName("original_language")
    @Expose
    private String original_language;

    @SerializedName("original_title")
    @Expose
    private String original_title;

    @SerializedName("genre_ids")
    @Expose
    private Double genre_ids;

    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;

    @SerializedName("adult")
    @Expose
    private Boolean adult;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("poster_path")
    @Expose
    private String poster_path;

    public Movie(Double popularity, Integer id, Boolean video, Integer vote_count, Double vote_average, String title, String release_date, String original_language, String original_title, Double genre_ids, String backdrop_path, Boolean adult, String overview, String poster_path) {
        this.popularity = popularity;
        this.id = id;
        this.video = video;
        this.vote_count = vote_count;
        this.vote_average = vote_average;
        this.title = title;
        this.release_date = release_date;
        this.original_language = original_language;
        this.original_title = original_title;
        this.genre_ids = genre_ids;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.poster_path = poster_path;
    }

    public Movie(String poster_path){

    }

    public Movie(){

    }

    public Movie(Double vote_average, String title, String release_date,String overview, String poster_path){

    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getVideo() {
        return video;
    }

    public void setVideo(Boolean video) {
        this.video = video;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }

    public Double getVote_average() {
        return vote_average;
    }

    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public Double getGenre_ids() {
        return genre_ids;
    }

    public void setGenre_ids(Double genre_ids) {
        this.genre_ids = genre_ids;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public Boolean getAdult() {
        return adult;
    }

    public void setAdult(Boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
}
