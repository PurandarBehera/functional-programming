package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamWithCollection {

	public static void main(String[] args) {

		List<String> names = new ArrayList<String>();

		names.add("Adam");
		names.add("Ben");
		names.add("Zoe");
		names.add("Daniel");
		names.add("Kevin");
		names.add("Phil");

		Stream<String> nameStream = names.stream();
		nameStream.forEach(System.out::println);
		// nameStream.forEach(System.out::println);//throws exception , as a stream can
		// be traversed only once.

		// Although below works , as both are different stream references

		names.stream().forEach(System.out::println);
		names.stream().forEach(System.out::println);
	}

}
