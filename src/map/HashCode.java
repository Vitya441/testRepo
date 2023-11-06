package map;

import java.util.Objects;
import java.util.Map;
import java.util.HashMap;

/* Переопределил equals() - переопредели и hashCode().
 * Стандатрная реализация (equals и hashCode), унаследованная от Object счиает каждый объект уникальным.
 *  */

public class HashCode {
	public static void main(String[] args) {
		
		Map<Student, Double> map = new HashMap<>();
		Student st1 = new Student("Zaur", "Tregulov", 3);
		Student st2 = new Student("Mariya", "Ivanova", 1);
		Student st3 = new Student("Sergey", "Petrov", 4);
		map.put(st1, 7.5);
		map.put(st2, 8.7);
		map.put(st3, 9.2);
		System.out.println(map);
	
		Student st4 = new Student("Zaur", "Tregulov", 3);
		System.out.println("equals = " + st1.equals(st4)); // если не переопределить hashCode, хэш-коды будут разными,
		System.out.println(st1.hashCode());  // даже если они равны по equals
		System.out.println(st4.hashCode());
		System.out.println(map.containsKey(st4)); // Map сравнивает хэш-коды, по-этому hashCode нужно переопределить
	
	}
	
}
class Student {
	String name;
	String surname;
	int course;
	
	public Student(String name, String surname, int course) {
		this.name = name;
		this.surname = surname;
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Student{" + "name='" + name + "', surname='" + surname +
				"', course=" + course + "}";
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Student student = (Student) obj; // downcasting - Object спустился вниз по иерархии и стал студентом
		return Objects.equals(course, student.course)
				&& Objects.equals(name, student.name)
				&& Objects.equals(surname, student.surname);
	}
	@Override
	public int hashCode() {
		return Objects.hash(name, surname, course);
	}
	
	
	
	
	
	
	
}