package com.example.todo.exception

import java.lang.RuntimeException

class NotFoundException : RuntimeException {
    constructor(message:String):super(message){}
}
