
package io.collective;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class SimpleAgedCache {
    private final String[] cache_key = new String[2000];
    private final String[] cache_value = new String[2000];
    private final int[] cache_times = new int[2000];
    private int times;
    private String key;
    private String value;
    Clock clock = new Clock();

    int contador = 0;

    public SimpleAgedCache(Clock clock) {
        this.clock = clock;
    }
    public void put(String key, String value, int times) {
        cache_key[contador] = key;
        cache_value[contador] = value;
        cache_times[contador] = times;
        contador++;
    }
    public boolean isEmpty() {
        return contador == 0;
    }
    public int size() {
        return contador;
    }
    public String get(String key) {
        if (contador == 0) return null;

    }
}
