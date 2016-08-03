# Basic

## Scalaのタイプ：

*   String    

        "aaaaaa"
        """ aaaa
            bbb
            ccc"""
*     Byte
*   Short
*   Int
*   Long     32L, 0x20L
*   Float    100F, 1e2f
*   Double   100d, 1e2D
*   Boolean
*   Char      '\102', 'B'

*   String interpolation
        
        scala> val k = "abc"
        k: String = abc
        
        scala> s"We can say $k"
        res11: String = We can say abc

        scala> val k = "abc"
        k: String = abc
        
        scala> var v = 1.9f
        v: Float = 1.9
        
        scala> var w = 2.6d
        w: Double = 2.6
        
        scala> f"$k%s is $v%4.5f to $w%4.6f"
        res12: String = abc is 1.90000 to 2.600000

*   XML

        scala> val message = "I didn't know xml could be so much fun"
        scala> val code = “1”
        scala> val alert = <alert>
        <message priority={code}>{message}</message>
        <date>{new java.util.Date()}</date>
        </alert>
        alert: scala.xml.Elem =
        <alert>
        <message priority=”1”>
        I didn't know xml could be so much fun
        </message>
        <date>Fri Feb 19 19:18:08 EST 2010</date>
        </alert>
        
## 変数

*   Lazy
    
        lazy val forLater = someTimeConsumingOperation()
*   List
        
        scala> val first :: second :: rest = List(1, 2, 3)
        first: Int = 1
        second: Int = 2
        rest: List[Int] = List(3)
        
## 関数

*   一般

        def welcome(name: String) :String = {"Exciting times ahead" + name }
        def max(a: Int, b: Int) = if(a > b) a else b
        def max : (Int, Int) => Int = (a, b) => if(a > b) a else b
        def toList[A](value:A) = List(value)
        
*   closure

        val evenNumbers = List(2, 4, 6, 8, 10)
        evenNumbers.foldLeft(0) { (a: Int, b:Int) => a + b }
        evenNumbers.foldLeft(0) { (a, b) => a + b }
        evenNumbers.foldLeft(0) { _ + _ }
        val hasUpperCase = name.exists(_.isUpper)

*   高階関数

        def xxx(op : (Int, Int) => Int) : (Int) => Int = (a) => op(a, a)
        val x = xxx((a, b) => a+b)
        val y = x(10)

## List/Array

        var arr = Array[Int](1, 2, 3)
        var lst = List[Int](1, 2, 3)
        
        lst.foreach(println _)

        scala> val a = List(10)
        a: List[Int] = List(10)

        scala> val b = 1 :: a
        b: List[Int] = List(1, 10)

        scala> val c = b :+ 100
        c: List[Int] = List(1, 10, 100)

        scala> val d = "This" :: "is" :: "immutable" :: Nil
        d: List[String] = List(This, is, immutable)

        scala>


## Control

*   if

            scala> val useDefault = false
            useDefault: Boolean = false

            scala> val configFile = if(useDefault) "custom.txt" else "default.txt"
            configFile: String = default.txt

            scala>

*   for
    
    format1

            scala> for(f <- files) { println(f) }
            ./.sudo_as_admin_successful
            ./.vimrc
                ./.npm
            ./.activator

    format2

            scala> a
            res23: List[Int] = List(1, 2)
            scala> b
            res24: List[Int] = List(3, 4)
            scala> for { x <- a; y <- b } println(x + y)
            4
            5
            5
            6
            scala> for { x <- a; y <- b } yield x + y
            res27: List[Int] = List(4, 5, 5, 6)
            scala>

*   match case

    *   case 1
            
            scala> var func : (Long) => String = (a) => a match {
                 |                 case 1L => "One"
                 |                 case 2L => "Two"
                 |                 case _ => "Others"
                 |             }
            func: Long => String = <function1>

            scala> func(10L)
            res0: String = Others

            scala> func(1L)
            res1: String = One

    *   case 2

            val func = (a : AnyRef) => a match {
                case s : String => s"String : $s"
                case l : List[_] => s"List ....."
                case a : Array[_] => s"Array ....."
                case d : java.util.Date => s"Date ....."
                case _ => "Unknown"
            }

            func("abc")
            func(List(1, 2, 2))
            func(new java.util.Date())

    *   case 3
        
            val func = (a : AnyRef) => a match {
                case f :: s :: rest => List(List(f, s), rest)
                case _ => "Unknown"
            }
            
            func("abc")
            func(List())
            func(List(1))
            func(List(1, 2))
            func(List(1, 2, 3))
            func(List(1, 2, 3, 4))

            scala> :load test.scala
            Loading test.scala...
            func: AnyRef => java.io.Serializable = <function1>
            res19: java.io.Serializable = Unknown
            res20: java.io.Serializable = Unknown
            res21: java.io.Serializable = Unknown
            res22: java.io.Serializable = List(List(1, 2), List())
            res23: java.io.Serializable = List(List(1, 2), List(3))
            res24: java.io.Serializable = List(List(1, 2), List(3, 4))

    *   case 4

            val func = (v : Long) => v match {
                case l if l < 10 => s"less then 10 => $l"
                case l if l < 100 => s"less then 100 => $l"
                case l if l < 1000 => s"less then 1000 => $l"
                case l => s"Unlimited => $l"
            }
            
            func(1)
            func(10)
            func(100)
            func(1000)

            scala> :load test.scala
            Loading test.scala...
            func: Long => String = <function1>
            res41: String = less then 10 => 1
            res42: String = less then 100 => 10
            res43: String = less then 1000 => 100
            res44: String = Unlimited => 1000

