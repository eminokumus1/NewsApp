package com.eminokumus.newsapp.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eminokumus.newsapp.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)


        return binding.root
    }


}