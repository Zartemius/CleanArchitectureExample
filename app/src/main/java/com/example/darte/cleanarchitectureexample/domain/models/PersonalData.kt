package com.example.darte.cleanarchitectureexample.domain.models

import com.google.firebase.Timestamp

class PersonalData {
    var email:String? = null
    var online :Boolean? = false
    var firstName :String? = null
    var lastName :String? = null
    var middleName :String? = null
    var phoneNumber :String? = null
    var stopDate: Timestamp? = null
    var deviceId:String? = null
}