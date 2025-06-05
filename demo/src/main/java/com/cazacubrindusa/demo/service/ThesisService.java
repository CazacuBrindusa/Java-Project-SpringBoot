package com.cazacubrindusa.demo.service;

import com.cazacubrindusa.demo.model.Thesis;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ThesisService {
    private final Map<Long, Thesis> store = new LinkedHashMap<>();
    private final AtomicLong counter = new AtomicLong(1);

    public Thesis create(Thesis t) {
        long id = counter.getAndIncrement();
        t.setId(id);
        store.put(id, t);
        return t;
    }

    public List<Thesis> findAll() {
        return new ArrayList<>(store.values());
    }

    public Optional<Thesis> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    public Optional<Thesis> update(Long id, Thesis t) {
        if (!store.containsKey(id)) {
            return Optional.empty();
        }
        t.setId(id);
        store.put(id, t);
        return Optional.of(t);
    }

    public boolean delete(Long id) {
        return store.remove(id) != null;
    }
}
