import java.util.*;

public class Main {
    public static void main(String[] args) {

        Student[] studentArr = {
                new Student("Alex", 20),
                new Student("Maria", 35),
                new Student("Ivan", 30),
                new Student("Kirill", 60),
                new Student("Kirill", 55)
        };

        List<Student> students = new ArrayList<>(List.of(studentArr));

//        Collections.sort(students);
//        Arrays.sort(studentArr);

//        System.out.println(students);
//        System.out.println(Arrays.toString(studentArr));
//
//        Collections.sort(students, new NameComparator());
//        Collections.sort(students, new NameAgeComparator());

        students.sort(new NameComparator().thenComparing(new AgeComparator())); // same as NameAgeComparator
        // thenComparing принимает компаратор и возвращает новый компаратор из двух старых

        System.out.println(students);

        // допустим Employee не имеют Comparable реализации

//        Comparator<Employee> employeeIdSalaryComparator = new EmployeeIdComparator().thenComparingLong(Employee::getSalary);
        Comparator<Employee> employeeIdSalaryComparator = new EmployeeIdComparator().thenComparingLong(e -> e.getSalary());
        // thenComparingLong (int, double) принимает ссылку на метод

        Collection<Student> studentCollection = students;



    }

}