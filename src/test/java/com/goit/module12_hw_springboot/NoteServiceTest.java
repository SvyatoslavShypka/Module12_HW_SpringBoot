package com.goit.module12_hw_springboot;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class NoteServiceTest {

    NoteService noteService = new NoteService();

    @Test
    void listAll() {
        System.out.println("Find all notes");
        System.out.println(noteService.listAll());
        System.out.println();
    }

    @Test
    void add() {
//        Given
        int expectedQuantity = 2;
        List<Note> list = createListNotes();
//        When
        list.forEach(note -> noteService.add(note));
//        Then
        Assertions.assertEquals(expectedQuantity, noteService.map.size());
    }

    @Test
    void deleteById() {
//        Given
        int expectedQuantity = 1;
        List<Note> list = createListNotes();
        noteService.add(list.get(0));
        Long id = noteService.add(list.get(1)).getId();

//        When
        noteService.deleteById(id);
//        Then
        Assertions.assertEquals(expectedQuantity, noteService.map.size());
        Assertions.assertThrows(RecordNotFound.class, (Executable) noteService.getById(id));
    }

    @Test
    void update() {
    }

    @Test
    void getById() {
    }

    List<Note> createListNotes() {
        List<Note> list = new ArrayList<>();
        Note testNote1 = new Note();
        testNote1.setTitle("TestNote title1");
        testNote1.setContent("TestNote content1");

        Note testNote2 = new Note();
        testNote2.setTitle("TestNote title2");
        testNote2.setContent("TestNote content2");

        list.add(testNote1);
        list.add(testNote2);

/*
        System.out.println("Added notes");
        System.out.println();
        noteService.add(testNote1);
        noteService.add(testNote2);
*/

        return list;
    }
}