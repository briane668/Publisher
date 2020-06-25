package com.wade.publisher

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.FirebaseFirestore
import java.util.*

class MainViewModel() : ViewModel() {

 val articles = MutableLiveData<List<Article>>()


//    val articles = MutableLiveData<List<Article>>()


//    val email = MutableLiveData<String>()
//
//    val search = MutableLiveData<String>()
//
//    val addwho= MutableLiveData<String>()
//
//    val receivewho= MutableLiveData<String>()
//
//    val content = MutableLiveData<String>()
//
//    val title = MutableLiveData<String>()
//
//    val author: MutableMap<String, Any> = HashMap()

    var db = FirebaseFirestore.getInstance()


    fun addData() {
        val articles = FirebaseFirestore.getInstance()

            .collection("articles")

        val document = articles.document()
        val data =hashMapOf(
        "author" to hashMapOf
        ("email" to "wayne@school.appworks.tw",
            "id" to "waynechen323",
        "name" to "AKA小安老師"),
            "title" to "​IU「亂穿」竟美出新境界！笑稱自己品味奇怪"
        ,
            "content" to "南韓歌手IU（李知恩）無論在歌唱方面或是近期的戲劇作品都有亮眼的成績，但俗話說人無完美、美玉微瑕，曾再跟工作人員的互動影片中坦言自己品味很奇怪，" +
                    "近日在IG上分享了宛如「媽媽們青春時代的玉女歌手」超復古穿搭造型，卻意" +
                    "外美出新境界。",

            "createdTime" to Calendar.getInstance()
        .timeInMillis,

            "id" to document.id,
            "tag" to "Beauty"
        )

        document.set(data)
    }

init {
    calldata()
}


fun calldata(){
    db.collection("articles")
        .get()
        .addOnSuccessListener { documents ->
            val list = mutableListOf<Article>()
            for (document in documents) {
                Log.d("search123456", "6666${document.id} => ${document.data}-----${document.reference}")
                val article = Article(
                    author = document.getString("author.name"),
                    title = document.getString("title"),
                    tag = document.getString("tag"),
                    createdTime = document.getLong("createdTime"),
                    content= document.getString("content")
                )
                list.add(article)

            }
            articles.value = list
            Log.d("Wade","${articles.value}")
        }


}
}