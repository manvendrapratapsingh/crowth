package com.know.myapplication.ui.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.know.myapplication.databinding.FragmentDashboardBinding
import com.know.myapplication.databinding.FragmentUseractivityBinding

class UserActivityFragment : Fragment() {

    private lateinit var dashboardViewModel: UserActivityViewModel
    private var _binding: FragmentUseractivityBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(UserActivityViewModel::class.java)

        _binding = FragmentUseractivityBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textUseractivity
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}