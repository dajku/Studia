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

/**
 * Main application class for the Geometric Figures drawing tool.
 *
 * Entry point of the JavaFX application. Builds the main window with a toolbar
 * containing drawing mode buttons (Circle, Rectangle, Polygon), file operation buttons
 * (Save, Load), and informational buttons (Info, Help).
 *
 * The central area of the window hosts a {@link DrawingPane} where the user
 * creates and edits shapes interactively.
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
public class GeometricFiguers extends Application {

    /**
     * Initializes and displays the main application window.
     *
     * Constructs the UI layout: a top toolbar with tool/action buttons
     * and a central {@link DrawingPane}. Wires up all button actions,
     * applies the CSS stylesheet, and shows the stage.
     *
     * @param stage The primary {@link Stage} provided by the JavaFX runtime.
     */
    @Override
    public void start(Stage stage) {

        BorderPane mainPanel = new BorderPane();

        HBox menuBar = new HBox(10);
        menuBar.setPadding(new Insets(10));
        menuBar.setAlignment(Pos.CENTER);
        menuBar.setStyle("-fx-background-color: black");

        DrawingPane drawingPane = new DrawingPane();

        // Toggle group ensures only one drawing mode is active at a time
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

        // Set active tool mode to CIRCLE
        circleBtn.setOnAction(e -> {
            drawingPane.setToolMode(ToolMode.CIRCLE);
        });

        // Set active tool mode to RECTANGLE
        rectangleBtn.setOnAction(e -> {
            drawingPane.setToolMode(ToolMode.RECTANGLE);
        });

        // Set active tool mode to POLYGON
        polygonBtn.setOnAction(e -> {
            drawingPane.setToolMode(ToolMode.POLYGON);
        });

        // Trigger save dialog in DrawingPane
        saveBtn.setOnAction(e -> {
            drawingPane.saveDrawing();
        });

        // Trigger load dialog in DrawingPane
        loadBtn.setOnAction(e -> {
            drawingPane.loadDrawing();
        });

        // Show "About" dialog with application metadata
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

        // Show "User Manual" dialog with usage instructions
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
                "   - Load - loads a drawing from a file; shapes are added to the current drawing.\n" +
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

    /**
     * Application entry point.
     * @param args Command-line arguments (not used).
     */
    public static void main(String[] args) {
        launch(args);
    }
}
