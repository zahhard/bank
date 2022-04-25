package com.example.bank

import android.content.Context
import androidx.room.*

@Entity
data class AccountEntity(
    @PrimaryKey(autoGenerate = true) val accountNumber : Long ,
    val accountType : String,
    val balance : String
)


@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun questionDao(): AccountDao

    companion object {
        var db: AppDatabase? = null

        fun getAppDataBase(context: Context): AppDatabase? {
            if (db == null) {
                synchronized(AppDatabase::class) {
                    db =
                        Room.databaseBuilder(
                            context.applicationContext,
                            AppDatabase::class.java, "myDB"
                        )
                            .allowMainThreadQueries()
                            .build()
                }
            }
            return db
        }

        fun destroyDataBase() {
            db = null
        }
    }
}