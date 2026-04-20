import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



    

public class pascalFX extends Application {


    @Override 
    public void start(Stage stage){
        

        VBox mainPanel = new VBox();
        
        mainPanel.setStyle("-fx-background-color: black;");
        mainPanel.setSpacing(10);
        mainPanel.setPadding(new Insets(20));


        for(int i = 0; i <= 3; i++){

            HBox triangleRow = new HBox();
            triangleRow.setStyle("-fx-background-color: white;");

            PascalTriangleRow calcPascal = new PascalTriangleRow(i);

            for(int j = 0; j < i + 1; j++){
                int value = calcPascal.pascalValue(j);
                if(value != 0){
                    Label number = new Label(String.valueOf(value));
                    
                    number.setTextFill(Color.WHITE);
                    number.setFont(Font.font("Arial", 24));
                    number.setStyle("-fx-color:white;");

                    triangleRow.getChildren().add(number);
                }
            }
            mainPanel.getChildren().add(triangleRow);

        }

        Scene scene = new Scene(mainPanel, 1000, 1000);


        stage.setTitle("Pascal's Triangle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Nie podano argumentów");
            return;
        }





    }
    
}
