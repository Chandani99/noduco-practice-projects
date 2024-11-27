import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Java11Features {
    public void newStringMthodExample(){

        // isBlank() example
        String str1 = "";
        System.out.println(str1.isBlank());

        String str2 = "GeeksForGeeks";
        System.out.println(str2.isBlank());

        // repeat() Example

        // Java Program to demonstrate

        String str = "GeeksForGeeks";
        System.out.println(str.repeat(4));

         // the working of stripLeading() method


        String str3 = " GeeksForGeeks";
        System.out.println(str3.stripLeading());

        //the working of stripTrailing() method

        String str4 = "GeeksForGeeks " ;
        System.out.println(str4.stripTrailing());

        //the working of strip() method

        String str5 = " GeeksForGeeks " ;
        System.out.println(str5.strip());


    }

    public void optionalNewMethod(){
        List<Integer> list = Arrays.asList(10,2,45, 67, 7, 44);
        List<Integer> result = list.stream().filter(a-> a%2 ==0).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        Java11Features java11Features = new Java11Features();
        java11Features.newStringMthodExample();

    }
}
