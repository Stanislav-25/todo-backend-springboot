package org.example.todoapp.service;

import org.example.todoapp.model.ToDo;
import org.example.todoapp.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getAllToDos() {
        return toDoRepository.findAll();
    }

    public Optional<ToDo> getToDoById(Long id) {
        return toDoRepository.findById(id);
    }

    public ToDo createToDo(ToDo toDo) {
        return toDoRepository.save(toDo);
    }

    public ToDo updateToDo(Long id, ToDo updateToDo) {
        return toDoRepository.findById(id).map(todo -> {
            todo.setTitle(updateToDo.getTitle());
            todo.setCompleted(updateToDo.isCompleted());
            return toDoRepository.save(todo);
        }).orElse(null);
    }

    public void deleteToDo(Long id) {
        toDoRepository.deleteById(id);
    }
}
