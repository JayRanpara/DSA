class MyHashMap {
    public int[] map;
    public MyHashMap() {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }
    
    public void put(int key, int value) {
       map[key]  = value; 
    }
    
    public int get(int key) {
        return map[key];
    }
    
    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
// Input 1 =

// ["MyHashMap","put","put","get","get","put","get","remove","get"]
// Input 2 =

// [[],[1,1],[2,2],[1],[3],[2,1],[2],[2],[2]]
// $0