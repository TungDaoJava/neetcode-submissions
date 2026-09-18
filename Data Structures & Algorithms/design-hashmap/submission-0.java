class MyHashMap {

    private static final int BUCKET_SIZE = 10_000;
    private final Node[] bucketList = new Node[BUCKET_SIZE];

    static class Node {
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.nextNode = null;
        }


        int key;
        int value;
        Node nextNode;
    }

    public MyHashMap() {

    }

    private int hashKey(int key){
        return Math.floorMod(key, BUCKET_SIZE);
    }

    public void put(int key, int value) {
        int bucketIdx = this.hashKey(key);
        Node curNode = bucketList[bucketIdx];
        if (curNode == null){
            Node newNode = new Node(key, value);
            bucketList[bucketIdx] = newNode;
            return;
        }

        while (curNode.key != key && curNode.nextNode != null){
            curNode = curNode.nextNode;
        }

        if (curNode.key != key){
            curNode.nextNode = new Node(key, value);
        } else {
            curNode.value = value;
        }
    }

    public int get(int key) {
        int bucketIdx = this.hashKey(key);
        Node curNode = bucketList[bucketIdx];

        if (curNode == null){
            return -1;
        }

        while (curNode.key != key && curNode.nextNode != null){
            curNode = curNode.nextNode;
        }

        if (curNode.key == key){
            return curNode.value;
        } else {
            return -1;
        }
    }

    public void remove(int key) {
        int bucketIdx = this.hashKey(key);
        Node curNode = bucketList[bucketIdx];
        if (curNode == null){
            return;
        }

        if (curNode.key == key) {
            bucketList[bucketIdx] = curNode.nextNode;
            return;
        }

        Node prevNode = curNode;
        while (curNode.key != key && curNode.nextNode != null){
            prevNode = curNode;
            curNode = curNode.nextNode;
        }

        if (curNode.key == key){
            prevNode.nextNode = curNode.nextNode;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */