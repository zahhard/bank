package com.example.bank


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MainViewModel (app: Application) : AndroidViewModel(app) {


    var counter = 0
    val nextEnableLiveData = MutableLiveData<Boolean>(true)
    val backEnableLiveData = MutableLiveData<Boolean>(false)
    val count: LiveData<Int>?

    init {
        AccountRepository.initDB(app.applicationContext)
        count = AccountRepository.getCount()
    }

    fun addAccountToDatabase(type: String, balance: String) {
        AccountRepository.insertAccount(type, balance)
    }

    fun showAllAccount(): List<AccountEntity>? {
        return AccountRepository.showAllAccounts()
    }

    fun deleteAll() {
        AccountRepository.deleteAll()
    }

    fun nextClicked() {

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