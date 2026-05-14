import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Utility class for saving and loading shape data to/from binary files.
 *
 * Provides static methods for serializing an {@link ArrayList} of {@link ShapeData} objects
 * to a binary {@code .fig} file and deserializing them back.
 * Uses Java's built-in object serialization ({@link ObjectOutputStream} / {@link ObjectInputStream}).
 *
 * @author Maciej Zyśk
 * @version 1.0
 */
public class FileIO {

    /**
     * Saves a list of shapes to a binary file.
     *
     * Serializes the given list and writes it to a file with the {@code .fig} extension
     * appended to the provided file name.
     *
     * @param shapesList List of {@link ShapeData} objects to save.
     * @param fileName   Path and base name of the output file (without extension).
     */
    public static void saveToFile(ArrayList<ShapeData> shapesList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName + ".fig"))) {
            oos.writeObject(shapesList);
        } catch (IOException e) {
            System.out.println("bład");
        } catch (ClassCastException e) {
            System.out.println("bład");
        }
    }

    /**
     * Loads a list of shapes from a binary file.
     *
     * Deserializes a previously saved {@code .fig} file and returns its contents
     * as an {@link ArrayList} of {@link ShapeData} objects.
     * Returns {@code null} if the file cannot be read or does not contain valid data.
     *
     * @param fileName Full path to the file to load (including extension).
     * @return ArrayList of {@link ShapeData} objects, or {@code null} on error.
     */
    public static ArrayList<ShapeData> loadFromFile(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (ArrayList<ShapeData>) ois.readObject();
        } catch (IOException e) {
            System.out.println("błąd");
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("blad");
            return null;
        } catch (ClassCastException e) {
            System.out.println("bład");
            return null;
        }
    }
}
