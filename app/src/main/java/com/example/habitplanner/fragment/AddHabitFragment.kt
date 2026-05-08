package com.example.habitplanner.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.habitplanner.R
import com.example.habitplanner.data.HabitRepository

class AddHabitFragment : Fragment() {

    private lateinit var editNome: EditText
    private lateinit var editDescricao: EditText
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("CicloDeVida", "AddHabitFragment - onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("CicloDeVida", "AddHabitFragment - onCreateView")
        return inflater.inflate(R.layout.fragment_add_habit, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("CicloDeVida", "AddHabitFragment - onViewCreated")

        editNome = view.findViewById(R.id.editNome)
        editDescricao = view.findViewById(R.id.editDescricao)
        btnSalvar = view.findViewById(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            val nome = editNome.text.toString().trim()
            val descricao = editDescricao.text.toString().trim()

            if (nome.isEmpty()) {
                Toast.makeText(requireContext(), "Digite o nome do hábito!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            HabitRepository.adicionar(nome, descricao)
            Toast.makeText(requireContext(), "Hábito adicionado!", Toast.LENGTH_SHORT).show()


            editNome.setText("")
            editDescricao.setText("")
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("CicloDeVida", "AddHabitFragment - onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("CicloDeVida", "AddHabitFragment - onPause")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("CicloDeVida", "AddHabitFragment - onDestroy")
    }
}
