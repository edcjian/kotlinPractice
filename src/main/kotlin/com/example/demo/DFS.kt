package com.example.demo

import java.util.LinkedList

data class DGraph(
    var n: Int,
    var vertexList: ArrayList<String> = ArrayList(n),
    var edges: Array<IntArray> = Array(n) { IntArray(n) },
    var numOfEdge: Int = 0,
    var isVisited: BooleanArray = BooleanArray(5)
) {
    fun getFirstNeighbor(index: Int) = vertexList.indices
        .find{edges[index][it] > 0}?:-1
    fun getNextNeighbor(v1: Int, v2: Int) = ((v2+1) until vertexList.size)
        .find { edges[v1][it] > 0 }?:-1
    fun getNumOfVertex() = vertexList.size
    fun getNumOfEdges() = numOfEdge
    fun showGraph() = edges.forEach { println(it.contentToString()) }
    fun getValueByIndex(i: Int) = vertexList[i]
    fun getWeight(v1: Int, v2: Int) = edges[v1][v2]
    fun insertVertex(vertex: String) = vertexList.add(vertex)
    fun insertEdge(v1: Int, v2: Int, weight: Int) {
        edges[v1][v2] = weight
        edges[v2][v1] = weight
        numOfEdge++
    }
    fun dfs(isVisited: BooleanArray, i: Int) {
        println(getValueByIndex(i)+"->")
        isVisited[i] = true
        var w = getFirstNeighbor(i)
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w)
            }
            w = getNextNeighbor(i, w)
        }
    }
    fun bfs(isVisited: BooleanArray, i: Int) {
        var u: Int
        var w: Int
        var queue = LinkedList<Int>()
        print(getValueByIndex(i)+"->")
        isVisited[i] = true
        queue.addLast(i)
        while (queue.isNotEmpty()) {
            u=queue.removeFirst()
            w = getFirstNeighbor(u)
            while (w != -1) {
                if (!isVisited[w]) {
                    println(getValueByIndex(w)+"->")
                    isVisited[w] = true
                    queue.addLast(w)
                }
                w=getNextNeighbor(u,w)
            }
        }
    }
}
@Suppress("UNSUPPORTED")
fun main() {

    var VertexValue = ["A", "B", "C", "D", "E"]
    var Vert = [1, 23, 4, 5, 6, 7, 8]
    var graph = DGraph(5)
    VertexValue.forEach { graph.insertVertex(it) }
    graph.apply {
        insertEdge(0, 1, 1)
        insertEdge(0, 2, 1)
        insertEdge(1, 2, 1)
        insertEdge(1, 3, 1)
        insertEdge(1, 4, 1)
        showGraph()

      //  println("start DFS")
     //  dfs(isVisited,0)
        println("start BFS")
     //  bfs()
bfs(isVisited,0)
    }
}



    



