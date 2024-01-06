package ui;

import functions.factory.TabulatedFunctionFactory;

public class ChoosenFactory {

    public static ChoosenFactory instance;
    private TabulatedFunctionFactory factory;

    private ChoosenFactory() {
    }

    public static ChoosenFactory getInstance() {
        if (instance == null) {
            instance = new ChoosenFactory();
        }
        return instance;
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

}
