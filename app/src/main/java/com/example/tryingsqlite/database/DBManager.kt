package com.example.tryingsqlite.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import com.example.tryingsqlite.entity.Notion

class DBManager(context: Context){
    private val dbHelper=DBHelper(context)
    private lateinit var db:SQLiteDatabase

    fun openDB(){
        db = dbHelper.writableDatabase
    }

    fun closeDB(){
        db.close()
    }

    fun insertDB(title:String, body:String){
        var cv:ContentValues= ContentValues()
        cv.put(DBConstants.ROW_TITLE,title)
        cv.put(DBConstants.ROW_BODY,body)
        db.insert(DBConstants.TABLE_NAME,null,cv)
    }

    fun getNotionList():List<Notion> {
        //db=notionDBHelper.writableDatabase
        var notionList= mutableListOf<Notion>()
        var title:String
        var body:String
        val cursor: Cursor = db.query(
            DBConstants.TABLE_NAME,
            null, null, null, null, null, null)
        while(cursor.moveToNext()){
            title=cursor.getString(cursor.getColumnIndexOrThrow(DBConstants.ROW_TITLE))
            body=cursor.getString(cursor.getColumnIndexOrThrow(DBConstants.ROW_BODY))
            notionList.add(Notion(title,body))
        }

        cursor.close()
        for(notion in notionList){
            println("${notion.title}, ${notion.body}")
        }
        //db.close()
        return notionList
    }
}