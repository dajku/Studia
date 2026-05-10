import java.util.*;
import javafx.event.ActionEvent;
import javafx.application.Application;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;

public class GeometricFiguers extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane mainPanel = new BorderPane();

        HBox menuBar = new HBox(10);
        menuBar.setPadding(new Insets(10));
        menuBar.setAlignment(Pos.CENTER);


        DrawingPane drawingPane = new DrawingPane();


        Button circleBtn = new Button("Circle");
        Button rectangleBtn = new Button("Rectangle");
        Button polygonBtn = new Button("Polygon");

        Button infoBtn = new Button("Info");



        
        circleBtn.getStyleClass().add("figureButton");
        rectangleBtn.getStyleClass().add("figureButton");
        polygonBtn.getStyleClass().add("figureButton");

        circleBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                drawingPane.setToolMode(ToolMode.CIRCLE);
            }
        });

        rectangleBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                drawingPane.setToolMode(ToolMode.RECTANGLE);
            }
        });
        polygonBtn.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e){
                drawingPane.setToolMode(ToolMode.POLYGON);
            }
        });

        infoBtn.getStyleClass().add("infoButton");
        infoBtn.setAlignment(Pos.CENTER_RIGHT);


        menuBar.getChildren().addAll(circleBtn, rectangleBtn, polygonBtn, infoBtn);

        menuBar.setStyle("-fx-background-color: black");

        mainPanel.setTop(menuBar);


        mainPanel.setCenter(drawingPane);

        // header.getChildren().add(menuBar);
        Scene scene = new Scene(mainPanel, 1000, 1000);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Geometric Figures");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}