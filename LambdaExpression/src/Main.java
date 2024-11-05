import java.sql.SQLOutput;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        LambdaExpression lambdaExpression = new LambdaExpression();
        lambdaExpression.funcInterface.abstractFun(10);
        LambdaWithCollections lambdaWithCollections= new LambdaWithCollections();
        System.out.println(lambdaWithCollections.sortUsingLambda());

        LambdaWithVariable lambdaWithVariable = new LambdaWithVariable();
        System.out.println(lambdaWithVariable.returnValue());

        LambdaWithInstanceVariable lambdaWithInstanceVariable = new LambdaWithInstanceVariable();
        lambdaWithInstanceVariable.interfaceDef();

    }
}