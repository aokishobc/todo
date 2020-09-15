package com.example.todo.exception

import com.example.todo.func.URLFunction
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@ControllerAdvice
class TodoControllerAdvice {

    @ExceptionHandler(DuplicationException::class)
    fun handleDuplicationException(webRequest:WebRequest, e:DuplicationException, attributes: RedirectAttributes):String{
        attributes.addFlashAttribute("titleError", e.message)
        val funcUri = URLFunction()
        return "redirect:"+funcUri.getUri(webRequest)
    }

    @ExceptionHandler(ExpiresException::class)
    fun handleExpiresException(webRequest:WebRequest, e:ExpiresException, attributes: RedirectAttributes):String{
        attributes.addFlashAttribute("DeadlineError", e.message)
        val funcUri = URLFunction()
        return "redirect:"+funcUri.getUri(webRequest)
    }

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(webRequest:WebRequest, e:NotFoundException, model:Model):String{
        model.addAttribute("errorMessage", e.message)
        return "error/500"
    }

    @ExceptionHandler(Exception::class)
    fun handleException(webRequest:WebRequest, e:Exception, model: Model):String{
        model.addAttribute("errorMessage", "内部エラー")
        return "error/500"
    }

}
