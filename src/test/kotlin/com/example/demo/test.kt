package com.example.demo

import arrow.core.*
import org.junit.jupiter.api.Assertions.assertEquals

inline fun <reified T> a(vararg items: T): Array<T> = arrayOf<T>(*items)
var ak =Tuple5(1,Tuple4(1,"we","",""),"123","as", arrayOf(1,2,3))

fun <T> T?.println() = println(this)
inline fun <reified T> heck (a:T)=println()
fun res(x:Int,y:Int,z:Int)=x+y+z
val tks =::res.curried()
val pa2=::res.partially1(1)
//val add = { x: Int, y: Int,z:Int -> x + y+z }.curried()


var a=listOf(1,2,3)

//var b=[12,3,4]
infix  fun Int.`-`(d:Int){

    haha(1,2).rightIfNull { 123.println() }
//    ifNotNull(this,d,::haha)
/*   ifNotNul(this,d){
haha()
   }*/
}
fun testNull(a:Int?, b: Int?)=when(null){
    a,b->println(a)
    else -> println("one is empty")
}
fun haha(x:Int,y:Int)=(x+y).println()
fun main() {

//  2  `-` 3
    //testNull(null,null)
    //pa2(2,3) shouldBe res(1,2,3)
    var a=1
    var b=1
    onAllPresent(a,b){
        println(b)
        println(a)
    }

 /* val va =a(1,2,3)
    println(va)*/
//add(1)(2)(3).println()
//   tks(1)(2)(3).println()

}

infix fun <T> T?.shouldBe(expected: T?) = assertEquals(expected, this)

fun <T1, T2> ifNotNull(value1: T1?, value2: T2?, bothNotNull: (T1, T2) -> (Unit)) {
    if (value1 != null && value2 != null) {
        bothNotNull(value1, value2)
    }

}
fun onAllPresent(vararg elements: Any?, block: ()->Unit ) {
    if( !elements.any { it == null } ) {
        block()
    }
}

