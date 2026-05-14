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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
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
        Button helpBtn = new Button("Help");
        Button infoBtn = new Button("Info");


        circleBtn.setToggleGroup(figureButtons);
        rectangleBtn.setToggleGroup(figureButtons);
        polygonBtn.setToggleGroup(figureButtons);
        figureButtons.selectToggle(null);
        
        circleBtn.getStyleClass().add("figureButton");
        rectangleBtn.getStyleClass().add("figureButton");
        polygonBtn.getStyleClass().add("figureButton");
    
        infoBtn.getStyleClass().add("infoButton");
        infoBtn.setAlignment(Pos.CENTER_RIGHT);

        saveBtn.getStyleClass().add("infoButton");
        loadBtn.getStyleClass().add("infoButton");
        helpBtn.getStyleClass().add("infoButton");

        menuBar.getChildren().addAll(rectangleBtn, circleBtn, polygonBtn, saveBtn, loadBtn, infoBtn, helpBtn);
        saveBtn.setAlignment(Pos.CENTER_RIGHT);


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
            drawingPane.loadDrawing();
        });
        infoBtn.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("About");
            alert.setHeaderText("Geometric Figures");
            alert.setContentText(
                "Purpose:\n" +
                "  An application for drawing and editing geometric shapes.\n" +
                "  Supports creating circles, rectangles, and polygons,\n" +
                "  as well as moving, scaling, rotating, and saving/loading\n" +
                "  drawings to and from files.\n\n" +
                "Author:\n" +
                "  Maciej Zyśk\n\n");
            alert.show();
        });
        
        helpBtn.setOnAction(e -> {
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("User manual");
            alert.setHeaderText("User manual");
            alert.setContentText(
                "User manual:\n" +
                "1. Drawing Shapes\n" +
                "   - Select a tool (Circle / Rectangle / Polygon) from the menu bar.\n" +
                "   - Circle / Rectangle: click and drag on the drawing area.\n" +
                "   - Polygon: click to place vertices; double-click to finish.\n" +
                "2. Selecting and moving:\n" + 
                "   - Left-click on a shape to select it.\n" +
                "   - Drag the selected shape to move it.\n" +
                "3. Scaling and rotating\n" +
                "   - Select a shape, then use the mouse scroll wheel.\n" +
                "   - Select a shape, then use shift and mouse scroll wheel to rotate.\n" +
                "4. Changing fill color\n" +
                "   - Right-click on a shape.\n" +
                "   - A color picker will appear - choose a color and confirm.\n" +
                "5. Saving and loading\n" + 
                "   - Save - saves the current drawing to a file (.fig).\n" +
                "   - Load - loads a drawing from a file; shapes are added to the current drawing. \n" + 
                "6. About\n" +
                "   - The Info button displays a window with information about the application.\n"

            );
            alert.show();
        });

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