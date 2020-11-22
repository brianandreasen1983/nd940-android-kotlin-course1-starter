package com.udacity.shoestore.views

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ShoeListingFragmentBinding
import com.udacity.shoestore.viewmodels.ShoeViewModel

class ShoeListingFragment : Fragment() {
    // Shared Data Model
    // See the following documentation here: https://developer.android.com/topic/libraries/architecture/viewmodel#sharing
    private val viewModel: ShoeViewModel by activityViewModels()
    private lateinit var binding: ShoeListingFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.shoe_listing_fragment,
                container,
                false
        )

        binding.shoeViewModel = viewModel
        binding.lifecycleOwner = this

        binding.fab.setOnClickListener {
            findNavController().navigate(ShoeListingFragmentDirections.actionShoeListingFragmentToShoeDetailFragment())
        }


        // Observer that watches the shoeList in order to update the UI appropriately
//        model.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
//            shoeList.forEach { shoe ->
//                val shoeBinding: ShoeViewBinding = DataBindingUtil.inflate(inflater, R.layout.shoe_view, container, false)
//                shoeBinding.shoe = shoe
//                binding.linearList.addView(shoeBinding.root)
//            }
//        })

//        viewModel.shoeList.observe(viewLifecycleOwner, Observer {shoeList ->
//            // TODO: Construct a UI and inflate it.
//              // TODO: Test this afterwards
//            shoeList.forEach { shoe ->
//                val shoeBinding: ShoeViewBinding = DataBindingUtil.inflate(inflate, R.layout., container, false)
//                shoeBinding.shoe
//                binding.linearList.addView(shoeBinding.root)
//            }
//        })

        // Sets the action bar items.
        setHasOptionsMenu(true)
        return binding.root
    }

    // Provides inflation for the menu to be displayed on the screen.
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.logout_menu, menu)
    }

    // Provides the ability to navigate.
    // Id's must match
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}