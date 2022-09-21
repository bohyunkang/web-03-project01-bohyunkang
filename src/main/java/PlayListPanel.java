import models.Music;
import models.PlayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.FileNotFoundException;

public class PlayListPanel extends JPanel {
    private PlayList playList;

    private JPanel playListPanel;

    public PlayListPanel(PlayList playList) {
        this.playList = playList;

        this.setOpaque(false);
        this.add(initPlayListPanel());
    }

    public JPanel initPlayListPanel() {
        playListPanel = new JPanel();
        playListPanel.setBackground(new Color(255, 255, 255, 150));
        playListPanel.setLayout(new GridLayout(0, 1));
        playListPanel.setBorder(new EmptyBorder(5, 20, 20, 20));

        JLabel theme = new JLabel(playList.getTheme());
        theme.setFont(new Font("AppleSDGothicNeoSB00", Font.PLAIN, 16));

        theme.setHorizontalAlignment(JLabel.CENTER);
        playListPanel.add(theme);

        JPanel infoPanel = new JPanel();
        infoPanel.setOpaque(false);
        infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 5));
        playListPanel.add(infoPanel);

        JLabel curator = new JLabel("큐레이터: " + playList.getCurator());
        infoPanel.add(curator);

        JLabel tag = new JLabel("태그: " + playList.getTag().tagName());
        infoPanel.add(tag);

        for (Music music : playList.getMusics()) {
            JLabel text = new JLabel(music.toString());
            text.setOpaque(true);
            text.setBackground(new Color(0, 0, 0, 150));
            text.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
            text.setForeground(Color.WHITE);
            text.setHorizontalAlignment(JLabel.CENTER);

            playListPanel.add(text);
        }

        JButton button = new JButton("리스트로 돌아가기");
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(true);
        button.setBackground(new Color(238, 238, 238, 150));
        button.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
        button.addActionListener(event -> {
            try {
                updateContentPanel(new PlayListsPanel());
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
        playListPanel.add(button);

        return playListPanel;
    }

    public void updateContentPanel(JPanel panel) {
//        playListPanel.removeAll();
        this.removeAll();
        this.add(panel);

        this.setVisible(false);
        this.setVisible(true);
    }
}
