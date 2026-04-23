import java.util.TreeMap;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



    

public class CGui extends Application {




    @Override 
    public void start(Stage stage){

        BorderPane mainPanel = new BorderPane();

        VBox vertical = new VBox(10);

        // FIRST INPUT AREA
        HBox horizontal1 = new HBox(10);
        horizontal1.setAlignment(Pos.CENTER);
        
        Label label = new Label("Podaj wiersz:");
        label.setFont(Font.font("Arial", 24));

        TextField input = new TextField();


        horizontal1.getChildren().add(label);
        horizontal1.getChildren().add(input);

        vertical.getChildren().add(horizontal1);

        // SECOND INPUT AREA

        HBox horizontal2 = new HBox(10);
        horizontal2.setAlignment(Pos.CENTER);
        
        Label label2 = new Label("Podaj element:");
        label2.setFont(Font.font("Arial", 24));

        TextField input2 = new TextField();
        
        horizontal2.getChildren().add(label2);
        horizontal2.getChildren().add(input2);

        vertical.getChildren().add(horizontal2);

        Button btn = new Button("Uruchom");
        btn.setFont(Font.font("Arial", 18));

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                label.setText("a");
            }
        });
        
        vertical.getChildren().add(btn);
        vertical.setAlignment(Pos.CENTER);
        mainPanel.setTop(vertical);

        TextArea output = new TextArea();
        output.setFont(Font.font("Arial", 24));
        mainPanel.setCenter(output);
        output.setStyle("-fx-control-inner-background: black; -fx-text-fill: white;");
        output.setEditable(false);
        
        
        Scene scene = new Scene(mainPanel, 1000, 1000);


        stage.setTitle("Pascal's Triangle");
        stage.setScene(scene);
        stage.show();
    
    }

    public static void main(String[] args) {
        launch(args);

        ProcessBuilder pb = new ProcessBuilder();






    }
    
}
