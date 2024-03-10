package com.example.spring_02;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

enum EntryStatus {
    NEW, IN_PROGRESS, DONE
}

class Entry {
    private Long id;
    private String name;
    private EntryStatus entryStatus;

    public Entry(Long id, String name, EntryStatus entryStatus) {
        this.id = id;
        this.name = name;
        this.entryStatus = entryStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntryStatus getEntryStatus() {
        return entryStatus;
    }

    public void setEntryStatus(EntryStatus entryStatus) {
        this.entryStatus = entryStatus;
    }
}

@RestController
@RequestMapping("/entries")
public class EntryController {

    private Database<Long, Entry> database = new Database<>();
    private long lastId = 0;

    @GetMapping
    public List<Entry> list() {
        return database.list();
    }

    @GetMapping("/{id}")
    public Entry get(@PathVariable Long id) {
        Entry existing = database.get(id);
        if (existing == null) {
            throw new EntryNotFoundException(id);
        }
        return existing;
    }

    @PostMapping
    public Entry create(@RequestBody Entry entry) {
        entry.setEntryStatus(EntryStatus.NEW);
        entry.setId(++lastId);
        return database.create(entry.getId(), entry);
    }

    @PutMapping
    public Entry update(@RequestBody Entry entry) {
        Entry existing = database.get(entry.getId());
        if (existing == null) {
            throw new EntryNotFoundException(entry.getId());
        }
        return database.update(entry.getId(), entry);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        database.delete(id);
    }

}

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
class EntryNotFoundException extends RuntimeException {
    public EntryNotFoundException(Long id) {
        super("Entry with id " + id + " not found!");
    }
}
