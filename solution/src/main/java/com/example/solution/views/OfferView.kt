package com.example.solution.views

import android.content.Context
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.GradientDrawable
import android.util.AttributeSet
import android.util.TypedValue
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.res.ResourcesCompat
import com.example.solution.R
import com.example.solution.utils.extensions.dpToPx
import com.example.solution.utils.extensions.spToPx


/**
 * Задача 7
 *
 * Элемент списка офферов (спрецпредложений)
 *
 * Макет - "../images/figma/offerView.svg"
 */
class OfferView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
) : LinearLayout(context, attrs, defStyleAttr) {

    /**
     * Устанавливает Название спецпредложения
     *
     * input: Название
     */
    fun setOfferName(name: String) {
        // TODO add logic
    }

    /**
     * Устанавливает Краткое описание спецпредложения
     *
     * input: Название
     */
    fun setOfferDescription(shortDescription: String) {
        // TODO add logic
    }

    /**
     * Устанавливает Процент кэшбека
     *
     * input: Процент кэшбека в формате "n%" (где n - какое-то число)
     */
    fun setCashBackValue(cashBackValue: String) {
        // TODO add logic
    }

    /**
     * Устанавливает Фон компонента (тот что розовый на макете)
     *
     * input: Hex код цвета в формате строки (например "#FFC6C6")
     */
    fun setBackgroundColor(colorHex: String) {
        // TODO add logic
    }

    /**
     * Устанавливает Картинку спецофера
     *
     * input: id ресурса картинки
     */
    fun setImage(imageResId: Int) {
        // TODO add logic
    }

    /**
     * Устанавливает Данные о подписке
     * (Подписки может не быть)
     *
     * input: bundleName - Название подписки,
     *        bgColorHex - Hex код цвета фона,
     *        borderColorHex - Hex код цвета границы,
     */
    fun setBundle(bundleName: String, bgColorHex: String, borderColorHex: String) {
        // TODO add logic
    }

    /**
     * Устанавливает состояние для Иконки кнопки "Добавить в избранное" (Сердечко в правом нижнем углу)
     *
     * input: передается true - если оффер добавлен в избранное, в это случае устанавливаем иконку R.drawable.small_red_fill_heart
     *        передается false - если оффер НЕ добавлен в избранное в это случае устанавливаем иконку R.drawable.small_gray_heart
     */
    fun setLikeButtonIconStatus(isFavorite: Boolean) {
        // TODO add logic
    }

    /**
     * Устанавливает ClickListener на кнопку "Добавить в избранное" (Сердечко в правом нижнем углу)
     *
     * input: Лямбда с действием которое выполниться после нажатия
     */
    fun setLikeButtonClickListener(onClick: () -> Unit) {
        // TODO add logic
    }
}
