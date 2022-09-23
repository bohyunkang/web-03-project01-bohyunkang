package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MusicTest {

    @Test
    void creation() {
        Music music = new Music("질주 (2 Baddies)", "NCT 127");

        assertEquals("질주 (2 Baddies)", music.title());
        assertEquals("NCT 127", music.artist());
    }

    @Test
    void music() {
        Music music = new Music("질주 (2 Baddies)", "NCT 127");

        assertEquals("질주 (2 Baddies)-NCT 127", music.toString());
    }
}
