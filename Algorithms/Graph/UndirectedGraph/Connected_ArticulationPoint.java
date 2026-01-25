package UndirectedGraph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * i)Graph with Single Connected nodes is given , in that If a node is removed, then it will get converted to different connected components
 *
 */

public class Connected_ArticulationPoint{

    int discovery[],low[];
    boolean visited[];
    int count=0;
    Set<Integer> resultSet = new HashSet<>();


    public Set<Integer> findArticulationPointNode_edgesList_adjList(List<List<Integer>> edgesList, int n){
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

        //Step 3: Identify articulation point , where low
        return resultSet;

    }

    public int dfs(int source,int parent,List<List<Integer>> adjList) {
        discovery[source]=low[source]=++count;
        visited[source]=true;
        int tempCount=0;
        for(int v:adjList.get(source)){
            if(!visited[v]) {
                tempCount++;
                int currLowSource = dfs(v, source, adjList);
                low[source] = Math.min(currLowSource, low[source]);
                if(parent==-1 && tempCount>1){
                    resultSet.add(source);
                }
                if (parent!=-1 && low[v] >= discovery[source]) {
                    resultSet.add(source);
                }

            } else if(v!=parent){
                low[source] = Math.min(low[source],discovery[v]);
            }
        }
        return low[source];
    }


    public void findArticulationPointNode_adjMatrix(int adjMatrix[][],int n){
        int discovery[]=new int[n];
        int low[]=new int[n];
        boolean visited[]=new boolean[n];


    }

    /**
     * i)Articulation Point for 2d Grid is not possible , as in 2d grid , most of the nodes are connected , removing 1 node wont cause issues
     *
     */

    public void findArticulationPointNode_2dGrid(int grid[][],int n){
        int discovery[]=new int[n];
        int low[]=new int[n];
        boolean visited[]=new boolean[n];

    }

}