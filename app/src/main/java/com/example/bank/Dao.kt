package com.example.bank

import androidx.lifecycle.LiveData
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

    @Query("DELETE FROM AccountEntity")
    fun deleteAll()

    @Query ("SELECT COUNT(*) FROM AccountEntity")
    fun getCount(): LiveData<Int>

    @Query("SELECT * FROM AccountEntity WHERE accountNumber = :n LIMIT 1")
    fun getQuestion( n : Int?) : AccountEntity

    @Query("SELECT * FROM AccountEntity WHERE accountNumber = :id")
    fun findByAccountNumber(id: String?): AccountEntity?

    @Query("SELECT accountNumber FROM AccountEntity ORDER BY accountNumber DESC LIMIT 1")
    fun getLastAccountNumber(): Long

}