package ua.rozborsky.classes;

import com.vaadin.event.FieldEvents;
import com.vaadin.server.FileResource;
import com.vaadin.server.VaadinService;
import com.vaadin.ui.*;

import java.io.File;

/**
 * Created by roman on 16.02.2017.
 */
public class Project {
    public Project(String name) {
        final Window window = new Window();
        window.setWidth("70%");

        window.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                window.close();

            }
        });

        window.setContent(content(name));
        window.center();
        window.setModal(true);
        UI.getCurrent().addWindow(window);
    }

    private VerticalLayout content(String name) {
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.addStyleName("projectLayoutInWindow");
        verticalLayout.setWidth("90%");

        Label title = new Label(name);
        title.setStyleName("titleProject");
        verticalLayout.addComponent(title);

        if(name.equals("SQL CMD")) {

            Label description = new Label("My first project. Course work that has been done on online programming courses Juja. " +
                    "This is a console application that using only one tool of java core implements CRUD operations. " +
                    "Application working with PostgreSQL database.");
            verticalLayout.addComponents(
                    description,
                    image("sqlManager", "1.jpg"),
                    image("sqlManager", "2.jpg"),
                    image("sqlManager", "3.jpg"),
                    image("sqlManager", "4.jpg"),
                    image("sqlManager", "5.jpg"),
                    image("sqlManager", "6.jpg"),
                    image("sqlManager", "7.jpg"),
                    image("sqlManager", "8.jpg"));
        } else if(name.equals("Landing page")) {
            Label description = new Label("Using Spring MVC created a simple 3 - paged landing page. " +
                    "Implemented a registration and image upload to the server. " +
                    "Since the page does not perform any complex actions, it was used library SQL2O for interaction with " +
                    "database");
            verticalLayout.addComponent(description);
        } else if(name.equals("equation")) {
            Label description = new Label("Using Spring MVC and Hibernate was created web-page on which can calculated" +
                    " the value of the quadratic equation. If the equation has solutions - value displayed and recorded" +
                    " to the database. Using PostgreSQL");
            verticalLayout.addComponent(description);
        } else if(name.equals("calculationPi")) {
            Label description = new Label("Desktop application for calculation π. " +
                    "With limited memory get OutOfMemoryError, catch it and take calculated value");
            Label withoutLimit = new Label("If memory is not limited - " +
                    "application calculate and show nearly 280000 numbers of number π");
            Label limitedMemory = new Label("If memory is limited 8mB- application calculate nearly 240000 numbers of of number π," +
                    " throw OutOfMemoryError and show calculated value");
            verticalLayout.addComponents(
                    description,
                    image("calculationPi", "start.jpg"),
                    withoutLimit,
                    image("calculationPi", "normalFinish.jpg"),
                    limitedMemory,
                    image("calculationPi", "lowMemory.jpg"));
        } else if(name.equals("rss reader")) {
            Label description = new Label("Desktop application, which is designed to get the latest news from news sites " +
                    "that support rss feeds. Allows you to add and remove rss channels. " +
                    "Clicking on the news in the program - news opens in the browser window");
            verticalLayout.addComponents(
                    description,
                    image("rssReader", "rss1.jpg"),
                    image("rssReader", "rss2.jpg"));
        } else if(name.equals("toll road")) {
            Label description = new Label("The system of payment for the use of toll roads. " +
                    "Includes a desktop client, created using Swing library, and server. " +
                    "The client can be configured as a terminal at the entrance to the road, " +
                    "as well as away from the road. System installed on the toll road checkpoint. " +
                    "Implements passes and calculates the fee for use, depending on the traversed path." +
                    "Communication between client and server through a socket. " +
                    "Allows you to connect multiple clients to the server.");
            Label ok = new Label("If driver registered in the system - system allow him to use road");
            Label notRegistered = new Label("If driver is not registerd in the system - the system does not pass him");
            Label inChain = new Label("If it was incorrectly entered user code that is already on the road" +
                    " - then a warning message is displayed");
            Label blocked = new Label("If the driver is registered, but he is locked in the system - appears this message");

            verticalLayout.addComponents(
                    description,
                    image("tollRoad", "tolRoad.jpg"),
                    ok,
                    image("tollRoad", "tollRoad1.jpg"),
                    notRegistered,
                    image("tollRoad", "tollRoad4.jpg"),
                    inChain,
                    image("tollRoad", "tollRoad2.jpg"),
                    blocked,
                    image("tollRoad", "tollRoad3.jpg"));
        } else if(name.equals("web CV")) {
            Label description = new Label("This is the site where you are right now. Created using Vaadin framework");
            verticalLayout.addComponents(description);
        }

        return verticalLayout;
    }

    private Image image(String project, String photo) {
        String basePath = VaadinService.getCurrent().getBaseDirectory().getAbsolutePath();

        FileResource resource = new FileResource(new File(basePath + "/WEB-INF/images/" + project + "/" + photo));
        Image image = new Image("", resource);
        image.setStyleName("photo");
        image.setWidth("80%");

        return image;
    }

}
