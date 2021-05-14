package com.example.demo

import arrow.core.*
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import kotlinx.coroutines.*

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import kotlin.math.abs
import kotlin.system.measureTimeMillis
import kotlin.time.ExperimentalTime
import kotlin.time.seconds

typealias s2i =Pair<String,Int>
/*typealias i2u =(Int)->IntRange
val t:i2u = {it->it..Int.MAX_VALUE}*/
val bs =::IntRange.curried()
class Hello(){
    fun one(a:Int): String {
        return "hello"
    }
    fun two(a:String): Int {
        return 123
    }
}
suspend fun hello(): String {
    delay(1000)
    return "hello"
}
suspend fun world(args:String): String {
    return suspendCoroutine{
        it.resume("333")
    }
}

fun tf(a:Int?)=a
val applys={(a,_):Tech->a}
fun lts(a:Int)=if (a%5==0) a else 0
fun cas(a:Any): String = when (a) {
    "2" to 1,"3" to 4  -> "branch 1"
    is Tech ->  {{(r,_):Tech->r}(a)}
    else -> "no chose"
}


@Suppress("UNSUPPORTED")
 fun main(){
    (tf(null)?:-2).println()
//    val pk=listOf(Tech("1",1),Tech("2",2))
/*    pk.forEach { (a,_)->
        a.println()
    }*/
//  applys(Tech("edc",123)).println()

/*    cas(("3" to 2))
    cas(("2" to 1))*/
  //  ter(4).println()
//cas("3" to 4).println()
val kt =[1,2,4,5]
    val kp =[2,3]
    //(kt+kp).contentToString().println()
    val ts= mMapOf(
        "we" to 2,
        "he" to 3
    )

//    bs(1)(3).forEach(::println)

val kn ="2" to 1
    val tk=Tech("an",1) to 4
  //  ts += tk
  //  ts["we"].println()
    ts["he"]=5

 //   ts.println()
 /*   Hello().apply{
        ( ::two * ::one)("123").println()
    }*/

/*val s=rec(3)(3)
    s.println()*/
/*    fun subs(x:Int)=if(x %3==0) x else -1
    val s=[14,34,3,5,6,3,12,7,9]
    val Vert = [1, 23, 4, 5, 6, 7, 8,9]
    s.indices.filter { subs(it)>0 }.println()*/
    fun xt(it:String):String{

    return it + "world"
    }
    val ma:(x:String)->String={
         it + "kotlin"

    }
    val ks:(Int)->String  ={
  /*      var x=1
        x+=it
        x.println()*/
       "hello" . repeat(it)
    }
  //  (ks `-` ma).println()
//    ( ks andThen   ::xt )(5).println()


 /*   GlobalScope.launch {
        val res =async{
            return@async "hello"
        }

            val tk = hello()
       res.await()


    }*/
/*    runBlocking{
        //todo  会阻塞线程
    }*/

}



/*private fun <E> Collection<E>.filterAndMap(function: () -> Unit, function1: () -> Unit): Any {

}*/


