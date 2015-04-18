package de.berlin.kata.dependency;

import java.util.*;

/**
 * Created by quan on 18.04.15.
 */
public class Dependencies {
    //TODO rename
    private Map<String, List<String>> dependencyMap = new HashMap<>();

    public void addDependencies(String word, String... dependencies) {
        dependencyMap.put(word, Arrays.asList(dependencies));
    }

    public List<String> getDependencies(String start) {
        Set<String> dependencyQueue = new LinkedHashSet<>(dependencyMap.get(start));
        Set<String> dependencies = new LinkedHashSet<>(dependencyMap.get(start));

        while (!dependencyQueue.isEmpty()) {
            String firstDependency = dependencyQueue.iterator().next();
            List<String> transitiveDependencies = dependencyMap.get(firstDependency);

            if (transitiveDependencies != null && !transitiveDependencies.isEmpty()) {
                dependencies.addAll(transitiveDependencies);
                dependencyQueue.addAll(transitiveDependencies);
            }

            //remove fist element
            dependencyQueue.remove(firstDependency);
        }

        List<String> result = new ArrayList<>(dependencies);
        Collections.sort(result);
        return result;
    }
}
