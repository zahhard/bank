package com.example.bank

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AccountDao {
    @Query ("SELECT * FROM AccountEntity")
    fun getAll() : List<AccountEntity>

    @Query (" SELECT * FROM AccountEntity WHERE accountNumber IN (:accountNumber)")
    fun loadAllByNumber ( accountNumber : LongArray ) : List<AccountEntity>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg accountEntity: AccountEntity)
}