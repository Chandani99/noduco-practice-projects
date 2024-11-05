import java.sql.SQLOutput;

public class LambdaWithInstanceVariable {
    int data = 100;
    public void interfaceDef(){
        MyInterface intFace = () -> {
            System.out.println("Data: " + this.data);
            this.data += 500;
            System.out.println("Data after modification: " + this.data);
        };
        intFace.myFunction();
        System.out.println(this.data);
    }
}
interface MyInterface {
    void myFunction();
}