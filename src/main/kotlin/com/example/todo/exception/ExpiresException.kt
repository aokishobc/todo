package com.example.todo.exception

import java.lang.RuntimeException

class ExpiresException : RuntimeException {
    constructor(message:String):super(message){}
}
