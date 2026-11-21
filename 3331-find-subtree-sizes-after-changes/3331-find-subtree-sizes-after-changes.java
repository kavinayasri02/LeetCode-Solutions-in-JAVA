import java.util.*;

class Solution {
    private List<Integer>[] adj;
    private Deque<Integer>[] lastSeen;
    private int[] ans;
    private char[] chars;

    @SuppressWarnings("unchecked")
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        lastSeen = new ArrayDeque[26];
        for (int i = 0; i < 26; i++) {
            lastSeen[i] = new ArrayDeque<>();
        }

        ans = new int[n];
        chars = s.toCharArray();

        dfs(0, -1);
        return ans;
    }

    private void dfs(int u, int p) {
        ans[u] = 1;
        int c = chars[u] - 'a';

        // The top of the stack before pushing u is the closest ancestor with the same character
        int newParent = lastSeen[c].isEmpty() ? p : lastSeen[c].peek();

        lastSeen[c].push(u);
        for (int v : adj[u]) {
            dfs(v, u);
        }
        lastSeen[c].pop();

        // Add u's finalized subtree size directly to its new (or original) parent
        if (newParent != -1) {
            ans[newParent] += ans[u];
        }
    }
}
