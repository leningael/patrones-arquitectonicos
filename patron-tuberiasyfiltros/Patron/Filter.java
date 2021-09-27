package Patron;

public abstract class Filter {
    private Filter nextFilter;

    protected abstract Object procesar(Object entrada);

    public Object ejecutar(Object entrada){
        Object valor = procesar(entrada);
        if (this.nextFilter != null) 
            valor = this.nextFilter.ejecutar(valor);
        return valor;
    }

    public void registrar(Filter filter){
        if (this.nextFilter == null) 
            this.nextFilter = filter;
        else this.nextFilter.registrar(filter);
    }
}