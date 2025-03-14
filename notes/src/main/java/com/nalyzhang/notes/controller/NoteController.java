package com.nalyzhang.notes.controller;

import com.nalyzhang.notes.model.Note;
import com.nalyzhang.notes.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

// Контроллер для обработки запросов
@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    // Метод для отображения всех заметок
    @GetMapping("/")
    public String index(Model model) {
        List<Note> notes = noteService.findAll();
        model.addAttribute("notes", notes);
        return "index";
    }

    // Метод для сохранения созданной заметки
    @PostMapping("/save")
    public String save(Note note) {
        noteService.save(note); // Сохраняем заметку
        return "redirect:/"; // Перенаправляем на главную страницу
    }

    // Метод для направления на редактирование заметки
    @GetMapping("/edit/{id}")
    public String editNote(@PathVariable Long id, Model model) {
        Note note = noteService.findById(id);
        model.addAttribute("note", note);
        return "edit";
    }

    // Метод для редактирования заметки
    @PostMapping("/update")
    public String update(Note note) {
        noteService.save(note);
        return "redirect:/";
    }

    // Метод для удаления заметки по id
    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        noteService.deleteById(id);
        return "redirect:/";
    }

    // Метод для отображения страницы создания заметки
    @GetMapping("/create")
    public String createNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "create";
    }
}