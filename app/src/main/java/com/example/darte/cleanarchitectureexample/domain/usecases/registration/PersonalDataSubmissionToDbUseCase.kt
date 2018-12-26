package com.example.darte.cleanarchitectureexample.domain.usecases.registration

import com.example.darte.cleanarchitectureexample.data.database.DataBaseRepository
import com.example.darte.cleanarchitectureexample.domain.models.PersonalData
import io.reactivex.Single
import javax.inject.Inject

class PersonalDataSubmissionToDbUseCase @Inject constructor(private val dataBaseRepository:DataBaseRepository,
                                                            private val mPersonalData:PersonalData){

    fun setEmail(email:String){
       mPersonalData.email = email
    }

    fun setFirstName(firstName:String){
        mPersonalData.firstName = firstName
    }

    fun setLastName(lastName:String){
        mPersonalData.lastName = lastName
    }

    fun setMiddleMan(middleMan:String){
        mPersonalData.middleName = middleMan
    }

    fun setPhoneNumber(phoneNumber:String){
        mPersonalData.phoneNumber = phoneNumber
    }

    fun allRequiredDataIsPrepared():Boolean{
        if(mPersonalData.email == null){
            return false
        }else if(mPersonalData.firstName == null){
            return false
        }else if(mPersonalData.lastName == null){
            return false
        }else if(mPersonalData.middleName == null){
            return false
        }else if(mPersonalData.phoneNumber == null){
            return false
        }
        return true
    }

    fun submitDataAsync():Single<Boolean>{
        val personalData = mPersonalData
        return dataBaseRepository.submitUserPersonalData(personalData)
    }

}