package krusk;



import java.util.ArrayList;
import java.util.Collections;

/**
 * Clase que modela la ciudad
 * @author Javier
 */
public class Ciudad {
    
    private int Cantidad_Cruces;//atributo para guardar la cantidad de cruces(vertices)
    private ArrayList<Calle> Calles;//lista de calles(aristas)
    
    public Ciudad(int cantidad_cruces){
        this.Cantidad_Cruces = cantidad_cruces;
        this.Calles = new ArrayList<>();
    }
    /**
     * Metodo que agrega una calle 
     * @param a calle que se agregara
     */
    public void AgregarCalle(Calle a){
        Calles.add(a);
    }
    /*
    Metodo para ordenar de menor a mayor las calles segun el largo
    */
    public void ordenarCalles(){
        Collections.sort(Calles);
    }

    public int getCantidad_Cruces() {
        return Cantidad_Cruces;
    }

    public ArrayList<Calle> getCalles() {
        return Calles;
    }

    public void setCalles(ArrayList<Calle> calles) {
        this.Calles = calles;
    }
    
}
