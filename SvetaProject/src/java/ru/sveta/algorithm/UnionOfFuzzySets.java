package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class UnionOfFuzzySets implements FuzzySetInterface {

    private List<FuzzySet> fuzzySets;

    public UnionOfFuzzySets() {
        this.fuzzySets = new ArrayList();

    }

    public UnionOfFuzzySets(List<FuzzySet> fuzzySets) {
        this.fuzzySets = fuzzySets;
    }

    public void addFuzzySet(FuzzySet set) {
        this.fuzzySets.add(set);
    }

    private double getMaxValue(double x) {
        double result = 0.0;
        for (FuzzySet fuzzySet : fuzzySets) {
            result = Math.max(result, fuzzySet.getActivatedValue(x));
//            result = Math.max(result, fuzzySet.getValue(x));
        }
        return result;
    }

    public double integrate(int steps, boolean withX) {
        double from = findLeftBorder();
        double to = findRightBorder();
        double sum = 0.0;
        double f1, f2;

        System.out.println("integrating from " + from + " to " + to);

        if (to < from) {
            return 0;
        }

        double delta_x = (to - from)
                / (double) steps;

        if (!withX) {
            f1 = getMaxValue(from);
            for (int i = 0; i < steps; i++) {
                f2 = getMaxValue(from + (i + 1) * delta_x);
                sum += 0.5 * (f1 + f2) * delta_x;
                f1 = f2;
            }
        } else {
            f1 = from * getMaxValue(from);
            for (int i = 0; i < steps; i++) {
                f2 = (from + (i + 1) * delta_x) * getMaxValue(from + (i + 1) * delta_x);
                sum += 0.5 * (f1 + f2) * delta_x;
                f1 = f2;
            }
        }

        return sum;
    }

    private double findLeftBorder() {
        double f0 = -50.0;
        double delta = 0.001;
        while (f0 < 190 && (getMaxValue(f0) == 0)) {
//            System.out.println("seraching for left border: f(" + (new Double(f0)).toString() + ")=" + (new Double(getMaxValue(f0))).toString());
            f0 += delta;
        }
        return f0 - delta;
    }

    private double findRightBorder() {
        double f0 = 190;
        double delta = 0.001;
        while (f0 > -50 && (getMaxValue(f0) == 0)) {
            f0 -= delta;
        }
        return f0 + delta;
    }

    @Override
    public double getValue(double x) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setName(String name) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
