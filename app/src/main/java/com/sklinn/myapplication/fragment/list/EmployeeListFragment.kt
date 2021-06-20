package com.sklinn.myapplication.fragment.list

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sklinn.myapplication.R
import com.sklinn.myapplication.adapter.EmployeeAdapter
import com.sklinn.myapplication.viewmodel.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_list_employee.*

class EmployeeListFragment : Fragment(R.layout.fragment_list_employee) {

    private lateinit var employeeAdapter: EmployeeAdapter
    private lateinit var employeeViewModel: EmployeeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        employeeViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(activity?. application!!)
        )[EmployeeViewModel::class.java]

        employeeAdapter = EmployeeAdapter()
        rvCustomerList.adapter = employeeAdapter
        rvCustomerList.layoutManager =
            LinearLayoutManager(requireContext())

        employeeViewModel.readAllEmployee.observe(viewLifecycleOwner,{employees->
            employeeAdapter.setNewData(employees)
            Log.d("employees", employees.toString())
        })


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            findNavController().navigate(R.id.action_customerListFragment_to_addCustomerFragment)
        } else if (item.itemId == R.id.menu_delete) {
            //todo: delete function
        }
        return super.onOptionsItemSelected(item)
    }

}