package other;

public class CloningTestClass implements Cloneable{
    private int i;
    private String s;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public CloningTestClass(int i, String s) {
        super();
        this.i = i;
        this.s = s;
    }

    public static CloningTestClass getInstance(CloningTestClass inst) throws CloneNotSupportedException {
        return (CloningTestClass) inst.clone();
    }
}
