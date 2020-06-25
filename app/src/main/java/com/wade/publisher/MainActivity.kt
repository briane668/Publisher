package com.wade.publisher

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import com.example.android.marsrealestate.overview.PhotoGridAdapter

import com.google.firebase.firestore.FirebaseFirestore
import com.wade.publisher.databinding.ActivityMainBinding
import java.util.*
import kotlin.collections.HashMap


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainViewModel: MainViewModel by lazy {
            ViewModelProvider(this).get(MainViewModel::class.java)
        }

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        binding.viewModel = mainViewModel
        binding.lifecycleOwner = this
        binding.article.adapter = PhotoGridAdapter()



        binding.imageButton.setOnClickListener {
            mainViewModel.addData()
            mainViewModel.calldata()
        }




        var db = FirebaseFirestore.getInstance()

        // Create a new user with a first, middle, and last name

        // Create a new user with a first, middle, and last name
        val user: MutableMap<String, Any> = HashMap()
        user["first"] = "Alan"
        user["middle"] = "Mathison"
        user["last"] = "Turing"
        user["born"] = 1912


        db.collection("users")
            .add(user)
//            .addOnSuccessListener { documentReference ->
//                Log.d(
//                    FragmentActivity.TAG,
//                    "DocumentSnapshot added with ID: " + documentReference.id
//                )
//            }






    }
}

