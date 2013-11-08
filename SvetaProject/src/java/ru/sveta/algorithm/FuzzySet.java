package ru.sveta.algorithm;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class FuzzySet implements FuzzySetInterface {

    private String name;
    private double truthDegree;

    @Override
    public double getValue(double x) {
        System.out.println("if i'm printed then there is a mistake");
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public double getActivatedValue(double x) {
        return Math.min(getValue(x), truthDegree);
    }

    public void setTruthDegree(double truthDegree) {
        this.truthDegree = truthDegree;
    }

    public double getTruthDegree() {
        return truthDegree;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
