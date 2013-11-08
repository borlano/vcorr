package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class RulesPool {

    private List<Rule> rules;

    public RulesPool() {
        this.rules = new ArrayList();
        initPool();
    }

    public List<Rule> getRules() {
        return rules;
    }

    private void initPool() {
        TermsPool tp = new TermsPool();
        VariablesPool vp = new VariablesPool();
        //Rule1
        Rule rule1 = new Rule();
        rule1.setConditions(new Condition(tp.getTermByName("k1_небольшой"), vp.getVariableById(0, false)), new Condition(tp.getTermByName("k3_анаэробный"), vp.getVariableById(2, false)));
        rule1.setConclusions(new Conclusion(tp.getTermByName("v_повышенная"), vp.getVariableById(0, true)));
        //end of Rule1

        //Rule2
        Rule rule2 = new Rule();
        rule2.setConditions(new Condition(tp.getTermByName("k1_длительный"), vp.getVariableById(0, false)), new Condition(tp.getTermByName("k3_анаэробный"), vp.getVariableById(2, false)));
        rule2.setConclusions(new Conclusion(tp.getTermByName("v_умеренная"), vp.getVariableById(0, true)));
        //end of Rule2


        //Rule3
        Rule rule3 = new Rule();
        rule3.setConditions(new Condition(tp.getTermByName("k3_аэробный"), vp.getVariableById(2, false)));
        rule3.setConclusions(new Conclusion(tp.getTermByName("v_повышенная"), vp.getVariableById(0, true)));
        //end of Rule3


        //Rule4
        Rule rule4 = new Rule();
        rule4.setConditions(new Condition(tp.getTermByName("k2_низкий"), vp.getVariableById(1, false)));
        rule4.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule4



        //Rule5
        Rule rule5 = new Rule();
        rule5.setConditions(new Condition(tp.getTermByName("k2_средний"), vp.getVariableById(1, false)));
        rule5.setConclusions(new Conclusion(tp.getTermByName("v_умеренная"), vp.getVariableById(0, true)));
        //end of Rule5



        //Rule6
        Rule rule6 = new Rule();
        rule6.setConditions(new Condition(tp.getTermByName("k2_повышенный"), vp.getVariableById(1, false)));
        rule6.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule6



        //Rule7
        Rule rule7 = new Rule();
        rule7.setConditions(new Condition(tp.getTermByName("k2_высокий"), vp.getVariableById(1, false)));
        rule7.setConclusions(new Conclusion(tp.getTermByName("v_повышенная"), vp.getVariableById(0, true)));
        //end of Rule7


        //Rule8
        Rule rule8 = new Rule();
        rule8.setConditions(new Condition(tp.getTermByName("k4_низкое"), vp.getVariableById(3, false)));
        rule8.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule8



        //Rule9
        Rule rule9 = new Rule();
        rule9.setConditions(new Condition(tp.getTermByName("k4_среднее"), vp.getVariableById(3, false)));
        rule9.setConclusions(new Conclusion(tp.getTermByName("v_умеренная"), vp.getVariableById(0, true)));
        //end of Rule9



        //Rule10
        Rule rule10 = new Rule();
        rule10.setConditions(new Condition(tp.getTermByName("k4_высокое"), vp.getVariableById(3, false)));
        rule10.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule10


        //Rule11
        Rule rule11 = new Rule();
        rule11.setConditions(new Condition(tp.getTermByName("k5_высококачественная"), vp.getVariableById(4, false)));
        rule11.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule11


        //Rule12
        Rule rule12 = new Rule();
        rule12.setConditions(new Condition(tp.getTermByName("k5_качественная"), vp.getVariableById(4, false)));
        rule12.setConclusions(new Conclusion(tp.getTermByName("v_умеренная"), vp.getVariableById(0, true)));
        //end of Rule12


        //Rule13
        Rule rule13 = new Rule();
        rule13.setConditions(new Condition(tp.getTermByName("k5_некачественная"), vp.getVariableById(4, false)));
        rule13.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule13

        //Rule14
        Rule rule14 = new Rule();
        rule14.setConditions(new Condition(tp.getTermByName("k6_высокая"), vp.getVariableById(5, false)));
        rule14.setConclusions(new Conclusion(tp.getTermByName("v_высокая"), vp.getVariableById(0, true)));
        //end of Rule14


        //Rule15
        Rule rule15 = new Rule();
        rule15.setConditions(new Condition(tp.getTermByName("k6_средняя"), vp.getVariableById(5, false)));
        rule15.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule15


        //Rule16
        Rule rule16 = new Rule();
        rule16.setConditions(new Condition(tp.getTermByName("k6_низкая"), vp.getVariableById(5, false)));
        rule16.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule16


        //Rule17
        Rule rule17 = new Rule();
        rule17.setConditions(new Condition(tp.getTermByName("k7_высокий"), vp.getVariableById(6, false)));
        rule17.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule17


        //Rule18
        Rule rule18 = new Rule();
        rule18.setConditions(new Condition(tp.getTermByName("k7_средний"), vp.getVariableById(6, false)));
        rule18.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule18


        //Rule19
        Rule rule19 = new Rule();
        rule19.setConditions(new Condition(tp.getTermByName("k7_низкий"), vp.getVariableById(6, false)));
        rule19.setConclusions(new Conclusion(tp.getTermByName("v_повышенная"), vp.getVariableById(0, true)));
        //end of Rule19


        //Rule20
        Rule rule20 = new Rule();
        rule20.setConditions(new Condition(tp.getTermByName("k7_крайне низкий"), vp.getVariableById(6, false)));
        rule20.setConclusions(new Conclusion(tp.getTermByName("v_высокая"), vp.getVariableById(0, true)));
        //end of Rule20


        //Rule21
        Rule rule21 = new Rule();
        rule21.setConditions(new Condition(tp.getTermByName("k8_низкая"), vp.getVariableById(7, false)), new Condition(tp.getTermByName("k4_среднее"), vp.getVariableById(3, false)));
        rule21.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule21


        //Rule22
        Rule rule22 = new Rule();
        rule22.setConditions(new Condition(tp.getTermByName("k8_средняя"), vp.getVariableById(7, false)), new Condition(tp.getTermByName("k4_низкое"), vp.getVariableById(3, false)));
        rule22.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule22



        //Rule23
        Rule rule23 = new Rule();
        rule23.setConditions(new Condition(tp.getTermByName("k8_высокая"), vp.getVariableById(7, false)), new Condition(tp.getTermByName("k4_низкое"), vp.getVariableById(3, false)));
        rule23.setConclusions(new Conclusion(tp.getTermByName("v_повышенная"), vp.getVariableById(0, true)));
        //end of Rule23


        //Rule24
        Rule rule24 = new Rule();
        rule24.setConditions(new Condition(tp.getTermByName("k9_кислый"), vp.getVariableById(8, false)));
        rule24.setConclusions(new Conclusion(tp.getTermByName("v_высокая"), vp.getVariableById(0, true)));
        //end of Rule24


        //Rule25
        Rule rule25 = new Rule();
        rule25.setConditions(new Condition(tp.getTermByName("k9_слабокислый"), vp.getVariableById(8, false)));
        rule25.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule25


        //Rule26
        Rule rule26 = new Rule();
        rule26.setConditions(new Condition(tp.getTermByName("k9_нейтральный"), vp.getVariableById(8, false)));
        rule26.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule26


        //Rule27
        Rule rule27 = new Rule();
        rule27.setConditions(new Condition(tp.getTermByName("k9_слабощелочной"), vp.getVariableById(8, false)));
        rule27.setConclusions(new Conclusion(tp.getTermByName("v_средняя"), vp.getVariableById(0, true)));
        //end of Rule27


        //Rule28
        Rule rule28 = new Rule();
        rule28.setConditions(new Condition(tp.getTermByName("k9_щелочной"), vp.getVariableById(8, false)));
        rule28.setConclusions(new Conclusion(tp.getTermByName("v_высокая"), vp.getVariableById(0, true)));
        //end of Rule28


        //Rule29
        Rule rule29 = new Rule();
        rule29.setConditions(new Condition(tp.getTermByName("k10_сухой"), vp.getVariableById(9, false)));
        rule29.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule29

        //Rule30
        Rule rule30 = new Rule();
        rule30.setConditions(new Condition(tp.getTermByName("k10_влажный"), vp.getVariableById(9, false)), new Condition(tp.getTermByName("k3_анаэробный"), vp.getVariableById(2, false)));
        rule30.setConclusions(new Conclusion(tp.getTermByName("v_умеренная"), vp.getVariableById(0, true)));
        //end of Rule30


        //Rule31
        Rule rule31 = new Rule();
        rule31.setConditions(new Condition(tp.getTermByName("k10_влажный"), vp.getVariableById(9, false)), new Condition(tp.getTermByName("k3_аэробный"), vp.getVariableById(2, false)));
        rule31.setConclusions(new Conclusion(tp.getTermByName("v_повышенная"), vp.getVariableById(0, true)));
        //end of Rule31


        //Rule32
        Rule rule32 = new Rule();
        rule32.setConditions(new Condition(tp.getTermByName("k10_особовлажный"), vp.getVariableById(9, false)));
        rule32.setConclusions(new Conclusion(tp.getTermByName("v_умеренная"), vp.getVariableById(0, true)));
        //end of Rule32

        //Rule33
        Rule rule33 = new Rule();
        rule33.setConditions(new Condition(tp.getTermByName("k11_низкая"), vp.getVariableById(10, false)));
        rule33.setConclusions(new Conclusion(tp.getTermByName("v_низкая"), vp.getVariableById(0, true)));
        //end of Rule33


        //Rule34
        Rule rule34 = new Rule();
        rule34.setConditions(new Condition(tp.getTermByName("k11_средняя"), vp.getVariableById(10, false)), new Condition(tp.getTermByName("k10_влажный"), vp.getVariableById(9, false)));
        rule34.setConclusions(new Conclusion(tp.getTermByName("v_повышенная"), vp.getVariableById(0, true)));
        //end of Rule34

        //Rule35
        Rule rule35 = new Rule();
        rule35.setConditions(new Condition(tp.getTermByName("k11_высокая"), vp.getVariableById(10, false)), new Condition(tp.getTermByName("k10_влажный"), vp.getVariableById(9, false)));
        rule35.setConclusions(new Conclusion(tp.getTermByName("v_высокая"), vp.getVariableById(0, true)));
        //end of Rule35

        this.rules.add(rule1);
        this.rules.add(rule2);
        this.rules.add(rule3);
        this.rules.add(rule4);
        this.rules.add(rule5);
        this.rules.add(rule6);
        this.rules.add(rule7);
        this.rules.add(rule8);
        this.rules.add(rule9);
        this.rules.add(rule10);
        this.rules.add(rule11);
        this.rules.add(rule12);
        this.rules.add(rule13);
        this.rules.add(rule14);
        this.rules.add(rule15);
        this.rules.add(rule16);
        this.rules.add(rule17);
        this.rules.add(rule18);
        this.rules.add(rule19);
        this.rules.add(rule20);
        this.rules.add(rule21);
        this.rules.add(rule22);
        this.rules.add(rule23);
        this.rules.add(rule24);
        this.rules.add(rule25);
        this.rules.add(rule26);
        this.rules.add(rule27);
        this.rules.add(rule28);
        this.rules.add(rule29);
        this.rules.add(rule30);
        this.rules.add(rule31);
        this.rules.add(rule32);
        this.rules.add(rule33);
        this.rules.add(rule34);
        this.rules.add(rule35);
    }
}
