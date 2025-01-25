package pij.day14solution.tree;

import org.junit.jupiter.api.Test;
import pij.day14.tree.Direction;
import pij.day14.tree.Position;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TreeTest {

    private static Tree<Integer> makeExampleTree() {
        Tree<Integer> tree = new Tree<>(
                new TreeNode<>(1,
                        new TreeNode<>(2,
                                new TreeNode<>(4),
                                new TreeNode<>(5)),
                        new TreeNode<>(3,
                                new TreeNode<>(6),
                                new TreeNode<>(7)))
        );
        return tree;
    }

    private static TreeNode<Integer> makeExampleTreeNode() {
        return new TreeNode<>(11, new TreeNode(12), null);
    }

    @Test
    public void testContainsTrueRoot() {
        Tree<Integer> t = makeExampleTree();
        final int DATA = 1;
        assertTrue(t.contains(DATA));
    }

    @Test
    public void testContainsTrueMiddle() {
        Tree<Integer> t = makeExampleTree();
        final int DATA = 3;
        assertTrue(t.contains(DATA));
    }

    @Test
    public void testContainsTrueLeaf() {
        Tree<Integer> t = makeExampleTree();
        final int DATA = 6;
        assertTrue(t.contains(DATA));
    }

    @Test
    public void testContainsFalse() {
        Tree<Integer> t = makeExampleTree();
        final int DATA = 234;
        assertFalse(t.contains(DATA));
    }


    @Test
    public void testToString() {
        String expected = "[1 L[2 L[4 L[] R[]] R[5 L[] R[]]] R[3 L[6 L[] R[]] R[7 L[] R[]]]]";
        Tree<Integer> t = makeExampleTree();
        String actual = t.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testToStringSimplified() {
        String expected = "[1 [2 [4] [5]] [3 [6] [7]]]";
        Tree<Integer> t = makeExampleTree();
        String actual = t.toStringSimplified();
        assertEquals(expected, actual);
    }

    @Test
    public void testHeightZero() {
        Tree<Integer> t = new Tree<>(new TreeNode<>(56));
        int expected = 0;
        int actual = t.height();
        assertEquals(expected, actual);
    }

    @Test
    public void testHeightPositive() {
        Tree<Integer> t = makeExampleTree();
        int expected = 2;
        int actual = t.height();
        assertEquals(expected, actual);
    }

    @Test
    public void testSizeZero() {
        Tree<Integer> t = new Tree<>();
        int expected = 0;
        int actual = t.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testSizePositive() {
        Tree<Integer> t = makeExampleTree();
        int expected = 7;
        int actual = t.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testCollectEmpty() {
        List<Integer> expected = List.of();
        Tree<Integer> t = new Tree<>();
        List<Integer> actual = new ArrayList<>();
        t.collect(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testCollectNonEmpty() {
        List<Integer> expected = List.of(4, 2, 5, 1, 6, 3, 7);
        Tree<Integer> t = makeExampleTree();
        List<Integer> actual = new ArrayList<>();
        t.collect(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void testHasPositionRootTrue() {
        Position p = new Position();
        Tree<Integer> t = makeExampleTree();
        assertTrue(t.hasPosition(p));
    }

    @Test
    public void testHasPositionMiddleTrue() {
        Position p = new Position(List.of(Direction.LEFT));
        Tree<Integer> t = makeExampleTree();
        assertTrue(t.hasPosition(p));
    }

    @Test
    public void testHasPositionLeafTrue() {
        Position p = new Position(List.of(Direction.LEFT, Direction.RIGHT));
        Tree<Integer> t = makeExampleTree();
        assertTrue(t.hasPosition(p));
    }

    @Test
    public void testHasPositionFalse() {
        Position p = new Position(List.of(Direction.LEFT, Direction.RIGHT, Direction.LEFT));
        Tree<Integer> t = makeExampleTree();
        assertFalse(t.hasPosition(p));
    }

    @Test
    public void testGet() {
        Position p = new Position(List.of(Direction.LEFT));
        Tree<Integer> t = makeExampleTree();
        int expected = 2;
        int actual = t.get(p);
        assertEquals(expected, actual);
    }

    @Test
    public void testPositionOfPresent() {
        Tree<Integer> t = makeExampleTree();
        final int DATA = 5;
        Position expected = new Position(List.of(Direction.LEFT, Direction.RIGHT));
        Position actual = t.positionOf(DATA);
        assertEquals(expected, actual);
    }

    @Test
    public void testPositionOfAbsent() {
        Tree<Integer> t = makeExampleTree();
        final int DATA = 42;
        Position actual = t.positionOf(DATA);
        assertNull(actual);
    }

    @Test
    public void testReplaceData() {
        Tree<Integer> t = makeExampleTree();
        final int DATA = 42;
        Position p = new Position(List.of(Direction.LEFT));
        t.replaceData(p, DATA);
        int actual = t.get(p);
        int expected = DATA;
        assertEquals(expected, actual);
    }

    @Test
    public void testInsertSubtree() {
        Tree<Integer> t = makeExampleTree();
        TreeNode<Integer> replacement = makeExampleTreeNode();
        Position p = new Position(List.of(Direction.RIGHT));
        t.insertSubtree(p, replacement);
        List<Integer> expected = List.of(4, 2, 5, 1, 12, 11);
        List<Integer> actual = new ArrayList<>();
        t.collect(actual);
        assertEquals(expected, actual);
    }
}
