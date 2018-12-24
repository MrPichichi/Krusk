/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskalmst;


public class Edge  {
    
    int source;
    int destiny;
    double peso;
    
    public Edge(){
        
    }
    public Edge(int source, int destiny, double peso){
        this.source = source;
        this.destiny = destiny;
        this.peso = peso;
    }


    public Double compareTo(Edge t) {
        return this.peso-t.peso;
    }
    
    
    
}
