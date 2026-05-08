package com.example.habitplanner.model

data class Habit(
    val id: Int,
    val nome: String,
    val descricao: String,
    val feito: Boolean = false
)
