package app.ListTree;

public class SelectExerciseTree {
    public SelectExerciseTree(Integer exerciseOption) {
        switch (exerciseOption) {
        case 1:
            // validação das notas, deve ser entre 0 e 10, validação dos pesos, deve ser
            // considerado 10
            //validação de peso ainda está errada
            new Number02();
            break;
        case 2:
            // mostrar no mesmo lugar
            new Select();
            break;
        case 3:
            new PurchaseDiscount();
            break;
        case 4:
            new ConvertTemperature();
            break;
        default:
            break;
        }
    }
}