package de.berlin.kata.dependency;

import java.util.*;
import java.util.stream.Collectors;

public class DependencyManager {
    private Map<String, List<String>> dependencyMap = new HashMap<>();

    public void addDependencies(String word, String... dependencies) {
        this.dependencyMap.put(word, Arrays.asList(dependencies));
    }

    public List<String> getDependencies(String start) {
        List<String> dependencies = new ArrayList<>(this.dependencyMap.get(start));

        for(int i=0;i<dependencies.size();i++) {
            String dependency = dependencies.get(i);
            List<String> transitiveDependencies = this.dependencyMap.get(dependency);

            if (transitiveDependencies != null ) {
                dependencies.addAll(transitiveDependencies);
                dependencies = getUniqueDependencies(dependencies);
            }
        }

        Collections.sort(dependencies);
        return dependencies;
    }

    private List<String> getUniqueDependencies(List<String> dependencies) {
        return dependencies.stream().distinct().collect(Collectors.toList());
    }
}