*   Exception
    
        cala> :load test.scala
        Loading test.scala...
        func: Long => String = <function1>
        res41: String = less then 10 => 1
        res42: String = less then 100 => 10
        res43: String = less then 1000 => 100
        res44: String = Unlimited => 1000

        scala> :load test.scala
        Loading test.scala...
        func: (Long, Long) => String = <function2>
        res57: String = result => 10
        res58: String = Unknown Exception : java.lang.ArithmeticException: / by zero

# OOP

##  クラス

*   Normal

        class TestClass(val field1 : String, val field2 : String)

        val t = new TestClass("abc", "123")
        t.field1
        t.field2

        scala> :load test.scala
        Loading test.scala...
        defined class TestClass
        t: TestClass = TestClass@69eb9518
        res0: String = abc
        res1: String = 123

*   property method

        class TestClass(private val field1 : String, private val field2 : String) {
                def f1 = field1
                def f2 = field2
        }

        val t = new TestClass("abc", "123")
        t.f1
        t.f2

        scala> :load test.scala
        Loading test.scala...
        defined class TestClass
        t: TestClass = TestClass@42c87005
        res2: String = abc
        res3: String = 123

*   constractor

        class TestClass(val field1 : String, val field2 : String) {
            def this() = this("abc", "123")
        }

        val t = new TestClass()
        t.field1
        t.field2

        val t = new TestClass("def", "456")
        t.field1
        t.field2

        scala> :load test.scala
        Loading test.scala...
        defined class TestClass
        t: TestClass = TestClass@24674be7
        res4: String = abc
        res5: String = 123
        t: TestClass = TestClass@1db3ff02
        res6: String = def
        res7: String = 456

*   setter and getter

        class TestClass(private var field1 : String) {
                def f1 = field1
                def f1_= (v : String) = field1 = v
        }

        val t = new TestClass("abc")
        t.f1
        t.f1 = "def"
        t.f1

        scala> :load test.scala
        Loading test.scala...
        defined class TestClass
        t: TestClass = TestClass@28c11a3c
        res18: String = abc
        t.f1: String = def
        res19: String = def

  private attribute

        import java.util.{Date => Dt}

        object ooo {
            private var _time : Dt = new Dt()
            def time = _time
            def time_= (t : Dt) = _time = t
        }

*   package

        package per {
            package nwh {
                class MyClass(val name : String, val age : Int)
            }
        }

        package per.nwh {
                class MyClass(val name : String, val age : Int)
        }

        package per.nwh

        class MyClass(val name : String, val age : Int)

*   import

        import xxx.yyy._

        {
            import xxx.yyy._
        }

        scala> {
             | import System._
             | out.println("aaa")
             | }
        aaa

        scala> out.println("aaa")
        <console>:8: error: not found: value out
                      out.println("aaa")
                      ^

        scala>

        scala> import java.util.Date
        import java.util.Date

        scala> import java.util.{Date => SqlDate}
        import java.util.{Date=>SqlDate}

*   singltone object

        object testObj {
            def apply(s : String) = s + s
        }

        testObj("abc")

        scala> :load test.scala
        Loading test.scala...
        defined object testObj
        res6: String = abcabc

*   package object

        :test.scala
        package object ppp {
            def outpkg(s : String) = "ppp => " + s
        }

        package ppp {
            class TestClass(val name: String, val msg :String) {
                def this(n : String) = this(n, outpkg(n))
            }
        }

        dev@research:~/public_html/learn/scala$ scalac test.scala
        dev@research:~/public_html/learn/scala$ scala
        Welcome to Scala version 2.11.6 (OpenJDK 64-Bit Server VM, Java 1.7.0_101).
        Type in expressions to have them evaluated.
        Type :help for more information.

        scala> import ppp._
        import ppp._

        scala> val t = new TestClass("my name")
        t: ppp.TestClass = ppp.TestClass@695d20e0

        scala> t.msg
        res0: String = ppp => my name

