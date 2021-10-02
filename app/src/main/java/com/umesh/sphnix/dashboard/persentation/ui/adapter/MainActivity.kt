package com.umesh.sphnix.dashboard.persentation.ui.adapter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.umesh.sphnix.R
import com.umesh.sphnix.databinding.DashboardListLayoutBinding
import com.umesh.sphnix.auth.persentation.viewmodel.LoginViewModel
import com.umesh.sphnix.resource.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest

@AndroidEntryPoint

class MainActivity : AppCompatActivity() , ImageAdapter.OnClickPost {
    lateinit var binding: DashboardListLayoutBinding
    val viewModel: LoginViewModel by viewModels()
    lateinit var imageAadapter:ImageAdapter
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.dashboard_list_layout)
        imageAadapter= ImageAdapter(emptyList(),this)
        binding.rvList.apply {
            adapter=imageAadapter
        }

        /*   lifecycleScope.launchWhenStarted {
               viewModel.getImageList()
               viewModel.getImageListDataStatus.collectLatest {
                   when (it.status) {
                       Resource.Status.LOADING -> {
                           binding.progressCircular.visibility = View.VISIBLE
                       }
                       Resource.Status.SUCCESS -> {
                           binding.progressCircular.visibility = View.GONE
                           //println("${it.data?.body()?.rows}______dataList")
   //                        imageAadapter.list = it.data?.body()?.rows ?: emptyList()
   //                        imageAadapter.notifyDataSetChanged()
   //                        binding.tvName.text=it.data?.body()?.title
                       }
                       Resource.Status.ERROR -> {
                           binding.progressCircular.visibility = View.GONE
                           Log.d("Error", it.message ?: "")
                       }
                   }
               }

           }
           lifecycleScope.launchWhenStarted {
               viewModel.getImageListPickSum()
               viewModel.getImageListPickSumDataStatus.collectLatest {
                   when(it.status){
                       Resource.Status.LOADING->{
                           binding.progressCircular.visibility =View.VISIBLE
                       }
                       Resource.Status.SUCCESS->{
                           binding.progressCircular.visibility =View.GONE
                           imageAadapter.list =it.data?.body()?: emptyList()
                           binding.rvList.adapter=imageAadapter
                       }
                       Resource.Status.ERROR->{
                           binding.progressCircular.visibility =View.GONE
                           Log.d("Error",it.message?:"")
                       }
                   }
               }

           }*/
    }

    override fun openImageListPost(article: String, position: Int) {
        //
    }
}