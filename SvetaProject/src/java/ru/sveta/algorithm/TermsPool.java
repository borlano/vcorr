package ru.sveta.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class TermsPool {

//    private static TermsPool instance;
    private Set<FuzzySet> terms;

//    public static TermsPool getIntstance() {
//        if (instance == null) {
//            instance = new TermsPool();
//        }
//        return instance;
//    }
    public TermsPool() {
        initPool();
    }

    private void initPool() {
        this.terms = new HashSet();
        this.terms.addAll(initK1Terms());
        this.terms.addAll(initK2Terms());
        this.terms.addAll(initK3Terms());
        this.terms.addAll(initK4Terms());
        this.terms.addAll(initK5Terms());
        this.terms.addAll(initK6Terms());
        this.terms.addAll(initK7Terms());
        this.terms.addAll(initK8Terms());
        this.terms.addAll(initK9Terms());
        this.terms.addAll(initK10Terms());
        this.terms.addAll(initK11Terms());
        this.terms.addAll(initVTerms());
    }

    public FuzzySet getTermByName(String name) {
        for (FuzzySet set : terms) {
            if (name.equals(set.getName())) {
                return set;
            }
        }
        return null;
    }

    /**
     * 1. срок эксплуатации газопровода (Т, годы);
     *
     * @return
     */
    private Set<FuzzySet> initK1Terms() {
        //небольшой, длительный
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k1_небольшой");
                    }

                    @Override
                    public double getValue(double x) {
                        return (new TrapMF(-40.5, -4.5, 10, 20)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k1_длительный");
            }

            @Override
            public double getValue(double x) {
                return (new TrapMF(10, 20, 49.5, 85.5)).getValue(x);
                //[10 20 49.5 85.5]
            }
        });

        return set;
    }

    /**
     * 2. уровень напряжений в стенках газопровода (σ, МПа);
     *
     * @return
     */
    private Set<FuzzySet> initK2Terms() {
        //низкий, средний, повышенный, высокий
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k2_низкий");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-2.7 -0.3 1 3]
//                        return (new TrapMF(-2.7, -0.3, 1, 3)).getValue(x);
                        return (new TrapMF(-2.7, -0.3, 1, 3)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k2_средний");
            }

            @Override
            public double getValue(double x) {
                //[2 3 3 5]
//                return (new TrapMF(2, 3, 3, 5)).getValue(x);
                return (new TrapMF(2, 3, 3, 5)).getValue(x);

            }
        });
        set.add(new FuzzySet() {

            {
                setName("k2_повышенный");
            }

            @Override
            public double getValue(double x) {
                //[4 5 5 7]
//                return (new TrapMF(4, 5, 5, 7)).getValue(x);
                return (new TrapMF(4, 5, 5, 7)).getValue(x);
            }
        });
        set.add(new FuzzySet() {

            {
                setName("k2_высокий");
            }

            @Override
            public double getValue(double x) {
                //[6 7 9.3 11.7]
//                return (new TrapMF(6, 7, 9.3, 11.7)).getValue(x);
                return (new TrapMF(6, 7, 9.3, 11.7)).getValue(x);
            }
        });

        return set;
    }

    /**
     * 3. степень анаэробности грунта;
     *
     * @return
     */
    private Set<FuzzySet> initK3Terms() {
        //аэробный, анаэробный
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k3_аэробный");
                    }

                    @Override
                    public double getValue(double x) {
                        //[2 6 9.36 12.2]
                        return (new TrapMF(2, 6, 9.36, 12.2)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k3_анаэробный");
            }

            @Override
            public double getValue(double x) {
                //[-3.24 -0.36 2 7]
                return (new TrapMF(-3.24, -0.36, 2, 7)).getValue(x);
            }
        });

        return set;
    }

    /**
     * 4. удельное электрическое сопротивление грунта (ρ, Ом·м);
     *
     * @return
     */
    private Set<FuzzySet> initK4Terms() {
        //низкое, среднее, высокое
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k4_низкое");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-64.8 -7.2 20 60]
                        return (new TrapMF(-64.8, -7.2, 20, 60)).getValue(x);

                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k4_среднее");
            }

            @Override
            public double getValue(double x) {
                //[49.5238095238095 59.5238095238095 79.5238095238095 119.52380952381]
                return (new TrapMF(49.5238095238095, 59.5238095238095, 79.5238095238095, 119.52380952381)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k4_высокое");
            }

            @Override
            public double getValue(double x) {
                //[80 120 187 244]
                return (new TrapMF(80, 120, 187, 244)).getValue(x);
            }
        });

        return set;
    }

    /*
     * 5. марка стали;
     */
    private Set<FuzzySet> initK5Terms() {
        //некачественная, качественная, высококачественная
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k5_некачественная");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-3.6 0 3]
                        return (new TriMF(-3.6, 0, 3)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k5_качественная");
            }

            @Override
            public double getValue(double x) {
                //[2 5 6.5]
                return (new TriMF(2, 5, 6.5)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k5_высококачественная");
            }

            @Override
            public double getValue(double x) {
                //[5.5 7 9.36 12.2]
                return (new TrapMF(5.5, 7, 9.36, 12.2)).getValue(x);
            }
        });

        return set;
    }

    /**
     * 6. ионная сила грунтовой влаги (μ, к-ион/куб.дм);
     *
     * @return
     */
    private Set<FuzzySet> initK6Terms() {
        //высокая, средняя, низкая
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k6_низкая");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-1.62 -0.18 0.45 1.35]
                        return (new TrapMF(-1.62, -0.18, 0.45, 1.35)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k6_средняя");
            }

            @Override
            public double getValue(double x) {
                //[1 2 2.5]
                return (new TriMF(1, 2, 2.5)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k6_высокая");
            }

            @Override
            public double getValue(double x) {
                //[2 3.5 4.68 6.12]
                return (new TrapMF(2, 3.5, 4.68, 6.12)).getValue(x);
            }
        });

        return set;
    }

    /**
     * 7. окислительно-восстановительный потенциал грунта, редокс-потенциал (E,
     * В);
     *
     * @return
     */
    private Set<FuzzySet> initK7Terms() {
        //крайне низкий, низкий, средний, высокий
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k7_крайне низкий");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-0.334 -0.126 -0.05 0]
                        return (new TrapMF(-0.334, -0.126, -0.05, 0)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k7_низкий");
            }

            @Override
            public double getValue(double x) {
                //[0 0.05 0.1]
                return (new TriMF(0, 0.05, 0.1)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k7_средний");
            }

            @Override
            public double getValue(double x) {
                //[0.075 0.3 0.4]
                return (new TriMF(0.075, 0.3, 0.4)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k7_высокий");
            }

            @Override
            public double getValue(double x) {
                //[0.376719576719577 0.451719576719577 0.561719576719577 0.561719576719577]
                return (new TrapMF(40.376719576719577, 0.451719576719577, 0.561719576719577, 0.561719576719577)).getValue(x);
            }
        });

        return set;
    }

    /**
     * 8. средняя плотность катодного тока (I, А/кв.м);
     *
     * @return
     */
    private Set<FuzzySet> initK8Terms() {
        //высокая, средняя, низкая
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k8_низкая");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-0.081 -0.009 0.025 0.075]
                        return (new TrapMF(-0.081, -0.009, 0.025, 0.075)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k8_средняя");
            }

            @Override
            public double getValue(double x) {
                //[0.05 0.1 0.15 0.2]
                return (new TrapMF(0.05, 0.1, 0.15, 0.2)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k8_высокая");
            }

            @Override
            public double getValue(double x) {
                //[0.175 0.2 0.228 0.304]
                return (new TrapMF(0.175, 0.2, 0.228, 0.304)).getValue(x);
            }
        });

        return set;
    }

    /**
     * 9. уровень рН грунта;
     *
     * @return
     */
    private Set<FuzzySet> initK9Terms() {
        //кислый, слабокислый, нейтральный, слабощелочной, щелочной
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k9_кислый");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-4.32 -0.48 5 5.5]
                        return (new TrapMF(-4.32, -0.48, 5, 5.5)).getValue(x);

                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k9_слабокислый");
            }

            @Override
            public double getValue(double x) {
                //[5 6 6.75]
                return (new TriMF(5, 6, 6.75)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k9_нейтральный");
            }

            @Override
            public double getValue(double x) {
                //[6.5 7 7.5]
                return (new TriMF(6.5, 7, 7.5)).getValue(x);
            }
        });
        set.add(new FuzzySet() {

            {
                setName("k9_слабощелочной");
            }

            @Override
            public double getValue(double x) {
                //[7.35 8 9]
                return (new TriMF(7.35, 8, 9)).getValue(x);
            }
        });
        set.add(new FuzzySet() {

            {
                setName("k9_щелочной");
            }

            @Override
            public double getValue(double x) {
                //[8.5 9 12.4 12.6]
                return (new TrapMF(8.5, 9, 12.4, 12.6)).getValue(x);

            }
        });

        return set;
    }

    /**
     * 10. влажность грунта (W, %);
     *
     * @return
     */
    private Set<FuzzySet> initK10Terms() {
        //сухой, влажный, особовлажный
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k10_сухой");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-36 -4 15 30]
                        return (new TrapMF(-36, -4, 15, 30)).getValue(x);

                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k10_влажный");
            }

            @Override
            public double getValue(double x) {
                //[25 33.5 61 69.1798941798942]
                return (new TrapMF(25, 33.5, 61, 69.1798941798942)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k10_особовлажный");
            }

            @Override
            public double getValue(double x) {
                //[65 85 104 136]
                return (new TrapMF(65, 85, 104, 136)).getValue(x);
            }
        });

        return set;
    }

    /**
     * 11. температура стенки газопровода (t, °C).
     *
     * @return
     */
    private Set<FuzzySet> initK11Terms() {
        //высокая, средняя, низкая
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("k11_низкая");
                    }

                    @Override
                    public double getValue(double x) {
                        //[-68.8 -43.2 -25 0]
                        return (new TrapMF(-68.8, -43.2, -25, 0)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("k11_средняя");
            }

            @Override
            public double getValue(double x) {
                //[-3.5 5 15 23.5]
                return (new TrapMF(-3.5, 5, 15, 23.5)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("k11_высокая");
            }

            @Override
            public double getValue(double x) {
                //[20 30 43.2 68.8]
                return (new TrapMF(20, 30, 43.2, 68.8)).getValue(x);
            }
        });

        return set;
    }

    private Set<FuzzySet> initVTerms() {
        //повышенная, умеренная, низкая, средняя, высокая
        Set<FuzzySet> set = new HashSet();
        set.add(
                new FuzzySet() {

                    {
                        setName("v_повышенная");
                    }

                    @Override
                    public double getValue(double x) {
                        //[0.5 0.6 0.8]
                        return (new TriMF(0.5, 0.6, 0.8)).getValue(x);
                    }
                });

        set.add(new FuzzySet() {

            {
                setName("v_умеренная");
            }

            @Override
            public double getValue(double x) {
                //[0.1 0.3 0.4]
                return (new TriMF(0.1, 0.3, 0.4)).getValue(x);
            }
        });

        set.add(new FuzzySet() {

            {
                setName("v_низкая");
            }

            @Override
            public double getValue(double x) {
                //[-0.324 -0.036 0.1 0.2]
                return (new TrapMF(-0.324, -0.036, 0.1, 0.2)).getValue(x);
            }
        });
        set.add(new FuzzySet() {

            {
                setName("v_средняя");
            }

            @Override
            public double getValue(double x) {
                //[0.3 0.4 0.5 0.6]
                return (new TrapMF(0.3, 0.4, 0.5, 0.6)).getValue(x);
            }
        });
        set.add(new FuzzySet() {

            {
                setName("v_высокая");
            }

            @Override
            public double getValue(double x) {
                //[0.7 0.8 0.99 1.71]
                return (new TrapMF(0.7, 0.8, 0.99, 1.71)).getValue(x);
            }
        });

        return set;
    }

    public List<double[]> getPlotPoints(String name, double from, double to) {
        System.out.println("getPlotPoints: name = " + name + "; from = " + from + "; to = " + to);
        List<double[]> list = new ArrayList();
        double step = (to  - from) / 300;
        FuzzySet term = getTermByName(name);
        for (double x = from; x < to; x += step) {
            double[] a = new double[2];
            a[0] = x;
            a[1] = term.getValue(x);
//            System.out.println("adding f(" + x +") = " + term.getValue(x));
            list.add(a);
        }
        return list;
    }
}
