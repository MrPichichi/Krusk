/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kruskalmst;


public class Node {
    private int identificador;
    private double coordX;
    private double coordY;
    private int posEntrada;
    
    public Node(){
        
    }
    public Node(int identificador, double coordX, double coordY,int posEntrada) {
        this.identificador = identificador;
        this.coordX = coordX;
        this.coordY = coordY;
        this.posEntrada = posEntrada;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coodX) {
        this.coordX = coodX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoorY(double coorY) {
        this.coordY = coorY;
    }

    public int getPosEntrada() {
        return posEntrada;
    }

    public void setPosEntrada(int posEntrada) {
        this.posEntrada = posEntrada;
    }
    
    public double calcularDistancia(Node n){
        double x = Math.pow((this.coordX-n.coordX),2);
        double y = Math.pow((this.coordY -n.coordY),2);
        double distancia = Math.sqrt(x+y);
        return distancia;
    }
    
    
}
