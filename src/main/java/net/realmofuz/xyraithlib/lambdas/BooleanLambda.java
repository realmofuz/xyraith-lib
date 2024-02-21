package net.realmofuz.xyraithlib.lambdas;

import net.realmofuz.xyraithlib.types.SingleSelection;

@FunctionalInterface
public interface BooleanLambda {
    boolean run(SingleSelection location);
}
