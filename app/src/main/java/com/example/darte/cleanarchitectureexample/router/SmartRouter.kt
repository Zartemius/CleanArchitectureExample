package com.example.darte.cleanarchitectureexample.router

import ru.terrakok.cicerone.Navigator

interface SmartRouter{
    fun navigateForward()
    fun navigateBack()
    fun setNavigator(navigator: Navigator)
    fun removeNavigator()
}