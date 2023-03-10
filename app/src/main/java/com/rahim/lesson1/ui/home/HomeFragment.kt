package com.rahim.lesson1.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rahim.lesson1.App
import com.rahim.lesson1.R
import com.rahim.lesson1.databinding.FragmentHomeBinding
import com.rahim.lesson1.ui.Task.Task
import com.rahim.lesson1.ui.Task.TaskAdapter
import com.rahim.lesson1.ui.Task.TaskData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() , TaskAdapter.Listener{
    private lateinit var builder:AlertDialog.Builder
    private var _binding: FragmentHomeBinding? = null
    private lateinit var adapter: TaskAdapter

    private val binding get() = _binding!!
    private val task:Task
        get() {
            TODO()
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = TaskAdapter(this)
        builder = AlertDialog.Builder(requireActivity())



    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tasks = App.db.taskDao().getAll()
        adapter.addTasks(tasks)
        binding.recycleTask.adapter = adapter
        binding.btnPlus.setOnClickListener {
            findNavController().navigate(R.id.task)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(adapter: TaskData) {

        builder.setTitle("Delete?").setMessage("Are you Sure?").setCancelable(true).setPositiveButton("Yes") { _, _ ->
                GlobalScope.launch {
                    App.db.taskDao().delete(task.binding())
                }
            }.setNegativeButton("No"){ DialogInterface, _ -> DialogInterface.cancel()}

        super.onClick(adapter)
    }



}





