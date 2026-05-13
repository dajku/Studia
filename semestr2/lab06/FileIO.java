import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FileIO {

    public static void saveToFile(ArrayList<ShapeData> shapesList, String path){

 
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path + ".fig"))){
            oos.writeObject(shapesList);
        }
        catch(IOException e){
            System.out.println("bład");
        }
    }
}
