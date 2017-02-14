package ua.rozborsky.classes;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;


/**
 * Created by roman on 14.02.2017.
 */
public class CV extends VerticalLayout implements View {
    public CV() {
        setSizeFull();
        Label label = new Label("ROMAN ROZBORSKY");
        addComponent( label);
        setComponentAlignment(label, Alignment.MIDDLE_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {

    }
}
