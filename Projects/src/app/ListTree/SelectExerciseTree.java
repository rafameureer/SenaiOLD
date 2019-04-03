package app.ListTree;

public class SelectExerciseTree {
    public SelectExerciseTree(Integer exerciseOption) {
        switch (exerciseOption) {
        case 1:
            new Number02();
            break;
        case 2:
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