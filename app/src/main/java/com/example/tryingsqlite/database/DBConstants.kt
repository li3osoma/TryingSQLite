package com.example.tryingsqlite.database

class DBConstants {

    companion object{
        @JvmStatic
        val DATABASE_NAME = "my_database1"
        @JvmStatic
        val DATABASE_VERSION = 1
        @JvmStatic
        val TABLE_NAME = "table1"
        @JvmStatic
        val ROW_ID = "id"
        @JvmStatic
        val ROW_TITLE = "title"
        @JvmStatic
        val ROW_BODY = "body"

        @JvmStatic
        val CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " +
                TABLE_NAME + " (" +
                ROW_ID + " INTEGER PRIMARY KEY, " +
                ROW_TITLE + " TEXT, " +
                ROW_BODY + " TEXT)"

        @JvmStatic
        val DROP_TABLE = "DROP TABLE IF EXISTS $TABLE_NAME"
    }
}