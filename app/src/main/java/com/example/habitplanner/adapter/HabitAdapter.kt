package com.example.habitplanner.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.habitplanner.R
import com.example.habitplanner.model.Habit

class HabitAdapter(
    private var lista: List<Habit>,
    private val onItemClick: (Habit) -> Unit
) : RecyclerView.Adapter<HabitAdapter.HabitViewHolder>() {


    class HabitViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val txtNome: TextView = view.findViewById(R.id.txtNome)
        val txtDescricao: TextView = view.findViewById(R.id.txtDescricao)
        val checkFeito: CheckBox = view.findViewById(R.id.checkFeito)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_habit, parent, false)
        return HabitViewHolder(view)
    }


    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {
        val habit = lista[position]
        holder.txtNome.text = habit.nome
        holder.txtDescricao.text = habit.descricao
        holder.checkFeito.isChecked = habit.feito


        if (habit.feito) {
            holder.txtNome.paintFlags = holder.txtNome.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.txtNome.paintFlags = holder.txtNome.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        holder.checkFeito.setOnClickListener {
            onItemClick(habit)
        }
    }

    override fun getItemCount(): Int = lista.size

    fun atualizarLista(novaLista: List<Habit>) {
        lista = novaLista
        notifyDataSetChanged()
    }
}
