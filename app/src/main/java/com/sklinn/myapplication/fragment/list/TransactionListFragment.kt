package com.sklinn.myapplication.fragment.list

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.sklinn.myapplication.R


class TransactionListFragment : Fragment(R.layout.fragment_transaction_list) {

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
            findNavController().navigate(R.id.action_transactionListFragment_to_addTransactionFragment)
        }else if(item.itemId == R.id.menu_delete){
            //todo: delete function
        }
        return super.onOptionsItemSelected(item)
    }
}