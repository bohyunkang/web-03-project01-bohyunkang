import models.Music;
import models.PlayList;
import models.Tag;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadPanel extends JPanel {
    private PlayListService playListService;
    
    List<Music> musics = new ArrayList<>();

    public UploadPanel() {
        playListService = new PlayListService();

        this.setOpaque(false);

        this.setLayout(new GridLayout(0, 1));

        this.add(initUploadFormPanel());
        this.add(initListPanel());

        this.setVisible(true);
    }

    public JPanel initUploadFormPanel() {
        JPanel uploadFormPanel = new JPanel();
        uploadFormPanel.setBackground(new Color(255, 255, 255, 200));

        JPanel panel = new JPanel();
        uploadFormPanel.add(panel);
        panel.setOpaque(false);
        panel.setLayout(new GridLayout(0, 1));

        JLabel description = new JLabel("플레이리스트를 등록해주세요 :)");
        description.setHorizontalAlignment(JLabel.CENTER);
        panel.add(description);

        JPanel themePanel = new JPanel();
        themePanel.setOpaque(false);
        panel.add(themePanel);

        themePanel.add(new JLabel("테마 제목: "));
        JTextField themeInput = new JTextField(10);
        themePanel.add(themeInput);

        JPanel tagPanel = new JPanel();
        tagPanel.setOpaque(false);
        panel.add(tagPanel);

        tagPanel.add(new JLabel("태그: "));
        JTextField tagInput = new JTextField(10);
        tagPanel.add(tagInput);

        JPanel curatorPanel = new JPanel();
        curatorPanel.setOpaque(false);
        panel.add(curatorPanel);

        curatorPanel.add(new JLabel("제작자: "));
        JTextField curatorInput = new JTextField(10);
        curatorPanel.add(curatorInput);

        JPanel songTitlePanel = new JPanel();
        songTitlePanel.setOpaque(false);
        panel.add(songTitlePanel);

        songTitlePanel.add(new JLabel("노래 제목: "));
        JTextField songTitleInput = new JTextField(10);
        songTitlePanel.add(songTitleInput);

        JPanel artistPanel = new JPanel();
        artistPanel.setOpaque(false);
        panel.add(artistPanel);

        artistPanel.add(new JLabel("가수 이름: "));
        JTextField artistInput = new JTextField(10);
        artistPanel.add(artistInput);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setOpaque(false);
        panel.add(buttonsPanel);

        JButton addButton = new JButton("추가");
        addButton.setBorderPainted(false);
        addButton.setContentAreaFilled(false);
        addButton.setFocusPainted(false);
        addButton.setOpaque(true);
        addButton.setBackground(new Color(238, 238, 238, 150));

        addButton.addActionListener(event -> {
            String music = songTitleInput.getText();
            String artist = artistInput.getText();

            if (music.equals("")) {
                return;
            }

            if (artist.equals("")) {
                return;
            }

            musics.add(new Music(music, artist));

            songTitleInput.setText("");
            artistInput.setText("");
        });
        buttonsPanel.add(addButton);

        JButton uploadButton = new JButton("등록");
        uploadButton.setBorderPainted(false);
        uploadButton.setContentAreaFilled(false);
        uploadButton.setFocusPainted(false);
        uploadButton.setOpaque(true);
        uploadButton.setBackground(new Color(238, 238, 238, 150));

        uploadButton.addActionListener(event -> {
            // TODO: 코드 정리 필요
            int id = 0;

            try {
                id = playListService.loadPlayList().size() + 1;
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }

            String theme = themeInput.getText();
            String curator = curatorInput.getText();
            Tag tag = new Tag(tagInput.getText());

            if (theme.equals("") || curator.equals("") || musics.size() == 0 || tag.tagName().equals("")) {
                return;
            }

            PlayList playList = new PlayList(id, theme, curator, musics, tag);

            try {
                playListService.savePlayList(playList);
                updateContentPanel(new PlayListsPanel());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        buttonsPanel.add(uploadButton);

        return uploadFormPanel;
    }

    public JPanel initListPanel() {
        JPanel listPanel = new JPanel();
        listPanel.setBackground(new Color(255, 255, 255, 200));

        return listPanel;
    }

    public void updateContentPanel(JPanel panel) {
        this.removeAll();
        this.add(panel);

        this.setVisible(false);
        this.setVisible(true);
    }
}