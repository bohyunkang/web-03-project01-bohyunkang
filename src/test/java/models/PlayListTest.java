package models;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayListTest {

    @Test
    void creation() {
        int id = 1;
        String theme = "꼭 들어야 하는 9월의 신곡";
        String curator = "보니";
        List<Music> musics = new ArrayList<>();
        Tag tag = new Tag("중독성");

        musics.add(new Music("After Like", "IVE"));

        PlayList playList = new PlayList(id, theme, curator, musics, tag);

        assertEquals(1, playList.getId());
        assertEquals("꼭 들어야 하는 9월의 신곡", playList.getTheme());
        assertEquals("보니", playList.getCurator());
        assertEquals("After Like", playList.getMusics().get(0).title());
        assertEquals("IVE", playList.getMusics().get(0).artist());
        assertEquals("중독성", playList.getTag().tagName());
    }

    @Test
    void string() {
        int id = 1;
        String theme = "꼭 들어야 하는 9월의 신곡";
        String curator = "보니";
        List<Music> musics = new ArrayList<>();
        Tag tag = new Tag("중독성");

        musics.add(new Music("After Like", "IVE"));

        PlayList playList = new PlayList(id, theme, curator, musics, tag);

        assertEquals("1,꼭 들어야 하는 9월의 신곡,보니,After Like-IVE,중독성", playList.toString());
    }
}
