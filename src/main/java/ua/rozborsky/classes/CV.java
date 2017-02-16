package ua.rozborsky.classes;

import com.vaadin.server.*;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by roman on 14.02.2017.
 */
public class CV{
    public CV() {
        Window window = new Window();
        window.setWidth("90%");
        window.setHeight("100%");
        String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        BrowserFrame frame = new BrowserFrame("Rozborsky_Roman", new FileResource(new File(basePath + "/WEB-INF/cv/Rozborsky_Roman_Junior_Java_Developer.pdf")));
        frame.setWidth("100%");
        frame.setHeight("100%");
        window.setContent(frame);
        window.center();
        window.setModal(true);
        UI.getCurrent().addWindow(window);
    }
}
