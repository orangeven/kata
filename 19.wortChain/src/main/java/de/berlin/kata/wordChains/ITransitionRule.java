package de.berlin.kata.wordChains;

/**
 * @author weng
 *         created: 21.04.15 - 18:00
 */
public interface ITransitionRule {

    boolean hasTransition(Node startNode, Node endNode);

}
