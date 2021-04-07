import java.util.*;
import java.util.stream.Collectors;


class Trader {
	private String name;
	private String city;

	public Trader(String name, String city) {
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Trader{name=" + "'" + name + "'" + ", city=" + "'" + city + "'" + "}";
	}

}

class Transaction {
	private Trader trader;
	private int year;
	private int value;

	public Transaction(Trader trader, int year, int value) {
		this.trader = trader;
		this.year = year;
		this.value = value;
	}

	public Trader getTrader() {
		return trader;
	}

	public void setTrader(Trader trader) {
		this.trader = trader;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Transaction{trader=" + trader + ", year=" + year + ", value=" + value + "}";
	}
}

public class Assignment5Q4 {

	public static List<Transaction> sortTransactions(List<Transaction> transactions) {
		List<Transaction> s1 = new ArrayList<Transaction>();
		List<Transaction> s2 = new ArrayList<Transaction>();
		s1 = transactions.stream().filter(i -> i.getYear() == 2011).collect(Collectors.toList());
		s2 = s1.stream().sorted((t1, t2) -> t1.getValue() - t2.getValue()).collect(Collectors.toList());

		return s2;
	}

	public static List<Integer> transaction3sValuesDelhi(List<Transaction> transactions) {
		List<Transaction> tr = new ArrayList<>();
		List<Integer> trSatara = new ArrayList<>();

		tr = transactions.stream().filter(i -> i.getTrader().getCity().contentEquals("Satara"))
				.collect(Collectors.toList());
		tr.stream().forEach(i -> trSatara.add(i.getValue()));
		return trSatara;
	}

	public static int highestTransaction2(List<Transaction> transactions) {
		Optional<Transaction> trHigh = transactions.stream().max(Comparator.comparing(Transaction::getValue));
		Transaction obj = trHigh.stream().findFirst().get();
		return obj.getValue();

	}

	public static int smallestTransaction1(List<Transaction> transactions) {
		Optional<Transaction> trSmall = transactions.stream().min(Comparator.comparing(Transaction::getValue));
		Transaction obj = trSmall.stream().findFirst().get();
		return obj.getValue();
	}

	public static void main(String[] args) {
	}
}