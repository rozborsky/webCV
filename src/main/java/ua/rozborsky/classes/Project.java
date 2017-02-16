package ua.rozborsky.classes;

import com.vaadin.event.FieldEvents;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

/**
 * Created by roman on 16.02.2017.
 */
public class Project {
    public Project() {
        final Window window = new Window();
        window.setWidth("70%");
        window.setHeight("50%");
        window.addBlurListener(new FieldEvents.BlurListener() {

            @Override
            public void blur(FieldEvents.BlurEvent event) {
                window.close();

            }
        });

        Label label = new Label("jjjjfffffff");

        window.setContent(label);
        window.center();
        window.setModal(true);
        UI.getCurrent().addWindow(window);
    }
}
