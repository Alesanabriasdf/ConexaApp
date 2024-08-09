package com.example.conexaapp.ui.news.newdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.conexaapp.MainActivity
import com.example.conexaapp.databinding.FragmentNewDetailBinding
import com.squareup.picasso.Picasso

class NewDetailFragment : Fragment() {

    private var _binding: FragmentNewDetailBinding? = null
    private val args: NewDetailFragmentArgs by navArgs()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val newsViewModel =
            ViewModelProvider(this).get(NewDetailViewModel::class.java)

        _binding = FragmentNewDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        newsViewModel.getNewDetail(args.idNew)

        (activity as? MainActivity)?.setUpToolbar(true, "New") {
            findNavController().popBackStack()
        }

        binding.pbLoaderDetailOffer.visibility = View.VISIBLE

        newsViewModel.newDetailModel.observe(viewLifecycleOwner) {
            if (it != null) {
                binding.pbLoaderDetailOffer.visibility = View.GONE

                with(binding) {
                    tvTitleNewDetail.text = it.title
                    tvDescriptionNewDetail.text = it.description
                    Picasso.get().load(it.image).into(ivNewDetail)
                    tvAuthor.text = it.author
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