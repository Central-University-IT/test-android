package com.example.prod_playground.ui.alerts

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.prod_playground.R

class InfoAlertDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return AlertDialog.Builder(requireContext(), R.style.InfoAlertDialog)
            .setMessage("Функционал пока недоступен")
            .setPositiveButton("Ok") { _, _ ->
                dismiss()
            }
            .create()
    }
}
