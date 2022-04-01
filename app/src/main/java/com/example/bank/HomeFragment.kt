package com.example.bank

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bank.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding

  //  private val movieList = ArrayList<MovieModel>()
    private lateinit var transActionData: TransActionData
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().title = "Bank :)"
        setRecyclerView()
    }

    private fun setRecyclerView() {
        var posts: ArrayList<TransActionData> = ArrayList()
        var card1 = Card("1", BankName.Mellat, "Zahra")
        var card2 = Card("2", BankName.Keshavarzi, "Vahid")
        for (i in 1..5) {
            posts.add(TransActionData(card1, card2))
        }
        binding.recyclerview.layoutManager = LinearLayoutManager(
            activity,
            LinearLayoutManager.HORIZONTAL, false
        )
        binding.recyclerview.adapter = CustomAdapter(posts)
    }
}