package com.example.bank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
        binding.btnCreate.setOnClickListener {
            if (checkBeFull()) {
                viewModel.addAccountToDatabase(checkType() , binding.etBalance.text.toString())
                Toast.makeText(requireActivity(), "sdfsf", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun checkBeFull() : Boolean {
        if (binding.etBalance.text.isNullOrBlank()){
            binding.etBalance.error = ""
            return false
        }
        if ( binding.rbSaving.text.isNullOrBlank() && binding.rbGharzolhasane.text.isNullOrBlank() ){
            binding.tvAccountType.error = ""
            return false
        }
        return true
    }

    fun checkType() : String {
        if (binding.rbGharzolhasane.isChecked)
            return binding.rbGharzolhasane.text.toString()
        if (binding.rbSaving.isChecked)
            return binding.rbSaving.text.toString()
        return  ""
    }
}