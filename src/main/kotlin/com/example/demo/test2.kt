package com.example.demo
import java.io.File
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.findAnnotation
import kotlin.reflect.jvm.javaField
import kotlin.reflect.jvm.javaGetter

/*typealias i2s=(Int)->String
fun  hes(b: i2s, a: i2s): String {
    return "123"
}*/
annotation class Result(val tableName: String)

@Result("123")
data class Departments(val id:Int,val name: String)

@Suppress("UNSUPPORTED")
fun main() {
   /* val res=Foo::class.annotations.find { it is Result} as? Result
    res?.name.println()*/
/*var re=Departments::class.declaredMemberProperties.first().name

    re.println()*/
    var paramsNum=Departments::class.declaredMemberProperties
    var annotation=Departments::class.findAnnotation<Result>()?.tableName


    var r=""
    paramsNum.forEach {
        r+="val ${it.name} = varchar(\"${it.name}\") \n"
    }
    var p=   """
        object Employees : Table<Nothing>("$annotation") {
$r   
}
    """
//  p.println()
    val tn=File("I:\\ideaProject\\FP\\src\\main\\kotlin\\com\\example\\demo\\generated\\test.kt")
   tn.appendText("$p \n")
/*    val tx=File("I:\\ideaProject\\FP\\src\\main\\kotlin\\com\\example\\demo\\test2.kt")
    val tn=File("I:\\ideaProject\\FP\\test.kt")
    var fg= "val res=Foo::class.annotations.find { it is Result} as? Result"
   var tu= tx.readText().findStr("@Re","todo")
    "^.*?(?=io)".toRegex().find(tx.readText())?.value.println()
tn.appendText(tu)*/

}

