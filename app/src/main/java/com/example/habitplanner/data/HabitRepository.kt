package com.example.habitplanner.data

import com.example.habitplanner.model.Habit

object HabitRepository {

    private val lista = mutableListOf(
        Habit(1, "Beber água", "Tomar 2L de água por dia", false),
        Habit(2, "Exercitar", "30 minutos de exercício", false),
        Habit(3, "Ler", "Ler pelo menos 20 páginas", true),
        Habit(4, "Meditar", "10 minutos de meditação", false)
    )

    fun getLista(): List<Habit> = lista.toList()

    fun marcarFeito(id: Int) {
        val index = lista.indexOfFirst { it.id == id }
        if (index != -1) {
            val habit = lista[index]
            lista[index] = habit.copy(feito = !habit.feito)
        }
    }

    fun adicionar(nome: String, descricao: String) {
        val novoId = (lista.maxOfOrNull { it.id } ?: 0) + 1
        lista.add(Habit(novoId, nome, descricao, false))
    }
}
