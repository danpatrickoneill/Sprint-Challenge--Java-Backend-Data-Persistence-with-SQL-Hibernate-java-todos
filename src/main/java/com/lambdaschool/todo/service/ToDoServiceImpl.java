package com.lambdaschool.todo.service;

import com.lambdaschool.todo.model.ToDo;
import com.lambdaschool.todo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Transactional
@Service(value = "toDoService")
public class ToDoServiceImpl implements ToDoService
{
    @Autowired
    ToDoRepository todorepos;

    @Override
    public ToDo findToDoById(long id) throws EntityNotFoundException
    {
        return todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public ToDo update(ToDo toDo, long id)
    {
        ToDo currentToDo = findToDoById(id);

        if (toDo.getTododescription() != null) {
            currentToDo.setTododescription(toDo.getTododescription());
        }
        if (toDo.getDatestarted() != null) {
            currentToDo.setDatestarted(toDo.getDatestarted());
        }

        return todorepos.save(currentToDo);
    }
}
