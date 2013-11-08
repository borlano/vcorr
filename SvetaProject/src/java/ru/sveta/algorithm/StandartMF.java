package ru.sveta.algorithm;

/**
 *
 * @author Shaykhlislamov Sabir (email: sha-sabir@yandex.ru)
 */
public abstract class StandartMF {

    public int countParams;
    public Double[] paramsMF;

    public abstract Double[] GetDiscreteFunction(Double[] x);
    
    public abstract Double getValue(Double x);

    public abstract Double[] GetInitialParams(Double lp, Double rp);
}