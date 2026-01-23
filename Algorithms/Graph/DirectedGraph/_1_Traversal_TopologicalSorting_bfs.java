package DirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class _1_Traversal_TopologicalSorting_bfs {

    public List<Integer> topologicalSorting_bfs_edgeList_and_adjList(List<List<Integer>> edgesList,int n){
        int incomingDegree[]=new int[n];
        boolean visited[]=new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();

        /** Step1 : Convert edgeList to adjList **/
        List<List<Integer>> adjList = new ArrayList<>();

        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edgesList.size();i++){
            incomingDegree[edgesList.get(i).get(1)]++;
            adjList.get(edgesList.get(i).get(0)).add(edgesList.get(i).get(1));
        }

        /** Step 2 : **/
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

    /**
     * When adjMatrix is given , its usually because its dense graph , so try to use it directly instead of converting to adjList
     * @param matrix
     * @param n
     */
    public List<Integer> topologicalSorting_adjMatrix(int matrix[][], int n){
        // Build Incoming Edge counter
        int incomingDegree[]=new int[n];
        Queue<Integer> q = new LinkedList<>();
        List<Integer> resultList = new ArrayList<>();


        for(int row=0;row<matrix.length;row++){
            for(int col=0;col<matrix[0].length;col++) {
                if(matrix[row][col]==1) {
                    incomingDegree[col]++;
                }
            }
        }

        /** Step 2 : **/
        for(int i=0;i<n;i++){
            if(incomingDegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int rowIndex=q.poll();
            resultList.add(rowIndex);
            for(int colIndex=0;colIndex<matrix[rowIndex].length;colIndex++){
                if(matrix[rowIndex][colIndex]!=0){
                    incomingDegree[colIndex]--;
                    if(incomingDegree[colIndex]==0){
                        q.add(colIndex);
                    }
                }
            }
        }
        return resultList;
    }

    /**
     * 2d-grid topological sorting for BFS is not available (whereas DFS topological sorting is available)
     */
    public void topologicalSorting_2dGrid(){

    }



}