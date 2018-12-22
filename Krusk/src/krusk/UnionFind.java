package krusk;


/**
 *
 * @author Javier
 */
public class UnionFind implements QuickUnion{
    private int[] array;
    
    public UnionFind(int n){
        array = new int[n];
        for(int i=0;i<n;i++){
            array[i]=i;
        }
    }
    
    @Override
    public int find(int i){
        while(i != array[i]) i=array[i];
        return i;
    }
    
    @Override
    public void union(int p, int q){      
       int i = find(p); 
       int j = find(q); 
       array[i] = j;       
   }  
   public boolean conectado(int p, int q) {
       return find(p) == find(q);
   }
}
