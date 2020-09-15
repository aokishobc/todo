package com.example.todo.exception

import java.lang.RuntimeException

class DuplicationException : RuntimeException {
    constructor(message:String):super(message){}
}
