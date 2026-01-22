package CommonForDirectedAndUndirectedGraph;

public class _1_Traversal_DisjointSet{
    int n=10;
    int rank[]=new int[n];
    int root[]=new int[n];

    _1_Traversal_DisjointSet(){
        for(int i=0;i<n;i++){
            rank[i]=1;
            root[i]=i;
        }
    }
    private boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            int rankX = rank[rootX];
            int rankY = rank[rootY];

            if (rankX > rankY) {
                root[rootY] = rootX;
            } else if (rankX < rankY) {
                root[rootX] = rootY;
            } else {
                root[rootX] = rootY;
                rank[rootY] += 1;
            }
            return false;
        }
        return true;
    }

    private int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return x = find(root[x]);
    }


}