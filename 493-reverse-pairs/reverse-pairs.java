class Solution {
    private class SegmentTree {
        private class Node {
            int l, r, sum;
            Node lChild, rChild;
            
            Node(int l, int r) {
                this.l = l;
                this.r = r;
                this.sum = 0;
                this.lChild = null;
                this.rChild = null;
            }
        }
        
        private Node root;
        
        public SegmentTree(int[] nums) {
            root = build(nums, 0, nums.length - 1);
        }
        
        private Node build(int[] nums, int l, int r) {
            Node node = new Node(l, r);
            
            if (l == r) {
                node.sum = nums[l];
                return node;
            }
            
            int mid = (l + r) / 2;
            node.lChild = build(nums, l, mid);
            node.rChild = build(nums, mid + 1, r);
            node.sum = node.lChild.sum + node.rChild.sum;
            
            return node;
        }
        
        public void update(int index, int val) {
            pointUpdate(root, index, val);
        }
        
        private void pointUpdate(Node node, int index, int value) {
            if (node.l == node.r) {
                node.sum = value;
                return;
            }
            
            int mid = (node.l + node.r) / 2;
            if (index <= mid) {
                pointUpdate(node.lChild, index, value);
            } else {
                pointUpdate(node.rChild, index, value);
            }
            node.sum = node.lChild.sum + node.rChild.sum;
        }
        
        public int rangeQuery(int left, int right) {
            return rangeQuery(root, left, right);
        }
        
        private int rangeQuery(Node node, int l, int r) {
            if (l > node.r || r < node.l) {
                return 0;
            }
            
            if (l <= node.l && r >= node.r) {
                return node.sum;
            }
            
            return rangeQuery(node.lChild, l, r) + rangeQuery(node.rChild, l, r);
        }
    }
    
    public int reversePairs(int[] nums) {
        List<Long> allValues = new ArrayList<>();
        
        for (int num : nums) {
            allValues.add((long) num);
            allValues.add(2L * num);
        }
        
        Collections.sort(allValues);
        allValues = new ArrayList<>(new LinkedHashSet<>(allValues));
        
        Map<Long, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < allValues.size(); i++) {
            valueToIndex.put(allValues.get(i), i);
        }
        
        int[] dummyArr = new int[valueToIndex.size()];
        SegmentTree st = new SegmentTree(dummyArr);
        
        int pairCount = 0;
        
        for (int num2 : nums) {
            long num1Min = 2L * num2;
            int targetIdx = valueToIndex.get(num1Min) + 1;
            
            if (targetIdx < valueToIndex.size()) {
                pairCount += st.rangeQuery(targetIdx, valueToIndex.size() - 1);
            }
            
            int num2Idx = valueToIndex.get((long) num2);
            st.update(num2Idx, st.rangeQuery(num2Idx, num2Idx) + 1);
        }
        
        return pairCount;
    }
}