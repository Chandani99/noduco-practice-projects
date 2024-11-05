public class LambdaWithVariable {

    public int returnValue(){
//        int number = 10;

        MyFunction myLambda = (n) ->
        {
            int number = 10;
            // This use of number is OK It does not modify
            // num
            int value = number + n;

            // However, the following is illegal because it
            // attempts to modify the value of number

            // number++;
            return value;
        };
        int result = myLambda.func(20);
        return result;
    }

}
interface MyFunction {

    // Method inside the interface
    int func(int n);
}