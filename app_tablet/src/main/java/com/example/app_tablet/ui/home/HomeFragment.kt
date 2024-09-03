package com.example.app_tablet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.app_tablet.databinding.FragmentHomeBinding
import com.example.app_tablet.ui.adapter.SimpsonAdapter
import com.example.app_tablet.ui.adapter.WireAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var binding : FragmentHomeBinding

//    private lateinit var leftAdapter: SimpsonAdapter
//    private lateinit var rightAdapter: WireAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel: HomeViewModel by viewModels()

        homeViewModel.detailsleft.observe(viewLifecycleOwner){

            binding.apply {
                simpsonRecycle.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = SimpsonAdapter(it)

                }
            }

        }
        homeViewModel.getSimpson("simpsons+characters", "json")
        val dashboardViewModel: HomeViewModel by viewModels()

        dashboardViewModel.detailsRight.observe(viewLifecycleOwner){

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