package org.dainn.functions;

import java.util.ArrayList;
import java.util.List;

public class SumResult {
    private final String sum;
    private final List<String> steps;

    public SumResult(String sum, List<String> steps) {
        this.sum = sum;
        this.steps = new ArrayList<>(steps);
    }

    public String getSum() {
        return sum;
    }

    public List<String> getSteps() {
        return steps;
    }
}
