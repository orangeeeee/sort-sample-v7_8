package version8;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import bean.Person;

public class TestLogic {

	public void comparatorTest() {

		final List<Person> people = Arrays.asList(
	    	      new Person("John", 20),
	    	      new Person(null, 22),
	    	      new Person("Sara", 21),
	    	      new Person("Jane", 21),
	    	      new Person("Greg", 35));

		/**
		 * 完成型(昇順)
		 * nullを考慮する場合は以下のようにする必要がある。
		 */
	      List<Person> testParsonList= people.stream()
		            .sorted(comparing(Person::getName, nullsLast(naturalOrder()))
		            .thenComparing(Person::getAge))
		            .collect(toList());

	    printPeople("Sorted in ascending order by age and name: ",testParsonList);

		/**
		 * 完成型（降順）
		 * さらに降順と昇順を混在させるには以下のようにする
		 *
		 */
	      List<Person> testParsonList2= people.stream()
	            .sorted(comparing(Person::getName, nullsLast(reverseOrder()))
	            .thenComparing(Person::getAge))
	            .collect(toList());

		    printPeople("Sorted in ascending order by age and name: ",testParsonList2);

	}

	public static void printPeople(final String message, final List<Person> people) {

		System.out.println(message);
		people.forEach(System.out::println);
	}
	
}
