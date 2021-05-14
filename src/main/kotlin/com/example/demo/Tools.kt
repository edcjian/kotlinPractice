package com.example.demo

import arrow.core.curried
import arrow.core.partially1
import arrow.core.partially2
import java.io.File
import kotlin.reflect.KFunction
import kotlin.reflect.full.memberProperties

/*import kotlin.reflect.full.declaredMemberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible*/

val gt =::IntRange.partially2(Int.MAX_VALUE)

val lt =::IntRange.partially1(Int.MIN_VALUE)
/**
equal indices.asSequence()
 */
fun IntArray.indicesSequence()=this.asSequence()

fun Array<Int>.indicesSequence()=this.asSequence()

fun swap(arr:Array<Int>,i:Int,j:Int){arr[i]=arr[j].apply{arr[j]=arr[i]}}

fun <T> T?.println() = println(this)

inline infix operator fun Int.times(action: (Int) -> Unit) {
    var i = 0
    while (i < this) action(i++)
}
/**
equal map.toList()
 */
@Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
fun <T, R> Sequence<T>.mapToList(transform: (T) -> R): List<R> {
    return TransformingSequence(this, transform).toList()
}

@Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
fun <T> Sequence<T>.filterToList(predicate: (T) -> Boolean): Sequence<T> {
    return FilteringSequence(this, true, predicate)
}
 fun Int.prev(nums: IntArray, i: Int=1)= nums[nums.indexOf(this)-1]

public inline fun IntArray.forEachFrom(start:Int,action: (Int) -> Unit) {
    var i=start
    while(i<= this.lastIndex) {action(this[i]);i++}
}
public inline fun Array<Int>.forEachFrom(start:Int,action: (Int) -> Unit) {
    var i=start
    while(i<= this.lastIndex) {action(this[i]);i++}
}
/*fun <T> Any.privateField(name: String): T {
    val field = this::class.java.getDeclaredField(name)
    field.isAccessible = true
    @Suppress("UNCHECKED_CAST")
    return field.get(this) as T
}

inline fun <reified T> T.callPrivateFunc(name: String, vararg args: Any?): Any? =
    T::class
        .declaredMemberFunctions
        .firstOrNull { it.name == name }
        ?.apply { isAccessible = true }
        ?.call(this, *args)

@Suppress("UNCHECKED_CAST")
inline fun <reified T : Any, R> T.getPrivateProperty(name: String): R? =
    T::class
        .memberProperties
        .firstOrNull { it.name == name }
        ?.apply { isAccessible = true }
        ?.get(this) as? R*/

fun <A, B, C> compose(f: (B) -> C, g: (A) -> B): (A) -> C {
    return { x -> f(g(x)) }
}

infix operator fun <A, B, C>((A) -> B).times( g:(B)->C ): (A) -> C  {
    return { x->g(this(x)) }
}
@Suppress("INVISIBLE_REFERENCE", "INVISIBLE_MEMBER")
public fun <K, V> mMapOf(vararg pairs: Pair<K, V>): MutableMap<K, V> =
    LinkedHashMap<K, V>(mapCapacity(pairs.size)).apply { putAll(pairs) }

public fun <T> mListOf(): MutableList<T> = ArrayList()

fun arr(size: Int)=Array(size){0}
fun arr2(x:Int,y:Int,init:Int=0) =Array(x){Array(y){init} }

 fun <T> Array<Array<T>>.forEach2()=this.forEach {it.contentToString().println()}
 operator fun Array<Int>.times(t: Int)=Array(t){this}

fun Array<Int>.twoFilter(predicate: (Int) -> Boolean,fun1:(Int)->Unit,fun2:(Int)->Unit){
    for (element in this) if (predicate(element)) fun1(element) else fun2(element)
}
fun Array<Int>.twoFilters(predicate: (Int) -> Boolean,fun1:(Int)->Unit,fun2:(Int)->Unit)=this::twoFilter.curried()
fun Any.print()=print(this)

fun String.findStr(a: String, b: String) = this.substring(indexOf(a),indexOf(b))

fun searchParagraph(a:String,b:String,tn: File): MutableList<String?> {
    val rts= mutableListOf<String?>()
    var flag1=false
    var flag2=false
    for (i in tn.readLines()){
        if(a in i) flag1=true
        if(b in i) flag2=true
        if(!flag1) continue
        rts+=i
        if(flag2) break;
    }
    return rts
}

@Throws(IllegalAccessException::class, ClassCastException::class)
inline fun <reified T> Any.getField(fieldName: String): T? {
    this::class.memberProperties.forEach { kCallable ->
        if (fieldName == kCallable.name) {
            return kCallable.getter.call(this) as T?
        }
    }
    return null
}