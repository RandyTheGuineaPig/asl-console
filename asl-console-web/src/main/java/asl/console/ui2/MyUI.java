package asl.console.ui2;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@Widgetset("asl.console.ui2.MyAppWidgetset")
public class MyUI extends UI {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        final MainWindow mainWindow = new MainWindow();
        mainWindow.pageTitleLabel.setValue("Servers State");

        // create table header
        Table serversStateTable = mainWindow.serversStateTable;
        serversStateTable.addContainerProperty("Server name", String.class, null);
        serversStateTable.addContainerProperty("Temperature", String.class, null);
        serversStateTable.addContainerProperty("CPU Load", String.class, null);
        serversStateTable.addContainerProperty("Bandwidth", String.class, null);
        serversStateTable.addContainerProperty("IO", String.class, null);
        serversStateTable.addContainerProperty("RAM Load", String.class, null);

        // add values to a header
        serversStateTable.addItem(new Object[] { "Linux1", "99.0 C", "66.01%", "86.02 Mb/s", "", "14.66%" }, 2);



        setContent(mainWindow);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
    }
}