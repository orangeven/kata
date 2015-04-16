package de.berlin.kata.wordChains;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

/**
 * Created by quan on 16.04.15.
 */
public class Transition {
    Node from;
    Node to;

    public Node getFrom() {
        return from;
    }

    public void setFrom(Node from) {
        this.from = from;
    }


    public Node getTo() {
        return to;
    }

    public void setTo(Node to) {
        this.to = to;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(from).append(to).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
              if (!(obj instanceof Transition)) {
            return false;

              }
        if (obj == this){

            return true;
        }

        Transition other = (Transition) obj;
        return new EqualsBuilder().append(other.getFrom(), from).append(other.getTo(), to).isEquals();
    }
}
