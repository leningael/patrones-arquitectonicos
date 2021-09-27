package Patron;

public class Pipe {
    private Filter pump;

    public Object ejecutar(Object entrada){
        return this.pump.ejecutar(entrada);
    }

    public Pipe registrar(Filter filter) {
        if (this.pump == null)
            this.pump = filter;
        else 
            this.pump.registrar(filter);
        return this;
    }
}