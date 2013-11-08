package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class Variable {

    private int id;
    public List<FuzzySet> terms;
    private double leftBorder, rightBorder;

    public Variable(int id, double left, double right, FuzzySet... iTerms) {
        this.id = id;
        this.leftBorder = left;
        this.rightBorder = right;
        this.terms = new ArrayList();
        for (FuzzySet ft : iTerms) {
            this.terms.add(ft);
        }
    }

    public double getLeftBorder() {
        return leftBorder;
    }

    public void setLeftBorder(double leftBorder) {
        this.leftBorder = leftBorder;
    }

    public double getRightBorder() {
        return rightBorder;
    }

    public void setRightBorder(double rightBorder) {
        this.rightBorder = rightBorder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
