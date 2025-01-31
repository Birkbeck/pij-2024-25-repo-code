package pij.day15solution.expression;

public class IntExpressionDriver {
    public static void main(String[] args) {
        IntExpression intExp1 = new IntConstant(9);
        IntExpression intExp2 = new IntConstant(3);
        IntExpression intExp3 = new IntConstant(15);
        IntExpression intExp4 = new IntConstant(6);
        IntExpression plusExp = new PlusExpression(intExp1, intExp2);
        IntExpression divExp = new DivExpression(intExp3, intExp4);
        IntExpression timesExp = new TimesExpression(plusExp, divExp);
        System.out.println(timesExp + " = " + timesExp.value());
        System.out.println(timesExp + " has " + timesExp.numberOfNodes() + " nodes");
    }

}
