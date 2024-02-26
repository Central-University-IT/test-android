package com.example.prod_playground.ui.secialOffersRecycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.solution.entities.SpecialOfferUiItem
import com.example.solution.utils.extensions.imageIdToResId
import com.example.solution.views.OfferView

class SpecialOffersRecyclerAdapter(
    val items: List<SpecialOfferUiItem>,
    private val itemRootClickListener: (String) -> Unit,
    private val onLikeClickListener: (String, Int) -> Unit,
) : RecyclerView.Adapter<SpecialOffersRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val root = OfferView(parent.context)
        return ViewHolder(root)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        with(holder.root) {
            setOfferName(item.title.replace("\n", " "))
            setOfferDescription(item.description)
            setCashBackValue(item.bonusValue)
            setBackgroundColor(item.bgColorHex)
            setImage(imageIdToResId(item.imageId))

            setOnClickListener {
                itemRootClickListener(item.id)
            }

            setLikeButtonIconStatus(item.isFavorite)

            setLikeButtonClickListener { onLikeClickListener(item.id, position) }

            if (item.bundle != null) {
                setBundle(
                    bundleName = item.bundle!!.name,
                    bgColorHex = item.bundle!!.baseColor,
                    borderColorHex = item.bundle!!.secondaryColor
                )
            }
        }
    }

    class ViewHolder(itemView: OfferView) : RecyclerView.ViewHolder(itemView) {
        val root = itemView
    }
}
