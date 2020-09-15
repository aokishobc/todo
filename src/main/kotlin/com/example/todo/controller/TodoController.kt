package com.example.todo.controller

import com.example.todo.form.TodoForm
import com.example.todo.service.TodoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@ControllerAdvice
@Controller
class TodoController(private val todoService: TodoService) {
    @GetMapping("/")
    fun index(model: Model,todoForm: TodoForm): String {
        model.addAttribute("todos",todoService.getTodoList())
        model.addAttribute("todoForm", todoForm)
        return "index"
    }

    @PostMapping("/post")
    fun post(@Valid @ModelAttribute todoForm: TodoForm, result: BindingResult, model:Model):String {
        if (result.hasErrors()) {
            model.addAttribute("todos",todoService.getTodoList())
            return "index"
        }
        todoService.postTodo(todoForm)
        return "redirect:/"
    }

    @GetMapping("/editPage/{id}")
    fun editPage(@PathVariable("id") id:Long, model:Model):String{
        model.addAttribute("todoForm",todoService.getTodo(id))
        return "edit"
    }

    @PutMapping("/edit/{id}/complete")
    fun edit(@PathVariable("id") id:Long,@Valid @ModelAttribute todoForm: TodoForm, result: BindingResult, model:Model):String {
        if (result.hasErrors()) {
            model.addAttribute("todoForm",todoService.getTodo(id))
            return "edit"
        }
        todoService.editTodo(todoForm,id)
       return "redirect:/"
   }

    @GetMapping("/search")
    fun search():String{
        return "search"
    }

    @GetMapping("search/result")
    fun searchTodo(title:String,model: Model):String{
        model.addAttribute("todos",todoService.searchTodo(title))
        return "search"
    }

    @PatchMapping("/toggle-status/{id}")
    fun toggleStatus(@PathVariable("id") id:Long):String{
        todoService.toggleStatus(id)
        return "redirect:/"
    }
}
