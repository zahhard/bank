package com.example.bank

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.random.Random
import kotlin.random.nextLong

object AccountRepository {
    var db : AppDatabase? = null
    var accountDao  : AccountDao? = null

    fun initDB(context : Context){
        db = AppDatabase.getAppDataBase(context)

        accountDao = db?.questionDao()

        addTestData()
    }

    private fun addTestData() {
        accountDao?.insertAll(
            AccountEntity(123456789, "saving", "95.5"),
            AccountEntity(123456785, "saving", "95.5")
        )
    }

    private fun numberProducer() : Long? {
        var number = db?.questionDao()?.getLastAccountNumber()
        if (number != null) {
            return number+5
        }
        return null
    }

    fun insertAccount(accountType: String, balance: String){
        var num = numberProducer()
        num?.let { AccountEntity(it, accountType, balance) }
            ?.let { db?.questionDao()?.insertAll(it) }
    }

    fun showAllAccounts() : List<AccountEntity>?{
        return  db?.questionDao()?.getAll()
    }

    fun deleteAll(){
        db?.questionDao()?.deleteAll()
    }

    fun getCount(): LiveData<Int>? {
        return db?.questionDao()?.getCount()
    }

    fun getQuestion(n : Int) : AccountEntity? {
        return db?.questionDao()?.getQuestion(n)
    }

    fun getAccount(n : String): AccountEntity? {
        return db?.questionDao()?.findByAccountNumber(n)
    }

}