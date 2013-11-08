package ru.sveta.algorithm;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class TriMF extends StandartMF {

//    public TriMF() {
//        this.countParams = 3;
//        this.paramsMF = new Double[this.countParams];
//    }

    public TriMF(double a, double b, double c) {
        this.countParams = 3;
        this.paramsMF = new Double[this.countParams];
        this.paramsMF[0] = a;
        this.paramsMF[1] = b;
        this.paramsMF[2] = c;
    }

    @Override
    public Double[] GetDiscreteFunction(Double[] x) {

        Double a = this.paramsMF[0],
                b = this.paramsMF[1],
                c = this.paramsMF[2];
        int n = x.length;
        Double[] func = new Double[n];

        for (int i = 0; i < n; i++) {
            if (x[i] <= a) {
                func[i] = new Double(0);
            } else if (x[i] > a && x[i] <= b) {
                func[i] = (x[i] - a) / (b - a);
            } else if (x[i] > b && x[i] <= c) {
                func[i] = (c - x[i]) / (c - b);
            } else if (x[i] >= c) {
                func[i] = new Double(0);
            }
        }
        return func;
    }

    @Override
    public Double[] GetInitialParams(Double lp, Double rp) {
        return new Double[]{lp, (rp - lp) / 2.0, rp};
    }

    @Override
    public Double getValue(Double x) {
        Double[] xx = new Double[1];
        xx[0] = x;
        return GetDiscreteFunction(xx)[0];
    }
}