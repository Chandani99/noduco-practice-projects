import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SpecialUseCases {
    public void parallelProcessing(){
        List<Integer> numbers = IntStream.range(1, 10000).boxed().collect(Collectors.toList());
        long count = numbers.parallelStream()
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println(count);
    }

    public void sortingElements(){
//      example of Number collection
        List<Integer> list = Arrays.asList(10,57,556,56,109, 20, 117);
        List<Integer> result = list.stream().sorted().collect(Collectors.toList());

        System.out.println("The sorted elements of the list are : "+result);


//        Example of string collection

        // Creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        // sorting the list of string based on character
        List<String> sortedList = words.stream()
                .sorted((word1, word2) -> word1.compareTo(word2)).collect(Collectors.toList());

        // Displaying the longest String
        System.out.println("Sorted list of string based on character : "+sortedList);

        // sorting the list of string based on length
        List<String> sortedListLength = words.stream()
                .sorted((word1, word2) -> word1.length() - word2.length()).collect(Collectors.toList());

        // Displaying the String
        System.out.println("Sorted list of string based on string length : "+sortedListLength);
    }

    public void sortingObjects(){
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student(1, "Chandani", "B.Tech"));
        allStudents.add(new Student(4, "Chandan", "High School"));
        allStudents.add(new Student(6, "Vandana", "B.A."));
        allStudents.add(new Student(3, "Aarti", "High school"));


        List<Student> result = allStudents.stream().sorted((obj1, obj2)->obj1.getId()-obj2.getId()).collect(Collectors.toList());
        System.out.println(result);
    }


    public void groupingData(){
        List<Student> allStudents = new ArrayList<>();
        allStudents.add(new Student(1, "Chandani", "B.Tech"));
        allStudents.add(new Student(4, "Chandan", "High School"));
        allStudents.add(new Student(6, "Vandana", "B.A."));
        allStudents.add(new Student(3, "Aarti", "High school"));
    }
}

class  Student{
    private Integer id;
    private String Name;
    private String course;

    public Student() {
        super();
    }
    public Student(Integer id, String name, String course) {
        this.id = id;
        Name = name;
        this.course = course;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}