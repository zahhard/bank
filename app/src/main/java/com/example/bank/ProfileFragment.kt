package com.example.bank

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.bank.databinding.FragmentInputProfileBinding
import com.example.bank.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    lateinit var binding : FragmentProfileBinding
    lateinit var ppreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ppreferences =  requireActivity().getSharedPreferences("SHARED_PREF", Context.MODE_PRIVATE)
        if ( ppreferences.getBoolean("isRemember", false) ) {
            binding.textView2.text = ppreferences.getString("NAME", "")
            binding.textView3.text = ppreferences.getString("CODE", "")
            binding.textView4.text = ppreferences.getString("BIRTHPLACE", "")
            binding.textView5.text = ppreferences.getString("ADDRESS", "")
            binding.textView6.text = ppreferences.getString("POSTCODE", "")
        }
        else
            findNavController().navigate(R.id.action_profileFragment2_to_inputProfileFragment)

        buttonsHandler()
    }

    private fun buttonsHandler() {
        binding.btnAddNewPerson.setOnClickListener {
            val editor: SharedPreferences.Editor = ppreferences.edit()
            editor.clear()
            editor.apply()
            findNavController().navigate(R.id.action_profileFragment2_to_inputProfileFragment)
        }

        binding.btnEdit.setOnClickListener {
            Toast.makeText(requireContext(), "qqqqqqqqqqqqq", Toast.LENGTH_SHORT).show()
            val editor: SharedPreferences.Editor = ppreferences.edit()
            editor.putBoolean("isRemember", false)
            editor.apply()
            findNavController().navigate(R.id.action_profileFragment2_to_inputProfileFragment)
        }
    }
}