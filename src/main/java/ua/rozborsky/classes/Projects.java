package ua.rozborsky.classes;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


/**
 * Created by roman on 14.02.2017.
 */
public class Projects  extends VerticalLayout implements View {
        public Projects() {
            setSizeFull();

            Label label = new Label("Projects");
            addComponent( label);
            setComponentAlignment(label, Alignment.MIDDLE_CENTER);
        }

        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {

        }
    }
