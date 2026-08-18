package other;

public class Phone {
    private String name;
    private String mobileNumber;

    public Phone(String mobileNumber, String name) {
        super();
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    @Override
    public String toString() {
        return "Phone [name=" + name + ", mobileNumber=" + mobileNumber + "]";
    }
}
