package com.example.petproject2fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.petproject2fragments.databinding.FragmentANestedBinding

class NestedFragmentA: BindingFragment<FragmentANestedBinding>() {



    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentANestedBinding {
        return FragmentANestedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleNestedFragmentA.text = (requireActivity() as SongNameProvider).getSongName().plus(other = " | A")
        binding.button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_child_container, NestedFragmentB())
                addToBackStack(null)
            }
        }
    }
}
