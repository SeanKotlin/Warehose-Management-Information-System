package com.sklinn.myapplication.fragment.list

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sklinn.myapplication.R


class VendorListFragment : Fragment(R.layout.fragment_list_vendor) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            findNavController().navigate(R.id.action_vendorListFragment_to_addVendorFragment)
        }else if(item.itemId == R.id.menu_delete){
            //todo: delete function
        }
        return super.onOptionsItemSelected(item)
    }

}