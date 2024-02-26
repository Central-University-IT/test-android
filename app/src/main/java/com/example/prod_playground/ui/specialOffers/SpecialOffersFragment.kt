package com.example.prod_playground.ui.specialOffers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prod_playground.R
import com.example.prod_playground.databinding.FragmentSpecialOffersBinding
import com.example.prod_playground.ui.alerts.InfoAlertDialogFragment
import com.example.prod_playground.ui.favorites.FavoritesScreenFragment
import com.example.prod_playground.ui.offerInfo.OfferInfoFragment
import com.example.prod_playground.ui.secialOffersRecycler.SpecialOffersRecyclerAdapter
import com.example.solution.utils.extensions.imageIdToResId

class SpecialOffersFragment : Fragment() {

    private lateinit var binding: FragmentSpecialOffersBinding
    private lateinit var viewModel: SpecialOffersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            SpecialOffersViewModelFactory()
        )[SpecialOffersViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecialOffersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initBannerInfoUi()
        initProfileInfoUi()
        initFavoritesUi()
        initSpecialOffersListUi()
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavoritesBadgeCount()
        viewModel.getSpecialOffersList()
    }

    private fun initBannerInfoUi() {
        viewModel.bannerInfoLiveData.observe(requireActivity()) {
            binding.promoBanner.apply {
                setBackgroundColor(it.backgroundColor)
                setImage(imageIdToResId(it.imageId))
                setTitle(it.title)
                setDescription(it.description)

                setOnClickListener {
                    InfoAlertDialogFragment().show(parentFragmentManager, "InfoAlertDialogFragment")
                }
            }
        }
    }

    private fun initProfileInfoUi() {
        with(viewModel) {
            userInfoLiveData.observe(requireActivity()) { userInfo ->
                binding.profileView.apply {
                    setUserName(userInfo.userName)
                    setBalance(userInfo.balance)
                    setSpecialPoints(userInfo.specialPoints)

                    setOnClickListener {
                        InfoAlertDialogFragment().show(
                            parentFragmentManager,
                            "InfoAlertDialogFragment"
                        )
                    }
                }
            }
        }
    }

    private fun initFavoritesUi() {
        viewModel.favoritesBadgeCountLiveData.observe(requireActivity()) { value ->

            binding.favoriteView.apply {
                setBadgeCount(value)

                setOnClickListener {
                    val fragment = FavoritesScreenFragment()
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, fragment)
                        .addToBackStack(null)
                        .commit()
                }
            }
        }
    }

    private fun initSpecialOffersListUi() {
        viewModel.specialOffersListLiveData.observe(requireActivity()) {

            val itemRootClickListener: (String) -> Unit = { id ->
                val fragment = OfferInfoFragment.newInstance(id)
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, fragment)
                    .addToBackStack(null)
                    .commit()
            }

            val onLikeClickListener: (String, Int) -> Unit = { id, position ->
                viewModel.onLikeClick(id, position)
            }

            binding.offersListRecycler.adapter = SpecialOffersRecyclerAdapter(
                items = it,
                itemRootClickListener = itemRootClickListener,
                onLikeClickListener = onLikeClickListener,
            )
        }

        viewModel.updateSpecialOffersListLiveData.observe(requireActivity()) {
            binding.offersListRecycler.adapter?.notifyItemChanged(it)
        }
    }
}
