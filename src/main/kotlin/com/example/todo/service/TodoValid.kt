package com.example.todo.service

import com.example.todo.exception.DuplicationException
import com.example.todo.exception.ExpiresException
import com.example.todo.form.TodoForm
import com.example.todo.repository.TodoRepository
import java.time.LocalDate

class TodoValid (private val todoRepository: TodoRepository){
    fun saveTodoValid(todoForm: TodoForm){
        if(todoRepository.countByTitle(todoForm.title!!) == 1){
            throw DuplicationException("タイトルが重複しています")
        }

        if(todoForm.deadline!!.isBefore(LocalDate.now())){
            throw ExpiresException("過去の期限になっています")
        }
    }
}
