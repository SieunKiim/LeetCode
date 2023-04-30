class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind Alice = new UnionFind(n);
        UnionFind Bob = new UnionFind(n);

        int edgesRequired = 0;
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                edgesRequired += (Alice.performUnion(edge[1], edge[2]) | Bob.performUnion(edge[1], edge[2]));
            }
        }

        for (int[] edge : edges) {
            if (edge[0] == 1) {
                edgesRequired += Alice.performUnion(edge[1], edge[2]);
            } else if (edge[0] == 2) {
                edgesRequired += Bob.performUnion(edge[1], edge[2]);
            }
        }

        if (Alice.isConnected() && Bob.isConnected()) {
            return edges.length - edgesRequired;
        }
        
        return -1;
    }

    private class UnionFind {
        int[] representative;
        int[] componentSize;
        int components;

        public UnionFind(int n) {
            components = n;
            representative = new int[n + 1];
            componentSize = new int[n + 1];

            for (int i = 0; i <= n; i++) {
                representative[i] = i;
                componentSize[i] = 1;
            }
        }

        int findRepresentative(int x) {
            if (representative[x] == x) {
                return x;
            }

            return representative[x] = findRepresentative(representative[x]);
        }
        
        int performUnion(int x, int y) {       
            x = findRepresentative(x); y = findRepresentative(y);

            if (x == y) {
                return 0;
            }

            if (componentSize[x] > componentSize[y]) {
                componentSize[x] += componentSize[y];
                representative[y] = x;
            } else {
                componentSize[y] += componentSize[x];
                representative[x] = y;
            }

            components--;
            return 1;
        }

        boolean isConnected() {
            return components == 1;
        }
    }
}
