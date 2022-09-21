import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.io.FileNotFoundException;

public class MainPanel extends JPanel {
    public MainPanel() throws FileNotFoundException {
        this.setOpaque(false);
        this.setLayout(new BorderLayout(0, 0));

        this.add(initHeaderPanel(), BorderLayout.PAGE_START);
        this.add(new PlayListsPanel());
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
}
