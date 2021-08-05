package TDA;

public class NodoDE<T> {
    private T info;
    private NodoDE<T> next;
    private NodoDE<T> previous;

    public NodoDE(T info, NodoDE<T> next, NodoDE<T> previous) {
        this.info = info;
        this.next = next;
        this.previous = previous;
    }

    public NodoDE(T info) {
        this.info = info;
        this.next = null;
        this.previous = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoDE<T> getNext() {
        return next;
    }

    public void setNext(NodoDE<T> next) {
        this.next = next;
    }

    public NodoDE<T> getPrevious() {
        return previous;
    }

    public void setPrevious(NodoDE<T> previous) {
        this.previous = previous;
    }
    
    
}
