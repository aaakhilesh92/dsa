package other;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PhoneTest {
    List<Phone> phoneBook = new ArrayList<Phone>();

    public void makeCall(Phone phone) {
        phoneBook.add(phone);
    }

    public List<Phone> find(String number) {
        return phoneBook.stream().filter(p -> p.getName().startsWith(number)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        PhoneTest obj = new PhoneTest();
        obj.makeCall(new Phone("1000", "AB1"));
        obj.makeCall(new Phone("1001", "AC2"));
        obj.makeCall(new Phone("1002", "AB3"));

        obj.makeCall(new Phone("2000", "BD1"));
        obj.makeCall(new Phone("2001", "BC2"));
        obj.makeCall(new Phone("2002", "BC3"));

        obj.makeCall(new Phone("3000", "CD1"));
        obj.makeCall(new Phone("3001", "CE2"));
        obj.makeCall(new Phone("3002", "CF3"));
        
        obj.makeCall(new Phone("1000", "AP1"));
        obj.makeCall(new Phone("1001", "AB1"));

        List<Phone> list = obj.find("A");
        System.out.println(list);
    }
}
