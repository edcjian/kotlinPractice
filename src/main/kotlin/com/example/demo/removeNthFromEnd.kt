package com.example.demo

data class linkList(var root: listNodes? = null) {
    fun addList(value: Int) = root?.add(value) ?: run { root = listNodes(value) }
    fun printList() = root?.printNode()
    fun removeNthFromEnd(head: listNodes?, n: Int): listNodes {
        val pre = listNodes(0)
        pre.next = head
        var start = pre
        var end = pre
        repeat(n) { start = start.next!! }
        while (start.next != null) {
            start = start.next!!
            end = end.next!!
        }
        end.next = end.next?.next
        return pre.next!!
    }

    fun deleteDup(head: listNodes?): listNodes? = when {
        head?.next == null -> head
        head.value == head.next?.value -> {
            head.next = deleteDup(head.next?.next)
            deleteDup(head)
        }
        else -> {
            deleteDup(head.next)
            head
        }
    }

}


data class listNodes(val value: Int, var next: listNodes? = null) {
    fun add(va: Int): Any = next?.add(va) ?: run { next = listNodes(va) }
    fun printNode() {
        print("$value =>")
        next?.printNode()
    }

}


fun main() {
//    val head = listNodes(0)
    val linkList = linkList()
    val a = Array(10) { it }.also { it[5] = it[4] }
    a.contentToString().println()
    linkList.apply {
        a.forEach {
            addList(it)
        }
        printList()
        /*      removeNthFromEnd(root,4)

              printList()*/
        println("      ")
        deleteDup(root)
        printList()
    }
}

