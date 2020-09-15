package com.example.todo.repository

import com.example.todo.entity.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo, Long>{
    fun findByTitleContainingAndStatusFalse(title:String):List<Todo>

    fun countByTitle(title:String):Int
}
