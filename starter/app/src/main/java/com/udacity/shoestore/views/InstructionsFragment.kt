package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.InstructionsFragmentBinding

class InstructionsFragment: Fragment() {
    private lateinit var binding: InstructionsFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.instructions_fragment,
                container,
                false
        )

        binding.lifecycleOwner = this
        binding.shoeListingButton.setOnClickListener {
            findNavController().navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoeListingFragment())
        }

        return binding.root
    }
}