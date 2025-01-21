package streams;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamWithStrings {

	public static void main(String[] args) {

		String[] names = { "Adam", "Daniel", "Kevin", "Joe", "Brad", "Susan" };

		// Stream.of(names).forEach(System.out :: println); //print every names in the
		// array

		//Stream.of(names).sorted().forEach(System.out::println); // print every names in the array in alphabetical order.

		
		//if we want to print in reverse order, then
		
		//Stream.of(names).sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		//if we want to print in names strating with character 'A', then
		
		Stream.of(names).filter(x -> x.startsWith("A")).forEach(System.out::println);
		
		//Here , sorted() ,filter are Intermediate operations.
	}

}
