package com.example.playwithhiltagus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playwithhiltagus.adapter.RecyclerViewAdapter
import com.example.playwithhiltagus.databinding.ActivityMainBinding
import com.example.playwithhiltagus.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var rvAdapter: RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initRecyclerView()
    }

    private fun initRecyclerView(){

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        rvAdapter = RecyclerViewAdapter()
        binding.recyclerView.adapter = rvAdapter

    }

    private fun initViewModel(){
        val viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveDataOberver().observe(this, Observer{
            if(it != null){
                rvAdapter.setListData(it)
                rvAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "error in getting data", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.loadOfListData()
    }
}