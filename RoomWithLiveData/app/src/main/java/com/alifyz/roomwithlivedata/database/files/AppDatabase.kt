package com.alifyz.roomwithlivedata.database.files

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.alifyz.roomwithlivedata.database.files.dao.DesertDao
import com.alifyz.roomwithlivedata.database.files.entity.DesertEntity

@Database(entities = arrayOf(DesertEntity::class), version = 1)
abstract class AppDatabase : RoomDatabase(){

    //Database Dao
    abstract fun desertDao() : DesertDao

    //Static Creation of the Local Database
    companion object {
        @Volatile

        private var INSTANCE : AppDatabase? = null

        fun getInstance(context : Context) : AppDatabase? {

            val tempInstance = INSTANCE

            if(INSTANCE != null) {
                return tempInstance
            }

            synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "database").build()
                return INSTANCE
            }
        }
    }
}