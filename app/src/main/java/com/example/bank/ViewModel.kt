package com.example.bank


import android.app.Application
import androidx.lifecycle.AndroidViewModel

class MainViewModel (app: Application) : AndroidViewModel(app) {

    init {
        AccountRepository.initDB(app.applicationContext)
    }
}