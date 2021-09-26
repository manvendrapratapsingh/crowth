package com.know.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.know.androidnew.HomeAdapter
import com.know.myapplication.R
import com.know.myapplication.data.CrowthData
import com.know.myapplication.data.Data
import com.know.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private lateinit var mRecyclerView: RecyclerView
    private var mHomeListAdapter: HomeAdapter? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        mRecyclerView = binding.homeRecycllerView
        val LinearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.layoutManager = LinearLayoutManager;

        homeViewModel.mCrowthData.observe(viewLifecycleOwner, Observer {
            setAdapter(it)
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun setAdapter(list: List<CrowthData>) {

        if (mHomeListAdapter == null) {
            mHomeListAdapter = HomeAdapter(list!!)
            mRecyclerView!!.adapter = mHomeListAdapter

        } else {
            mHomeListAdapter!!.notifyDataSetChanged()
        }
    }


}