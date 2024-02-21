package com.example.chating

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.chating.databinding.ChatMeItemBinding
import com.example.chating.databinding.ChatOthersItemBinding
import com.example.chating.databinding.ListItemBinding

class ChattingAdapter(val context: Context, val List : MutableList<ChatUserData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    companion object {
        const val CHATTING_OTHER = 1
        const val CHATTING_ME = 2
    }

    override fun getItemViewType(position: Int): Int {
        return if (List[position].userId==1) { // 임시 조건
            CHATTING_OTHER
        } else {
            CHATTING_ME
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == CHATTING_OTHER) {
            val binding = ChatOthersItemBinding.inflate(LayoutInflater.from(context), parent, false)
            ViewHolderOther(binding)
        } else {
            val binding = ChatMeItemBinding.inflate(LayoutInflater.from(context), parent, false)
            ViewHolderMe(binding)
        }
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderOther) {
            holder.bindItems(List[position])
        } else if (holder is ViewHolderMe) {
            holder.bindItems(List[position])
        }
    }

    inner class ViewHolderOther(private val binding: ChatOthersItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(item : ChatUserData) {
            binding.chatMessage.text=item.message
            binding.chatProfile.text=item.userId.toString()
            //프로필 색 변경 추가 예정
        }
    }

    class ViewHolderMe(private val binding: ChatMeItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bindItems(item : ChatUserData) {
            binding.chatMessageMe.text=item.message
        }
    }

}
//추가예정