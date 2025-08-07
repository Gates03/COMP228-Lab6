import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LottoController {
    private VBox view;
    private TextArea resultArea;
    private Button runButton;
    private int runCount = 0;
    private ExecutorService executor = Executors.newFixedThreadPool(5);

    private TextField minField;
    private TextField maxField;
    private TextField ballCountField;

    public LottoController() {
        view = new VBox(15);
        view.setPadding(new Insets(20));

        Label minLabel = new Label("Min Number:");
        minField = new TextField("0");

        Label maxLabel = new Label("Max Number:");
        maxField = new TextField("100");

        Label ballLabel = new Label("Number of Balls:");
        ballCountField = new TextField("5");

        resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setWrapText(true);

        runButton = new Button("Run Lotto");
        runButton.setOnAction(e -> runLotto());

        view.getChildren().addAll(
                minLabel, minField,
                maxLabel, maxField,
                ballLabel, ballCountField,
                runButton,
                resultArea
        );
    }

    public VBox getView() {
        return view;
    }

    private void runLotto() {
        if (runCount >= 5) {
            resultArea.appendText("\n\nLotto has already been run 5 times.\n");
            runButton.setDisable(true);
            return;
        }

        try {
            int min = Integer.parseInt(minField.getText());
            int max = Integer.parseInt(maxField.getText());
            int ballCount = Integer.parseInt(ballCountField.getText());

            if (min < 0 || max > 100 || min >= max || ballCount <= 0 || ballCount > (max - min + 1)) {
                resultArea.appendText("Invalid input. Please check your ranges.\n");
                return;
            }

            runCount++;
            int currentRun = runCount;

            executor.submit(() -> {
                LottoGame game = new LottoGame(currentRun, min, max, ballCount);
                game.generate();
                String result = game.getResult();
                DatabaseUtil.insertLottoResult(currentRun, result);

                javafx.application.Platform.runLater(() -> {
                    resultArea.appendText("Run " + currentRun + ": " + result + "\n");
                });
            });
        } catch (NumberFormatException ex) {
            resultArea.appendText("Please enter valid numeric values.\n");
        }
    }
}