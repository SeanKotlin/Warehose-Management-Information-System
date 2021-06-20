package com.sklinn.myapplication.fragment.list

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklinn.myapplication.R
import com.sklinn.myapplication.adapter.VendorAdapter
import com.sklinn.myapplication.data.AppDatabase
import com.sklinn.myapplication.data.VendorDao
import com.sklinn.myapplication.viewmodel.VendorViewModel
import com.sklinn.myapplication.viewmodel.WarehouseViewModel
import kotlinx.android.synthetic.main.fragment_list_vendor.*


class VendorListFragment : Fragment(R.layout.fragment_list_vendor) {

    private lateinit var vendorAdapter: VendorAdapter
    private lateinit var mViewModel: WarehouseViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        mViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(
                activity?.application!!
            )
        )[WarehouseViewModel::class.java]

        vendorAdapter = VendorAdapter()
        rvVendorList.adapter = vendorAdapter
        rvVendorList.layoutManager = LinearLayoutManager(requireContext())

        mViewModel.readAllVendor.observe(viewLifecycleOwner,{vendorList->
            vendorAdapter.setNewData(vendorList)
            Log.d("vendors",vendorList.toString())
        })
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            findNavController().navigate(R.id.action_vendorListFragment_to_addVendorFragment)
        } else if (item.itemId == R.id.menu_delete) {
            //todo: delete function
        }
        return super.onOptionsItemSelected(item)
    }

}