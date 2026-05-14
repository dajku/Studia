import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class FileIO {

    public static void saveToFile(ArrayList<ShapeData> shapesList, String fileName){

 
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".fig"))){
            oos.writeObject(shapesList);
        }
        catch(IOException e){
            System.out.println("bład");
        }
        catch(ClassCastException e){
            System.out.println("bład");
        }
    }

    public static ArrayList<ShapeData> loadFromFile(String fileName){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
            return (ArrayList<ShapeData>) ois.readObject();
        }
        catch(IOException e){
            System.out.println("błąd");
            return null;
        }
        catch(ClassNotFoundException e){
            System.out.println("blad");
            return null;
        }
        catch(ClassCastException e){
            System.out.println("bład");
            return null;
        }
    }
}
