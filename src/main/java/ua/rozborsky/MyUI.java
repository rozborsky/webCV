package ua.rozborsky;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.LayoutEvents;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import ua.rozborsky.classes.CV;
import ua.rozborsky.classes.Home;
import ua.rozborsky.classes.Projects;

@Theme("cv")
@Title("rozborsky")
public class MyUI extends UI {
    private Navigator navigator;
    private Layout content = new VerticalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = new Navigator(this, content);

        navigator.addView("", new Home());
        navigator.addView("projects", new Projects());
        navigator.addView("cv", new CV());

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

        Button home = getButton("HOME", "");
        Button cv = getButton("CV", "cv");
        Button projects = getButton("PROJECTS", "projects");

        navigation.addComponents(home, cv, projects);

        navigation.setExpandRatio(home, 1);
        navigation.setExpandRatio(cv, 1);
        navigation.setExpandRatio(projects, 1);

        return navigation;
    }

    private Button getButton(String name, String view) {
        Button projects = new Button(name);
        projects.setSizeFull();
        projects.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                navigator.navigateTo(view);
            }
        });
        return projects;
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
        styles.add(".buttonLinkedin, .buttonFacebook { " +
                "margin-top: 30px;" +
                "border-radius: 5px;" +
                "padding: 5px;}");

        styles.add(".buttonFacebook {" +
                "background-color: #3B5998;}");

        styles.add(".buttonLinkedin {" +
                "background-color: #007AB9;}");

        styles.add(".photo { " +
                "margin: 50px;" +
                "margin-top: 0px;" +
                "box-shadow: 0 0 10px rgba(0,0,0,0.5); }");
        return styles;
    }
}
