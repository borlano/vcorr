package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class VariablesPool {

    private List<Variable> variables;

    public VariablesPool() {
        initPool();
    }

    private void initPool() {
        this.variables = new ArrayList();
        TermsPool tp = new TermsPool();
        this.variables.add(new Variable(0, 0, 45, tp.getTermByName("k1_небольшой"), tp.getTermByName("k1_длительный")));
        this.variables.add(new Variable(1, 0, 9, tp.getTermByName("k2_низкий"), tp.getTermByName("k2_средний"), tp.getTermByName("k2_повышенный"), tp.getTermByName("k2_высокий")));
        this.variables.add(new Variable(2, 0, 9, tp.getTermByName("k3_аэробный"), tp.getTermByName("k3_анаэробный")));
        this.variables.add(new Variable(3, 0, 180, tp.getTermByName("k4_низкое"), tp.getTermByName("k4_среднее"), tp.getTermByName("k4_высокое")));
        this.variables.add(new Variable(4, 0, 9, tp.getTermByName("k5_некачественная"), tp.getTermByName("k5_качественная"), tp.getTermByName("k5_высококачественная")));
        this.variables.add(new Variable(5, 0, 4.5, tp.getTermByName("k6_высокая"), tp.getTermByName("k6_средняя"), tp.getTermByName("k6_низкая")));
        this.variables.add(new Variable(6, -0.1, 0.55, tp.getTermByName("k7_крайне низкий"), tp.getTermByName("k7_низкий"), tp.getTermByName("k7_средний"), tp.getTermByName("k7_высокий")));
        this.variables.add(new Variable(7, 0, 0.225, tp.getTermByName("k8_высокая"), tp.getTermByName("k8_средняя"), tp.getTermByName("k8_низкая")));
        this.variables.add(new Variable(8, 0, 12, tp.getTermByName("k9_кислый"), tp.getTermByName("k9_слабокислый"), tp.getTermByName("k9_нейтральный"), tp.getTermByName("k9_слабощелочной"), tp.getTermByName("k9_щелочной")));
        this.variables.add(new Variable(9, 0, 100, tp.getTermByName("k10_сухой"), tp.getTermByName("k10_влажный"), tp.getTermByName("k10_особовлажный")));
        this.variables.add(new Variable(10, -40, 40, tp.getTermByName("k11_высокая"), tp.getTermByName("k11_средняя"), tp.getTermByName("k11_низкая")));

        this.variables.add(new Variable(0, 0, 0.9, tp.getTermByName("v_повышенная"), tp.getTermByName("v_умеренная"), tp.getTermByName("v_низкая"), tp.getTermByName("v_средняя"), tp.getTermByName("v_высокая")));
    }

    public Variable getVariableById(int vId, boolean isOutput) {
        if (isOutput && vId == 0) {
            for (Variable v : variables) {
                if (v.getId() == vId && v.terms.size() == 5) {
                    return v;
                }
            }
        }
        for (Variable v : variables) {
            if (v.getId() == vId) {
                return v;
            }
        }
        return null;
    }

    public List<List<double[]>> getPlotOfVariable(int id, boolean isOutput) {
        System.out.println("getPlotOfVariable: id = " + id);
        List<List<double[]>> list = new ArrayList();
        Variable v = getVariableById(id, isOutput);
//        System.out.println("variable = " + v.);
        TermsPool tp = new TermsPool();
        for (FuzzySet s : v.terms) {
            System.out.println("current term is " + s.getName());
            List<double[]> plot = tp.getPlotPoints(s.getName(), v.getLeftBorder(), v.getRightBorder());
            list.add(plot);
        }

        return list;
    }
}
