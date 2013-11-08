package ru.sveta.algorithm;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class ActivatedFuzzySet extends FuzzySet {

    private double truthDegree;

//    private double getActivatedValue(double x) {
//        return Math.min(super.getValue(x), truthDegree);
//    }

    public void setTruthDegree(double truthDegree) {
        this.truthDegree = truthDegree;
    }
}
