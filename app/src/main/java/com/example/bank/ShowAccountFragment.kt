package com.example.bank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.bank.databinding.FragmentShowAccountBinding

class ShowAccountFragment : Fragment() {
    private lateinit var binding: FragmentShowAccountBinding

    // var accounts : List<AccountEntity>
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShowAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      //var accounts = viewModel.showAllAccount()
        observeAll()
        binding.tvCount.text = viewModel.count.toString()
        var adapter = CustomAdapter(viewModel.listAccount)
        binding.recyclerview.adapter = adapter
    }


    private fun observeAll(){
        val countObserver = Observer<Int>{ count ->
            binding.tvCount.text = count.toString()
        }

        viewModel.list?.observe(requireActivity()){
            it.forEach {
                //خب اینجا تو حلقه لیست اکانت هارو بهت میده
               //binding.tvAccountNum.text=it.accountNumber.toString()
                viewModel.listAccount.add(it)
            }
        }
        viewModel.count?.observe(viewLifecycleOwner, countObserver)
    }

}