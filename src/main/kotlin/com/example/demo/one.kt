package com.example.demo

import arrow.core.Tuple10
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import kotlinx.coroutines.*

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity

import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity

/*val restTemplate = RestTemplate()
val urls="http://mock.51y.cc:81/mock/6007a37332adfa0499d3b861/kor#!method=get"
suspend fun num() =GlobalScope.async {
    val res = restTemplate.getForEntity<String>(urls, Tuple10)
    return@async res.body
}*/




data class  Tech(val name:String,val id:Int)
@Suppress("UNSUPPORTED")
fun main(){


//    tc.insert(Tech("edc",123))
    /*GlobalScope.launch {
        num().await().println()
    }*/



   // [1,2,3,4,5,6].filter{it>5}.forEach(::println)
}
