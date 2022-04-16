package com.example.bank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.room.Room
import com.example.bank.AppDatabase.Companion.db
import com.example.bank.databinding.FragmentCraeteAccountBinding

class CraeteAccountFragment : Fragment() {
    lateinit var binding: FragmentCraeteAccountBinding
    val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       binding = FragmentCraeteAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnRegester.setOnClickListener {
            checkBeFull()
            var type = ""
            if (binding.saving.isChecked)
                type = binding.saving.text.toString()
            if (binding.Gharzolhasane.isChecked)
                type = binding.Gharzolhasane.text.toString()
            AccountRepository.insertAccount(type , binding.myEditTextBalance.text.toString())
        }
    }

    private fun checkBeFull() {
        if (binding.myEditTextBirth.text.isNullOrBlank()){
            binding.myEditTextBirth.error = ""
        }
        if (binding.myEditTextName.text.isNullOrBlank()){
            binding.myEditTextName.error = ""
        }
        if (binding.myEditTextPost.text.isNullOrBlank()){
            binding.myEditTextPost.error = ""
        }
    }
}