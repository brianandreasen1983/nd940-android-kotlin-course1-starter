package com.udacity.shoestore.views

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
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

        viewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList ->
            var linearLayout: LinearLayout = binding.shoeLayout.findViewById(R.id.shoe_layout)
            shoeList.forEach { shoe ->
                val view: View = layoutInflater.inflate(R.layout.shoe_view, null)
                val shoeNameTextView: TextView = view.findViewById(R.id.tv_shoe_name)
                val shoeSizeTextView: TextView = view.findViewById(R.id.tv_shoe_size)
                val shoeCompanyTextView: TextView = view.findViewById(R.id.tv_shoe_company)
                val shoeDescriptionTextView: TextView = view.findViewById(R.id.tv_shoe_description)

                shoeNameTextView.text = shoe.name
                shoeSizeTextView.text = shoe.size
                shoeCompanyTextView.text = shoe.company
                shoeDescriptionTextView.text = shoe.description

                 linearLayout.addView(view)
            }
        })

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
        viewModel.clearShoes()
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}