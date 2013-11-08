package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class MamdaniAlgorithm {

    private static final int stepsAmount = 100000;
    private int numberOfConclusions;
    private int numberOfConditions;
    private int numberOfInputVariables;
    private int numberOfOutputVariables;
    private int numberOfRules;
    private List<Rule> rules;

    public MamdaniAlgorithm(int numberOfConclusions, int numberOfConditions, int numberOfInputVariables, int numberOfOutputVariables, int numberOfRules) {
        this.numberOfConclusions = numberOfConclusions;
        this.numberOfConditions = numberOfConditions;
        this.numberOfInputVariables = numberOfInputVariables;
        this.numberOfOutputVariables = numberOfOutputVariables;
        this.numberOfRules = numberOfRules;
    }

    private void printDoubleArray(double[] array) {
        for (double d : array) {
            System.out.println(d);
        }
    }

    private void printSet(List<FuzzySet> set) {
        for (FuzzySet s : set) {
            System.out.println("name = " + s.getName() + "; truthDegree = " + s.getTruthDegree());
        }
    }

    private double[] fuzzification(double[] inputData) {
        System.out.println("fuzzification started: inputData = ");
        printDoubleArray(inputData);
        int i = 0;
        double[] b = new double[numberOfConditions];
        for (Rule rule : rules) {
            for (Condition condition : rule.getConditions()) {
                int j = condition.getVariable().getId();
                FuzzySet term = condition.getTerm();
                b[i] = term.getValue(inputData[j]);
                i++;
            }
        }
//        System.out.println("fuzzification completed: b = ");
//        printDoubleArray(b);

        return b;
    }

    private double[] aggregation(double[] b) {
//        System.out.println("aggregation started: b = ");
//        printDoubleArray(b);

        int i = 0;
        int j = 0;
//        double[] c = new double[numberOfInputVariables];
        double[] c = new double[numberOfRules];
        for (Rule rule : rules) {
            double truthOfConditions = 1.0;
            for (Condition condition : rule.getConditions()) {
                truthOfConditions = Math.min(truthOfConditions, b[i]);
                i++;
            }
            c[j] = truthOfConditions;
            j++;
        }
//        System.out.println("aggregation completed: c = ");
//        printDoubleArray(c);

        return c;
    }

    private List<FuzzySet> activation(double[] c) {
//        System.out.println("activation started: c = " + c);
//        printDoubleArray(c);

        int i = 0;
        List<FuzzySet> activatedFuzzySets = new ArrayList<FuzzySet>();
        double[] d = new double[numberOfConclusions];
        for (Rule rule : rules) {
            for (Conclusion conclusion : rule.getConclusions()) {
                d[i] = c[i] * conclusion.getWeight();
                FuzzySet activatedFuzzySet = (new TermsPool()).getTermByName(conclusion.getTerm().getName());//!!!!!!
                activatedFuzzySet.setTruthDegree(d[i]);
//                System.out.println("setting truthDegree = " + d[i] + " to " + activatedFuzzySet.getName() + " (c[i] = " + c[i] +")");
                activatedFuzzySets.add(activatedFuzzySet);
                i++;
            }
        }
        System.out.println("activation completed: activatedFuzzySets = ");
        printSet(activatedFuzzySets);
        return activatedFuzzySets;
    }

    private void printActivatedSet(FuzzySet set) {
        System.out.println("name = " + set.getName() + " ; truthDegree = " + set.getTruthDegree());
    }

    private List<UnionOfFuzzySets> accumulation(List<FuzzySet> activatedFuzzySets) {
        List<UnionOfFuzzySets> unionsOfFuzzySets =
                new ArrayList<UnionOfFuzzySets>();

        for (int i = 0; i < numberOfOutputVariables; i++) {
            unionsOfFuzzySets.add(new UnionOfFuzzySets());
        }
        int f = 0;
        for (Rule rule : rules) {
            for (Conclusion conclusion : rule.getConclusions()) {
                int id = conclusion.getVariable().getId();
                System.out.println("addingActivatedFuzzySet = ");
                printActivatedSet(activatedFuzzySets.get(f));
                unionsOfFuzzySets.get(id).addFuzzySet(activatedFuzzySets.get(f));
                f++;
            }
        }
        return unionsOfFuzzySets;
    }

    private double[] defuzzification(List<UnionOfFuzzySets> unionsOfFuzzySets) {
        double[] y = new double[numberOfOutputVariables];
        for (int i = 0; i < numberOfOutputVariables; i++) {
            double i1 = unionsOfFuzzySets.get(i).integrate(stepsAmount, true);
            double i2 = unionsOfFuzzySets.get(i).integrate(stepsAmount, false);
            y[i] = i1 / i2;
        }
        return y;
    }

    public double execute(double[] inputData, List<Rule> rules) {
        this.rules = rules;
        double[] fuzzificated = fuzzification(inputData);
        double[] aggregated = aggregation(fuzzificated);
        List<FuzzySet> activated = activation(aggregated);
        List<UnionOfFuzzySets> accumulated = accumulation(activated);
        double[] defuzzificated = defuzzification(accumulated);
        System.out.println("defuzzificated = ");
        printDoubleArray(defuzzificated);
        return defuzzificated[0];
    }
}
