package app.Extra;

public class SelectExerciseExtra {
    public SelectExerciseExtra(Integer exerciseOption) {
        switch (exerciseOption) {
        case 1:
            new BiggerAndSmaller();
            break;
        case 2:
            new Vector();
            break;
        case 3:
            new Average();
            break;
        case 4:
            new SelectLineInMatrix();
            break;
        default:
            break;
        }
    }
}