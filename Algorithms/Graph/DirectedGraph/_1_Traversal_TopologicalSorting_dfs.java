package DirectedGraph;

import java.util.*;

class _1_Traversal_TopologicalSorting_dfs {

    public List<Integer> topologicalSorting_dfs_edgeList_and_AdjList(List<List<Integer>> edgesList,int n){
        Deque<Integer> stack = new ArrayDeque<>();
        boolean visited[]=new boolean[n];
        List<Integer> resultList = new ArrayList<>();

        //Step 1: Convert EdgeList to AdjList
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edgesList.size();i++){
            adjList.get(edgesList.get(i).get(0)).add(edgesList.get(i).get(1));
        }

        //Step 2: dfs iterate using adjList
        for(int i=0;i<n;i++){
            if(!visited[i]) {
                dfsForList(i,adjList,visited,stack);
            }
        }

        while(!stack.isEmpty()){
            Integer stVal = stack.pop();
            resultList.add(stVal);
        }
        return resultList;
    }

    public void dfsForList(int i,List<List<Integer>> adjList,boolean visited[],Deque<Integer> stack){
        visited[i]=true;
        for(int v : adjList.get(i)){
            if(!visited[v]){
                dfsForList(v,adjList,visited,stack);
            }
        }
        stack.push(i);
    }

    public List<Integer> topologicalSorting_dfs_adjMatrix(int adjMatrix[][],int n){
        Deque<Integer> stack = new ArrayDeque<>();
        boolean visited[]=new boolean[n];
        List<Integer> resultList = new ArrayList<>();

        for(int i=0;i<n;i++){
            if(!visited[i]) {
                dfsForMatrix(adjMatrix,visited, i, stack);
            }
        }

        while(!stack.isEmpty()){
            Integer stVal = stack.pop();
            resultList.add(stVal);
        }
        return resultList;

    }

    public void dfsForMatrix(int adjMatrix[][],boolean visited[],int rowIndex,Deque<Integer> stack){
        visited[rowIndex]=true;
        for(int colIndex=0;colIndex<adjMatrix[rowIndex].length;colIndex++){
            if(adjMatrix[rowIndex][colIndex]!=0 && !visited[colIndex]){
                dfsForMatrix(adjMatrix,visited,colIndex,stack);
            }
        }
        stack.push(rowIndex);
    }

    /**
     * Topological sorting DFS is used for Directed Graph , when needed to count the
     *    329.Longest Increasing Path in a Matrix
     *   ii)Course Schedule with Prerequisites Grid
     *  iii)Minimum Cost Path with Dependencies
     *
     */

    public void topologicalSorting_dfs_2dGrid(int grid[][],int n){

    }

}

/***
 * => topological sorting - dfs
 *
 */