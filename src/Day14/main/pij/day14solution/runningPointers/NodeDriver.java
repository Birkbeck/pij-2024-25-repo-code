package pij.day14solution.runningPointers;

public class NodeDriver {
    public static void main(String[] args) {
        final int LENGTH_TO_NULL = 12;
        final int STEM_LENGTH = 15;
        final int CYCLE_LENGTH = 21;

        Node<String> listEndingInNull = Node.makeListEndingInNull(LENGTH_TO_NULL);
        Node<String> lasso = Node.makeListEndingInCycle(STEM_LENGTH, CYCLE_LENGTH);

        System.out.println("listEndingInNull.endsInNull(): " + listEndingInNull.endsInNull());
        System.out.println("lasso.endsInNull(): " + lasso.endsInNull());
    }
}
