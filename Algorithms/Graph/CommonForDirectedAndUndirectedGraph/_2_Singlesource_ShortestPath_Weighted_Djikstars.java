package CommonForDirectedAndUndirectedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.List;
public class _2_Singlesource_ShortestPath_Weighted_Djikstars {

    int n = 10;

    public void djikstars_adjList(List<List<int[]>> adjList, int sourceNode) {
        boolean visited[] = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new int[]{sourceNode, 0});
        int visitedNodesCount = 0;
        while (!pq.isEmpty() && visitedNodesCount < n) {
            int uNode_and_Weight[] = pq.poll();
            int uNode = uNode_and_Weight[0];
            if (!visited[uNode]) {
                visited[uNode] = true;
                visitedNodesCount++;
                int uNodeWeight = uNode_and_Weight[1];
                for (int vNode_weight[] : adjList.get(uNode)) {
                    int vNode = vNode_weight[0];
                    int vNodeWeight = vNode_weight[1];
                    if (uNodeWeight + vNodeWeight < dist[vNode]) {
                        dist[vNode] = uNodeWeight + vNodeWeight;
                        pq.add(new int[]{vNode, dist[vNode]});
                    }
                }
            }
        }
    }


    /**
     * Convert adjMatrix to adjList and then do same process as adjList is more efficient
     */
    public void djikstars_adjMatrix(int adjMatrix[][], int sourceNode) {
        List<List<int[]>> adjList = new ArrayList<>();

        for (int i = 0; i < adjMatrix.length; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int row = 0; row < adjMatrix.length; row++) {
            for (int col = 0; col < adjMatrix[row].length; col++) {
                if (adjMatrix[row][col] != 0) {
                    adjList.get(row).add(new int[]{col, adjMatrix[row][col]});
                }
            }
        }
        djikstars_adjList(adjList, sourceNode);
    }

    /**
     * 2d-grid as graph
     * 1631. Path With Minimum Effort
     */
    public int djikstars_2dGrid(int grid[][]) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        int sourceRow = 0, sourceColumn = 0;
        int endRowIndex = grid.length - 1, endColumnIndex = grid[0].length - 1;
        int directions[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int pathVal[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < pathVal.length; i++) {
            Arrays.fill(pathVal[i], Integer.MAX_VALUE);
        }

        pq.add(new int[]{sourceRow, sourceColumn, 0});
        pathVal[sourceRow][sourceColumn] = 0;
        while (!pq.isEmpty()) {
            int sourceNode[] = pq.poll();
            int sourceRowIndex = sourceNode[0];
            int sourceColumnIndex = sourceNode[1];
            int sourceNodeVal = sourceNode[2];
            if (sourceRowIndex == endRowIndex && sourceColumnIndex == endColumnIndex) {
                return sourceNodeVal;
            }
            for (int i = 0; i < directions.length; i++) {
                if (sourceRowIndex + directions[i][0] >= 0 && sourceRowIndex + directions[i][0] < grid.length &&
                        sourceColumnIndex + directions[i][1] >= 0 && sourceColumnIndex + directions[i][1] < grid[0].length) {
                    if (pathVal[sourceRowIndex + directions[i][0]][sourceColumnIndex + directions[i][1]] >  Math.max(sourceNodeVal , Math.abs(grid[sourceRowIndex][sourceColumnIndex] - grid[sourceRowIndex + directions[i][0]][sourceColumnIndex + directions[i][1]]))) {
                        pathVal[sourceRowIndex + directions[i][0]][sourceColumnIndex + directions[i][1]] = Math.max(sourceNodeVal , Math.abs(grid[sourceRowIndex][sourceColumnIndex] - grid[sourceRowIndex + directions[i][0]][sourceColumnIndex + directions[i][1]]));
                        pq.add(new int[]{sourceRowIndex + directions[i][0], sourceColumnIndex + directions[i][1], pathVal[sourceRowIndex + directions[i][0]][sourceColumnIndex + directions[i][1]]});
                    }
                }
            }
        }
        return -1;
    }
}

/**
 * boolean visited[];
 * int dist[];
 * <p>
 * for(int i=0)
 * <p>
 * AdjList
 * 1 -> (2,10),{3,5},{4,6}
 * 2 -> (3,1)
 * <p>
 * <p>
 * visited[] =
 * t    f    f    f    f
 * 1    2    3    4    5
 * 1    INF  INF  INF  INF  INF
 * 1         10   5   6     INF
 */