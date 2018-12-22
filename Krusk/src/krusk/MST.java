package krusk;



import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Javier
 */
public class MST {
    
    private double costo_total;
    private double costo_optimizado;
    private ArrayList<Calle> camino_minimo;
    
            
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FileReader f = new FileReader(args[0]);//leo el archivo        
        BufferedReader b = new BufferedReader(f);
        
        int NumeroLineas = 0;

        while ((b.readLine()) != null) {// veo la cantidad de lineas del archivo
            NumeroLineas++;
        }

        FileReader f1 = new FileReader(args[0]);//leo el archivo        
        BufferedReader b1 = new BufferedReader(f1);
        
        
        Ciudad ciudad = new Ciudad(0);
        for (int i = 0; i < NumeroLineas; i++) {
            String linea = b1.readLine();       
            if(i==0){
                int cantidad_cruces = Integer.parseInt(linea.split(" ")[0]);
                ciudad = new Ciudad(cantidad_cruces);
            }
            else{
                int cruce1 = Integer.parseInt(linea.split(" ")[0]);
                int cruce2 = Integer.parseInt(linea.split(" ")[1]);
                double largo = Double.parseDouble(linea.split(" ")[2]);
                Calle calle = new Calle(cruce1,cruce2,largo);
                ciudad.AgregarCalle(calle);
            }         
        }
        
        ciudad.ordenarCalles();
        MST mst = new MST(ciudad); 
        mst.calcularCostototal(ciudad);
        mst.calcularCaminoMinimo(ciudad);
        System.out.println((int)(mst.getCosto_optimizado()*2000));
        System.out.println((int)((mst.getCosto_total()-mst.getCosto_optimizado())*2000));
        for(int i=0;i<mst.getCamino_minimo().size();i++){
            System.out.println(mst.getCamino_minimo().get(i).toString());
        }
        
        
    }
    /**
     * Constructor
     * @param ciudad ciudad que se le aplicara MST
     */
    public MST(Ciudad ciudad){
        this.costo_optimizado=0;
        this.costo_total=0;
        this.camino_minimo=new ArrayList<>();
    }
    /**
     * Metodo que calcula el camino con valor minimo, aplicando el algoritmo de kruskal
     * @param ciudad ciudad a la cual se quiere calcular el camino minimo
     */
    public void calcularCaminoMinimo(Ciudad ciudad){        
        UnionFind uf = new UnionFind(ciudad.getCantidad_Cruces());
        for(int i=0;i<ciudad.getCalles().size();i++){
            int Vertice_inicio=ciudad.getCalles().get(i).getVertice_inicio();
            int Vertice_final=ciudad.getCalles().get(i).getVertice_llegada();
            if(!uf.conectado(Vertice_inicio, Vertice_final)){//para saber si estan conectados
                uf.union(Vertice_inicio, Vertice_final);//uno los vertices(cruces)
                camino_minimo.add(ciudad.getCalles().get(i));//agrego la arista a a la lista de camino minimo
                costo_optimizado+=ciudad.getCalles().get(i).getLargo();//voy sumando el largo
            }
        }
    }
    /**
     * metodo que calcula el costo total de todas las calles
     * @param ciudad ciudad a la cual se quiere calcular el costo total de sus calles
     */
    public void calcularCostototal(Ciudad ciudad){
       for(int i=0;i<ciudad.getCalles().size();i++){
            costo_total+=ciudad.getCalles().get(i).getLargo();            
        }
    }

    public double getCosto_total() {
        return costo_total;
    }

    public void setCosto_total(double costo_total) {
        this.costo_total = costo_total;
    }

    public double getCosto_optimizado() {
        return costo_optimizado;
    }

    public void setCosto_optimizado(double costo_optimizado) {
        this.costo_optimizado = costo_optimizado;
    }

    public ArrayList<Calle> getCamino_minimo() {
        return camino_minimo;
    }

    public void setCamino_minimo(ArrayList<Calle> camino_minimo) {
        this.camino_minimo = camino_minimo;
    }
    
}
