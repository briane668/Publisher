package com.wade.publisher

import androidx.lifecycle.MutableLiveData
import java.util.HashMap

data class Article(

    val author: String?,

    val content : String?,

    val title : String?,

    val createdTime : Long?,


    val tag :String?


){}
data class Author(
    val email : MutableLiveData<String>,
    val id : MutableLiveData<String>,
    val name : MutableLiveData<String>


)
{}
