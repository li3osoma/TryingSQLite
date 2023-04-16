package com.example.tryingsqlite

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.tryingsqlite.database.DBManager
import com.example.tryingsqlite.databinding.ActivityMainBinding
import com.example.tryingsqlite.entity.Notion

class MainActivity : AppCompatActivity() {

    private lateinit var dbManager:DBManager
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        var title=""
        var body=""
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        dbManager=DBManager(applicationContext)
        dbManager.openDB()
        binding.saveButton.setOnClickListener {
            onClickSave()
        }
        for(notion: Notion in dbManager.getNotionList()){
            title+=notion.title+"\n"
            body+=notion.body+"\n"
        }
        binding.titleText.text=title
        binding.bodyText.text=body
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        dbManager.openDB()
    }

    override fun onDestroy() {
        super.onDestroy()
        dbManager.closeDB()
    }

    private fun onClickSave() {
        var title=""
        var body=""
        dbManager.insertDB(binding.titleEditText.text.toString(),binding.bodyEditText.text.toString())
        for(notion: Notion in dbManager.getNotionList()){
            title+=notion.title+"\n"
            body+=notion.body+"\n"
        }
        binding.titleText.text=title
        binding.bodyText.text=body
    }
}