package serialization;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerializationTest {

    public static void main(String[] args) {
        Collar c = new Collar("Blue", 2);
        Dog d = new Dog(c, "A");
        try {
            FileOutputStream fos = new FileOutputStream("test.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
