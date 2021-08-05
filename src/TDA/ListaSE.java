
package TDA;


import Utiles.FueraDeRango;
import Utiles.ColeccionVacia;

public class ListaSE<T> implements ILista<T>{

    protected NodoSE<T> head;
    protected NodoSE<T> end;
    protected int length;

    public ListaSE() {
        head = end = null;
        length = 0;
    }
    
    @Override
    public void Adicionar(T value) {
        
        if(Vacia())
            head = end = new NodoSE(value); 
        else
        {
            end.setNext(new NodoSE(value));
            end = end.getNext();
        }
        length++;       
    }

    @Override
    public void Insertar(int pos, T value)throws FueraDeRango{
        if(pos < 0 || pos > length)
            throw new FueraDeRango("Error!!! Posición fuera de rango");
        
        if(pos == 0)
            head = new NodoSE(value,head);
        else
            if(pos == length)
            {
                end.setNext(new NodoSE(value));
                end = end.getNext();
            }
            else
            {
                NodoSE<T> cursor = head;
                while(pos-- != 1)
                    cursor = cursor.getNext();
                
                cursor.setNext(new NodoSE(value,cursor.getNext()));
            }
        length++;
    }

    @Override
    public T Obtener(int pos) throws FueraDeRango, ColeccionVacia{
        if(pos < 0 || pos >= length)
            throw new FueraDeRango("Error!!! Posición fuera de rango");
        
        if(Vacia())
            throw new ColeccionVacia("Lista Vacía");
        
        NodoSE<T> cursor = head;
        while(pos-- !=0)
            cursor = cursor.getNext();
        
        return cursor.getInfo();
    }

    @Override
    public void Eliminar(int pos) throws FueraDeRango, ColeccionVacia {
        if(pos < 0 || pos >= length)
            throw new FueraDeRango("Error!!! Posición fuera de rango");
        
        if(Vacia())
            throw new ColeccionVacia("Lista Vacía");
        
        if(pos == 0)
            head = head.getNext();
        else
        {
            NodoSE<T> cursor = head;
            while(pos-- !=1)
                cursor = cursor.getNext();
            
            cursor.setNext(cursor.getNext().getNext());
            if(cursor.getNext() == null)
                end = cursor;
        }
            
        length--;
    }

    @Override
    public boolean Vacia() {
        return head == null;
    }

    @Override
    public int Longitud() {
        return length;
    }
    
    @Override
    public String toString() {
        
        String cadena = "";
        NodoSE<T> cursor = head;
        int pos = length-1;
        
        while(pos-- !=0){
            cadena += cursor.getInfo() + ", ";
            cursor = cursor.getNext();
        }
        cadena += cursor.getInfo();
        
        return cadena; 
    }
    
    public void InvertirLista(){
        int pos = length;
        ListaSE<T> auxSe = new ListaSE<>();

        while (pos-- > 0) {
            try {
                auxSe.Adicionar(Obtener(pos));
            } catch (FueraDeRango | ColeccionVacia e) {
                e.printStackTrace();
            }
        }

        int r = -1;
        NodoSE<T> cursor = head;

        while (r++ < length) {
            try {
                cursor.setInfo(auxSe.Obtener(r));
            } catch (FueraDeRango | ColeccionVacia e) {
                e.printStackTrace();
            }

            if (cursor.getNext() == null)
                end = cursor;  
            else 
                cursor = cursor.getNext();
        }

    }

}
