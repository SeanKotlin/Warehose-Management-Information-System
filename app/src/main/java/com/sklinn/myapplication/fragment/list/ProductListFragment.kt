package com.sklinn.myapplication.fragment.list

import android.os.Bundle
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
import com.sklinn.myapplication.adapter.ProductAdapter
import com.sklinn.myapplication.viewmodel.WarehouseViewModel
import kotlinx.android.synthetic.main.fragment_list_product.*

class ProductListFragment : Fragment(R.layout.fragment_list_product) {

    private lateinit var adapter: ProductAdapter
    private lateinit var mViewModel: WarehouseViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mViewModel =
            ViewModelProvider(
                this, ViewModelProvider.AndroidViewModelFactory.getInstance(
                    activity?.application!!
                )
            )[WarehouseViewModel::class.java]

        adapter = ProductAdapter()
        rvProductList.adapter = adapter
        rvProductList.layoutManager = LinearLayoutManager(requireContext())

        mViewModel.readAllProduct.observe(viewLifecycleOwner, { products ->
            adapter.setNewData(products)
            Toast.makeText(requireContext(), "add to product list", Toast.LENGTH_LONG).show()
        })

        setHasOptionsMenu(true)

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_add, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add) {
            findNavController().navigate(R.id.action_productListFragment_to_addProductFragment)
        }else if(item.itemId == R.id.menu_delete){
            //todo: delete function
        }
        return super.onOptionsItemSelected(item)
    }

}