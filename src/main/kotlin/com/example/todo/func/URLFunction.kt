package com.example.todo.func

import org.springframework.web.context.request.WebRequest

class URLFunction {
    fun getUri(webRequest:WebRequest):String{
        val host:String = webRequest.getHeader("HOST").toString()
        val referer:String = webRequest.getHeader("REFERER").toString()
        return referer.substring(referer.indexOf(host) + host.length)
    }
}
