package krusk;


/**
 * Clase que Modela la calle de la ciudad 
 * 
 * @author Javier
 */
public class Calle implements Comparable<Calle>{
    private int cruce_inicio;//atributo para guardar el cruce inicial de la calle
    private int cruce_llegada;//atributo para guardar el cruce de final de la calle
    private double largo;//atributo para guardar el largo de la calle
    
    public Calle(int cruce_inicio,int cruce_llegada,double largo){
        this.cruce_inicio = cruce_inicio;
        this.cruce_llegada = cruce_llegada;
        this.largo = largo;
    }
    
    public int getVertice_llegada() {
        return cruce_llegada;           
    }
    public int getVertice_inicio() {
        return cruce_inicio;
    }
    
    @Override
    public int compareTo(Calle calle){
        if(this.largo < calle.largo){
            return -1;
        }
        else if(this.largo > calle.largo){
            return +1;
        }
        else{
            return 0;
        }
    }
    /**
     * 
     * @return retorna el largo de la calle
     */
    public double getLargo() {
        return largo;
    }
    @Override
    public String toString(){
        return this.cruce_inicio+" "+this.cruce_llegada+" ";
    }




    
}
