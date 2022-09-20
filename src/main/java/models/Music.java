package models;

import java.util.Objects;

public class Music {
    private final String title;
    private final String artist;

    public Music(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    public String title() {
        return title;
    }

    public String artist() {
        return artist;
    }

    @Override
    public String toString() {
        return title + "-" + artist;
    }

    @Override
    public boolean equals(Object other) {
        Music otherMusic = (Music) other;

        return Objects.equals(this.title, otherMusic.title()) && Objects.equals(this.artist, otherMusic.artist());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
