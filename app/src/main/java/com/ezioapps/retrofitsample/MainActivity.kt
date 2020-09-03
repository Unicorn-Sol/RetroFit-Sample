package com.ezioapps.retrofitsample


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        val repository = Repository()
       // val get = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
        viewModel = MainViewModelFactory(repository).create<MainViewModel>(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.getPost(3)
        viewModel.myResponse.observe(this, Observer {
           if(it.isSuccessful){
               Log.e("MainActivity", it.body()?.userId.toString())
               Log.e("MainActivity", it.body()?.id.toString())
               Log.e("MainActivity", it.body()?.title!!)
               Log.e("MainActivity", it.body()?.body!!)
           }else{
               Log.e("MainActivity", it.errorBody().toString())
               textV.text = it.code().toString()
           }
        })


        button.setOnClickListener {
            val num = Integer.parseInt(editText.text.toString())
            viewModel.getCustomPost(num)
            viewModel.listPosts.observe(this, Observer {
                response_tv.text = it.body().toString()

            })
        }
    }



}