package com.example.todo.form
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.Id
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TodoForm(
        @Id
        var id: Long? = null,

        @field:NotEmpty(message = "値を入力してください")
        @field:Size(min = 1, max = 30, message = "1文字以上30文字以内で入力してください")
        var title: String? = null,

        @field:NotNull(message = "値を入力してください")
        @field:DateTimeFormat(pattern = "yyyy-MM-dd")
        var deadline: LocalDate? = null,

        var status: Boolean=false
)
