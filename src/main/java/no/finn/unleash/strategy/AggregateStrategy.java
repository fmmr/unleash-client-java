package no.finn.unleash.strategy;

import java.util.List;
import java.util.Map;

public abstract class AggregateStrategy implements Strategy {

    protected final List<Strategy> strategies;

    protected AggregateStrategy(List<Strategy> strategies) {
        this.strategies = strategies;
    }

    public boolean isEnabled(Map<String, String> parameters) {
        for (Strategy strategy : strategies) {
            if (strategy.isEnabled(parameters)) {
                return true;
            }
        }
        return false;
    }
}
