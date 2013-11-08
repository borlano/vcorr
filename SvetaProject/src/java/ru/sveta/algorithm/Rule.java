package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class Rule {

    private List<Conclusion> conclusions;
    private List<Condition> conditions;

    public Rule(List<Conclusion> conclusions, List<Condition> conditions) {
        this.conclusions = conclusions;
        this.conditions = conditions;
    }

    public Rule() {
        this.conclusions = new ArrayList();
        this.conditions = new ArrayList();
    }

    public List<Conclusion> getConclusions() {
        return conclusions;
    }

    public void setConclusions(List<Conclusion> conclusions) {
        this.conclusions = conclusions;
    }

    public void setConclusions(Conclusion... cus) {
        for (Conclusion c : cus) {
            this.conclusions.add(c);
        }
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public void setConditions(Condition... cis) {
        for (Condition c : cis) {
            this.conditions.add(c);
        }
    }
}
