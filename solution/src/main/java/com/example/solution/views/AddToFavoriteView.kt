package com.example.solution.views

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.res.ResourcesCompat
import com.example.solution.R
import com.example.solution.utils.extensions.dpToPx
import com.example.solution.utils.extensions.spToPx

/**
 * Задача 10
 *
 * Компонент "Добавить в избранное"
 *
 * Текст кнопки - R.string.add_to_favorite_button_text
 * Иконка - в зависимости от статуса переданого в метод setIsFavoriteStatus()
 *          - если оффер добавлен в избранное, в это случае устанавливаем иконку R.drawable.small_black_fill_heart
 *          - если оффер НЕ добавлен в избранное в это случае устанавливаем иконку R.drawable.small_black_heart
 * Цвет фона - R.color.add_to_favorite_button_bg_color
 *
 * Макет - "../images/figma/addToFavoriteView.svg"
 */
class AddToFavoriteView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    /**
     * Устанавливает статус
     *
     * input: передается true - если оффер добавлен в избранное, в это случае устанавливаем иконку R.drawable.small_black_fill_heart
     *        передается false - если оффер НЕ добавлен в избранное в это случае устанавливаем иконку R.drawable.small_black_heart
     */
    fun setIsFavoriteStatus(isFavorite: Boolean) {
        // TODO add logic
    }

    // TODO add UI
}
