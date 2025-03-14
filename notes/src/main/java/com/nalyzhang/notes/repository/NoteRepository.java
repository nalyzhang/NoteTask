package com.nalyzhang.notes.repository;

import com.nalyzhang.notes.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

// Репозиторий для хранения заметок
public interface NoteRepository extends JpaRepository<Note, Long> {
}
