package com.example.phoneandtablet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.phoneandtablet.databinding.FragmentHomeBinding
import com.example.phoneandtablet.ui.adapter.SimpsonAdapter

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private lateinit var binding : FragmentHomeBinding

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

        homeViewModel.details.observe(viewLifecycleOwner){

            binding.apply {
                simpsonRecycle.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = SimpsonAdapter(it.relatedTopics)

                }
            }

        }
        homeViewModel.getSimpson("simpsons+characters", "json")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}