*   Mixin

        import com.mongodb.{DBCollection => MongoDBCollection }
        import com.mongodb.DBObject
        trait ReadOnly {
            val underlying: MongoDBCollection
            def name = underlying getName
            def fullName = underlying getFullName
            def find(doc: DBObject) = underlying find doc
            def findOne(doc: DBObject) = underlying findOne doc
            def findOne = underlying findOne
            def getCount(doc: DBObject) = underlying getCount doc
        }

        def administrableCollection(name: String) = new DBCollection(collection(name)) with Administrable with Memoizer

*   caseクラスの本質

    *   Scala prefixes all the parameters with val, and that will make them public value.
        But remember that you still never access the value directly; you always access
        through accessors.

    *   Both equals and hashCode are implemented for you based on the given parameters.

    *   The compiler implements the toString method that returns the class name and its parameters.

    *   Every case class has a method named copy that allows you to easily create a modified copy of 
        the class’s instance. You’ll learn about this later in this chapter.

    *   A companion object is created with the appropriate apply method, which takes the same arguments
        as declared in the class.

    *   The compiler adds a method called unapply, which allows the class name to be used as an 
    extractor for pattern matching (more on this later).

    *   A default implementation is provided for serialization

    example

        scala> case class Person(firstName : String, lastName : String)
        defined class Person

        scala> val people = List(
             |   Person("A", "a"),
             |   Person("B", "b"),
             |   Person("C", "c")
             | )
        people: List[Person] = List(Person(A,a), Person(B,b), Person(C,c))

        scala> for(Person(fn, ln) <- people) yield fn + "," + ln
        res0: List[String] = List(A,a, B,b, C,c)

*   modifiers

        package outerpkg {
            package innerpkg {

                class Outer {
                    class Inner {
                        private def e() = "This is e"
                        private[Outer] def f() = "This is f"
                        private[innerpkg] def g() = "This is g"
                        private[outerpkg] def h() = "This is h"

                        def ee() = e()
                    }

                    def ff() = (new Inner()).f()
                }

                object gg { 
                    def gg() = {
                        val o = new Outer()
                        val i = new o.Inner()
                        i.g()
                    }
                }
            }
            object hh {
                def hh() = {
                    val o = new innerpkg.Outer()
                    val i = new o.Inner()
                    i.h()
                }
            }
        }

*   val class(AnyVal)

    *   目的

        Flyweightパターン

    *   制約
        *   The class must have exactly one val parameter (vars are not allowed).
        *   The parameter type may not be a value class.
        *   The class can not have any auxiliary constructors.
        *   The class can only have def members, no vals or vars.
        *   The class cannot extend any traits, only universal traits (we will see them shortly).

*   implicit

        case class ListMaker(val left:Int) {
            import scala.collection.mutable.MutableList

            def -->(right: Int) = {
                println(s"${left} --> ${right}")
                val list = MutableList[Int]()
                for(i <- left to right) {
                    list += i
                }
                println(list)
                list.toList
            }
        }

        implicit def int2ListMaker(i:Int):ListMaker = ListMaker(i)

        1 --> 10

        scala> :load test.scala
        Loading test.scala...
        defined class ListMaker
        warning: there was one feature warning; re-run with -feature for details
        int2ListMaker: (i: Int)ListMaker
        1 --> 10
        MutableList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        res66: List[Int] = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

# Functions

## Higher Order

    scala> object Add10 {
         | def apply(f:Double => Double) : Double => Double = (p) => 10 + f(p)
         | }
    defined object Add10

    scala> object Add100 {
         | def apply(f:Double => Double) : Double => Double = (p) => 100 + f(p)
         | }
    defined object Add100

    scala> object Add1000 {
         | def apply(f:Double => Double) : Double => Double = (p) => 1000 + f(p)
         | }
    defined object Add1000

    scala> var f = Add10(x => x)
    f: Double => Double = <function1>

    scala> f = Add100(f)
    f: Double => Double = <function1>

    scala> f = Add1000(f)
    f: Double => Double = <function1>

    scala> f = Add100(f)
    f: Double => Double = <function1>

    scala> f(1)
    res3: Double = 1211.0

# 暇潰し

ここまで勉強したことを哲学スタイルで纏めて見る。

*   プログラムの目的は　処理（Input)　＝＞　Output 。
    自然に、関数である。関数でプログラムは理がある。

*   しかし、なんでプロシジャー向けが一瞬（１０数年）で、オブジェクト指向が台頭になる？

    その答え、
