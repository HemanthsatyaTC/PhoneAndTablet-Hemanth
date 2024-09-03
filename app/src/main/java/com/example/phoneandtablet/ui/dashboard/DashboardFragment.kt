package com.example.phoneandtablet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoneandtablet.databinding.FragmentDashboardBinding
import com.example.phoneandtablet.ui.adapter.SimpsonAdapter
import com.example.phoneandtablet.ui.adapter.WireAdapter
import com.example.phoneandtablet.ui.home.HomeViewModel

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null

    private lateinit var binding : FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dashboardViewModel: DashboardViewModel by viewModels()

        dashboardViewModel.details.observe(viewLifecycleOwner){

            binding.apply {
                wireRecycle.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = WireAdapter(it)

                }
            }

        }
        dashboardViewModel.getWire("the+wire+characters", "json")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}