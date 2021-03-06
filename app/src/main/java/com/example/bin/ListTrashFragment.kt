package com.example.bin

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bin.databinding.ListTrashFragmentBinding
import com.example.bin.tools.showToast

class ListTrashFragment : Fragment() {

    private lateinit var binding: ListTrashFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = ListTrashFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buildUI()
    }

    private fun getTrashForm() = Trash(
        binding.uid.text.toString(),
        binding.type.text.toString(),
        binding.location.text.toString(),
        binding.date.text.toString(),
        binding.amount.text.toString()
    )

    val textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
                enableContinueButton(validateIsNotBlank(getTrashForm()))
        }
    }

    fun validateIsNotBlank(form: Trash): Boolean {
        return form.userID.isNotBlank() && form.type.isNotBlank() && form.location.isNotBlank() && form.date.isNotBlank() && form.amount.isNotBlank() && form.date.isNotBlank() && form.type.isNotBlank()
    }
    private fun enableContinueButton(isEnable: Boolean) {
        binding.button.isEnabled = isEnable
    }

    private fun buildUI() {
        binding.uid.addTextChangedListener(textWatcher)
        binding.type.addTextChangedListener(textWatcher)
        binding.location.addTextChangedListener(textWatcher)
        binding.date.addTextChangedListener(textWatcher)
        binding.amount.addTextChangedListener(textWatcher)

        binding.button.setOnClickListener {
            requireContext().showToast(text = " Continue ")
            requireActivity().finish()
        }
    }
}
