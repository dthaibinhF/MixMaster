package dthaibinhf.project.mixmaster.viewmodel;

import dthaibinhf.project.mixmaster.view.pages.AboutView;
import dthaibinhf.project.mixmaster.view.pages.HomeView;
import dthaibinhf.project.mixmaster.view.pages.NewsletterView;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.Node;

public class AppViewModel {
    private final ObjectProperty<Node> currentView = new SimpleObjectProperty<>();

    public Node getCurrentView() {
        return currentView.get();
    }

    public ObjectProperty<Node> currentViewProperty() {
        return currentView;
    }

    public void navigateToHome() {
        currentView.set(new HomeView().getView());
    }

    public void navigateToAbout() {
        currentView.set(new AboutView().getView());
    }

    public void navigateToNewsletter() {
        currentView.set(new NewsletterView().getView());
    }

}
