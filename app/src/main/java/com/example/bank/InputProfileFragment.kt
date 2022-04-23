package com.example.bank

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bank.databinding.FragmentInputProfileBinding

class InputProfileFragment : Fragment() {
    lateinit var binding: FragmentInputProfileBinding
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentInputProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedPreferences =
            requireActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)

        checkToNavigate()
        register()
        checkToShowEdit()
    }

    private fun checkToShowEdit() {
        if (sharedPreferences.contains("NAME") && !sharedPreferences.getBoolean("isRemember", false))
            binding.myEditTextName.setText(sharedPreferences.getString("NAME", ""))
        if (sharedPreferences.contains("CODE") && !sharedPreferences.getBoolean("isRemember", false))
            binding.myEditTextCode.setText(sharedPreferences.getString("CODE", ""))
        if (sharedPreferences.contains("POSTCODE") && !sharedPreferences.getBoolean("isRemember", false))
            binding.myEditTextPost.setText(sharedPreferences.getString("POSTCODE", ""))
        if (sharedPreferences.contains("BIRTHPLACE") && !sharedPreferences.getBoolean("isRemember", false))
            binding.myEditTextBirth.setText(sharedPreferences.getString("BIRTHPLACE", ""))
        if (sharedPreferences.contains("ADDRESS") && !sharedPreferences.getBoolean("isRemember", false))
            binding.myEditText1.setText(sharedPreferences.getString("ADDRESS", ""))
    }

    private fun register() {
        sharedPreferences =
            requireActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        binding.button.setOnClickListener {
            checkEmptyView()
            if (!checkEmptyView()) {
                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putBoolean("isRemember", true)
                editor.putString("NAME", binding.myEditTextName.text.toString())
                editor.putString("CODE", binding.myEditTextCode.text.toString())
                editor.putString("POSTCODE", binding.myEditTextPost.text.toString())
                editor.putString("BIRTHPLACE", binding.myEditTextBirth.text.toString())
                editor.putString("ADDRESS", binding.myEditText1.text.toString())
                editor.apply()
                Toast.makeText(requireActivity(), "shared successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_inputProfileFragment_to_profileFragment2)
            }
        }
    }

    private fun checkToNavigate() {
        if (  sharedPreferences.getBoolean("isRemember", false)  ) {
            findNavController().navigate(R.id.action_inputProfileFragment_to_profileFragment2)
        }
    }

    private fun checkEmptyView(): Boolean {
        var isChecked = false
        if (binding.myEditTextCode.text?.isBlank() == true) {
            binding.myEditTextCode.error = "*"
            isChecked = true
        }
        if (binding.myEditTextName.text?.isBlank() == true) {
            binding.myEditTextName.error = "*"
            isChecked = true
        }
        if (binding.myEditText1.text?.isBlank() == true) {
            binding.myEditText1.error = "*"
            isChecked = true
        }
        if (binding.myEditTextBirth.text?.isBlank() == true) {
            binding.myEditTextBirth.error = "*"
            isChecked = true
        }
        if (binding.myEditTextPost.text?.isBlank() == true) {
            binding.myEditTextPost.error = "*"
            isChecked = true
        }

        return isChecked
    }

    private fun init() {
        binding.myEditTextCode.text = null
        binding.myEditTextName.text = null
        binding.myEditText1.text = null
        binding.myEditTextBirth.text = null
        binding.myEditTextPost.text = null
    }
}