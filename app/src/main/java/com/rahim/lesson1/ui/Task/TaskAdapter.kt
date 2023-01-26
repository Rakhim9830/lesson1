package com.rahim.lesson1.ui.Task

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.rahim.lesson1.databinding.TaskModelBinding

class TaskAdapter(val listener: Listener): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

private val data = arrayListOf<TaskData>()

    fun addTask(tasks: TaskData){
        data.add(0,tasks)
        notifyItemChanged(0)
    }
    
    fun addTasks(list:List<TaskData>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
      return TaskViewHolder(TaskModelBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(data[position], listener)
    }

    override fun getItemCount(): Int {
       return data.size
    }
    inner class TaskViewHolder(private val binding: TaskModelBinding ): RecyclerView.ViewHolder(binding.root){
        fun bind(task: TaskData, listener: Listener) {
            binding.descText.text = task.desc
            binding.taskText.text = task.title
            itemView.setOnLongClickListener(){
                listener.onClick(task)
                return@setOnLongClickListener true
            }

        }

    }
    interface Listener{
        fun onClick(adapter: TaskData){

        }
    }

}






