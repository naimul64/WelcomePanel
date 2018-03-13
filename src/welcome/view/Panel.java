package welcome.view;

import propertyReader.PropertyReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Panel {
    public JFrame frame;
    public void showWelcomePanel(String title) {
        frame = new JFrame(title);
        frame.setLayout(new BorderLayout());
        final JPanel jPanel = new JPanel();

        String panelText = PropertyReader.getProperty("PANEL_TEXT", "Welcome To My Computer!");
        jPanel.add(new JLabel(panelText));
        frame.add(jPanel);

        JLabel label = getJlabelWithImage();
        jPanel.add(label);

        //create a button which will hide the panel when clicked.
        JButton b = new JButton("HIDE");
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if (b.getText().equals("HIDE")) {
                    jPanel.setVisible(false);
                    b.setText("SHOW");
                    return;
                }
                if (b.getText().equals("SHOW")) {
                    jPanel.setVisible(true);
                    b.setText("HIDE");
                    return;
                }
            }
        });

        frame.add(b,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private JLabel getJlabelWithImage() {
        Path imagePath = Paths.get("..", "..", "gif", "analog_clock.gif");
        URL url = getClass().getResource(imagePath.toString());

        Icon imageIcon = new ImageIcon(url);

        return new JLabel(imageIcon);
    }
}
