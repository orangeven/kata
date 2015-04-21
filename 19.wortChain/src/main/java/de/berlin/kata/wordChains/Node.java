package de.berlin.kata.wordChains;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by quan on 16.04.15.
 */
public class Node {
    Node previousNode;
    private String value;
    private int weight = 0;

    public Node(String word) {
        this.value = word;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Node)) {
            return false;

        }
        if (obj == this) {

            return true;
        }

        Node other = (Node) obj;
        return new EqualsBuilder().append(other.value, value).isEquals();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(value).hashCode();
    }

    public void reset() {
        this.previousNode = null;
        this.weight = 0;
    }

    // TODO add transition value
    public void setPreviousNode(Node previousNode) {
        if (previousNode.weight < weight + 1) {
            weight = previousNode.weight + 1;
            this.previousNode = previousNode;
        }
    }
}
