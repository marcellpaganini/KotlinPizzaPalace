package com.example.pizzapalace

data class Order(var size: String = "medium", var extraSauce: Boolean = false,
                 var extraCheese: Boolean = false, var toppings: MutableList<String> = mutableListOf(),
                 var crust: String = "", var quantity: Int = 2)