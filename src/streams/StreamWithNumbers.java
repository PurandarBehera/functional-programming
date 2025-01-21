package streams;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamWithNumbers {

	public static void main(String[] args) {

		// Below usage of stream with forEach are all Terminal operation, that
		// returns either a scalar value or void.

		int[] nums = { 2, -9, 7, 9, 5, 7, 2, 16, 0, -5 };

		Arrays.stream(nums).forEach(x -> System.out.print(x + " ")); // -> lambda expression

		System.out.println("--------------");

		Arrays.stream(nums).forEach(System.out::println); // :: Method reference

		int sum = Arrays.stream(nums).sum();
		System.out.println(sum);

		IntStream.range(0, 5).forEach(x -> System.out.print(x + " ")); // prints int from 0 to 4

		System.out.println();

		int total = IntStream.range(0, 5).sum();
		System.out.println(total);

		// Let's look at some of the Intermediate operations.

		// The below line prints number greater than 4 in the provided data set in range
		// (0,10), where 0 is inclusive & 10 is exclusive to the console.
		// filter(x -> x > 4) , this is a intermediate operation.

		IntStream.range(0, 10).filter(x -> x > 4).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//Prints even numbers from the data set
		IntStream.range(0, 10).filter(x -> x % 2 == 0).forEach(x -> System.out.print(x + " "));
		System.out.println();
		
		//Prints odd numbers from the data set
		IntStream.range(0, 10).filter(x -> x % 2 != 0).forEach(x -> System.out.print(x + " "));

	}

}
