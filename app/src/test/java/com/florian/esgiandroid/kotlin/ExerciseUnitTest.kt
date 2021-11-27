package com.florian.esgiandroid.kotlin

import junit.runner.Version
import org.junit.Assert
import org.junit.Test
import java.math.BigInteger
import java.math.RoundingMode
import java.text.DecimalFormat

class ExerciseUnitTest {


    @Test
    fun variables() {

        val test = "test"
        var test2 = "test2"

        //test = "1"
        test2 = "2"

        Assert.assertSame(test, test)
        Assert.assertNotEquals(test2, "test2")

        // use var for a mutable variable
        // use val for an immutable variable
    }

    @Test
    fun nullable() {
        var test : String
        var test2 : String?
        var test3 : String? = null

        //test = null
        test2 = null

        // test2.uppercase()

        // test2!!.uppercase()

        test2 = "test2"
        test2!!.uppercase()

        // elvis operator to check is not null

        var test4 = test3?.length ?: "ok"
        Assert.assertEquals(test4, "ok")
    }

    fun Double.roundDecimal(digit: Int) = "%.${digit}f".format(this)


    @Test
    fun calculatrice(){
        println("Saisissez votre montant HT :")
        //val input = readLine()
        val input = 10
        val a = input*1.021
        val b = input*1.055
        val c = input*1.1
        val d = input*1.2

        println("Résultats :")
        println("TVA 2,1% : ${a} €")
        println("TVA 5,5% : ${b} €")
        println("TVA 10% : ${c} €")
        println("TVA 20 % : ${d} €")

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING

        Assert.assertEquals(df.format(a),"10,21")
        Assert.assertEquals(df.format(b),"10,55")
        Assert.assertEquals(df.format(c),"11")
        Assert.assertEquals(df.format(d), "12")
    }


    private fun isEven (value: Int) : Boolean = value % 2 ==  0

    private fun isVoyelle(char : Char) : Boolean {
        return when(char) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }

    }

    @Test
    fun conditionsAndLoop(){
        Assert.assertTrue(isEven(2))
        Assert.assertFalse(isEven(3))

        Assert.assertTrue(isVoyelle('a'))
        Assert.assertFalse(isVoyelle('b'))

        for (i in 0..100) {
            println(i)
        }
        for (i in 100 downTo 0) {
            println(i)
        }
    }

    private fun helloESGI() : Unit{
        println("Hello ESGI")
    }

    private fun entier(value : Int) : Int = value*5
    private fun entier2(value : Int = 1) : Int = value*5

    private fun foo(name: String, number: Int = 1, toUpperCase: Boolean = false) =
        (if (toUpperCase) name.uppercase() else name) + number

    private fun useFoo() = listOf(
        foo("a"),
        foo("b", number = 1),
        foo("c", toUpperCase = true),
        foo(name = "d", number = 2, toUpperCase = true)
    )

    private fun factorial(num : Int) : BigInteger {
        var factorial = BigInteger.ONE
        for (i in 1..num) {
            // factorial = factorial * i;
            factorial = factorial.multiply(BigInteger.valueOf(num.toLong()))
        }
        return factorial
    }

    @Test
    fun methods(){
        Assert.assertTrue(entier(5) == 25)
        Assert.assertTrue(entier2() == 5)

        val uf = useFoo()
        Assert.assertNotNull(uf)

        val fct = factorial(8)
        Assert.assertNotNull(fct)
    }

    @Test
    fun classes(){
        val usr1 = User("f", "g")
        val usr2 = User("f", "g")

        Assert.assertNotEquals(usr1, usr2)

        val usr3 = UserData("f", "g")
        val usr4 = UserData("f", "g")
        Assert.assertEquals(usr3, usr4)

        var temp = 10.0
        val pos = "paris"

        val weater = Weather(temp, pos)
        Assert.assertEquals(weater.isCold(), "il fait pas encore trop froid")

        temp = 33.0
        val localWeather = LocalWeather(temp, pos)
        Assert.assertEquals(localWeather.isHot(), "il fait très chaud")

        temp = 39.0
        val obj = object : LocalWeather(temp = temp,position = pos) {
            override fun isHot(): String {
                return if (temp > 40) "il fait très chaud" else "il fait pas encore si chaud"
            }
        }
        Assert.assertEquals(obj.isHot(), "il fait pas encore si chaud")

        val user9 = User.hello()
        Assert.assertEquals(user9, "Hello World")
        // usage du static

    }

    @Test
    fun pangrammeExercise(){
        val pangramme = pangramme("Portez ce vieux whisky au juge blond qui fume")
        Assert.assertTrue(pangramme)

    }

    @Test
    fun scopedFunctions() {
        val numberList = mutableListOf<Double>()
        numberList.also { println("Populating the list") }
            .apply {
                add(2.71)
                add(3.14)
                add(1.0)
            }
            .also { println("Sorting the list") }
            .sort()

        Assert.assertEquals(numberList, listOf(1.0, 2.71, 3.14))

        val numbers = mutableListOf("one", "two", "three", "four", "five")
        val nbs : List<Int>?
        numbers.map { it.length }.filter { it > 3 }.let {
            nbs = it
            // and more function calls if needed
        }

        Assert.assertEquals(nbs, listOf(5, 4, 4))


        val numb = mutableListOf("one", "two", "three")
        val firstAndLast = with(numb) {
            "The first element is ${first()}," +
                    " the last element is ${last()}"
        }
        Assert.assertEquals(firstAndLast, "The first element is one, the last element is three")

        val hexNumberRegex = run {
            val digits = "0-9"
            val hexDigits = "A-Fa-f"
            val sign = "+-"

            Regex("[$sign]?[$digits$hexDigits]+")
        }

        for (match in hexNumberRegex.findAll("+123 -FFFF !%*& 88 XYZ")) {
            println(match.value)
        }

        val adam = Person("Adam").apply {
            age = 32
            city = "London"
        }
        Assert.assertEquals(adam.age, 32)


        val nbrs = mutableListOf("one", "two", "three")
        nbrs
            .also { println("The list elements before adding new one: $it") }
            .add("four")
        Assert.assertEquals(nbrs, listOf("one", "two", "three", "four"))
    }

    @Test
    fun collections() {
        val entiers = mutableListOf<Int>()
        (1..10).all { entiers.add(it) }

        var total = 0
        for (entier in entiers){
            total += entier
        }

        val totalSum = entiers.sum()
        val totalSumBy = entiers.sumOf { it*2 }

        Assert.assertEquals(total, totalSum)
        Assert.assertEquals(total*2, totalSumBy)

        val list = listOf("bonjour", "le", "Monde", "je", "m'appelle", "Toto", "j'habite", "en", "Bretagne")
        val grouped = list.groupBy { it[0].toLowerCase() }

        Assert.assertNotNull(grouped)


        val l : Collection<Int?> = mutableListOf(1, null, 42, 3, 26)
        l.forEach {
            if (it != null) print(it)
        }
        l.filterNotNull().sortedDescending().reversed().forEach {
            print(it)
        }
        Assert.assertTrue(l.size == 4)


        val myMap : Map<String, Int>  = hashMapOf(Pair("A", 1), Pair("B", 2), Pair("C", 3))

        Assert.assertNull(myMap["E"])


        println(listOf(1, 2, 3, 4, 5).fold(0) { total, item -> total + item })
        // accumulate by + from to left to right
        println(listOf(1, 2, 3, 4, 5).foldRight(0) { item, total -> total + item })
        // accumulate by + from to right to left
        println(listOf(1, 2, 3, 4, 5).fold(1) { mul, item -> mul * item })
        // accumulate by * from to left to right
        println(listOf(1, 2, 3, 4, 5).foldRight(1) { item, mul -> mul * item })
        // accumulate by * from to right to left

        println(listOf(0, 1, 2, 3, 4, 5)
            .foldIndexed(0) { index, total, item -> if (index % 2 == 0) (total + item) else total })
        // accumulate by + from to left to right only if even

        println(listOf(0, 1, 2, 3, 4, 5)
            .foldRightIndexed(0) { index, item, total -> if (index % 2 == 0) (total + item) else total })
        // accumulate by + from to right to left only if even

    }

}



