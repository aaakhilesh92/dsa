package serialization;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class DeSerializationTest {

    public static void main(String[] args) {
        Dog d = null;
        try {
            FileInputStream fos = new FileInputStream("test.ser");
            ObjectInputStream oos = new ObjectInputStream(fos);
            d = (Dog) oos.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Dog Name : " + d.getName());
        Collar c = d.getCollar();
        if (c instanceof Collar) {
            System.out.println("Collar details : Color=" + c.getColor() + ", Size =" + c.getSize());
        }
    }

}
