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
    // Shared Data Model
    // See the following documentation here: https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoeDetailFragmentBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_detail_fragment,
                container,
                false
        )

        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(R.id.shoeListingFragment)
        }

        // Observe the shoeList and if a new shoe has been added to the list then navigate back to the ui
        // Need to determine if the model or ViewModel shoudl be observed.
        // viewModel works, model does not.
        // FATAL ERROR on navigation.
        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            if (shoeList.isNotEmpty()){
                findNavController().navigate(R.id.shoeListingFragment)
            }
        })

        return binding.root
    }
}