package com.example.demo
fun heap(tree:Array<Int>,n:Int,i:Int){
    val c1=2*i+1
    val c2=2*i+2
    var max=i
    if(c1<n&&tree[c1]>tree[max]) max=c1
    if(c2<n&&tree[c2]>tree[max]) max=c2
    if(max!=i){
        swap(tree,max,i)
        heap(tree,n,max)
    }
}
fun buildHeaps(n: Int, tree: Array<Int>) {
    val last =n-1
    val parent=(last-1)/2
    (parent downTo 0).forEach{heap(tree,n,it)}
}
fun heapSort( n: Int, tree: Array<Int>) {
   buildHeaps(n,tree)
    (n-1 downTo 0).forEach{
        swap(tree,it,0)
        heap(tree,it,0)
    }
}


@Suppress("UNSUPPORTED")
fun main() {
val tree= [4, 10, 3, 5, 1, 2]
    val a=6
heapSort(a,tree)
    tree.contentToString().println()
}
