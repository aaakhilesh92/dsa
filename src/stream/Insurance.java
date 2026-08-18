package stream;

public class Insurance {
    private String insuranceName;
    private int year;

    public int getYear() {
        return year;
    }

    public Insurance(String insuranceName, int year) {
        super();
        this.insuranceName = insuranceName;
        this.year = year;
    }

    public String getInsuranceName() {
        return insuranceName;
    }

    @Override
    public String toString() {
        return "insuranceName : " + insuranceName + ", year : " + year;
    }
}
