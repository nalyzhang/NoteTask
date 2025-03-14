package com.nalyzhang.notes.service;

import com.nalyzhang.notes.model.Note;
import com.nalyzhang.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Сервис для обработки списка заметок
@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> findAll() {
        return noteRepository.findAll(); // Получаем все заметки
    }

    public void save(Note note) {
        noteRepository.save(note); // Сохраняем заметку
    }

    public Note findById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        noteRepository.deleteById(id); // Удаляем заметку из репозитория
    }
}
