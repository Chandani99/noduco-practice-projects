import java.sql.SQLOutput;

public class LambdaExpression {
     FuncInterface funcInterface = (int x)-> {
         x = x * 2;
         System.out.println(x);
     };

}

interface FuncInterface
{
    // An abstract function
    void abstractFun(int x);

    // A non-abstract (or default) function
    default void normalFun()
    {
        System.out.println("Hello");
    }
}