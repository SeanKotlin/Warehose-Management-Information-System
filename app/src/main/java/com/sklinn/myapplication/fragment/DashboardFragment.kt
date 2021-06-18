package com.sklinn.myapplication.fragment

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sklinn.myapplication.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        btn_toAddEmployee.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_addCustomerFragment)
        }

        btn_toAddProduct.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_addProductFragment)
        }

        btn_toAddVendor.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_addVendorFragment)
        }

        btn_toEmployeeList.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_customerListFragment)
        }

        btn_toProductList.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_productListFragment)
        }

        btn_toVendorList.setOnClickListener {
            findNavController().navigate(R.id.action_dashboardFragment_to_vendorListFragment)
        }

        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_profile, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId==R.id.menu_item_profile){
            findNavController().navigate(R.id.action_dashboardFragment_to_profileFragment)
        }
        return super.onOptionsItemSelected(item)
    }

}