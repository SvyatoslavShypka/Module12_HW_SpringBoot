package com.goit.module12_hw_springboot;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService {

    Map<Long, Note> map = new HashMap<>();

    public List<Note> listAll() {
        List<Note> result = new ArrayList<>();
        for (Map.Entry<Long, Note> entry : map.entrySet()) {
            result.add(entry.getValue());
        }
        return result;
    }

    public Note add(Note note) {
        Random random = new Random();
        note.setId(random.nextLong());
        map.put(note.getId(), note);
        return note;
    }

    public void deleteById(long id) {
        try {
            map.remove(id);
        } catch (Exception e) {
            throw new RecordNotFound("Note was not found");
        }
    }

    public void update(Note note) {
        Note getNote = getById(note.getId());
        getNote.setTitle(note.getTitle());
        getNote.setContent(note.getContent());
    }

    public Note getById(long id) {
        Note result;
        try {
            result = map.get(id);
        } catch (Exception e) {
            throw new RecordNotFound("Note was not found");
        }
        return result;
    }
}
