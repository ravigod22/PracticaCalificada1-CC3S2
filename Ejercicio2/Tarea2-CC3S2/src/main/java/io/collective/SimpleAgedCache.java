
package io.collective;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public class SimpleAgedCache {
    private final String[] cache_key = new String[2000];
    private final String[] cache_value = new String[2000];
    private final int[] cache_times = new int[2000];
    private Clock clock = new Clock() {
        @Override
        public ZoneId getZone() {
            return null;
        }

        @Override
        public Clock withZone(ZoneId zone) {
            return null;
        }

        @Override
        public Instant instant() {
            return null;
        }
    };

    int contador = 0;
    public SimpleAgedCache() {
        this.contador = 0;
    }
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
    public String getKey(int pos) {
        return cache_key[pos];
    }
    public String get(String key) {
        if (contador == 0) return null;
        int pos = 0;
        for (int i = 0; i < contador; ++i) {
            if (getKey(i).equals(key)) {
                pos = i;
                break;
            }
        }
        return cache_value[pos];
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }
}
