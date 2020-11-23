package com.udacity.shoestore.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private var _shoes = MutableLiveData<MutableList<Shoe>>()

    private val _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe> get() = _shoe

    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>> get() = _shoeList

    private val _canReturnToShoeList = MutableLiveData<Boolean>()
    val canReturnToShoeList: LiveData<Boolean> get() = _canReturnToShoeList

    // Used to initialize the shoe, shoes and returnToShoeList variables for when the view first loads.
    // After the initialized values have been assigned they will need to be reset programmatically by the developer.
    init {
        _shoe.value = Shoe("", 0.0, "", "")
        _shoes.value = mutableListOf()
        _canReturnToShoeList.value = false
    }

    // Add Shoe function adds a shoe to the shoes list and passes the shoes to the shoeList.
    fun addShoe() {
        _shoes.value?.add(shoe.value!!)
        _shoeList.value = _shoes.value
        _canReturnToShoeList.value = true
    }

    // Used to reset the shoe list navigation after being observe to true.
    fun resetCanReturnToShoeList() {
        _canReturnToShoeList.value = false
        resetAddShoeForm()
    }

    // Helper function to clear and reset the AddShoeForm
    // If this is not done then the values are retained.
    private fun resetAddShoeForm() {
        _shoe.value?.name = ""
        _shoe.value?.size = 0.0
        _shoe.value?.company = ""
        _shoe.value?.description = ""
    }

    // Clear Shoes function is used to clear the shoes from the shoes list
    fun clearShoes() {
        _shoes.value?.clear()
    }
}