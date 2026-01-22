package DirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class _1_Traversal_TopologicalSorting_bfs {
    public List<Integer> topologicalSorting_bfs_edgeList(List<List<Integer>> edgesList,int n){
        int incomingDegree[]=new int[n];
        boolean visited[]=new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edgesList.size();i++){
            incomingDegree[edgesList.get(i).get(1)]++;
            adjList.get(edgesList.get(i).get(0)).add(edgesList.get(i).get(1));
        }

        for(int i=0;i<n;i++){
            if(incomingDegree[i]==0){
                q.add(i);
                visited[i]=true;
            }
        }

        while(!q.isEmpty()){
            int currIndex=q.poll();
            resultList.add(currIndex);
            for(int v : adjList.get(currIndex)){
                if(!visited[v]){
                    incomingDegree[v]--;
                    if(incomingDegree[v]==0){
                        visited[v]=true;
                        q.add(v);
                    }
                }
            }
        }
        return resultList;
    }
    public void topologicalSorting_bfs_adjList(List<List<Integer>> adjList,int n){
        int incomingEdgeCounter[]=new int[n];
        for(int i=0;i<n;i++) {
            for(int v:adjList.get(i)){
                incomingEdgeCounter[v]++;
            }
        }

        // Now we have incomingEdgeCounter and adjList , now same logic as topologicalSorting_bfs_edgeList
    }

    public void topologicalSorting_adjMatrix(int matrix[][], int n){
        // Build adjList
        // Build Incoming Edge counter
        int incomingEdgeCounter[]=new int[n];

        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++) {
                if(matrix[row][col]==1) {
                    adjList.get(row).add(col);
                    incomingEdgeCounter[col]++;
                }
            }
        }
        // Reuse topologicalSorting_bfs_edgeList logic
    }

    /**
     * 2d-grid topological sorting for BFS is not available (whereas DFS topological sorting is available)
     */
    public void topologicalSorting_2dGrid(){

    }



}