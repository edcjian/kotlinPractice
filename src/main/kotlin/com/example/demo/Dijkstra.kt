package com.example.demo

import arrow.core.andThen
import arrow.core.compose


fun test(a: Int){

}
data class Graph(
        var vertex: Array<Char>,
        var matrix: Array<IntArray>,
) {

    fun showGraph() = matrix.forEach { println(it.joinToString()) }
    lateinit var vv: VisitedVertex
    fun dsj(index: Int) {
        var inde = index
        var vv = VisitedVertex(vertex.size, inde)
        update(inde)
        vertex.size * {
            inde = vv.updateArr()
            update(inde)
        }
    }

    var len = 0
    fun update(index: Int) = matrix[index].indicesSequence()
            .filter { vv notHave it && (vv.getDis(index) + matrix[index][it]) < vv.getDis(it) }
            .map {
                vv.updatePre(it, index)
                vv.updateDis(it, len)
            }
}

data class VisitedVertex(var lenght: Int, var index: Int) {
    var alreadyArr = IntArray(lenght)
    var preVisited = IntArray(lenght)
    var dis = IntArray(lenght) { 65535 }.also { it[index] = 0 }
    infix fun notHave(index: Int) = alreadyArr[index] == 0
    fun updateDis(index: Int, len: Int) {
        dis[index] = len
    }

    fun updatePre(pre: Int, index: Int) {
        preVisited[pre] = index
    }

    fun getDis(inde: Int) = dis[inde]
    fun updateArr(): Int {
        var min = 65535
        var indexs = 0
        alreadyArr.indicesSequence()
                .filter {
                   val kn= alreadyArr[it]
                  kn  == 0 && dis[it] < min
                }
                .map {
                    min = dis[it]
                    indexs = it
                }
        alreadyArr[indexs] = 1
        return indexs
    }

    fun show() {
        alreadyArr.joinToString()
        preVisited.joinToString()
        dis.joinToString()
    }
}



fun hello(x:Int)=when{
    x>5 -> "more than 5"
    x<0 -> "less than 0"
    else -> null
}
fun isOdd(x: Int) = x % 2 != 0
fun length(s: String) = s.length
//data class  Ha( val name:String,val id:Int)
@Suppress("UNSUPPORTED")
fun main() {





   
 /*val oddLength= compose(::isOdd,::length)
    val strings = listOf("a", "ab", "abc")
    println(strings.filter(oddLength))*/
    //(1 and 2).println()
//    (1 to 2).swap()
//    var ks =[Ha(id=1,name="123")]
/*    var t =[1,2,3]

  hello(3).println()*/
    val vertex= ['A','B','C','D','E','F','G']
    val N=65535
    val matrix:Array<IntArray> = [
     [N, 5, 7, N, N, N, 2],
     [5, N, N, 9, N, N, 3],
     [7, N, N, N, 8, N, N],
     [N, 9, N, N, N, 4, N],
     [N, N, 8, N, N, 5, 4],
     [N, N, N, 4, 5, N, 6],
     [2, 3, N, N, 4, 6, N]
             ]
  //  matrix[4].joinToString().println()
/*Graph(vertex, matrix).apply {
    showGraph()
    dsj(6)
}*/
}