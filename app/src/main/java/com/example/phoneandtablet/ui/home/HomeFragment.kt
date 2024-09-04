package com.example.phoneandtablet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoneandtablet.databinding.FragmentHomeBinding
import com.example.phoneandtablet.ui.adapter.SimpsonAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: SimpsonAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel: HomeViewModel by viewModels()

        homeViewModel.details.observe(viewLifecycleOwner) { details ->
            binding.apply {
                simpsonRecycle.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = SimpsonAdapter(details.relatedTopics).also {
                        this@HomeFragment.adapter = it
                    }
                }
            }
        }



        // Set up SearchView listener
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
        homeViewModel.getSimpson("simpsons+characters", "json")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}