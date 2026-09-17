class MyHashSet {

    private static final int nodeSize = 10_000;

    static class Node{
        public Node(int val){
            this.val = val;
            this.nextNode = null;
        }

        int val;
        Node nextNode;
    }

    Node[] bucket = new Node[nodeSize];

    public MyHashSet() {

    }

    private int hashKey(int key){
        return Math.floorMod(key, nodeSize);
    }

    public void add(int key) {
        int bucketIndex = this.hashKey(key);
        if (bucket[bucketIndex] == null){
            Node newNode = new Node(key);
            bucket[bucketIndex] = newNode;
        } else {
            Node bucketNode = bucket[bucketIndex];
            while (bucketNode.val != key && bucketNode.nextNode != null){
                bucketNode = bucketNode.nextNode;
            }

            if (bucketNode.val != key){
                bucketNode.nextNode = new Node(key);
            }

        }
    }

    public void remove(int key) {
        int bucketIndex = this.hashKey(key);
        if (bucket[bucketIndex] == null) {
            return;
        }

        Node bucketNode = bucket[bucketIndex];
        if (bucketNode.val == key){
            bucket[bucketIndex] = bucketNode.nextNode;
            return;
        }

        Node prevNode = bucketNode;

        while (bucketNode.val != key && bucketNode.nextNode != null){
            prevNode = bucketNode;
            bucketNode = bucketNode.nextNode;
        }

        if (bucketNode.val == key){
            prevNode.nextNode = bucketNode.nextNode;
        }
    }


    public boolean contains(int key) {
        int bucketIndex = this.hashKey(key);
        Node bucketNode = bucket[bucketIndex];

        if (bucketNode == null){
            return false;
        }

        while (bucketNode.val != key && bucketNode.nextNode != null){
            bucketNode = bucketNode.nextNode;
        }

        return bucketNode.val == key;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */