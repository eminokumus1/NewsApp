package com.eminokumus.newsapp.news

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.eminokumus.newsapp.MainActivity
import com.eminokumus.newsapp.databinding.FragmentNewsBinding
import com.eminokumus.newsapp.vo.Article
import javax.inject.Inject


class NewsFragment : Fragment(), OnNewsItemClickListener {
    private lateinit var binding: FragmentNewsBinding



    @Inject
    lateinit var viewModel: NewsViewModel

    private val newsAdapter = NewsAdapter(this)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        (activity as MainActivity).appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNewsBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.newsPagingData.observe(viewLifecycleOwner) {
            newsAdapter.submitData(lifecycle, it)
        }

        newsAdapter.addLoadStateListener {state->
            when(state.refresh){
                is LoadState.Loading ->{
                    binding.newsProgress.visibility = View.VISIBLE
                }
                is LoadState.NotLoading ->{
                    binding.newsProgress.visibility = View.GONE
                }
                else ->{
                    binding.newsProgress.visibility = View.GONE
                    Toast.makeText(requireContext(),"Error", Toast.LENGTH_SHORT).show()
                }
            }

        }

        binding.newsRecyler.adapter = newsAdapter
    }

    override fun onNewsItemClick(article: Article?) {
        findNavController().navigate(
            NewsFragmentDirections.actionNewsFragmentToDetailsFragment(article)
        )
    }


}