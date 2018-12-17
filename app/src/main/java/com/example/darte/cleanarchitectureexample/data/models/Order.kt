package com.example.darte.cleanarchitectureexample.data.models

import com.google.firebase.Timestamp

class Order {
    var orderId: String? = null
    var userId: String? = null
    var description: String? = null
    var clientName:String? = null
    var number: String? = null
    var address: AddressOfOrder? = null
    var expireTime: Timestamp? = null
    var status: String? = null
    var startWorkTime: Timestamp? = null
    var timerWasLaunched: Timestamp? = null
    var problemWithSW:Boolean? = false
    var suspicionForHD:Boolean? = false
    var type:String? = null
    var relatedReportsIds:ArrayList<String>? = null
    var canCall:Boolean? = false
    var notificationState:String? = null
    var orderWasSeen: Timestamp? = null
}