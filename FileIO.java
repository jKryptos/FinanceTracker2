import java.io.*;

public class FileIO {

    public static void saveData(Categories categories) {
        try {
            FileOutputStream dataOut = new FileOutputStream("save.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(dataOut);

            objectOut.writeObject(categories);
            objectOut.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Categories loadData() {
        Categories c = new Categories();

        try {
            FileInputStream dataIn = new FileInputStream("save.ser");
            ObjectInputStream objectIn = new ObjectInputStream(dataIn);

            c = (Categories) objectIn.readObject();
            objectIn.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return c;
    }
}
