package ua.rozborsky;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.LayoutEvents;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.BaseTheme;

import java.io.File;

@Theme("cv")
@Title("rozborsky")
public class MyUI extends UI {
    private Navigator navigator;;
    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = getUI().getNavigator();
        styles();
        final VerticalLayout screen = new VerticalLayout();
        screen.setSizeFull();
        screen.setStyleName("body");

        Layout mainLayout = mainLayout();
        screen.addComponent(mainLayout);
        screen.setComponentAlignment(mainLayout, Alignment.MIDDLE_CENTER);
        screen.setMargin(true);
        screen.setSpacing(true);
        
        setContent(screen);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    private Layout mainLayout() {
        VerticalLayout mainLayout = new VerticalLayout();
        mainLayout.setStyleName("mainLayout");
        mainLayout.setHeight("90%");
        mainLayout.setWidth("80%");

        Layout header = header();
        mainLayout.addComponent(header);

        Layout content = content();
        mainLayout.addComponent(content);

        mainLayout.setExpandRatio(header, 2);
        mainLayout.setExpandRatio(content, 5);

        return mainLayout;
    }

    private Layout header() {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("header");
        header.setWidth("100%");
        header.setHeight("150px");

        Layout name = name();
        header.addComponent(name);
        header.setComponentAlignment(name, Alignment.MIDDLE_CENTER);

        Layout navigation = navigation();
        header.addComponent(navigation);
        header.setComponentAlignment(navigation, Alignment.MIDDLE_RIGHT);

        header.setExpandRatio(name, 1);
        header.setExpandRatio(navigation, 1);

        return header;
    }

    private Layout name() {
        HorizontalLayout name = new HorizontalLayout();
        name.addComponents(titleName(), titleSurname());

        return name;
    }

    private Label titleName() {
        Label name = new Label("ROMAN");
        name.addStyleName("titleName");

        return name;
    }

    private Label titleSurname() {
        Label surname = new Label("ROZBORSKY");
        surname.addStyleName("titleSurname");

        return surname;
    }

    private Layout navigation() {
        HorizontalLayout navigation = new HorizontalLayout();
        navigation.setStyleName("navigation");
        navigation.setWidth("70%");
        navigation.setHeight("100%");


        Layout home = button(new Link("HOME", new ExternalResource("http://vaadin.com/")));
        Button cv = new Button("CV");
        cv.setSizeFull();
        cv.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                new Link("",
                        new ExternalResource("http://vaadin.com/"));

                //navigator.navigateTo("hello");
            }
        });
        Layout projects = button(new Link("PROJECTS", new ExternalResource("http://vaadin.com/")));

        navigation.addComponents(home, cv, projects);

        navigation.setExpandRatio(home, 1);
        navigation.setExpandRatio(cv, 1);
        navigation.setExpandRatio(projects, 1);


        return navigation;
    }


    private Layout button(Link button) {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.setStyleName("button");

        layout.addComponent(button);
        layout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);
        layout.addLayoutClickListener(new LayoutEvents.LayoutClickListener() {
            @Override
            public void layoutClick(LayoutEvents.LayoutClickEvent layoutClickEvent) {
                System.out.println(button.getTargetName());
            }
        });

        return layout;
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

        Resource res = new ExternalResource("https://www.facebook.com");//todo refactor
        final ResourceReference rr = ResourceReference.create(res, social, "email");
        Button facebook = new Button("facebook");
        facebook.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Page.getCurrent().open(rr.getURL(), null);
            }});

        social.addComponent(facebook);
        social.addComponent(new Button("linkedin"));

        social.addStyleName("social");

        return social;
    }

    private Page.Styles styles() {
        Page.Styles styles = Page.getCurrent().getStyles();
        styles.add(".body { " +
                "min-width: 1500px;" +
                "min-height: 900px;" +
                "overflow: auto;" +
                "background-color: #3A3E47; " +
                "font-family: calibri; }");
        styles.add(".about { " +
                "margin-left: 50px;" +
                "padding-right: 30px;" +
                "font-size: 180%;" +
                "border-right: 1px groove #383838;}");
        styles.add(".position { " +
                "font-size: 150%;" +
                "color: #2D2D38; " +
                "background-color: #F9FFF1;}");
        styles.add(".mainLayout { " +
                "background-color: #F9FFF1;" +
                "");
        styles.add(".header { " +
                "background-color: #383838; }");
        styles.add(".social { font-size: 180%; }");
        styles.add(".navigation { " +
                "font-size: 200%;" +
                "color: #908778; }");
        styles.add(".v-label-titleName,  .v-label-titleSurname{ " +
                "font-size: 400%;" +
                "color:#F9FFF1; }");
        styles.add(".v-label-titleSurname { font-weight: 600; }");

        styles.add(".button { background-color: #7C4444; }");

        styles.add(".photo { " +
                "margin: 50px;" +
                "margin-top: 0px;" +
                "box-shadow: 0 0 10px rgba(0,0,0,0.5); }");

        return styles;
    }

}
