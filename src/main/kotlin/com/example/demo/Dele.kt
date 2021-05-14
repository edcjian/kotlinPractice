package com.example.demo

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

suspend fun global()= coroutineScope{
val cor=async{

}
}
/*interface  Paper{
    fun writePaper()
}

class RealWriter(val name:String):Paper{
    override fun writePaper() {
        println("Not yet implemented")

    }

}
class Student(val writer:Paper):Paper by writer*/
interface Marks {
    fun printMarks()
}

class StdMarks() : Marks {
    override fun printMarks() { println("printed marks") }
}

class CsvMarks() : Marks {
    override fun printMarks() { println("printed csv marks") }
}

interface Totals {
    fun printTotals()
}

class StdTotals : Totals {
    override fun printTotals() { println("calculated and printed totals") }
}

class CheatTotals : Totals {
    override fun printTotals() { println("calculated and printed higher totals") }
}

class Student(val studentId: Int, marks: Marks, totals: Totals)
    : Marks by marks, Totals by totals

fun main(args:Array<String>) {
    val student = Student(1,StdMarks(), StdTotals())
    student.printMarks()
    student.printTotals()
    val cheater = Student(1,CsvMarks(), CheatTotals())
    cheater.printMarks()
    cheater.printTotals()
}
/*
fun main() {
    val realWriter = RealWriter("edc")
    val student = Student(realWriter)
    student.writePaper()
}*/
