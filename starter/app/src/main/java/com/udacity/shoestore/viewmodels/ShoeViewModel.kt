package com.udacity.shoestore.viewmodels

import android.util.Log
import androidx.lifecycle.*
import com.udacity.shoestore.models.Shoe

class ShoeViewModel : ViewModel() {
    private var _shoe = MutableLiveData<Shoe>()
    val shoe: LiveData<Shoe> get() = _shoe

    private var _shoes = MutableLiveData<MutableList<Shoe>>()
    private val _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: LiveData<MutableList<Shoe>> get() = _shoeList

    init {
        _shoe.value = Shoe("", "", "", "")
        _shoes.value = mutableListOf()
    }

    fun addShoe() {
        _shoes.value?.add(shoe.value!!)
        _shoeList.value = _shoes.value
    }
}