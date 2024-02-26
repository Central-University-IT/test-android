package com.example.solution.views

import android.content.Context
import android.graphics.Typeface
import android.graphics.Typeface.NORMAL
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import com.example.solution.R
import com.example.solution.utils.extensions.dpToPx
import com.example.solution.utils.extensions.spToPx

/**
 * Задача 9
 *
 * Компонент "Промокод"
 *
 * Заголовок - R.string.promo_code_view_text
 * Иконка - R.drawable.copy_icon
 *
 * Макет - "../images/figma/promocodeView.svg"
 */
class PromoCodeView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    /**
     * Устанавливает значение промокода
     *
     * input: Промокод
     */
    fun setPromoCodeValue(value: String) {
        // TODO add logic
    }
}
