class MyHashSet {

    private int buckets = 1000;
    private int itemsPerBucket = 1001;
    private boolean[][] table;

    public MyHashSet() {
        table = new boolean[buckets][];
    }
    
    public int hashKey(int key) {
        return key % buckets;
    }
    
    public void add(int key) {
        int hashkey = hashKey(key);
        if (table[hashkey] == null)
            table[hashkey] = new boolean[itemsPerBucket];
        table[hashkey][key / buckets] = true;
    }
    
    public void remove(int key) {
        int hashkey = hashKey(key);
        if (table[hashkey] != null)
            table[hashkey][key / buckets] = false;
    }
    
    public boolean contains(int key) {
        int hashkey = hashKey(key);
        return table[hashkey] != null && table[hashkey][key / buckets];
    }
}
