package stream;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public class TransactionTest {

    public static void main(String[] args) {
        System.out.println("############ Query1 ############");
        getTransaction().stream().filter(t -> t.getYear() == 2011).sorted(comparing(Transaction::getValue))
                .forEach(System.out::println);
        System.out.println("############ Query2 ############");
        getTransaction().stream().map(t -> t.getTrader().getCity()).distinct().forEach(System.out::println);
        System.out.println("############ Query3 ############");
        getTransaction().stream().map(Transaction::getTrader).filter(t -> t.getCity().equals("Cambridge")).distinct()
                .sorted(comparing(Trader::getName)).forEach(System.out::println);
        System.out.println("############ Query4 ############");
        System.out.println(getTransaction().stream().map(t -> t.getTrader().getName()).distinct().sorted().reduce("",
                (n1, n2) -> n1 + n2));
        System.out.println("############ Query5 ############");
        System.out.println("AnyTraders in Milan ? "
                + getTransaction().stream().anyMatch(t -> t.getTrader().getCity().equals("Milan")));
        System.out.println("############ Query6 ############");
        getTransaction().stream().filter(t -> t.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println("############ Query7 ############");
        getTransaction().stream().mapToInt(Transaction::getValue).max().ifPresent(System.out::println);
        System.out.println("############ Query8 ############");
        getTransaction().stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2)
                .ifPresent(System.out::println);
        getTransaction().stream().min(comparing(Transaction::getValue)).ifPresent(System.out::println);
    }

    public static List<Transaction> getTransaction() {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 200),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2011, 300),
                new Transaction(alan, 2012, 950));
        return transactions;
    }
}
