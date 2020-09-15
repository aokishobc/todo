package com.example.todo.service

import com.example.todo.entity.Todo
import com.example.todo.exception.DuplicationException
import com.example.todo.exception.ExpiresException
import com.example.todo.exception.NotFoundException
import com.example.todo.form.TodoForm
import com.example.todo.repository.TodoRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component
import java.lang.Exception
import java.time.LocalDate

@Component
@RequiredArgsConstructor
class TodoService(private val todoRepository: TodoRepository) {
    fun getTodoList():List<Todo>{
        return todoRepository.findAll()
    }

    fun getTodo(id:Long):TodoForm{
        val findById = todoRepository.findById(id)
        val todo:Todo =findById.orElseThrow{ throw NotFoundException("値が存在しません") }
        var todoForm = TodoForm()
        todoForm.id = todo.id
        todoForm.title = todo.title
        todoForm.deadline = todo.deadline
        return todoForm
    }

    fun postTodo(todoForm: TodoForm){
        val todoValid = TodoValid(todoRepository)
        todoValid.saveTodoValid(todoForm)
        val todo = Todo()
        todo.title = todoForm.title
        todo.deadline = todoForm.deadline
        todo.status = todoForm.status
        todoRepository.save(todo)
    }

    fun editTodo(todoForm: TodoForm,id: Long){
        val todoValid = TodoValid(todoRepository)
        todoValid.saveTodoValid(todoForm)
        val findById = todoRepository.findById(id)
        val todo:Todo =findById.orElseThrow{ throw NotFoundException("値が存在しません") }
        todo.title = todoForm.title
        todo.deadline = todoForm.deadline
        todoRepository.save(todo)
    }

    fun searchTodo(title:String):List<Todo>{
        return todoRepository.findByTitleContainingAndStatusFalse(title)
    }

    fun toggleStatus(id:Long){
        val findById = todoRepository.findById(id)
        val todo:Todo =findById.orElseThrow{ throw NotFoundException("値が存在しません") }
        todo.status = !todo.status!!
        todoRepository.save(todo)
    }
}
