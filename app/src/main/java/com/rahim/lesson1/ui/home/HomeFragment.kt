package com.rahim.lesson1.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.rahim.lesson1.R
import com.rahim.lesson1.databinding.FragmentHomeBinding
import com.rahim.lesson1.ui.Task.Task
import com.rahim.lesson1.ui.TaskData

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

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
        binding.btnPlus.setOnClickListener {
            findNavController().navigate(R.id.task)
            setFragmentResultListener(Task.RESULT_TASK) {key, bundle -> val result =bundle.getSerializable("bundleKey") as TaskData }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}