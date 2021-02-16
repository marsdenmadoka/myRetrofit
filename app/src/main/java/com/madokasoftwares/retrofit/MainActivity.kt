package com.madokasoftwares.retrofit

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.madokasoftwares.retrofit.databinding.ActivityMainBinding
import com.madokasoftwares.retrofit.databinding.ItemTodoBinding
import retrofit2.HttpException
import java.io.IOException

//if you use the MVVM architecture then you will make the retrofit call in the repository /then call that from the viewmodel
//then you wont need to write in the activity

const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var todoAdapter:TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpRecycleView() //call our function

        //make our APi request inside coroutine since we want to execute it in the background thread
        lifecycleScope.launchWhenCreated {
            binding.progressBar.isVisible = true//make our progress bar visible since we want to make our API request

            val response = try{ //get our response
                RetrofitInstance.api.getTodos() //since we use retrofit with coroutine
            } catch (e:IOException) {
             Log.e(TAG, "IOException,you might not have internet")
                binding.progressBar.isVisible = false
            return@launchWhenCreated
            } catch (e:HttpException){
                Log.e(TAG, "HttpException,unexpected response")
                binding.progressBar.isVisible = false
               return@launchWhenCreated
            }

            if(response.isSuccessful && response.body() !=null){
                todoAdapter.todos=response.body()!!
            }else{
                Log.e(TAG,"Response not successful")
            }

            binding.progressBar.isVisible = false
        }


    }

    private fun setUpRecycleView() = binding.rvTodos.apply {
        todoAdapter = TodoAdapter()
        adapter = todoAdapter
        layoutManager = LinearLayoutManager(this@MainActivity)
    }
}