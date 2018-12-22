package krusk;


/**
 *
 * @author Javier
 */
public interface QuickUnion {
    int find(int i);
    void union(int p, int q);
}
