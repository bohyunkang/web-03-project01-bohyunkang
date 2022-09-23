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

public class HistoryPanel extends JPanel {
    private List<PlayList> historyPlayLists;

    HistoryService historyService = new HistoryService();

    public HistoryPanel() throws FileNotFoundException {
        historyPlayLists = historyService.loadHistoryList();

        this.setOpaque(false);
        this.add(initBackButton());
        this.add(initHistoryListPanel());
    }

    public JButton initBackButton() {
        JButton button = new JButton("리스트로 돌아가기");
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBackground(new Color(238, 238, 238, 150));
        button.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 12));
        button.addActionListener(event -> {
            try {
                updateContentPanel(new PlayListsPanel());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        return button;
    }

    public JPanel initHistoryListPanel() {
        JPanel historyListPanel = new JPanel();
        historyListPanel.setLayout(new GridLayout(0, 1));
        historyListPanel.setOpaque(false);

        for (PlayList playList : historyPlayLists) {
            JPanel panel = new JPanel();
            panel.setOpaque(true);
            panel.setBackground(new Color(255, 255, 255, 150));
            historyListPanel.add(panel);

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

        return historyListPanel;
    }

    public void updateContentPanel(JPanel panel) {
        this.removeAll();
        this.add(panel);

        this.setVisible(false);
        this.setVisible(true);
    }
}
