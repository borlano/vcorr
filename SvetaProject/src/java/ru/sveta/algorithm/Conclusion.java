package ru.sveta.algorithm;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class Conclusion extends Statement {

    public Conclusion(FuzzySet term, Variable variable) {
        super(term, variable);
    }
    private double weight;

    public double getWeight() {
//        return weight;
        return 1.0;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
