import java.util.Objects;

public class Student {
    int age;
    int height;
    int weight;
    int size;
    String name;
    String surname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (height != student.height) return false;
        if (weight != student.weight) return false;
        if (size != student.size) return false;
        if (!Objects.equals(name, student.name)) return false;
        return Objects.equals(surname, student.surname);
    }


    // сломанный хешкод
    @Override
    public int hashCode() {
        return 5;
    }
}
