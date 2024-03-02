package com.example.petproject2fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.petproject2fragments.databinding.FragmentABinding

class FragmentA: BindingFragment<FragmentABinding>() {

    override fun createBinding(inflater: LayoutInflater, container: ViewGroup?): FragmentABinding {
        return FragmentABinding.inflate(inflater, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleFragmentA.text = requireArguments().getString(SONG_NAME_KEY)
            .plus(other = " | Parent")
        childFragmentManager.beginTransaction()
            .add(R.id.fragment_child_container, NestedFragmentA())
            .commit()
    }

    companion object {
        private const val SONG_NAME_KEY = "SONG_NAME_KEY"
        fun getInstance(songName: String): FragmentA = FragmentA().apply {
            arguments = bundleOf(SONG_NAME_KEY to songName)
        }
    }
}