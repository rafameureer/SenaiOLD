package app.ListTwo;

public class SelectExerciseTwo {
    public SelectExerciseTwo(Integer exerciseOption) {
        switch (exerciseOption) {
        case 1:
            new Select();
            break;
        case 2:
            new SepareteOddAndEven();
            break;
        case 3:
            new Average();
            break;
        case 4:
            new ConvertNumbersForNegative();
            break;
        case 5:
            new HigherPositionLowerPosition();
            break;
        case 6:
            new IsLeapYear();
            break;
        case 7:
            new FastFood();
            break;
        case 8:
            new Number08();
            break;
        case 9:
            new Number09();
            break;
        default:
            break;
        }
    }
}