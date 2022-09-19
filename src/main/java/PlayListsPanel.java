import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

public class PlayListsPanel extends JPanel {
    public PlayListsPanel() {
        this.setOpaque(false);
        this.add(initPlayListsPanel());
    }

    public JPanel initPlayListsPanel() {
        JPanel playListsPanel = new JPanel();
        playListsPanel.setLayout(new GridLayout(0, 1));
        playListsPanel.setOpaque(false);

        // List 1 - 우선 하드코딩
        JPanel playListPanel1 = new JPanel();
        playListPanel1.setOpaque(true);
        playListPanel1.setBackground(new Color(255, 255, 255, 150));
        playListsPanel.add(playListPanel1);

        JLabel image = new JLabel("");
        image.setIcon(new ImageIcon("src/main/resources/playListIcon.png"));
        playListPanel1.add(image);

        JLabel playListTitle = new JLabel("한겨울이 오면 들어야 하는 케이팝");
        playListTitle.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 16));
        playListPanel1.add(playListTitle);

        JButton button = new JButton("보러 가기");
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setFocusPainted(false);
        button.setOpaque(false);
        button.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
        button.addActionListener(event -> {

        });
        playListPanel1.add(button);

        // List 2
        JPanel playListPanel2 = new JPanel();
        playListPanel2.setOpaque(true);
        playListPanel2.setBackground(new Color(255, 255, 255, 150));
        playListsPanel.add(playListPanel2);

        JLabel image2 = new JLabel("");
        image2.setIcon(new ImageIcon("src/main/resources/playListIcon.png"));
        playListPanel2.add(image2);

        JLabel playListTitle2 = new JLabel("청량한 날씨에 딱 듣기 좋은 케이팝");
        playListTitle2.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 16));
        playListPanel2.add(playListTitle2);

        JButton button2 = new JButton("보러 가기");
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.setFocusPainted(false);
        button2.setOpaque(false);
        button2.setFont(new Font("AppleSDGothicNeoR00", Font.PLAIN, 14));
        button2.addActionListener(event -> {

        });
        playListPanel2.add(button2);


        return playListsPanel;
    }
}
