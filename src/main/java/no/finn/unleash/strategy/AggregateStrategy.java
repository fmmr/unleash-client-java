package no.finn.unleash.strategy;

import java.util.List;
import java.util.Map;

/**
 * Contains a list of other stratetgy.  <code>isEnabled</code> is <code>true</code> if <strong>any</strong> of the strategies
 * are <code>true</code>.
 */
public abstract class AggregateStrategy implements Strategy {

    protected final List<Strategy> strategies;

    protected AggregateStrategy(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    public boolean isEnabled(Map<String, String> parameters) {
        // if this is a java8 projects the following could be used
        // strategies.stream().filter(strategy -> strategy.isEnabled(parameters)).findAny().isPresent();
        for (Strategy strategy : strategies) {
            if (strategy.isEnabled(parameters)) {
                return true;
            }
        }
        return false;
    }
}
