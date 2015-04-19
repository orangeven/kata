package de.berlin.kata.dependency;


import org.junit.Test;

import static org.junit.Assert.*;

public class DependencyManagerTest {

    @Test
    public void testTransitiveDependencies() {
        DependencyManager dependencyManager = new DependencyManager();

        dependencyManager.addDependencies("A", "B", "C");
        dependencyManager.addDependencies("B", "C", "E");
        dependencyManager.addDependencies("C", "G");
        dependencyManager.addDependencies("D", "A", "F");
        dependencyManager.addDependencies("E", "F");
        dependencyManager.addDependencies("F", "H");

        assertArrayEquals(new String[]{"B", "C", "E", "F", "G", "H"}, dependencyManager.getDependencies("A").toArray());
        assertArrayEquals(new String[]{"C", "E", "F", "G", "H"}, dependencyManager.getDependencies("B").toArray());
        assertArrayEquals(new String[]{"G"}, dependencyManager.getDependencies("C").toArray());
        assertArrayEquals(new String[]{"A", "B", "C", "E", "F", "G", "H"}, dependencyManager.getDependencies("D").toArray());
        assertArrayEquals(new String[]{"F", "H"}, dependencyManager.getDependencies("E").toArray());
        assertArrayEquals(new String[]{"H"}, dependencyManager.getDependencies("F").toArray());
    }

    @Test
    public void testBoundaryValues(){
        DependencyManager dependencyManager = new DependencyManager();

        dependencyManager.addDependencies("A", new String[]{});
        assertArrayEquals(new String[]{}, dependencyManager.getDependencies("A").toArray());
    }

    @Test
    public void testCycleDependencies() {
        DependencyManager dependencyManager = new DependencyManager();

        dependencyManager.addDependencies("A", "B");
        dependencyManager.addDependencies("B", "C");
        dependencyManager.addDependencies("C", "A");

        assertArrayEquals(new String[]{"B", "C"}, dependencyManager.getDependencies("A").toArray());
        assertArrayEquals(new String[]{"A", "C"}, dependencyManager.getDependencies("B").toArray());
        assertArrayEquals(new String[]{"A","B"}, dependencyManager.getDependencies("C").toArray());
    }
}
