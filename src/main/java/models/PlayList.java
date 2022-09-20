package models;

import java.util.List;

public class PlayList {
    private int id;
    private String theme;
    private String curator;

    private List<Music> musics;
    private Tag tag;

    public PlayList(int id, String theme, String curator, List<Music> musics, Tag tag) {
        this.id = id;
        this.theme = theme;
        this.curator = curator;
        this.musics = musics;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getTheme() {
        return theme;
    }

    public String getCurator() {
        return curator;
    }

    public List<Music> getMusics() {
        return musics;
    }

    public Tag getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return id + "," + theme + "," + curator + "," + musics.toString() + "," + tag.tagName();
    }

    public String[] values() {
        return new String[]{String.valueOf(id), theme, curator, musics.toString(), tag.tagName()};
    }
}
