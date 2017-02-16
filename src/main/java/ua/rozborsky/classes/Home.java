package ua.rozborsky.classes;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by roman on 14.02.2017.
 */
public class Home  extends VerticalLayout implements View {
    public Home() {
        setSizeFull();
        addComponent(content());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    private Layout content() {
        HorizontalLayout content = new HorizontalLayout();
        content.setSizeFull();
        content.setStyleName("content");

        Image photo = image();
        Layout aboutMe = aboutMe();
        content.addComponent(photo);
        content.addComponent(aboutMe);

        content.setExpandRatio(photo, 1);
        content.setExpandRatio(aboutMe, 2);

        return content;
    }

    private Layout aboutMe() {
        VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("about");
        layout.addComponent(position());
        layout.setWidth("80%");
        Label about = new Label(
                "I study programming for 2 years. Graduated from Vinnitsa IT Academy, where I studied programing, " +
                        "including C++, HTML, PHP, java-script. Last year working and graduated java online courses " +
                        "\"Juja\". Now I self-learning java at home. " +
                        "To improve knowledge independently develop small projects. Learn English. " +
                        "Interesting in learning and professional development as a java developer.");
        layout.addComponent(about);

        return layout;
    }

    private Layout position() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setStyleName("position");
        layout.addComponent(new Label("JUNIOR JAVA DEVELOPER"));

        return layout;
    }

    private Image image() {
        String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

        FileResource resource = new FileResource(new File(basePath + "/WEB-INF/images/rozborsky.jpg"));
        Image image = new Image("", resource);
        image.setStyleName("photo");
        image.setWidth("80%");

        return image;
    }
}