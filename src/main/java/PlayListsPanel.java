import models.PlayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.List;

public class PlayListsPanel extends JPanel {
    PlayListService playListService = new PlayListService();

    List<PlayList> playLists = playListService.loadPlayList();

    public PlayListsPanel() throws FileNotFoundException {
        this.setOpaque(false);
        this.add(initPlayListsPanel());
    }

    public JPanel initPlayListsPanel() {
        JPanel playListsPanel = new JPanel();
        playListsPanel.setLayout(new GridLayout(0, 1));
        playListsPanel.setOpaque(false);

        for (int i = 0; i < playLists.size(); i += 1) {
            JPanel playListPanel = new JPanel();
            playListPanel.setOpaque(true);
            playListPanel.setBackground(new Color(255, 255, 255, 150));
            playListsPanel.add(playListPanel);

            JLabel image = new JLabel("");
            image.setIcon(new ImageIcon("src/main/resources/playListIcon.png"));
            playListPanel.add(image);

            JLabel playListTheme = new JLabel(playLists.get(i).getTheme());
            playListTheme.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 16));
            playListPanel.add(playListTheme);

            JButton button = new JButton("보러 가기");
            button.setBorderPainted(false);
            button.setContentAreaFilled(false);
            button.setFocusPainted(false);
            button.setOpaque(false);
            button.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
            button.addActionListener(event -> {
                // 플레이리스트 상세 패널로 이동하는 이벤트
            });
            playListPanel.add(button);
        }

        // List 2
//        JPanel playListPanel2 = new JPanel();
//        playListPanel2.setOpaque(true);
//        playListPanel2.setBackground(new Color(255, 255, 255, 150));
//        playListsPanel.add(playListPanel2);
//
//        JLabel image2 = new JLabel("");
//        image2.setIcon(new ImageIcon("src/main/resources/playListIcon.png"));
//        playListPanel2.add(image2);
//
//        JLabel playListTitle2 = new JLabel("청량한 날씨에 딱 듣기 좋은 케이팝");
//        playListTitle2.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 16));
//        playListPanel2.add(playListTitle2);
//
//        JButton button2 = new JButton("보러 가기");
//        button2.setBorderPainted(false);
//        button2.setContentAreaFilled(false);
//        button2.setFocusPainted(false);
//        button2.setOpaque(false);
//        button2.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
//        button2.addActionListener(event -> {
//
//        });
//        playListPanel2.add(button2);


        return playListsPanel;
    }
}
