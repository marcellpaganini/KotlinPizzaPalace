package com.example.pizzapalace

class Order constructor(size: String, extraSauce: Boolean, extraCheese: Boolean,
                        toppings: MutableList<String>, crust: String, quantity: Int) {

    private var size : String? = null
    private var extraSauce : Boolean? = null
    private var extraCheese : Boolean? = null
    private var toppings = mutableListOf<String>()
    private var crust : String? = null
    private var quantity : Int? = null

}