import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryServiceTest {

    @Test
    void loadHistory() throws FileNotFoundException {
        HistoryService historyService = new HistoryService();

        assertEquals(0, historyService.loadHistory().size());
    }

    @Test
    void loadHistoryPlayList() throws FileNotFoundException {
        HistoryService historyService = new HistoryService();

        assertEquals(0, historyService.loadHistoryList().size());
    }
}
