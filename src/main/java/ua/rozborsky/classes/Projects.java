package ua.rozborsky.classes;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.Reindeer;


/**
 * Created by roman on 14.02.2017.
 */
public class Projects  extends VerticalLayout implements View {
        public Projects() {
            setSizeFull();

            Table table = new Table("Some of my projects:");

            table.addContainerProperty("Name", String.class, null);
            table.addContainerProperty("Description",  String.class, null);
            table.addContainerProperty("link to GitHub",  Button.class, null);

            Button button = new Button("iiiiiiiiiii");
            button.setStyleName(Reindeer.BUTTON_LINK);
            table.addItem(new Object[]{"ddd", "fffff", button}, 2);
            table.addItem(new Object[]{"aaaa", "wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww", button}, 3);

            addComponent(table);

        }

        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {

        }
    }
