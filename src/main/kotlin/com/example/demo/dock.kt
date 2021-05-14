package com.example.demo

fun ter(a:Int) =when(a){
    in gt(5) -> "more than 5"
    in lt(5) ->"less than 0"
    else ->null
}
data class cli(val a:Int,val b:String)
/*fun <T>destruct(arg:T)= { (a, _): T -> a }
fun <T>rec(a:T)=when(a){

    is cli ->destruct(a)
    else -> null
}*/
fun tools(a:Int,b:String)=b+a
fun main() {


}