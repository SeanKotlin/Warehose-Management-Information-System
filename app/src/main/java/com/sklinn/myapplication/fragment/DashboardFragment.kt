package com.sklinn.myapplication.fragment

import androidx.fragment.app.Fragment
import com.sklinn.myapplication.R

class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

//    private lateinit var employeeAdapter: EmployeeAdapter
//    private lateinit var productAdapter: ProductAdapter
//    private lateinit var mViewModel: AndroidViewModel

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)

//        mViewModel = ViewModelProvider(
//            this,
//            ViewModelProvider.AndroidViewModelFactory.getInstance(activity?.application!!)
//        ).get(WarehouseViewModel::class.java)
//
//        employeeAdapter = EmployeeAdapter()
//        productAdapter = ProductAdapter()
//
//        recyclerViewEmployeeList.adapter = employeeAdapter
//        recyclerViewEmployeeList.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
//
//        (mViewModel as WarehouseViewModel).readAllEmployee.observe(
//            viewLifecycleOwner,
//            Observer { users ->
//                employeeAdapter.setNewData(users)
//            })
//    }

}