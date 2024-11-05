import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NormaUseCases {

    public  void dataCollection(){
//        Example of Number collection
        List<Integer> list = Arrays.asList(10,57,556,56,109, 20, 117);
        List<Integer> result = list.stream().map(elem->elem+10).collect(Collectors.toList());

        System.out.println("mapped numbers with +10 : " +result);

//        Example of string collection
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> upperCaseNames = names.stream()
                .map(name->name.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("The upper case converted name : "+upperCaseNames);
    }

    public void dataAggrigation(){

//        example of Number collection
        List<Integer> list = Arrays.asList(10,57,556,56,109, 20, 117);
        int result = list.stream().reduce(0, (element1, element2) -> element1 + element2);

        System.out.println("Sum of integer elements are : "+result);


//        Example of string collection

        // Creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        // Using reduce to find the longest string in the list
        Optional<String> longestString = words.stream()
                .reduce((word1, word2) -> word1.length() > word2.length() ? word1 : word2);

        // Displaying the longest String
        longestString.ifPresent(System.out::println);
    }


    public void dataFiltering(){

//      example of Number collection
        List<Integer> list = Arrays.asList(10,57,556,56,109, 20, 117);
        List<Integer> result = list.stream().filter(element -> element % 2==0).collect(Collectors.toList());

        System.out.println("Sum of integer elements are : "+result);


//        Example of string collection

        // Creating a list of Strings
        List<String> words = Arrays.asList("GFG", "Geeks", "for", "GeeksQuiz", "GeeksforGeeks");

        // Using reduce to find the longest string in the list
        List<String> longestString = words.stream()
                .filter(word -> word.length() > 5 == true).collect(Collectors.toList());

        // Displaying the longest String
        System.out.println(longestString);
    }

}
