package TDA;

import Utiles.FueraDeRango;
import Utiles.ColeccionVacia;

public interface ILista<T> {
    void Adicionar(T value);
    void Insertar(int pos, T value)throws FueraDeRango;
    T Obtener(int pos) throws FueraDeRango, ColeccionVacia;
    void Eliminar(int pos)throws FueraDeRango, ColeccionVacia;
    boolean Vacia();
    int Longitud();
}
