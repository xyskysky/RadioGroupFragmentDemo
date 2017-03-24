package com.example.jwn.radiogroupfragment.domain;

import java.util.List;


public class DataBean {


    private List<ItemData> trailers;

    public void setTrailers(List<ItemData> trailers) {
        this.trailers = trailers;
    }

    public List<ItemData> getTrailers() {
        return trailers;
    }

    public static class ItemData {
        private int id;
        private String movieName;
        private String coverImg;
        private int movieId;
        private String url;
        private String hightUrl;
        private String videoTitle;
        private int videoLength;
        private int rating;
        private String summary;
        private List<String> type;

        public void setId(int id) {
            this.id = id;
        }

        public void setMovieName(String movieName) {
            this.movieName = movieName;
        }

        public void setCoverImg(String coverImg) {
            this.coverImg = coverImg;
        }

        public void setMovieId(int movieId) {
            this.movieId = movieId;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setHightUrl(String hightUrl) {
            this.hightUrl = hightUrl;
        }

        public void setVideoTitle(String videoTitle) {
            this.videoTitle = videoTitle;
        }

        public void setVideoLength(int videoLength) {
            this.videoLength = videoLength;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public void setType(List<String> type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public String getMovieName() {
            return movieName;
        }

        public String getCoverImg() {
            return coverImg;
        }

        public int getMovieId() {
            return movieId;
        }

        public String getUrl() {
            return url;
        }

        public String getHightUrl() {
            return hightUrl;
        }

        public String getVideoTitle() {
            return videoTitle;
        }

        public int getVideoLength() {
            return videoLength;
        }

        public int getRating() {
            return rating;
        }

        public String getSummary() {
            return summary;
        }

        public List<String> getType() {
            return type;
        }
    }
}
