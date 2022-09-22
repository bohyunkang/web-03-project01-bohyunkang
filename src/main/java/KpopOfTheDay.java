import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class KpopOfTheDay {
    public static void main(String[] args) throws IOException {
        KpopOfTheDay application = new KpopOfTheDay();
        application.run();
    }

    public void run() throws IOException {
        JFrame frame = new JFrame("Kpop Of The Day");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(560, 700);
        frame.setResizable(false);

        JPanel contentPanel = new JPanel();
        frame.add(contentPanel);

        OverlayLayout overlay = new OverlayLayout(contentPanel);
        contentPanel.setLayout(overlay);

        contentPanel.add(new MainPanel());
        contentPanel.add(setBackgroundImage());

        frame.setVisible(true);
    }

    public JLabel setBackgroundImage() throws IOException {
        BufferedImage image = ImageIO.read(new File("src/main/resources/background.jpeg"));
        JLabel background = new JLabel(new ImageIcon(image));
        background.setAlignmentX(0.5f);
        background.setAlignmentY(0.5f);

        return background;
    }
}
