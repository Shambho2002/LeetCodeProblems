class Solution {
    static List<Integer>[] adj;
    static int[] parent, depth, subtreeSize, heavy;
    static int[] head, pos;
    static int timer;
    static char[] chars;
    static int[] segmentTree;
    static int size;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        chars = s.toCharArray();

        parent = new int[n];
        depth = new int[n];
        subtreeSize = new int[n];
        heavy = new int[n];
        head = new int[n];
        pos = new int[n];

        Arrays.fill(parent, -1);
        Arrays.fill(heavy, -1);

        // Step 1: Iteratively find parents and depths.
        int[] order = new int[n];
        int[] stack = new int[n];
        int top = 0;
        int count = 0;

        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];
            order[count++] = u;

            for (int v : adj[u]) {
                if (parent[v] != -1) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }

        // Step 2: Calculate subtree sizes and heavy children.
        for (int i = n - 1; i >= 0; i--) {
            int u = order[i];
            subtreeSize[u] = 1;
            int maxSize = 0;

            for (int v : adj[u]) {
                if (parent[v] == u) {
                    subtreeSize[u] += subtreeSize[v];

                    if (subtreeSize[v] > maxSize) {
                        maxSize = subtreeSize[v];
                        heavy[u] = v;
                    }
                }
            }
        }

        // Step 3: Iterative Heavy-Light Decomposition.
        timer = 0;

        int[] nodeStack = new int[n];
        int[] headStack = new int[n];
        top = 0;

        nodeStack[top] = 0;
        headStack[top] = 0;
        top++;

        while (top > 0) {
            top--;

            int u = nodeStack[top];
            int h = headStack[top];

            // Process the entire heavy chain.
            while (u != -1) {
                head[u] = h;
                pos[u] = timer++;

                // Save light children for later processing.
                for (int v : adj[u]) {
                    if (parent[v] == u && v != heavy[u]) {
                        nodeStack[top] = v;
                        headStack[top] = v;
                        top++;
                    }
                }

                u = heavy[u];
            }
        }

        // Step 4: Build the segment tree.
        size = 1;

        while (size < n) {
            size <<= 1;
        }

        segmentTree = new int[size * 2];

        for (int i = 0; i < n; i++) {
            segmentTree[size + pos[i]] =
                    1 << (chars[i] - 'a');
        }

        for (int i = size - 1; i >= 1; i--) {
            segmentTree[i] =
                    segmentTree[i * 2] ^
                    segmentTree[i * 2 + 1];
        }

        // Step 5: Process queries.
        List<Boolean> answer = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split("\\s+");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                chars[u] = c;

                update(pos[u], 1 << (c - 'a'));

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int mask = queryPath(u, v);

                answer.add((mask & (mask - 1)) == 0);
            }
        }

        return answer;
    }

    // Point update in the segment tree.
    static void update(int index, int value) {
        int i = size + index;
        segmentTree[i] = value;

        while (i > 1) {
            i >>= 1;

            segmentTree[i] =
                    segmentTree[i * 2] ^
                    segmentTree[i * 2 + 1];
        }
    }

    // XOR query on the inclusive range [left, right].
    static int rangeQuery(int left, int right) {
        int result = 0;

        left += size;
        right += size;

        while (left <= right) {
            if ((left & 1) == 1) {
                result ^= segmentTree[left++];
            }

            if ((right & 1) == 0) {
                result ^= segmentTree[right--];
            }

            left >>= 1;
            right >>= 1;
        }

        return result;
    }

    // XOR mask of all characters along the path u -> v.
    static int queryPath(int u, int v) {
        int mask = 0;

        while (head[u] != head[v]) {

            if (depth[head[u]] < depth[head[v]]) {
                int temp = u;
                u = v;
                v = temp;
            }

            mask ^= rangeQuery(pos[head[u]], pos[u]);

            u = parent[head[u]];
        }

        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        mask ^= rangeQuery(pos[u], pos[v]);

        return mask;
    }
}