data class Person(var name : String, var age : Int = 0, var city : String = "")

class User (nom : String, prenom : String) {

    companion object{
        fun hello(): String = "Hello World"
    }

    fun hello() {
        println("Hello World")
    }
}
data class UserData (val nom : String, val prenom : String)

open class Weather(val temp : Double, val position : String){

    companion object{
        const val ZERO : Int = 0
        const val TWENTY_FIVE : Int = 25
    }


    constructor(weater : Weather) : this(weater.temp, weater.position)

    override fun toString(): String {
        return "Température de $position : $temp"
    }

    fun isCold() : String {
        return if (temp < ZERO ) "il fait froid" else "il fait pas encore trop froid"
    }

    open fun isHot() : String {
        return if(temp > TWENTY_FIVE) "il fait chaud" else "il fait pas encore chaud"
    }
}

open class LocalWeather(temp : Double, position : String) : Weather(temp = temp, position = position) {

    companion object{
        const val fourty = 40
    }

    override fun isHot(): String {
        return if (temp > 32) "il fait très chaud" else "il fait pas encore si chaud"
    }

}

fun pangrammeVoyelle(sentence: String) : Boolean{
    val characters = mutableListOf<Char>('a', 'e', 'u', 'i', 'o', 'y')
    val temp = mutableListOf<Char>()

    for (char in sentence){
        if(sentence.contains(char) && !temp.contains(char)) temp.add(char)
    }

    return temp.containsAll(characters)
}

fun pangramme(sentence: String) : Boolean = ('a'..'z').all { sentence.lowercase().contains(it) }


//Les exceptions : https://kotlinlang.org/docs/reference/exceptions.html
//Les generics : https://kotlinlang.org/docs/reference/generics.html
//Les lambdas : https://kotlinlang.org/docs/reference/lambdas.html
//Desctructuring declarations : https://kotlinlang.org/docs/reference/multi-declarations.html
//Gestion des cast : https://kotlinlang.org/docs/reference/typecasts.html