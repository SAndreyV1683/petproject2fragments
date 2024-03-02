package com.example.petproject2fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import com.example.petproject2fragments.databinding.FragmentBNestedBinding

class NestedFragmentB: BindingFragment<FragmentBNestedBinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBNestedBinding {
        return FragmentBNestedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val songNameProvider = activity as SongNameProvider
        binding.titleNestedFragmentB.text = songNameProvider.getSongName().plus(other = " | B")
        binding.button.setOnClickListener {
            parentFragmentManager.commit {
                (parentFragment as SelectPage).navigateTo(page = 0)
            }
        }
    }
}
