package com.example.bank

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AccountDao {
    @Query ("SELECT * FROM Account")
    fun getAll() : List<Account>

    @Query (" SELECT * FROM Account WHERE accountNumber IN (:accountNumber)")
    fun loadAllByNumber ( accountNumber : LongArray ) : List<Account>

    @Insert
    fun insertAll(vararg accounts : Account)
}