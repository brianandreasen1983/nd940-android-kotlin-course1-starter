package com.udacity.shoestore.viewmodels

import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    var shoe = Shoe("", "", "", "")
    // Represents data of a single shoe...
//    private val _shoe = MutableLiveData<Shoe>()
//    val shoe: LiveData<Shoe> get() = _shoe

    private var _shoes = mutableListOf<Shoe>()
    private val _shoeList = MutableLiveData<List<Shoe>>()
    val shoeList: LiveData<List<Shoe>> get() = _shoeList

    fun addShoe(shoe: Shoe) {
        _shoes.add(shoe)
        _shoeList.value = _shoes
    }
}