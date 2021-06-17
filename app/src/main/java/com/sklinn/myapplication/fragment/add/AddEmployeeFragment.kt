package com.sklinn.myapplication.fragment.add

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.AndroidViewModel
import com.sklinn.myapplication.R
import com.sklinn.myapplication.data.AppDatabase
import com.sklinn.myapplication.data.Employee
import com.sklinn.myapplication.data.EmployeeDao
import kotlinx.android.synthetic.main.fragment_add_employee.*


class AddEmployeeFragment : Fragment(R.layout.fragment_add_employee) {

    private lateinit var mViewModel: AndroidViewModel
    private lateinit var employeeDao: EmployeeDao

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        mViewModel = ViewModelProvider(
//            this, ViewModelProvider.AndroidViewModelFactory.getInstance(
//                activity?.application!!
//            )
//        ).get(EmployeeVIewModel::class.java)
        employeeDao = AppDatabase.getDatabase(requireContext()).employeeDao()

        btn_add_employee.setOnClickListener {
            adddEmployee()
//            findNavController().navigate(R.id.action_addCustomerFragment_to_customerListFragment)
            Toast.makeText(requireContext(),"Successfuly added the customer", Toast.LENGTH_LONG).show()
        }
    }

    private fun adddEmployee() {
        val name = etName.text.toString()
        val email = etEmail.text.toString()
        val jobTitle = etjobTitle.text.toString()
        val township = etTowship.text.toString()
        val state = etState.text.toString()
        val businessPhone = etBusinessPhone.text.toString()
        val mobilePhone = etMobilePhone.text.toString()
        val address = etAddress.text.toString()
        val notes = etNotes.text.toString()

        val employee = Employee(
            id=0,
            name = name,
            email = email,
            jobTitle = jobTitle,
            assignedTownship = township,
            assignedState = state,
            businessPhone = businessPhone,
            mobilePhone = mobilePhone,
            address = address,
            notes = notes
        )

        employeeDao.addEmployee(employee)

    }

}