package com.example.chating

import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chating.databinding.ActivityMakeroomBinding

class ChattingActivity: AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var rvAdapter : ChattingAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chating)

        //appBar 이름 설정
        getSupportActionBar()?.setTitle("정준형") // 방 네이밍 따와야함

        recyclerView = findViewById(R.id.rv_list_chat)


        /*임시 코드*/
        val chat_items = mutableListOf<ChatUserData>()
        chat_items.add(ChatUserData(1,"많이 먹는 무지","힘들다"))


        rvAdapter= ChattingAdapter(baseContext,chat_items)
        recyclerView.adapter=rvAdapter
        recyclerView.layoutManager= LinearLayoutManager(this)

        /*임시 코드*/
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.chatting_appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitBtn -> {

            }

        }
        return super.onOptionsItemSelected(item)
    }
}