package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Dog implements Serializable {

    private static final long serialVersionUID = -2181102076882899394L;

    transient private Collar collar;
    private String name;
    // private int ss;

    public Dog(Collar collar, String name) {
        super();
        this.collar = collar;
        this.name = name;
    }

    public Collar getCollar() {
        return collar;
    }

    public void setCollar(Collar collar) {
        this.collar = collar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void writeObject(ObjectOutputStream os) throws IOException {
        os.defaultWriteObject();
        os.writeObject(collar.getColor());
        os.writeInt(collar.getSize());
    }

    private void readObject(ObjectInputStream is) throws IOException, ClassNotFoundException {
        is.defaultReadObject();
        String color = (String) is.readObject();
        int s = is.readInt();
        collar = new Collar(color, s);
    }
}
