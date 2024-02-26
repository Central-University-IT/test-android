package com.example.prod_playground.ui.offerInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.prod_playground.core.api.domain.models.OfferTermsData
import com.example.prod_playground.databinding.FragmentCashBackInfoBinding
import com.example.solution.utils.extensions.imageIdToResId

class OfferInfoFragment : Fragment() {

    private lateinit var binding: FragmentCashBackInfoBinding
    private lateinit var viewModel: OfferInfoViewModel

    private var offerId: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        offerId = arguments?.getString("offerId")
        viewModel = ViewModelProvider(
            this,
            OfferInfoViewModelFactory()
        )[OfferInfoViewModel::class.java].apply {
            offerId?.let { offerId ->
                getOfferFullInfo(offerId)
                favoritesCheckPostValue(offerId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCashBackInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.offerFullInfoLiveData.observe(requireActivity()) { offerInfo ->

            binding.header.apply {
                setCashBackName(offerInfo.supplierName)
                setCashBackValue(
                    requireContext().getString(
                        com.example.solution.R.string.offer_view_cash_back_value_mask,
                        offerInfo.bonuses.value.intValueExact()
                    ),
                )
                setBackgroundColor(offerInfo.supplierBaseColor)
                setImage(imageIdToResId(offerInfo.offerImage))
            }

            binding.description.text = offerInfo.fullDescription

            offerInfo.terms.forEach {
                binding.endTime.apply {
                    setFirstValue("Дата завершения")
                    setSecondValue((it as OfferTermsData.EndDate).expirationDate.toString())
                }
            }

            binding.numberOfUses.apply {
                setFirstValue("Число использований")
                setSecondValue("3")
            }

            binding.promoCode.apply {
                setPromoCodeValue(offerInfo.promocode)
            }
        }

        viewModel.isFavoritesLiveData.observe(requireActivity()) { isFavorites ->
            binding.addToFavoriteButton.apply {
                setIsFavoriteStatus(isFavorites)
                setOnClickListener {
                    offerId?.let {
                        viewModel.onAddToFavoriteButtonClick(it)
                    }
                }
            }
        }
    }

    companion object {
        fun newInstance(offerId: String): OfferInfoFragment {
            val fragment = OfferInfoFragment()
            val args = Bundle()
            args.putString("offerId", offerId)
            fragment.arguments = args
            return fragment
        }
    }
}
