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
                        "Hello, my name is Roman. I am very hardworking and promising java developer. " +
                        "I learn programming for 2 years. Last year entirely devoted to the study java. " +
                        "In Vinnitsa IT Academy studied the basics of programming. But my main line of development - is java. " +
                        "Now to improve knowledge independently develop small projects and learn English. " +
                        "You can appreciate my programming skills by watching my projects. " +
                        "I live in Vinnitsa, but ready to relocate to to another city where I can progress " +
                        "as a java developer.");
        layout.addComponent(about);

        return layout;
    }

    private Layout position() {
        HorizontalLayout layout = new HorizontalLayout();
        layout.setStyleName("position");
        layout.setWidth("100%");
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