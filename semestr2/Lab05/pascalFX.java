import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;



    

public class pascalFX extends Application {

    private static int n = 0;



    @Override 
    public void start(Stage stage){

        try{

            VBox mainPanel = new VBox();
            
            mainPanel.setStyle("-fx-background-color: black;");
            mainPanel.setSpacing(10);
            mainPanel.setPadding(new Insets(20));


            for(int i = 0; i <= n; i++){

                HBox triangleRow = new HBox(15);
                triangleRow.setAlignment(Pos.CENTER);
                triangleRow.setStyle("-fx-background-color: black;");

                PascalTriangleRow calcPascal = new PascalTriangleRow(i);

                for(int j = 0; j < i + 1; j++){
                    int value = calcPascal.pascalValue(j);
                    if(value != 0){
                        Label number = new Label(String.valueOf(value));
                        
                        number.setTextFill(Color.WHITE);
                        number.setFont(Font.font("Arial", 24));
                        number.setMinWidth(75);
                        number.setMinHeight(75);
                        number.setAlignment(Pos.CENTER);

                        triangleRow.getChildren().add(number);
                    }
                }
                mainPanel.getChildren().add(triangleRow);

            }
            mainPanel.setAlignment(Pos.CENTER);
            Scene scene = new Scene(mainPanel, 1000, 1000);


            stage.setTitle("Pascal's Triangle");
            stage.setScene(scene);
            stage.show();
        }
        catch (InvalidArraySize ex) {
            System.out.println(ex + ":  - Nieprawidłowy wiersz trójkąta Pascala");
            Platform.exit();
            return;

        } catch (NumberFormatException ex) {
            System.out.println("nieprawidłowa dana");
            Platform.exit();
            return;
        }        
    }

    public static void main(String[] args) {


        if (args.length == 0) {
            System.out.println("Nie podano argumentów");
            return;
        }
        try{
        
            n = Integer.parseInt(args[0]);
            if(n < 0){
                System.out.println("Podano n mniejsze/równe zeru");
                return;
            }
        }
        catch (InvalidArraySize ex) {
            System.out.println(ex + ": " + args[0] + " - Nieprawidłowy wiersz trójkąta Pascala");
            return;

        } catch (NumberFormatException ex) {
            System.out.println(args[0] + " - nieprawidłowa dana");
            return;
        }
        launch(args);





    }
    
}
