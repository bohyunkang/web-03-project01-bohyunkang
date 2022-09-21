import models.Music;
import models.PlayList;
import models.Tag;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UploadFrame extends JFrame {
    List<Music> musics = new ArrayList<>();

    public UploadFrame() {
        this.setLayout(new GridLayout(0, 1));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("플레이리스트 등록하기");
        this.setSize(300, 600);
        this.setResizable(false);

        this.add(initUploadFormPanel());
        this.add(initListPanel());

        this.setVisible(true);
    }

    public JPanel initUploadFormPanel() {
        JPanel uploadFormPanel = new JPanel();
        JPanel panel = new JPanel();
        uploadFormPanel.add(panel);
        panel.setLayout(new GridLayout(0, 1));

        JLabel description = new JLabel("플레이리스트를 등록해주세요 :)");
        description.setHorizontalAlignment(JLabel.CENTER);
        panel.add(description);

        JPanel themePanel = new JPanel();
        panel.add(themePanel);

        themePanel.add(new JLabel("테마 제목: "));
        JTextField themeInput = new JTextField(10);
        themePanel.add(themeInput);

        JPanel tagPanel = new JPanel();
        panel.add(tagPanel);

        tagPanel.add(new JLabel("태그: "));
        JTextField tagInput = new JTextField(10);
        tagPanel.add(tagInput);

        JPanel curatorPanel = new JPanel();
        panel.add(curatorPanel);

        curatorPanel.add(new JLabel("제작자: "));
        JTextField curatorInput = new JTextField(10);
        curatorPanel.add(curatorInput);

        JPanel songTitlePanel = new JPanel();
        panel.add(songTitlePanel);

        songTitlePanel.add(new JLabel("노래 제목: "));
        JTextField songTitleInput = new JTextField(10);
        songTitlePanel.add(songTitleInput);

        JPanel artistPanel = new JPanel();
        panel.add(artistPanel);

        artistPanel.add(new JLabel("가수 이름: "));
        JTextField artistInput = new JTextField(10);
        artistPanel.add(artistInput);

        JPanel buttonsPanel = new JPanel();
        panel.add(buttonsPanel);

        JButton addButton = new JButton("추가");
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
        uploadButton.addActionListener(event -> {
            // TODO: 코드 정리 필요
            PlayListService playListService = new PlayListService();

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
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            this.setVisible(false);
        });
        buttonsPanel.add(uploadButton);

        return uploadFormPanel;
    }

    public JPanel initListPanel() {
        return new JPanel();
    }
}
