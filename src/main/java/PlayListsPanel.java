import models.PlayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class PlayListsPanel extends JPanel {
    private List<PlayList> playLists;
    private List<Integer> historyPlayLists;

    private JPanel playListsPanel;

    PlayListService playListService = new PlayListService();
    HistoryService historyService = new HistoryService();

    public PlayListsPanel() throws FileNotFoundException {
        playLists = playListService.loadPlayList();
        historyPlayLists = historyService.loadHistory();

        this.setOpaque(false);
        this.add(initButtonsPanel());
        this.add(initPlayListsPanel());
    }

    public JPanel initButtonsPanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(0, 1));

        panel.add(initAddButton());
        panel.add(initHistoryButton());

        return panel;
    }

    public JButton initAddButton() {
        JButton button = new JButton("플레이리스트 등록");
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBackground(new Color(238, 238, 238, 150));
        button.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 12));
        button.addActionListener(event -> {
            updateContentPanel(new UploadPanel());
        });
        return button;
    }

    public JButton initHistoryButton() {
        JButton button = new JButton("방금 본 플레이리스트");
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBackground(new Color(238, 238, 238, 150));
        button.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 12));
        button.addActionListener(event -> {
            try {
                updateContentPanel(new HistoryPanel());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return button;
    }

    public JPanel initPlayListsPanel() {
        playListsPanel = new JPanel();
        playListsPanel.setLayout(new GridLayout(0, 1));
        playListsPanel.setOpaque(false);

        for (PlayList playList : playLists) {
            JPanel panel = new JPanel();
            panel.setOpaque(true);
            panel.setBackground(new Color(255, 255, 255, 150));
            playListsPanel.add(panel);

            JLabel image = new JLabel("");
            image.setIcon(new ImageIcon("src/main/resources/playListIcon.png"));
            panel.add(image);

            JLabel playListTheme = new JLabel(playList.getTheme());
            playListTheme.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 16));
            panel.add(playListTheme);

            JButton button = new JButton("보러 가기");
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setOpaque(true);
            button.setBackground(new Color(238, 238, 238, 150));
            button.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
            button.addActionListener(event -> {
                try {
                    historyService.saveHistory(playList.getId());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

                updateContentPanel(new PlayListPanel(playList));
            });
            panel.add(button);
        }

        return playListsPanel;
    }

    public void updateContentPanel(JPanel panel) {
        this.removeAll();
        this.add(panel);

        this.setVisible(false);
        this.setVisible(true);
    }
}
