package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class Experiment {

    private MamdaniAlgorithm alg;
    private List<Rule> rules;

    public Experiment() {
        init();
    }

    private void init() {
        this.alg = new MamdaniAlgorithm(35, 44, 11, 1, 35);
        System.out.println("recreating alg");
        this.rules = (new RulesPool()).getRules();
    }

    public double execute(double[] inputData) {
        double result = this.alg.execute(inputData, this.rules);
        System.out.println("result = " + result);
        return result;
    }
}
