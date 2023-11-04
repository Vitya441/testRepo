import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> persons = Data.getPersons(); // исходный список

        List<Person> persons2 = persons.stream()
                .filter(p -> p.getAge() > 40)
                .collect(Collectors.toList());

        persons2.forEach(System.out::println);
//        persons2.forEach(p -> System.out.println(p) );


//                .filter(p -> p.getAge() > 30)
//                .sorted()
//                .collect(Collectors.toList());

//        Optional<Person> person = persons.stream()
//                .filter(p -> p.getAge() > 30 )
//                .findFirst();

//        long count = persons.stream()
//                .filter(p -> p.getAge() > 30)
//                .count();


//        System.out.println(count);




    }
}