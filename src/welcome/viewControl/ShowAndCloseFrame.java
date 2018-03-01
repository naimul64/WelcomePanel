package welcome.viewControl;

import propertyReader.PropertyReader;
import welcome.view.Panel;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.util.logging.Logger;

public class ShowAndCloseFrame {
    Logger logger = Logger.getAnonymousLogger();
    Panel panelHolderVar;
    public void ShowAndCloseFrame() {
        logger.info(this.getClass().getName() + " Class created.");
    }
    public void show() {
        Panel panel = new Panel();
        String panelTitle = PropertyReader.getProperty("PANEL_TITLE", "WELCOME");
        panel.showWelcomePanel(panelTitle);
        logger.info ("Panel opened");
        panelHolderVar = panel;
    }

    public void close() {
        JFrame jFrame = panelHolderVar.frame;
        jFrame.dispatchEvent(new WindowEvent(jFrame, WindowEvent.WINDOW_CLOSING));
        logger.info ("Panel closed");
    }
}
