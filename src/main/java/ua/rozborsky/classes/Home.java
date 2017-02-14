package ua.rozborsky.classes;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FileResource;
import com.vaadin.server.Page;
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
        //Notification.show("Welcome to the Animal Farm");
    }

    private Layout content() {
        HorizontalLayout content = new HorizontalLayout();
        content.setWidth("100%");
        content.setStyleName("content");

        Image photo = image();
        content.addComponent(photo);

        Layout aboutMe = aboutMe();
        content.addComponent(aboutMe);

        Layout social = social();
        content.addComponent(social);

        content.setExpandRatio(photo, 2);
        content.setExpandRatio(aboutMe, 4);
        content.setExpandRatio(social, 2.5f);

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


    private Layout social() {
        VerticalLayout social = new VerticalLayout();
        social.addComponent(new Label("You can find me in social networks"));

        social.addComponent(buttonFacebook());
        social.addComponent(buttonLinkedin());

        social.addStyleName("social");

        return social;
    }

    private Button buttonLinkedin() {
        Button button = new Button("Roman Rozborsky");
        button.setStyleName("buttonLinkedin");
        button.setWidth("70%");
        button.setHeight("40px");
        String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        button.setIcon(new FileResource(new File(basePath + "/WEB-INF/images/linkedin.png")));
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Page.getCurrent().open("https://ua.linkedin.com/in/roman-rozborsky-4ab000105", null);
            }
        });

        return button;
    }

    private Button buttonFacebook() {
        Button button = new Button("Roman Rozborsky");
        button.setStyleName("buttonFacebook");
        button.setWidth("70%");
        button.setHeight("40px");
        String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        button.setIcon(new FileResource(new File(basePath + "/WEB-INF/images/facebook.png")));
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Page.getCurrent().open("https://www.facebook.com/roman.rozborsky", null);
            }
        });

        return button;
    }
}