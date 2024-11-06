//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello and welcome!");
        NormaUseCases normaUseCases = new NormaUseCases();
        normaUseCases.dataAggrigation();
        normaUseCases.dataCollection();
        normaUseCases.dataFiltering();

        SpecialUseCases specialUseCases = new SpecialUseCases();
        specialUseCases.parallelProcessing();
        specialUseCases.sortingElements();
        specialUseCases.sortingObjects();

    }
}