package de.berlin.kata.wordChains;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by quan on 16.04.15.
 */
public class Node {
    Node previousNode;
    private String value;
    private int weigh = 0;

    public int getWeigh() {
        return weigh;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setPreviousNode(Node previousNode) {
        if (previousNode.weigh < weigh + 1) {
            weigh = previousNode.weigh + 1;
            this.previousNode = previousNode;
        }
    }

    public Node(String word) {
        this.value = word;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(value).hashCode();
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
}
