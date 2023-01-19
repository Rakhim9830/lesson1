package com.rahim.lesson1.ui.onBoarding.BoardingAdapter

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.rahim.lesson1.databinding.ItemOnboardingBinding
import com.rahim.lesson1.ui.model.OnBoard
import com.rahim.lesson1.ui.utils.loadIMage

class OnBoardingAdapter(private val onClick:() -> Unit): RecyclerView.Adapter<OnBoardingAdapter.OnBoardingViewHolder>() {
 private val data = arrayListOf(
     OnBoard("СЛЕДИТЕ ЗА СОБОЙ!", "ставьте себе новые задачи на день!", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7LfhaHsjWcKykbqT71vr1LZzRN1GWttFjLg&usqp=CAU"),
     OnBoard("ДИСЦИПЛИНА эТО ТВОЕ БУДУЩЕЕ!", "приложение поможет вам следить за поставленными задачами","https://img.freepik.com/premium-photo/stethoscope-workplace-healthcare-document-hand_1098-6921.jpg?size=626&ext=jpg" ),
     OnBoard("СТАНОВИТЕСЬ КАЖДЫЙ ДЕНЬ ЛУЧШЕ","станьте лучшей версией себя!","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRa7FiEZmXmQYoQ11_K8YhEqObk10qXpRxvQw&usqp=CAU")


 )
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OnBoardingViewHolder {
      return OnBoardingViewHolder(ItemOnboardingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }


  override fun onBindViewHolder(holder: OnBoardingViewHolder, position: Int) {
    holder.bind(data[position])
  }

  override fun getItemCount(): Int {
    return data.size
  }

  inner class OnBoardingViewHolder(private val binding: ItemOnboardingBinding): RecyclerView.ViewHolder(binding.root){
      fun bind(onBoard: OnBoard) {
          binding.boardTask.text = onBoard.title
          binding.descText.text = onBoard.decs
          binding.boardImg.loadIMage(onBoard.image.toString())
          binding.btnStartApp.isVisible = adapterPosition == data.lastIndex
          binding.btnStartApp.setOnClickListener{
              onClick()
          }
      }

  }


}