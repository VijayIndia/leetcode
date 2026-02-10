import java.util.ArrayList;
import java.util.List;

/**
 * Practice Problems : 3772. Maximum Subgraph Score in a Tree
 * Sol Code : https://leetcode.com/problems/maximum-subgraph-score-in-a-tree/solutions/7396907/simple-solution-by-gauravavghade-imsn/?envType=problem-list-v2&envId=tree
 */
class RerootingSol {
    List<List<Integer>> adj;
    int[] v;
    int[] dp;
    int[] ans;

    public int[] maxSubgraphScore(int n, int[][] ed, int[] g) {
        adj = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            adj.add(new ArrayList<>());

        for (int[] e : ed) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        v = new int[n];
        for (int i = 0; i < n; ++i)
            v[i] = (g[i] == 1) ? 1 : -1;

        dp = new int[n];
        ans = new int[n];

        dfsB(0, -1);
        ans[0] = dp[0];
        rerootingLogic(0, -1);

        return ans;
    }

    /**
     * With Root as '0',Calculating the subtree sum for all nodes
     */
    private void dfsB(int u, int p) {
        dp[u] = v[u];
        for (int v : adj.get(u)) {
            if (v != p) {
                dfsB(v, u);
                if (dp[v] > 0) dp[u] += dp[v];
            }
        }
    }

    /**
     * dp[0]=ans[0] // It will be same only for 0
     * For other nodes , ReRoot to all other nodes
     * ans[1]=dp[1](Only its dp[1] related subtrees)+Math.max(ans[0]-Math.max(0,dp[1]))(Except its parent node and its subtrees)
     */
    private void rerootingLogic(int u, int p) {
        for (int v : adj.get(u)) {
            if (v != p) {
                int c = Math.max(0, dp[v]);
                int s = ans[u] - c;
                ans[v] = dp[v] + Math.max(0, s);
                rerootingLogic(v, u);
            }
        }
    }
}