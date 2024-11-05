import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaWithCollections {
    public List<Integer> sortUsingLambda(){
        ArrayList<Integer> al = new ArrayList<Integer>();
        al.add(205);
        al.add(102);
        al.add(98);
        al.add(275);
        al.add(203);
        System.out.println("Elements of the ArrayList " +
                "before sorting : " + al);

        // using lambda expression in place of comparator object
        Collections.sort(al, (o1, o2) -> (o1 > o2) ? -1 :
                (o1 < o2) ? 1 : 0);
        return al;
    }
}
