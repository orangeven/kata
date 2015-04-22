package de.berlin.kata.dependency;

import java.util.*;

public class DependencyManager {
    private Map<String, List<String>> dependencyMap = new HashMap<>();

    public void addDependencies(String component, String... dependencies) {
        this.dependencyMap.put(component, Arrays.asList(dependencies));
    }

    public List<String> getDependencies(String component) {
        List<String> dependencies = new ArrayList<>(this.dependencyMap.get(component));

        for (int i = 0; i < dependencies.size(); i++) {
            String dependency = dependencies.get(i);
            List<String> transitiveDependencies = this.dependencyMap.get(dependency);

            if (transitiveDependencies != null) {
                addUniqueDependencies(dependencies, transitiveDependencies);
            }
        }

        // remove self.
        dependencies.remove(component);
        Collections.sort(dependencies);
        return dependencies;
    }

    private void addUniqueDependencies(List<String> dependencies, List<String> transitiveDependencies) {
        transitiveDependencies.forEach(newDependency -> {
            if (!dependencies.contains(newDependency)) {
                dependencies.add(newDependency);
            }
        });
    }
}
