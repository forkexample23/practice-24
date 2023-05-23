import java.util.Comparator;

public class NameAgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student s1, Student s2) {
        if (s1.getName().compareTo(s2.getName()) != 0) {
            return s1.getName().compareTo(s2.getName());
        }
        return s1.getAge() - s2.getAge();
    }
}
