package de.berlin.kata.dependency;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DependenciesTest {

    @Test
    public void testTransitiveDependencies() {
        Dependencies dependencies = new Dependencies();

        dependencies.addDependencies("A", "B", "C");
        dependencies.addDependencies("B", "C", "E");
        dependencies.addDependencies("C", "G");
        dependencies.addDependencies("D", "A", "F");
        dependencies.addDependencies("E", "F");
        dependencies.addDependencies("F", "H");

        assertArrayEquals(new String[]{"B", "C", "E", "F", "G", "H"}, dependencies.getDependencies("A").toArray());
        assertArrayEquals(new String[]{"C", "E", "F", "G", "H"}, dependencies.getDependencies("B").toArray());
        assertArrayEquals(new String[]{"G"}, dependencies.getDependencies("C").toArray());
        assertArrayEquals(new String[]{"A", "B", "C", "E", "F", "G", "H"}, dependencies.getDependencies("D").toArray());
        assertArrayEquals(new String[]{"F", "H"}, dependencies.getDependencies("E").toArray());
        assertArrayEquals(new String[]{"H"}, dependencies.getDependencies("F").toArray());
    }
}
