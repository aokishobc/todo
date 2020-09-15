package com.example.todo.entity

import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.persistence.*


@Entity
@Table(name = "todo")
data class Todo(
        @Id
        @Column(name = "id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long? = null,

        @Column(name = "title")
        var title: String? = null,

        @Column(name = "deadline")
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        var deadline: LocalDate? = null,

        @Column(name = "status")
        var status: Boolean? = null,

        @CreationTimestamp
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        @Column(name = "create_time")
        var create_time: LocalDate? = null,

        @UpdateTimestamp
        @Column(name = "update_time")
        var update_time: LocalDate? = null
)

