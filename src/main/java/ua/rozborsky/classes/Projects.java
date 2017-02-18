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

        Label about = new Label("You can see a more detailed description of the projects, if you click on the project name");
        about.setStyleName("projectsDescription");
        about.setSizeUndefined();

        Label designer = new Label("I'm not a designer, so the look of my projects could be better :)");
        designer.setSizeUndefined();

        verticalLayout.addComponents(about, table, designer);
        verticalLayout.setComponentAlignment(about, Alignment.TOP_CENTER);
        verticalLayout.setComponentAlignment(table, Alignment.TOP_CENTER);
        verticalLayout.setComponentAlignment(designer, Alignment.BOTTOM_CENTER);

        addComponent(verticalLayout);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

    private Table table() {
        Table table = new Table();
        table.setWidth("90%");
        table.setPageLength(0);

        table.addContainerProperty("name", Button.class, null);
        table.addContainerProperty("description", Label.class, null);
        table.addContainerProperty("link to GitHub", Link.class, null);

        table.setColumnExpandRatio("project", 1);
        table.setColumnExpandRatio("description", 4);
        table.setColumnExpandRatio("link to GitHub", 1);

        table.addItem(new Object[]{project("SQL CMD"), label("Console application to work with PostgreSQL database. " +
                        "Using java core implemented a database connection, recording, editing and deleting data in a table."),
                linkGithub("https://github.com/rozborsky/sql")}, 1);
        table.addItem(new Object[]{project("Landing page"), label("Using Spring mvc created a simple 3- paged landing page. " +
                        "Implemented a registration and image upload to the server. "),
                linkGithub("https://github.com/rozborsky/landingPage")}, 2);
        table.addItem(new Object[]{project("equation"), label("Page on which can calculate the value of the quadratic equation " +
                        "and record the results in a database"),
                linkGithub("https://github.com/rozborsky/equation")}, 3);
        table.addItem(new Object[]{project("calculationPi"), label("Desktop application for calculation π. " +
                        "With limited memory get OutOfMemoryError, catch it and take calculated value"),
                linkGithub("https://github.com/rozborsky/calculationPi")}, 4);
        table.addItem(new Object[]{project("rss reader"), label("desktop application for reading news"),
                linkGithub("https://github.com/rozborsky/rssReader")}, 5);
        table.addItem(new Object[]{project("toll road"), label("The system of payment for the use of toll roads. " +
                "Includes a desktop client and server.\n" +
                "System installed on the toll road checkpoint.)" +
                "Implements Passes and calculates the fee for use, depending on the traversed path"),
                linkGithub("https://github.com/rozborsky/tollRoadClient.git")}, 6);
        table.addItem(new Object[]{project("web CV"), label("This is the site where you are right now. " +
                "Created using Vaadin framework"),
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
        link.setStyleName("linkGithub");

        return link;
    }

    private Button project(final String name) {
        Button button = new Button(name);
        button.setStyleName("quiet");
        button.setWidth("100%");
        button.addClickListener(new Button.ClickListener() {
            @Override
            public void buttonClick(Button.ClickEvent clickEvent) {
                new Project(name);
            }
        });

        return button;
    }
}