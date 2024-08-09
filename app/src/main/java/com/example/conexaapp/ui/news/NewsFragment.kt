package com.example.conexaapp.ui.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.conexaapp.MainActivity
import com.example.conexaapp.R
import com.example.conexaapp.databinding.FragmentHomeBinding
import com.example.conexaapp.ui.news.adapter.AdapterNews

class NewsFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var adapterNews: AdapterNews

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val newsViewModel =
            ViewModelProvider(this).get(NewsViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        newsViewModel.getNews()

        (activity as? MainActivity)?.setUpToolbar(false, "All news") {}

        newsViewModel.newsModel.observe(viewLifecycleOwner) { list ->
            if (list.isNotEmpty()){
                binding.pbLoader.visibility = GONE

                adapterNews = AdapterNews(list) {
                    findNavController().navigate(NewsFragmentDirections.actionNavigationHomeToNewDetailFragment(it))
                }
                binding.rvNews.adapter = adapterNews

                binding.etSearchView.addTextChangedListener { filter ->
                    adapterNews.updateList(list.filter { it.title.lowercase().contains(filter.toString().lowercase()) || it.description.lowercase().contains(filter.toString().lowercase()) })
                }
            }
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}