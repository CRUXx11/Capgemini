import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Assignment3Q8a {
	public static void failFast(Map<String, String> cityCode) {
		Iterator<Entry<String, String>> hmIterator = cityCode.entrySet().iterator();
		while (hmIterator.hasNext()) {
			System.out.println(hmIterator.next());
			cityCode.put("Karad", "5"); // this line will through Exception because HashMap has fail-fast iterator. We can not do concurrent modification.
		}
	}

	public static void main(String[] args) {

		Map<String, String> map = new HashMap<>();
		map.put("Satara", "1");
		map.put("Pune", "2");
		map.put("Mumbai", "3");
		map.put("Kolhapur", "4");

		failFast(map);

	}
}