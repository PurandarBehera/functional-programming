package streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamWithCustomObject {

	public static void main(String[] args) {
		List<Book> books = new ArrayList<>();
		books.add(new Book("Two States", "Chetan Bhagat", 240, Type.NOVEL));
		books.add(new Book("Alice's Adventures in Wonderland", "Lewis Carroll", 650, Type.FICTIONAL));
		books.add(new Book("Basic Economics", "Thomas Sowell", 360, Type.ECONOMICS));
		books.add(new Book("Hamlet", "William Shakespeare", 260, Type.DRAMA));
		books.add(new Book("The Trial", "Franz Kafka", 300, Type.PHILOSPOHY));
		books.add(new Book("One Night Stand", "Chetan Bhagat", 130, Type.NOVEL));
		books.add(new Book("The Wealth of Nations", "Adam Smith", 160, Type.ECONOMICS));
		books.add(new Book("The Da Vinci Code", "Dan Brown", 320, Type.DRAMA));
		
		//books.stream().forEach(System.out::println);
		
		//books.stream().sorted(Comparator.comparing(Book::getPages).reversed()).forEach(System.out::println);
		
		/*
		 * List<Book> bookList = books.stream() .filter(b-> b.getType() ==
		 * Type.ECONOMICS)
		 * .sorted(Comparator.comparing(Book::getTitle)).collect(Collectors.toList());
		 * 
		 * 
		 * bookList.stream().forEach(System.out::println);
		 */
		
		/*
		 * List<String> bookList = books.stream() .filter(b-> b.getType() ==
		 * Type.ECONOMICS) .sorted(Comparator.comparing(Book::getTitle))
		 * .map(Book::getAuthor) //map only the Author to this intermediate stream
		 * ,which is a String type. .collect(Collectors.toList());
		 * 
		 * 
		 * bookList.stream().forEach(System.out::println);
		 */
		
		//GroupingBy Type
		
		/*
		 * Map<Type, List<Book>> bookByType = books.stream()
		 * .collect(Collectors.groupingBy(Book::getType));
		 * 
		 * bookByType.entrySet().forEach(System.out::println);
		 */
		
		//3 Longest book by page with more than 260 pages
		
		List<Book> longestBooks = books.stream().filter(b -> b.getPages() >= 260)
				.sorted(Comparator.comparing(Book::getPages).reversed())
				.limit(3).collect(Collectors.toList());
		
		longestBooks.stream().forEach(System.out::println);

	}

}
