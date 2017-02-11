package version8;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.nullsLast;
import static java.util.Comparator.reverseOrder;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import bean.Person;

public class TestLogic {

	public void comparatorTest() {

		final List<Person> people = Arrays.asList(
				new Person("Boo", 20),
				new Person("John", 20),
				new Person(null, 0), 
				new Person("Sara", 21),
				new Person("Jane", 21), 
				new Person("Jane", 35), 
				new Person("Greg", 35));

		people.stream().forEach(s -> System.out.println(s.getAge() + ":" + s.getName()));
		// sorted() このメソッドは与えられたコレクションを変更することなく、ソートされてたコレクションを返す。
		// Stream<T> sorted(Comparator<? super T> comparator)
		List<Person> resultList;

		// 完成型(昇順) nullを考慮する場合は以下のようにする必要がある。
		resultList = people.stream()
				.sorted(comparing(Person::getName, nullsLast(naturalOrder())).thenComparing(Person::getAge))
				.collect(toList());

		printPeople("Age,Name共に昇順: ", resultList);
		// 完成型（降順） さらに降順と昇順を混在させるには以下のようにする
		resultList = people.stream()
				.sorted(comparing(Person::getName, nullsLast(reverseOrder())).thenComparing(Person::getAge))
				.collect(toList());

		printPeople("Age降順、Name昇順: ", resultList);

		/*
		 * Comparatorの再利用
		 */

		// 昇順Comparator
		final Comparator<Person> compareAsc = comparing(Person::getName, nullsLast(naturalOrder()))
				.thenComparing(Person::getAge);
		// 降順Comparator
		final Comparator<Person> compareDec = comparing(Person::getName, nullsLast(reverseOrder()))
				.thenComparing(Person::getAge);

		// 降順Comparator 名前、年齢ともに降順
		final Comparator<Person> compareDecAsc = comparing(Person::getName, nullsLast(reverseOrder()))
				.thenComparing(Person::getAge, reverseOrder());

		resultList = this.sortList(people, compareAsc);
		printPeople("Age,Name共に昇順: ", resultList);

		resultList = this.sortList(people, compareDec);
		printPeople("Age,Name共に昇順: ", resultList);
		
		resultList = this.sortList(people, compareDecAsc);
		printPeople("Age,Name共に降順: ", resultList);
	}

	/**
	 * Comparatorの再利用
	 * 
	 * @param list
	 * @param comparator
	 * @return Sortedリスト
	 */
	private <E> List<E> sortList(List<E> list, Comparator<E> comparator) {
		return list.stream().sorted(comparator).collect(toList());
	}

	public static void printPeople(final String message, final List<Person> people) {

		System.out.println(message);
		people.forEach(System.out::println);
	}

}
