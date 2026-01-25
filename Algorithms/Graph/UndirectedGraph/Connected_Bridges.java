package UndirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Key differences between articulation point and bridges
 *   i)Return Edges instead of Nodes
 *  ii)It doesn't needed root node having multiple child node check
 * iii)There won't be deduplicates in it , so return type is List<int[]> as
 *
 */
public class Connected_Bridges {

    int discovery[],low[];
    boolean visited[];
    int count=0;
    List<int[]> resultList = new ArrayList<>();

    public List<int[]> findBridges_edgesList_adjList(List<List<Integer>> edgesList, int n){
        discovery=new int[n];
        low=new int[n];
        visited=new boolean[n];

        //Step 1 : Convert edgesList to adjList
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<edgesList.size();i++){
            adjList.get(edgesList.get(i).get(0)).add(edgesList.get(i).get(1));
            adjList.get(edgesList.get(i).get(1)).add(edgesList.get(i).get(0));
        }

        //Step 2: Start with any node and update discovery and low times
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                dfs(i, -1, adjList);
            }
        }

        //Step 3: Identify Bridges , where low
        return resultList;

    }

    public int dfs(int source,int parent,List<List<Integer>> adjList) {
        discovery[source]=low[source]=++count;
        visited[source]=true;
        for(int v:adjList.get(source)){
            if(!visited[v]) {
                int currLowSource = dfs(v, source, adjList);
                low[source] = Math.min(currLowSource, low[source]);
                if (low[v] > discovery[source]) {
                    resultList.add(new int[]{source,v});
                }

            } else if(v!=parent){
                low[source] = Math.min(low[source],discovery[v]);
            }
        }
        return low[source];
    }
}