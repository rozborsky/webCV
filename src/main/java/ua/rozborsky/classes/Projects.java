package ua.rozborsky.classes;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.ExternalResource;
import com.vaadin.ui.*;


/**
 * Created by roman on 14.02.2017.
 */
public class Projects  extends VerticalLayout implements View {
    public Projects() {
        setSizeFull();

        Table table = table();
        VerticalLayout verticalLayout = new VerticalLayout();
        verticalLayout.setStyleName("layout");
        verticalLayout.setSizeFull();
        verticalLayout.addComponent(table);
        verticalLayout.setComponentAlignment(table, Alignment.TOP_CENTER);

        addComponent(verticalLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    private Table table() {
        Table table = new Table();
        table.setWidth("90%");
        table.setPageLength(0);

        table.addContainerProperty("name", Label.class, null);
        table.addContainerProperty("description", Label.class, null);
        table.addContainerProperty("link to GitHub", Link.class, null);

        table.setColumnExpandRatio("project", 1);
        table.setColumnExpandRatio("description", 4);
        table.setColumnExpandRatio("link to GitHub", 1);

        table.addItem(new Object[]{label("SQL CMD"), label("Console application to work with PostgreSQL database. " +
                        "Using java core implemented a database connection, recording, editing and deleting data in a table."),
                linkGithub("https://github.com/rozborsky/sql")}, 1);
        table.addItem(new Object[]{label("Landing page"), label("Using Spring mvc created a simple 3- paged landing page. " +
                        "Implemented a registration and image upload to the server. "),
                linkGithub("https://github.com/rozborsky/landingPage")}, 2);
        table.addItem(new Object[]{label("equation"), label("Page on which can calculate the value of the quadratic equation " +
                        "and record the results in a database"),
                linkGithub("https://github.com/rozborsky/equation")}, 3);
        table.addItem(new Object[]{label("calculationPi"), label("Desktop application for calculation π. " +
                        "With limited memory get OutOfMemoryError, catch it and take calculated value"),
                linkGithub("https://github.com/rozborsky/calculationPi")}, 4);
        table.addItem(new Object[]{label("rss reader"), label("desktop application for reading news"),
                linkGithub("https://github.com/rozborsky/rssReader")}, 5);
        table.addItem(new Object[]{label("toll road"), label("The system of payment for the use of toll roads. " +
                "Includes a desktop client and server.\n" +
                "System installed on the toll road checkpoint.)" +
                "Implements Passes and calculates the fee for use, depending on the traversed path"),
                linkGithub("https://github.com/rozborsky/tollRoadClient.git")}, 6);
        table.addItem(new Object[]{label("web CV"), label("this project"),
                linkGithub("https://github.com/rozborsky/webCV.git")}, 7);

        return table;
    }


    private Label label(String description) {
        Label label = new Label(description);
        label.setStyleName("project");
        label.setWidth("100%");

        return label;
    }

    private Link linkGithub(String url) {
        Link link = new Link("see code",new ExternalResource(url));
        link.setStyleName("project");

        return link;
    }
}
