package ua.rozborsky;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import ua.rozborsky.classes.CV;
import ua.rozborsky.classes.Home;
import ua.rozborsky.classes.Projects;

import java.io.File;

@Theme("mytheme")
@Title("rozborsky")
public class MyUI extends UI {
    private Navigator navigator;
    private Layout content = new VerticalLayout();

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = new Navigator(this, content);
        navigator.addView("", new Home());
        navigator.addView("projects", new Projects());
        styles();
        VerticalLayout screen = new VerticalLayout();
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
        HorizontalLayout mainLayout = new HorizontalLayout();
        mainLayout.addStyleName("mainLayout");
       // mainLayout.setHeight("90%");
        mainLayout.setWidth("80%");

        VerticalLayout leftPart = leftPart();
        VerticalLayout rightPart = rightPart();
        mainLayout.addComponents(leftPart, rightPart);
        mainLayout.setExpandRatio(leftPart, 3);
        mainLayout.setExpandRatio(rightPart, 1);

        return mainLayout;
    }

    private VerticalLayout leftPart() {
        VerticalLayout verticalLayout = new VerticalLayout();
        content.setStyleName("content");

        HorizontalLayout header = header();
        verticalLayout.addComponents(header, content);
        verticalLayout.setExpandRatio(header, 1);
        verticalLayout.setExpandRatio(content, 5);

        return verticalLayout;
    }

    private HorizontalLayout header() {
        HorizontalLayout header = new HorizontalLayout();
        header.addStyleName("header");
        header.setWidth("100%");
        header.setHeight("150px");

        HorizontalLayout name = name();
        header.addComponent(name);
        header.setComponentAlignment(name, Alignment.MIDDLE_LEFT);

        return header;
    }

    private HorizontalLayout name() {
        Label name = new Label("ROMAN");
        name.addStyleName("titleName");
        Label surname = new Label("ROZBORSKY");
        surname.addStyleName("titleSurname");

        HorizontalLayout nameLayout = new HorizontalLayout();
        nameLayout.addComponents(name, surname);

        return nameLayout;
    }

    private VerticalLayout rightPart() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setStyleName("rightPart");
        verticalLayout.setHeight("100%");

        HorizontalLayout navigation = navigation();
        VerticalLayout social = social();
        verticalLayout.addComponent(navigation);
        verticalLayout.addComponent(social);
        verticalLayout.setExpandRatio(navigation, 1);
        verticalLayout.setExpandRatio(social, 5);

        return verticalLayout;
    }

    private VerticalLayout social() {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setStyleName("social");
        Button cv = getButtonCV();

        Label social = new Label("you can find me on social networks");
        social.addStyleName("socialLabel");

        Button buttonFacebook = buttonSocial(
                "Facebook",
                "facebook.png",
                "https://www.facebook.com/roman.rozborsky");
        Button buttonLinkedin = buttonSocial(
                "Linkedin",
                "linkedin.png",
                "https://ua.linkedin.com/in/roman-rozborsky-4ab000105");
        verticalLayout.addComponents(cv, social, buttonFacebook, buttonLinkedin);

        return verticalLayout;
    }

    private HorizontalLayout navigation() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setHeight("50px");
        horizontalLayout.setWidth("100%");

        Button button = buttonNavigation();
        horizontalLayout.addComponent(button);
        horizontalLayout.setComponentAlignment(button, Alignment.MIDDLE_CENTER);

        return horizontalLayout;
    }

    private Button buttonNavigation() {
        final Button button = new Button("projects");
        button.setSizeFull();

        button.setSizeFull();
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                if (button.getCaption().equals("projects")){
                    button.setCaption("home");
                    navigator.navigateTo("projects");
                } else {
                    button.setCaption("projects");
                    navigator.navigateTo("");
                }
            }
        });

        return button;
    }

    private Button getButtonCV() {
        final Button cv = new Button("CV");
        cv.setStyleName("navigation");
        cv.setWidth("100%");
        cv.setHeight("50px");
        cv.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                new CV();
            }
        });

        return cv;
    }

    private Button buttonSocial(String name, String icon, final String link) {
        Button button = new Button(name);
        button.setStyleName(name);
        button.setWidth("100%");
        button.setHeight("50px");
        String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();
        button.setIcon(new FileResource(new File(basePath + "/WEB-INF/images/" + icon)));
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                Page.getCurrent().open(link, null);
            }
        });

        return button;
    }

    private Page.Styles styles() {
        Page.Styles styles = Page.getCurrent().getStyles();
        styles.add(".body { " +
                "min-width: 1500px;" +
                "min-height: 900px;" +
                "overflow: auto;" +
                "background-color: #3A3E47;" +
                "color: #2D2D38;" +
                "font-family: arial;" +
                "overflow-x: hidden;" +
                "overflow-y: auto;}");
        styles.add(".mainLayout { " +
                "background-color: #F9FFF1;");
        styles.add(".header { " +
                "padding-left: 80px;" +
                "background-color: #383838; }");
        styles.add(".v-label-titleName, .v-label-titleSurname{ " +
                "font-size: 400%;" +
                "color:#F9FFF1; }");
        styles.add(".v-label-titleSurname { " +
                "margin-left: 30px;" +
                "font-weight: 600; }");
        styles.add(".content { " +
                "margin-top: 50px;" +
                "margin-bottom: 50px;" +
                "border-right: 1px solid #383838;}");
        styles.add(".photo { " +
                "margin: 50px;" +
                "margin-top: 60px;" +
                "box-shadow: 0 0 10px rgba(0,0,0,0.5); }");
        styles.add(".about { " +
                "margin-left: 50px;" +
                "font-size: 180%;");
        styles.add(".position, .projectsDescription { " +
                "font-size: 150%;");
        styles.add(".rightPart { " +
                "padding: 50px;" +
                "font-size: 180%;}");
        styles.add(".social {" +
                "margin-top: 50px;}");
        styles.add(".Linkedin, .Facebook{ " +
                "margin-top: 30px;");
        styles.add(".v-widget.Facebook{ " +
                "background: #3B5998;}");
        styles.add(".v-widget.Linkedin{ " +
                "background: #007AB9;}");
        styles.add(".socialLabel {" +
                "margin-top: 50px;}");
        styles.add(".v-table-row {" +
                "padding: 30px;}");
        styles.add(".v-button.v-widget.buttonTable.v-button-buttonTable.v-has-width {" +
                "font-weight: 600;}");
        styles.add(".projectLayoutInWindow{" +
                "margin: 0% 5% 2% 5%;" +
                "box-sizing: padding-box;" +
                "word-wrap: break-word;" +
                "overflow: hidden;}");
        styles.add(".titleProject{" +
                "margin: 50px;" +
                "font-weight: 600;" +
                "font-size: 200%;}");
        styles.add(".v-table-cell-content{" +
                "padding: 15px 0px;}");


        styles.add(".project, .linkGithub, .linkProject{" +
                "font-size: 110%;" +
                "word-break: normal;" +
                "line-height: 1.4;" +
                "text-decoration: none;}");

        return styles;
    }
}



//        і текст на 1-му треба скоротити та прибрати зайве
