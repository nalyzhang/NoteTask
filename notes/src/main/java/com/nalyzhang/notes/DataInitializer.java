package com.nalyzhang.notes;

import com.nalyzhang.notes.model.Note;
import com.nalyzhang.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

// Инициализация первой заметки при первом открытии приложения
@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private NoteService noteService;

    @Override
    public void run(String... args) throws Exception {
        if (noteService.findAll().isEmpty()) {
            Note initialNote = new Note();
            initialNote.setText("Ваша первая заметка уже написана! Вот она я!");
            noteService.save(initialNote);
        }
    }
}
