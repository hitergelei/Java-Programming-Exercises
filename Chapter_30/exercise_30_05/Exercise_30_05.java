package exercise_30_05;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Exercise_30_05 extends Application {
    private final static double WIDTH = 300;
    private final static double HEIGHT = 300;
    private final static double RADIUS = 100;
    
    @Override
    public void start(Stage primaryStage) {
        FanPane fanPane = new FanPane(WIDTH, HEIGHT, RADIUS);
        
        HBox hBox = new HBox(5);
        hBox.setAlignment(Pos.CENTER);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reverse");
        hBox.getChildren().addAll(pause, resume, reverse);
        
        BorderPane pane = new BorderPane(fanPane);
        pane.setBottom(hBox);
        
        Scene scene = new Scene(pane, WIDTH, HEIGHT);
        primaryStage.setTitle("Exercise_30_05");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        pause.setOnAction(e -> fanPane.suspend());
        resume.setOnAction(e -> fanPane.resume());
        reverse.setOnAction(e -> fanPane.reverse());
        
        pane.setOnMouseClicked(e -> {
            if(e.getButton().equals(MouseButton.PRIMARY)) {
                fanPane.increaseSpeed();
            }
            else if(e.getButton().equals(MouseButton.SECONDARY)) {
                fanPane.decreaseSpeed();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}