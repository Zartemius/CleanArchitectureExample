package com.example.darte.cleanarchitectureexample.domain.mappers

import com.example.darte.cleanarchitectureexample.data.models.Order

class OrderMapper{

    companion object {
        fun getActualOrder(orders:ArrayList<Order>):Order{

            var order = Order()
            order.description = ""

            for(i in orders){
                if(i.status == "sent"){
                    order = i
                }
            }
            return order
        }
    }
}