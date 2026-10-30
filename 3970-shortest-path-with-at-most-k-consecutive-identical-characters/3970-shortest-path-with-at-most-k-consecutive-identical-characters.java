class Solution {
    static class MinHeap {
        long[] costs;
        int[] nodes;
        int[] counts;
        int size = 0;

        MinHeap(int capacity) {
            costs = new long[capacity];
            nodes = new int[capacity];
            counts = new int[capacity];
        }

        boolean isEmpty() {
            return size == 0;
        }

        void offer(long cost, int node, int count) {
            if (size == costs.length) {
                int newCapacity = costs.length * 2;
                costs = Arrays.copyOf(costs, newCapacity);
                nodes = Arrays.copyOf(nodes, newCapacity);
                counts = Arrays.copyOf(counts, newCapacity);
            }

            int i = size++;

            while (i > 0) {
                int parent = (i - 1) / 2;

                if (costs[parent] <= cost) {
                    break;
                }

                costs[i] = costs[parent];
                nodes[i] = nodes[parent];
                counts[i] = counts[parent];
                i = parent;
            }

            costs[i] = cost;
            nodes[i] = node;
            counts[i] = count;
        }

        void poll() {
            poppedCost = costs[0];
            poppedNode = nodes[0];
            poppedCount = counts[0];

            long lastCost = costs[--size];
            int lastNode = nodes[size];
            int lastCount = counts[size];

            if (size == 0) {
                return;
            }

            int i = 0;

            while (true) {
                int left = 2 * i + 1;
                int right = left + 1;

                if (left >= size) {
                    break;
                }

                int child = left;

                if (right < size && costs[right] < costs[left]) {
                    child = right;
                }

                if (costs[child] >= lastCost) {
                    break;
                }

                costs[i] = costs[child];
                nodes[i] = nodes[child];
                counts[i] = counts[child];
                i = child;
            }

            costs[i] = lastCost;
            nodes[i] = lastNode;
            counts[i] = lastCount;
        }

        long poppedCost;
        int poppedNode;
        int poppedCount;
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        long[][] dist = new long[n][k + 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
        }

        MinHeap pq = new MinHeap(16);

        dist[0][1] = 0;
        pq.offer(0, 0, 1);

        while (!pq.isEmpty()) {

            pq.poll();

            long cost = pq.poppedCost;
            int node = pq.poppedNode;
            int count = pq.poppedCount;

            if (cost != dist[node][count]) {
                continue;
            }

            if (node == n - 1) {
                return (int) cost;
            }

            for (int[] edge : graph[node]) {

                int nextNode = edge[0];
                int weight = edge[1];

                int newCount;

                if (labels.charAt(node) == labels.charAt(nextNode)) {
                    newCount = count + 1;
                } else {
                    newCount = 1;
                }

                if (newCount > k) {
                    continue;
                }

                long newCost = cost + weight;

                if (newCost < dist[nextNode][newCount]) {

                    dist[nextNode][newCount] = newCost;

                    pq.offer(newCost, nextNode, newCount);
                }
            }
        }

        return -1;
    }
}