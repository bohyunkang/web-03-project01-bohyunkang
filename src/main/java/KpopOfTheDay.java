import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class KpopOfTheDay {
    private JPanel contentPanel = new JPanel();

    public static void main(String[] args) throws IOException {
        KpopOfTheDay application = new KpopOfTheDay();
        application.run();
    }

    public void run() throws IOException {
        JFrame frame = new JFrame("Kpop Of The Day");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 700);
        frame.setResizable(false);

        frame.add(contentPanel);

        OverlayLayout overlay = new OverlayLayout(contentPanel);
        contentPanel.setLayout(overlay);

        contentPanel.add(initMainPanel());
        contentPanel.add(setBackgroundImage());

        frame.setVisible(true);
    }

    private JPanel initMainPanel() throws FileNotFoundException {
        JPanel mainPanel = new JPanel();
        mainPanel.setOpaque(false);

        mainPanel.add(initHeaderPanel());
        mainPanel.add(new PlayListsPanel());

        return mainPanel;
    }

    public JPanel initHeaderPanel() {
        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(255, 255, 255, 150));

        JLabel title = new JLabel("Kpop of the Day :)");
        title.setFont(new Font("Montserrat", Font.BOLD, 24));
        title.setBorder(new EmptyBorder(10, 20, 10, 20));
        headerPanel.add(title);

        return headerPanel;
    }

    public JLabel setBackgroundImage() throws IOException {
        BufferedImage image = ImageIO.read(new File("src/main/resources/background.jpeg"));
        JLabel background = new JLabel(new ImageIcon(image));
        background.setAlignmentX(0.5f);
        background.setAlignmentY(0.5f);

        return background;
    }
}

