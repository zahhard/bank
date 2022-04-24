package com.example.bank


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel (app: Application) : AndroidViewModel(app) {


    var counter = 0
   // var questionLiveData = AccountRepository.getAccount(counter.toString())!!
    val nextEnableLiveData = MutableLiveData<Boolean>(true)
    val backEnableLiveData = MutableLiveData<Boolean>(false)
    val count: LiveData<Int>?

    init {
        AccountRepository.initDB(app.applicationContext)
        count = AccountRepository.getCount()
        //questionLiveData = AccountRepository.getAccount(counter.toString())!!
    }

    fun initCount() {
        //  count.value = AccountRepository.getCount()?.value
        // count.value = AccountRepository.getCount()?.value
    }

    fun addAccountToDatabase(type: String, balance: String) {
        //var newAccount = Account(type, cardNum, balance)
        AccountRepository.insertAccount(type, balance)
    }

    fun showAllAccount(): List<AccountEntity>? {
        return AccountRepository.showAllAccounts()
    }

    fun deleteAll() {
        AccountRepository.deleteAll()
    }

    fun nextClicked() {
        backEnableLiveData.value = true
        //if (counter < count?.value!!){
        counter ++
//        questionLiveData = AccountRepository.getAccount(counter.toString())!!
//    }
//        else
//            nextEnableLiveData.value = false
}

//    fun nextClicked() {
//        numberLiveData.value = numberLiveData.value?.plus(1)
//        numberLiveData.value?.let {
//            questionTextLiveData.value = QuestionRepository.questionList[it - 1]
//            answerTextLiveData.value = QuestionRepository.answerList[it - 2]
//        }
//        checkEnabled()
//    }
}