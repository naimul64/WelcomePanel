package welcome.window;

import propertyReader.PropertyReader;
import welcome.view.Panel;
import welcome.viewControl.ShowAndCloseFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class Hello {
    public static void main(String[] args) {
        System.out.println("Hello World.");

        ShowAndCloseFrame showAndCloseFrame = new ShowAndCloseFrame();
        showAndCloseFrame.show();

        Integer delay = Integer.parseInt(PropertyReader.getProperty("PANEL_LIFE_SPAN_IN_MILISECONDS", 10000));

        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAndCloseFrame.close();
            }
        });
        timer.start();
    }
}
