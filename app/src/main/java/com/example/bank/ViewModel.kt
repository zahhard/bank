package com.example.bank


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.ArrayList

class MainViewModel (app: Application) : AndroidViewModel(app) {


    var counter = 0
    val nextEnableLiveData = MutableLiveData<Boolean>(true)
    val backEnableLiveData = MutableLiveData<Boolean>(false)
    val count: LiveData<Int>?
    val list: LiveData<List<AccountEntity>>?
   val  listAccount = ArrayList<AccountEntity>()

    val livedata =MutableLiveData<List<String>>()
    init {
        AccountRepository.initDB(app.applicationContext)
        count = AccountRepository.getCount()
        list = AccountRepository.showAllAccounts()

    }

    fun addAccountToDatabase(type: String, balance: String) {
        AccountRepository.insertAccount(type, balance)
    }


    fun deleteAll() {
        AccountRepository.deleteAll()
    }

}