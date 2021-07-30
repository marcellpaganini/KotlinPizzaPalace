package com.example.pizzapalace

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.pizzapalace.databinding.FragmentOrderBinding


/**
 * A simple [Fragment] subclass.
 * Use the [OrderFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class OrderFragment : Fragment() {

    var check : Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentOrderBinding>(inflater,
            R.layout.fragment_order,container,false)

        val toppings = resources.getStringArray(R.array.Toppings)
        val crusts = resources.getStringArray(R.array.Crusts)
        val spnToppings = binding.spnToppings
        val spnCrusts = binding.spnCrusts
        val selectedToppings : MutableList<String> = mutableListOf()
        var txtToppings : String = ""

        populateSpinner(spnToppings, toppings)
        populateSpinner(spnCrusts, crusts)

        spnToppings.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                    if(check > 0) {

                        if(selectedToppings.contains(toppings[position])) {
                            context?.let {Toast.makeText(it.applicationContext,
                                toppings[position] + " was already added to your pizza", Toast.LENGTH_SHORT).show()}
                        } else {
                            selectedToppings.add(toppings[position])

                            if(selectedToppings.size == 1) {
                                txtToppings += selectedToppings[selectedToppings.size - 1]
                            } else {
                                txtToppings += ", " + selectedToppings[selectedToppings.size - 1]
                            }

                            binding.textView3.setText(txtToppings)

                            context?.let {Toast.makeText(it.applicationContext,
                                toppings[position] + " added", Toast.LENGTH_SHORT).show()}
                        }

                        check += 1
                    }
                    check += 1
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }

        return binding.root
    }

    private fun populateSpinner(spinner: Spinner, array: Array<String>) {
        val myAdapter = context?.let { ArrayAdapter(it.applicationContext, R.layout.support_simple_spinner_dropdown_item, array) }
        spinner.adapter = myAdapter
    }

}