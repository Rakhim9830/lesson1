package com.rahim.lesson1.ui.Task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.rahim.lesson1.App
import com.rahim.lesson1.databinding.FragmentTaskBinding


class Task : Fragment() {

private lateinit var binding: FragmentTaskBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
     binding = FragmentTaskBinding.inflate(inflater, container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener{
            App.db.taskDao().insert(TaskData(title = binding.edTitle.text.toString(), desc = binding.edDesc.text.toString()))
            findNavController().navigateUp()
        }

    }

    fun binding(){
        binding.edTitle.text.toString()
        binding.edDesc.text.toString()
    }
    companion object{
        const val RESULT_TASK = "result"
    }
}