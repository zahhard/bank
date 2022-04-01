package com.example.bank

data class TransActionData(var mabdaCard: Card,
                           var destinationCard: Card) {
    fun getName(): String{
        return mabdaCard.personName
    }
}

class Card(val  cardNumber: String, val bankName: BankName, val personName: String){}


enum class BankName{
    Melli, Mellat, Keshavarzi, Sepah,
}