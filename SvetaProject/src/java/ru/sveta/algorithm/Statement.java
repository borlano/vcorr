package ru.sveta.algorithm;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class Statement {

    private FuzzySet term;
    private Variable variable;

    public Statement(FuzzySet term, Variable variable) {
        this.term = term;
        this.variable = variable;
    }

    
    
    public FuzzySet getTerm() {
        return term;
    }

    public void setTerm(FuzzySet term) {
        this.term = term;
    }

    public Variable getVariable() {
        return variable;
    }

    public void setVariable(Variable variable) {
        this.variable = variable;
    }
}
