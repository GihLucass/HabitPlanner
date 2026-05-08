package com.example.habitplanner.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.habitplanner.R
import com.example.habitplanner.adapter.HabitAdapter
import com.example.habitplanner.data.HabitRepository

class HomeFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: HabitAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CicloDeVida", "HomeFragment - onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CicloDeVida", "HomeFragment - onCreateView")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CicloDeVida", "HomeFragment - onViewCreated")

        recyclerView = view.findViewById(R.id.recyclerViewHabitos)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Cria o adaptador passando a lista e a ação ao marcar um hábito
        adapter = HabitAdapter(HabitRepository.getLista()) { habit ->
            HabitRepository.marcarFeito(habit.id)
            adapter.atualizarLista(HabitRepository.getLista())
        }

        recyclerView.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        Log.d("CicloDeVida", "HomeFragment - onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "HomeFragment - onResume")
        // Atualiza a lista ao voltar para esta tela
        adapter.atualizarLista(HabitRepository.getLista())
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "HomeFragment - onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("CicloDeVida", "HomeFragment - onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "HomeFragment - onDestroy")
    }
}
