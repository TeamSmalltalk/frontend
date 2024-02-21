package com.example.chating

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.AbsSavedState
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chating.databinding.ActivityMakeroomBinding


class ListActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var rvAdapter : ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        //appBar 이름 설정
        getSupportActionBar()?.setTitle("채팅")

        recyclerView = findViewById(R.id.rv_list)

        /*임시 코드*/
        val chat_items = mutableListOf<ListData>()
        chat_items.add(ListData(1,"정준c2x",8))


        rvAdapter= ListAdapter(baseContext,chat_items)
        recyclerView.adapter=rvAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)

        /*임시 코드*/
    }

    //makeroom


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.list_appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.plusRoomBtn -> {
                val binding = ActivityMakeroomBinding.inflate(layoutInflater)
                val dialog = Dialog(this)
                dialog.setContentView(binding.root)
                settingDialog(dialog,binding)//개인적인 setting


                binding.EditRoomCheck.setOnClickListener {

                    dialog.dismiss()
                }

                binding.EditRoomCancel.setOnClickListener {
                    dialog.dismiss()
                }

                dialog.show()
            }

        }
        return super.onOptionsItemSelected(item)
    }

    fun settingDialog(dialog: Dialog,binding:ActivityMakeroomBinding){

        val window = dialog.window
        val params = window?.attributes

        params?.width = 1200 // 원하는 너비
        params?.height = 1000 // 원하는 높이

        window?.attributes = params
    }

}

