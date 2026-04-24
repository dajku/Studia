import java.util.*;
import javafx.event.ActionEvent;
import javafx.application.Application;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.event.EventHandler;
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
        input.setFont(Font.font("Arial", 16));


        horizontal1.getChildren().add(label);
        horizontal1.getChildren().add(input);

        vertical.getChildren().add(horizontal1);

        // SECOND INPUT AREA

        HBox horizontal2 = new HBox(10);
        horizontal2.setAlignment(Pos.CENTER);
        
        Label label2 = new Label("Podaj element:");
        label2.setFont(Font.font("Arial", 24));

        TextField input2 = new TextField();
        input2.setFont(Font.font("Arial", 16));
        
        horizontal2.getChildren().add(label2);
        horizontal2.getChildren().add(input2);

        vertical.getChildren().add(horizontal2);

        Button btn = new Button("Uruchom");
        btn.setFont(Font.font("Arial", 18));

        
        vertical.getChildren().add(btn);
        vertical.setAlignment(Pos.CENTER);
        mainPanel.setTop(vertical);

        // CENTER AREA

        Label output = new Label();
        
        output.setMaxHeight(Double.MAX_VALUE);
        output.setMaxWidth(Double.MAX_VALUE);

        output.setFont(Font.font("Arial", 24));
        mainPanel.setCenter(output);

        output.setAlignment(Pos.CENTER);
        output.setTextFill(Color.WHITE);
        output.setStyle("-fx-background-color: black");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e){
                try{
                    //
                    String n = input.getText();
                    String[] k = input2.getText().split(" ");
                    List<String> arguments = new ArrayList<String>();
                    arguments.add("/home/maciej/programowanie/Studia/semestr2/Lab03/C++/PascalTriangleRow");
                    arguments.add(n);
                    for(int i = 0; i < k.length; i++){
                        arguments.add(k[i]);
                    }
                    
                    ProcessBuilder pb = new ProcessBuilder(arguments);
                    pb.redirectErrorStream(true);

                    Process process = pb.start();

                    BufferedReader reader = new BufferedReader(
                        new InputStreamReader(process.getInputStream())
                    );
                    
                    StringBuilder result = new StringBuilder();
                    String line;
                    while((line = reader.readLine()) != null){
                        result.append(line + "\n");
                    }
                    process.waitFor();

                    output.setText(result.toString());
                }
                catch(Exception ex){
                    output.setText("Error: " + ex.getMessage());
                }
            }
        });
        
        
        Scene scene = new Scene(mainPanel, 1000, 1000);


        stage.setTitle("Pascal's Triangle");
        stage.setScene(scene);
        stage.show();
    
    }

    public static void main(String[] args) {
        launch(args);


    }
    
}
