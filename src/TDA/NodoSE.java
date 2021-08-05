package TDA;

public class NodoSE<T> {
    
    private T info;
    private NodoSE<T> next;

    public NodoSE(T info, NodoSE<T> next) {
        this.info = info;
        this.next = next;
    }

    public NodoSE(T info){
        this.info = info;
        this.next = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public NodoSE<T> getNext() {
        return next;
    }

    public void setNext(NodoSE<T> next) {
        this.next = next;
    }
}
