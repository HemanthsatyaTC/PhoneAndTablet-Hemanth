package com.example.phoneandtablet.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoneandtablet.databinding.FragmentDashboardBinding
import com.example.phoneandtablet.ui.adapter.WireAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private lateinit var binding : FragmentDashboardBinding

    private lateinit var adapter: WireAdapter

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
                    adapter = WireAdapter(it.relatedTopics).also {
                        this@DashboardFragment.adapter = it
                    }
                }
            }
        }




        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
        dashboardViewModel.getWire("the+wire+characters", "json")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}