package streams;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FPCustomClass {

	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), 
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), 
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), 
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));
		
		Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore()>95;
		Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore()>90;
		Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore()<90;
		
		
		
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
		System.out.println(courses.stream().allMatch(reviewScoreGreaterThan90Predicate));
		System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
		System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
		
		
		//sorting
		
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator
				.comparingInt(Course::getNoOfStudents);
		
		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator
				.comparingInt(Course::getNoOfStudents).reversed();
		
		Comparator<Course> comparingByNoOfStudentsAndReviewScore = Comparator
				.comparingInt(Course::getNoOfStudents)
				.thenComparingInt(Course::getReviewScore).reversed();
		
		System.out.println(courses.stream()
								  .sorted(comparingByNoOfStudentsIncreasing)
								  .collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				  .sorted(comparingByNoOfStudentsDecreasing)
				  .collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				  .sorted(comparingByNoOfStudentsAndReviewScore)
				  .collect(Collectors.toList()));
		
		// top 5 -> [Microservices:25000:96, API:22000:97, Azure:21000:99, AWS:21000:92, Spring:20000:98]
		System.out.println(courses.stream()
				  .sorted(comparingByNoOfStudentsAndReviewScore)
				  .limit(5)
				  .collect(Collectors.toList()));
		
		
		// skip first 3 , and then print top 5
		//[AWS:21000:92, Spring:20000:98, Docker:20000:92, Kubernetes:20000:91, Spring Boot:18000:95]
		System.out.println(courses.stream()
				  .sorted(comparingByNoOfStudentsAndReviewScore)
				  .skip(3)
				  .limit(5)
				  .collect(Collectors.toList()));
		
		System.out.println(courses);
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96, FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
		
		
		//considers courses until review is >=95 and then its ignore the Rest from the point its first breaks
		//[Spring:20000:98, Spring Boot:18000:95, API:22000:97, Microservices:25000:96]
		System.out.println(courses.stream()
				  .takeWhile(course -> course.getReviewScore()>=95) 
				  .collect(Collectors.toList()));
		
		//drop the courses until review is >=95 and then its print the Rest from the point its first breaks
		//[FullStack:14000:91, AWS:21000:92, Azure:21000:99, Docker:20000:92, Kubernetes:20000:91]
		System.out.println(courses.stream()
				  .dropWhile(course -> course.getReviewScore()>=95) 
				  .collect(Collectors.toList()));
		
		System.out.println(
				courses.stream()
				.max(comparingByNoOfStudentsAndReviewScore));
		//Optional[FullStack:14000:91], the last course in the courses list

		System.out.println(
				courses.stream()
				.min(comparingByNoOfStudentsAndReviewScore)
				.orElse(new Course("Kubernetes", "Cloud", 91, 20000))
				);
				
		//Optional[Microservices:25000:96]
		//Microservices:25000:96 ,  the first course in the courses list
	
		System.out.println(
			courses.stream()
			.filter(reviewScoreLessThan90Predicate)
			.min(comparingByNoOfStudentsAndReviewScore)
			.orElse(new Course("Kubernetes", "Cloud", 91, 20000))
				);
		//Optional.empty , if no elements/course here is found ,then it executes the orElse part
		//Kubernetes:20000:91
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreLessThan90Predicate)
				.findFirst()
					);//Optional.empty // because it is empty as per the predicate
		

		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.findFirst()
					);//Optional[Spring:20000:98] // finds the first element that matches the predicate

		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.findAny()
					);//Optional[Spring:20000:98]
		//// find any one of the  element that matches the predicate
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getNoOfStudents)
				.sum());
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getNoOfStudents)
				.average());
		
		System.out.println(
				courses.stream()
				.filter(reviewScoreGreaterThan95Predicate)
				.mapToInt(Course::getNoOfStudents)
				.count());

		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory)));
		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,Collectors.counting())));
		
		System.out.println(
				courses.stream()
				.collect(Collectors
						.groupingBy(Course::getCategory,
								Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
		System.out.println(
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory,
						Collectors.mapping(Course::getName, Collectors.toList()))));
		
	}

}
