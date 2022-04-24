package com.example.bank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.bank.databinding.FragmentHomeBinding
import com.example.bank.databinding.FragmentShowAccountBinding

class ShowAccountFragment : Fragment() {
    private lateinit var binding: FragmentShowAccountBinding

    // var accounts : List<AccountEntity>
    private var conter = 0
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
        var accounts = viewModel.showAllAccount()

        viewModel.initCount()
        observeAll()
        binding.tvCount.text = viewModel.count.toString()
        binding.btnNext.setOnClickListener {
            viewModel.nextClicked()
        }
    }


    private fun observeAll(){
        val countObserver = Observer<Int>{ count ->
            binding.tvCount.text = count.toString()
        }
        val accountObserver = Observer<AccountEntity>{ account->
            binding.tvAccountNum.text = account.toString()
        }
      //  viewModel.questionLiveData?.observe(viewLifecycleOwner, accountObserver)
        viewModel.count?.observe(viewLifecycleOwner, countObserver)
    }

}