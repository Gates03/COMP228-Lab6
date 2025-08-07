import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        LottoController controller = new LottoController();
        Scene scene = new Scene(controller.getView(), 600, 500);
        primaryStage.setTitle("Lotto Game - Lab 6");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}