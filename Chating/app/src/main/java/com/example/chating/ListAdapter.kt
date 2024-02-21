package com.example.chating

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chating.databinding.ListItemBinding

class ListAdapter(val context: Context, val List : MutableList<ListData>) : RecyclerView.Adapter<ListAdapter.ViewHolder>(){

    private lateinit var binding: ListItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListAdapter.ViewHolder, position: Int) {
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return List.size
    }

    inner class ViewHolder( private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindItems(item : ListData){
            binding.listNum.text=item.chatRoomId.toString()
            binding.listTitle.text=item.chatRoomName
            binding.listCapacity.text=item.memberCount.toString()+"/10"

        }
    }
}