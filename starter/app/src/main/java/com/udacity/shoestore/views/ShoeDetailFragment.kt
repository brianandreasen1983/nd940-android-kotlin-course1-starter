package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeDetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.viewmodels.ShoeViewModel
import kotlinx.android.synthetic.main.shoe_detail_fragment.view.*

class ShoeDetailFragment : Fragment() {
    private lateinit var binding: ShoeDetailFragmentBinding
    private lateinit var viewModel: ShoeViewModel
    // Shared Data Model
    // See the following documentation here: https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
    private val model: ShoeViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_detail_fragment,
                container,
                false
        )

        viewModel = ViewModelProvider(this).get(ShoeViewModel::class.java)
        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        // Intent is to navigate back to the shoe listing fragment.
        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.shoeListingFragment)
        }

        // Requirement is conflicting where if it is added then to navigate to the shoe list.
        binding.addShoe.setOnClickListener {
            var shoe = Shoe(
                    binding.etShoeName.text.toString(),
                    binding.etShoeSize.text.toString(),
                    binding.etCompanyName.text.toString(),
                    binding.etShoeDescription.text.toString()
            )

            viewModel.addShoe(shoe)
             findNavController().navigate(R.id.shoeListingFragment)
        }

        return binding.root
    }
}