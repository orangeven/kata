package de.berlin.kata.wordChains;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;


public class Node {
    Node parentNode;
    private String value;
    private int weight = 0;

    public Node(String word) {
        this.value = word;
    }

    public Node getParentNode() {
        return parentNode;
    }

    // TODO add transition value
    public void setParentNode(Node parentNode) {
        if (parentNode != null) {
            int neuWeight = parentNode.weight + 1;
            if (weight == 0 || neuWeight < weight) {
                weight = parentNode.weight + 1;
                this.parentNode = parentNode;
            }
        }
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
        this.parentNode = null;
        this.weight = 0;
    }

    @Override
    public String toString() {
        return value + " : " + weight;
    }
}
