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
import com.udacity.shoestore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    private lateinit var binding: WelcomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.welcome_fragment,
                container,
                false
        )
        binding.lifecycleOwner = this

        binding.instructionsButton.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        return binding.root
    }
}