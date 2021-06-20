package com.sklinn.myapplication.fragment.add

import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sklinn.myapplication.R
import com.sklinn.myapplication.data.Vendor
import com.sklinn.myapplication.viewmodel.VendorViewModel
import kotlinx.android.synthetic.main.fragment_add_employee.*
import kotlinx.android.synthetic.main.fragment_add_vendor.*


class AddVendorFragment : Fragment(R.layout.fragment_add_vendor) {

    private lateinit var vendorViewModel: VendorViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vendorViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application!!)
        )[VendorViewModel::class.java]

        btn_add_vendor.setOnClickListener {
            addNewVendor()
        }

    }

    private fun addNewVendor() {
        val vendorName = etVendorName.text.toString()
        val contactPerson = et_contactPerson.text.toString()
        val vendorEmail = etVendorEmail.text.toString()
        val vendorBusinessPhone = et_VendorBusinessPhone.text.toString()
        val vendorMobile = et_VendorMobilePhone.text.toString()
        val address = et_VendorAddress.text.toString()
        val vendorNotes = et_VendorNote.text.toString()

        val vendor = Vendor(
            vendorName = vendorName,
            contactPerson = contactPerson,
            email = vendorEmail,
            businessPhone = vendorBusinessPhone,
            mobilePhone = vendorMobile,
            address = address,
            notes = vendorNotes
        )
        if (inputCheck(vendorName, contactPerson)) {
            vendorViewModel.addVendor(vendor)
            findNavController().navigate(R.id.action_addVendorFragment_to_vendorListFragment)
            Toast.makeText(
                requireContext(),
                "Successfully added the new vendor",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                requireContext(),
                "Please must enter vendor name and contact person",
                Toast.LENGTH_LONG
            ).show()
        }

    }

    private fun inputCheck(vendorName: String, contactPerson: String): Boolean {
        return !(TextUtils.isEmpty(vendorName) && TextUtils.isEmpty(contactPerson))
    }

}