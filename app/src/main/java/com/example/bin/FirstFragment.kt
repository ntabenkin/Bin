package com.example.bin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import com.example.bin.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildUI()
    }
    private fun buildUI(){
        binding.getTrash.isVisible = true
        binding.listTrash.isVisible = true
        binding.listTrash.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_listTrashFragment)
        }
        binding.getTrash.setOnClickListener{
            findNavController().navigate(R.id.action_FirstFragment_to_getTrashFragment)
        }
    }

    fun navigate() {

    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}