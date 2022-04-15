package com.example.bank

import android.content.Context

object AccountRepository {
    var db : AppDatabase? = null
    var accountDao  : AccountDao? = null
    var accountCounter : Long = 1000000000000000

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
        accountCounter ++
        db?.questionDao()?.insertAll(AccountEntity(accountCounter, accountType, balance))
    }

}