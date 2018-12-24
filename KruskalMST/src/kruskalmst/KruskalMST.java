/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskalmst;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


public class KruskalMST {
    
    private Node nodos[];
    public int numNodos;
    public int numAristas;
    private Edge aristas[];
    
        /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        KruskalMST kmst= new KruskalMST();
        File construccion = new File("test.txt");
        BufferedReader reader = new BufferedReader(new FileReader(construccion));    
        String linea = "";
        int contador = 0;
        ArrayList<Edge> e = new ArrayList<>();
        int pos = 0;
        while((linea = (String) reader.readLine()) != null){
            if(contador == 0){
                kmst.numNodos = Integer.parseInt(linea);                
                kmst.nodos = new Node[kmst.numNodos];
                for(int i = 0;i<kmst.numNodos;i++){
                    kmst.nodos[i] = new Node();
                }            
            }
            if (contador >=1 && kmst.numNodos > contador){                                
                String[] coord = linea.split(" ");
                Node n = new Node(Integer.parseInt(coord[0]),
                        Double.parseDouble(coord[1]),Double.parseDouble(coord[2]),contador-1);
                kmst.nodos[contador-1] = n;
            }
            if(contador>kmst.numNodos){
                String[] coord = linea.split(" ");
                Node n1 = new Node(0,0,0,0);
                Node n2 = new Node(0,0,0,0);
                
                for(int i = 0;i<kmst.numNodos;i++){
                    if(kmst.nodos[i].getIdentificador() == Integer.parseInt(coord[0])){
                        n1 = kmst.nodos[i];
                    }
                    else if (kmst.nodos[i].getIdentificador() == Integer.parseInt(coord[1])){
                        n2 = kmst.nodos[i];
                    }
                    
                }
                Edge n = new Edge(n1.getPosEntrada(),n2.getPosEntrada(),n1.calcularDistancia(n2));
                e.add(n);
            }
            contador++;
        }
        int aux=0;
        int j = 0;
        kmst.aristas = new Edge[e.size()];
        while(true){
            if(j<e.size()-1){
                Edge x = e.get(j);
                kmst.aristas[j]=x;
                j++;
            }
            else{
                break;
            }
        }
        
        kmst.MST();
    }
    
    public KruskalMST(){
        this.numAristas = 0;
        this.numNodos = 0;
        aristas = new Edge[1000000];
    }
    
    public int find(Subset subsets[],int i){
        if(subsets[i].parent != i){
            subsets[i].parent = find(subsets,subsets[i].parent);
        }
        return subsets[i].parent;
    }
    
    public void union(Subset subsets[],int x, int y){
        int raizX = find(subsets,x);
        int raizY = find(subsets,y);
        
        if(subsets[raizX].rank < subsets[raizY].rank){
            subsets[raizX].parent = raizY;            
        }
        else if(subsets[raizX].rank > subsets[raizY].rank){
            subsets[raizY].parent = raizX;
        }
        else{
            subsets[raizY].parent = raizX;
            subsets[raizX].rank++;
        }
    }
    
    public void MST(){
        Edge mst[] = new Edge[this.numNodos];
        int k = 0;
        int i = 0;
        
        for(i=0;i<numNodos; i++){
            mst[i] = new Edge();
        }
        //Arrays.sort(aristas);
        ordenar();
        
        
        Subset subsets[] = new Subset[numNodos];
        for(i=0;i<numNodos;i++){
            subsets[i]=new Subset();
        }
        for (int v = 0; v < numNodos; v++){ 
            subsets[v].parent = v; 
            subsets[v].rank = 0; 
        } 
        
        i = 0;
        while (k < numNodos - 1){ 
            Edge sigArista = new Edge();
            if(i++ < aristas.length-1){
                sigArista = aristas[i++]; 
            }
            else{
                break;
            }
  
            int x = find(subsets, sigArista.source); 
            int y = find(subsets, sigArista.destiny); 
  
            if (x != y) 
            { 
                mst[k++] = sigArista; 
                union(subsets, x, y); 
            } 
        } 
        calcularPesoTotal(mst);
    }
    
    public void calcularPesoTotal(Edge mst[]){
        double total = 0;
        for(Edge e:mst){
            total+=e.peso;
        }
        System.out.println("Se necesitan "+total+" unidades de cable");
    }
    
    public void ordenar(){
        Edge aux[] = new Edge[this.aristas.length];
        for(int i = 0;i<this.aristas.length-1;i++){            
            int min = i;
            for(int j = i;j<this.aristas.length-1;j++){
                if(aristas[j].peso < aristas[min].peso){
                    min = j;
                }
            }
            aux[i] = aristas[min];
        }
        
        this.aristas = aux;
    }
}
