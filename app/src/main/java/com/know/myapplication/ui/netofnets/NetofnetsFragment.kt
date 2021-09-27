package com.know.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.know.myapplication.databinding.FragmentHomeBinding
import com.know.myapplication.databinding.FragmentNetsofnetsBinding

class NetofnetsFragment : Fragment() {

    private lateinit var homeViewModel: NetofnetsViewModel
    private var _binding: FragmentNetsofnetsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(NetofnetsViewModel::class.java)

        _binding = FragmentNetsofnetsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        homeViewModel.text.observe(viewLifecycleOwner, Observer {

        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}