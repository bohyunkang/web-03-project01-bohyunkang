import models.Music;
import models.PlayList;
import models.Tag;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayListService {
    public List<PlayList> loadPlayList() throws FileNotFoundException {
        List<PlayList> playLists = new ArrayList<>();

        File file = new File("playlists.txt");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();

            PlayList playList = parsePlayList(text);
            playLists.add(playList);
        }

        return playLists;
    }

    public PlayList parsePlayList(String text) {
        String[] elements = text.split(",");

        int id = Integer.parseInt(elements[0]);

        List<Music> musics = parseMusics(elements[3]);

        Tag tag = new Tag(elements[4]);

        return new PlayList(id, elements[1], elements[2], musics, tag);
    }

    public List<Music> parseMusics(String text) {
        List<Music> musics = new ArrayList<>();

        String[] musicInfo = text.split("/");

        for (int i = 0; i < musicInfo.length; i += 1) {
            String[] infos = musicInfo[i].split("-");
            musics.add(new Music(infos[0], infos[1]));
        }

        return musics;
    }

    public void savePlayList(PlayList playList) throws IOException {
        FileWriter fileWriter = new FileWriter("playlists.txt", true);

        fileWriter.write(playList.toString() + "\n");

        fileWriter.close();
    }

    public PlayList findBy(Integer historyPlayListId) throws FileNotFoundException {
        List<PlayList> playLists = loadPlayList();

        PlayList historyPlayList = playLists.stream()
                .filter(playList -> historyPlayListId == playList.getId())
                .findAny()
                .orElse(null);

        return historyPlayList;
    }
}
