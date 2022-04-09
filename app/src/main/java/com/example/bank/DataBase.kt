package com.example.bank

import androidx.room.Database
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomDatabase

@Entity
data class Account(
    @PrimaryKey val accountNumber : Long ,
    val accountType : String,
    val balance : Double
)

@Database (entities = [Account::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun accountDao() : AccountDao
}