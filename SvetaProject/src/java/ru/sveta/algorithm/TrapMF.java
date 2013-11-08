package ru.sveta.algorithm;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public class TrapMF extends StandartMF {

    public TrapMF() {
        this.countParams = 4;
        this.paramsMF = new Double[this.countParams];
    }

    public TrapMF(double a, double b, double c, double d) {
        this.countParams = 4;
        this.paramsMF = new Double[this.countParams];
        this.paramsMF[0] = a;
        this.paramsMF[1] = b;
        this.paramsMF[2] = c;
        this.paramsMF[3] = d;
    }

    @Override
    public Double[] GetDiscreteFunction(Double[] x) {

        Double a = this.paramsMF[0],
                b = this.paramsMF[1],
                c = this.paramsMF[2],
                d = this.paramsMF[3];

        int n = x.length;
        Double[] func = new Double[n];
        for (int i = 0; i < n; i++) {
            if (x[i] <= a) {
                func[i] = new Double(0);
            } else if (x[i] <= b) {
                func[i] = (x[i] - a) / (b - a);
            } else if (x[i] <= c) {
                func[i] = new Double(1);
            } else if (x[i] <= d) {
                func[i] = (d - x[i]) / (d - c);
            } else if (d <= x[i]) {
                func[i] = new Double(0);
            }
        };
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