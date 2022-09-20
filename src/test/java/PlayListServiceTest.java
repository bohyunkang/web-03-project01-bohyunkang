import models.Music;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayListServiceTest {

    @Test
    void loadPlayList() throws FileNotFoundException {
        PlayListService playListService = new PlayListService();

        assertEquals("1,꼭 들어야 하는 9월의 신곡 케이팝,보니,[질주(2 Baddies)-NCT 127, After " +
                        "Like-아이브, Attention-뉴진스, Pink Venom-블랙핑크, Talk Talk Talk-트와이스],신곡",
                playListService.loadPlayList().get(0).toString());
    }


    @Test
    void getMusics() throws FileNotFoundException {
        PlayListService playListService = new PlayListService();

        assertEquals(List.of(new Music[]{new Music("질주(2 Baddies)", "NCT 127"),
                        new Music("After Like", "아이브"),
                        new Music("Attention", "뉴진스"),
                        new Music("Pink Venom", "블랙핑크"),
                        new Music("Talk Talk Talk", "트와이스"),
                }),
                playListService.loadPlayList().get(0).getMusics());
    }
}
