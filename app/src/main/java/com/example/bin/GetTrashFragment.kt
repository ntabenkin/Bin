package com.example.bin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bin.databinding.GetTrashFragmentBinding


class GetTrashFragment : Fragment() {

    private lateinit var binding: GetTrashFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = GetTrashFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        binding.rvItems.layoutManager = layoutManager


        //binding.listTrash.setOnClickListener {
         //   findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
     //   }
    }
    private fun buildUI(){

        }
    fun navigate() {

    }

}
