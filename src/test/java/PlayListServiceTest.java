import models.Music;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayListServiceTest {

    @Test
    void loadPlayList() throws FileNotFoundException {
        PlayListService playListService = new PlayListService();

        assertEquals("1,꼭 들어야 하는 9월의 신곡 케이팝,보니,질주(2 Baddies)-NCT 127/After " +
                        "Like-아이브/Attention-뉴진스/Pink Venom-블랙핑크/Talk Talk Talk-트와이스,신곡",
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

    // 테스트 통과는 확인하였으나 실제 txt 파일에도 저장이 되어버리기 때문에 주석처리
    @Test
    void checkNewPlayList() throws IOException {
//        PlayListService playListService = new PlayListService();
//
//        int lastPlaylist = playListService.loadPlayList().size();
//
//        int id = lastPlaylist + 1;
//        String theme = "꼭 들어야 하는 8월의 신곡 케이팝";
//        String curator = "보니";
//        List<Music> musics = new ArrayList<>();
//        musics.add(new Music("Hype Boy", "뉴진스"));
//        Tag tag = new Tag("신곡");
//
//        PlayList playList = new PlayList(id, theme, curator, musics, tag);
//
//        playListService.savePlayList(playList);
//
//        assertEquals("4,꼭 들어야 하는 8월의 신곡 케이팝,보니,Hype Boy-뉴진스,신곡",
//                playListService.loadPlayList().get(lastPlaylist).toString());
    }

    @Test
    void findBy() throws FileNotFoundException {
        PlayListService playListService = new PlayListService();

        assertEquals("1,꼭 들어야 하는 9월의 신곡 케이팝,보니,질주(2 Baddies)-NCT 127/After Like-아이브/Attention-뉴진스/Pink Venom-블랙핑크/Talk Talk Talk-트와이스,신곡", playListService.findBy(1).toString());
    }
}
