package com.example.bank

import android.content.Context
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

    fun insertAccount(accountType: String, balance: String){
        var num = Random.nextLong(1000000000000000..9999999999999999)
        db?.questionDao()?.insertAll(AccountEntity(num, accountType, balance))
    }
    fun showAllAccounts() : List<AccountEntity>?{
        return  db?.questionDao()?.getAll()
    }

    fun deleteAll(){
        db?.questionDao()?.deleteAll()
    }

    fun getCount(): Int? {
        return db?.questionDao()?.getCount()
    }

}