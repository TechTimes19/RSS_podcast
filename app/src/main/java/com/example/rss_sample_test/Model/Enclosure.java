package com.example.rss_sample_test.Model;

public class Enclosure
{
    public String link;
    public String type;
    public int duration;
    public Rating rating;

    public Enclosure(String link, String type, int duration, Rating rating) {
        this.link = link;
        this.type = type;
        this.duration = duration;
        this.rating = rating;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
