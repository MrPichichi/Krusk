/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskalmst;


public class Edge implements Comparable<Edge> {
    
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


    @Override
    public int compareTo(Edge t) {
        double dif = peso- t.peso;
        if(dif >0){
            return 1;
        }
        else if (dif<0){
            return -1;
        }
        return 0;
    }
    
    
    
}
