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
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Font;

public class GeometricFiguers extends Application {

    @Override
    public void start(Stage stage) {

        BorderPane mainPanel = new BorderPane();

        HBox menuBar = new HBox(10);
        menuBar.setPadding(new Insets(10));
        menuBar.setAlignment(Pos.CENTER);
        menuBar.setStyle("-fx-background-color: black");


        DrawingPane drawingPane = new DrawingPane();
        
        ToggleGroup figureButtons = new ToggleGroup();
        ToggleButton circleBtn = new ToggleButton("Circle");
        ToggleButton rectangleBtn = new ToggleButton("Rectangle");
        ToggleButton polygonBtn = new ToggleButton("Polygon");

        Button saveBtn = new Button("Save");
        Button loadBtn = new Button("Load");


        circleBtn.setToggleGroup(figureButtons);
        rectangleBtn.setToggleGroup(figureButtons);
        polygonBtn.setToggleGroup(figureButtons);
        figureButtons.selectToggle(null);
        Button infoBtn = new Button("Info");
        
        circleBtn.getStyleClass().add("figureButton");
        rectangleBtn.getStyleClass().add("figureButton");
        polygonBtn.getStyleClass().add("figureButton");
    

        circleBtn.setOnAction(e -> {
            drawingPane.setToolMode(ToolMode.CIRCLE);   
        });

        rectangleBtn.setOnAction(e -> {
            drawingPane.setToolMode(ToolMode.RECTANGLE);
        });
        polygonBtn.setOnAction(e -> {
            drawingPane.setToolMode(ToolMode.POLYGON);
        });
        saveBtn.setOnAction(e -> {
            drawingPane.saveDrawing();
        });
        loadBtn.setOnAction(e -> {
            drawingPane.loadDrawing("Figures");
        });

        infoBtn.getStyleClass().add("infoButton");
        infoBtn.setAlignment(Pos.CENTER_RIGHT);

        saveBtn.getStyleClass().add("infoButton");
        loadBtn.getStyleClass().add("infoButton");

        menuBar.getChildren().addAll(circleBtn, rectangleBtn, polygonBtn, infoBtn, saveBtn, loadBtn);
        saveBtn.setAlignment(Pos.CENTER_RIGHT);


        mainPanel.setTop(menuBar);


        mainPanel.setCenter(drawingPane);

        Scene scene = new Scene(mainPanel, 800, 800);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        stage.setTitle("Geometric Figures");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}