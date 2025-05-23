import java.util.HashMap;

public class Cache {
    private HashMap<String, String> store;

    public Cache() {
        store = new HashMap<>();
    }

    public boolean contains(String key) {
        return store.containsKey(key);
    }

    public String get(String key) {
        return store.get(key);
    }

    public void put(String key, String value) {
        store.put(key, value);
    }
}
