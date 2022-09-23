import models.PlayList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryService {
    private List<Integer> histories = new ArrayList<>();

    public List<Integer> loadHistory() throws FileNotFoundException {
        File file = new File("histories.txt");

        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();

            histories.add(Integer.parseInt(text));
        }

        return histories;
    }

    public void saveHistory(int playListId) throws IOException {
        FileWriter fileWriter = new FileWriter("histories.txt", true);

        if (!histories.contains(playListId)) {
            fileWriter.write(playListId + "\n");
        }

        fileWriter.close();
    }

    public List<PlayList> loadHistoryList() throws FileNotFoundException {
        List<PlayList> historyLists = new ArrayList<>();

        PlayListService playListService = new PlayListService();

        List<Integer> copy = loadHistory();

        for (int i = 0; i < copy.size(); i += 1) {
            PlayList historyPlayList = playListService.findBy(histories.get(i));
            historyLists.add(historyPlayList);
        }

        return historyLists;
    }
}
