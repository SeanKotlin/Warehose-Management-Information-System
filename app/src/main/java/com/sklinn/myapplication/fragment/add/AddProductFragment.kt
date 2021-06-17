package com.sklinn.myapplication.fragment.add

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CalendarView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sklinn.myapplication.R
import com.sklinn.myapplication.data.Product
import com.sklinn.myapplication.viewmodel.WarehouseViewModel
import kotlinx.android.synthetic.main.fragment_add_product.*
import java.text.SimpleDateFormat
import java.util.*

class AddProductFragment : Fragment(R.layout.fragment_add_product) {

    private lateinit var mViewModel: WarehouseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel = ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(
            activity?.application!!
        ))[WarehouseViewModel::class.java]

        btnAddProduct.setOnClickListener {
            addProduct()
            findNavController().navigate(R.id.action_addProductFragment_to_productListFragment)
            notifyUser("Successfully add the product!!")
        }
    }

    private fun addProduct() {
        val pCode = et_product_code.text.toString()
        val item = et_item.text.toString()
        val description = et_product_description.text.toString()
        val category = et_product_category.text.toString()
        val grants = et_grants.text.toString()
        val expiryDate = et_expiryDate.setOnClickListener {
            datePick()
        }.toString()
        val lotNumber = et_product_lotNumber.text.toString()
        val unit = et_product_unit.text.toString()
        val discontinued = et_discontinue.isChecked
        val comment = et_comments.text.toString()

        val product = Product(
            pCode = pCode,
            item = item,
            description = description,
            category = category,
            grants = grants,
            expiryDate = expiryDate,
            lotNumber = lotNumber,
            countingUnit = unit,
            discontinued = discontinued,
            comments = comment
        )

        mViewModel.addProduct(product)

    }

    private fun notifyUser(message:String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
    }

     fun datePick():String{
        val calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val dpd = DatePickerDialog(requireContext(),{_,year, month, date ->
            calendar.set(year,Calendar.YEAR)
            calendar.set(month, Calendar.MONTH)
            calendar.set(date, Calendar.DAY_OF_MONTH)

        },Calendar.YEAR,Calendar.MONTH,Calendar.DAY_OF_MONTH)
         dpd.show()
        return sdf.format(calendar.time)
    }


}