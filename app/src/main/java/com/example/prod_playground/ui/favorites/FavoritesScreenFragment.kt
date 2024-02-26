package com.example.prod_playground.ui.favorites

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prod_playground.R
import com.example.prod_playground.databinding.FragmentFavoriteScreenBinding
import com.example.prod_playground.ui.secialOffersRecycler.SpecialOffersRecyclerAdapter
import com.example.prod_playground.ui.offerInfo.OfferInfoFragment

class FavoritesScreenFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteScreenBinding
    private lateinit var viewModel: FavoritesScreenViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, FavoritesScreenViewModelFactory())[FavoritesScreenViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val itemRootClickListener: (String) -> Unit = {
            val fragment = OfferInfoFragment()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .addToBackStack(null)
                .commit()
        }

        val onLikeClickListener: (String, Int) -> Unit = { id, position ->
            viewModel.onLikeClick(id, position)
        }

        viewModel.favoritesOffersListLiveData.observe(requireActivity()) {
            binding.offersListRecycler.adapter = SpecialOffersRecyclerAdapter(
                items = it,
                itemRootClickListener = itemRootClickListener,
                onLikeClickListener = onLikeClickListener,
            )
        }

        viewModel.updateSpecialOffersListLiveData.observe(requireActivity()) {
            binding.offersListRecycler.adapter?.notifyDataSetChanged()
        }
    }
}
