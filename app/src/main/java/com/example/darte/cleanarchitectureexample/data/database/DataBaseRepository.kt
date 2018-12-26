package com.example.darte.cleanarchitectureexample.data.database

import com.example.darte.cleanarchitectureexample.domain.models.PersonalData
import io.reactivex.Single

interface DataBaseRepository {
    fun submitUserPersonalData(personalData:PersonalData):Single<Boolean>
}