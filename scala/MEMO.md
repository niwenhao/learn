# Scalaのタイプ：

* String    

		"aaaaaa"
		""" aaaa
            bbb
            ccc"""
* Byte
* Short
* Int
* Long     32L, 0x20L
* Float    100F, 1e2f
* Double   100d, 1e2D
* Boolean
* Char      '\102', 'B'

* String interpolation
        
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

* XML

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
        
# 変数

* Lazy
    
        lazy val forLater = someTimeConsumingOperation()
* List
        
        scala> val first :: second :: rest = List(1, 2, 3)
        first: Int = 1
        second: Int = 2
        rest: List[Int] = List(3)
        
# 関数

* 一般

        def welcome(name: String) :String = {"Exciting times ahead" + name }
        def max(a: Int, b: Int) = if(a > b) a else b
        def toList[A](value:A) = List(value)
        
* closure

        val evenNumbers = List(2, 4, 6, 8, 10)
        evenNumbers.foldLeft(0) { (a: Int, b:Int) => a + b }
        evenNumbers.foldLeft(0) { (a, b) => a + b }
        evenNumbers.foldLeft(0) { _ + _ }
        val hasUpperCase = name.exists(_.isUpper)

* 高階関数

        def xxx(op : (Int, Int) => Int) : (Int) => Int = (a) => op(a, a)
        val x = xxx((a, b) => a+b)
        val y = x(10)

* List/Array

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


* Control

  * if

            scala> val useDefault = false
            useDefault: Boolean = false

            scala> val configFile = if(useDefault) "custom.txt" else "default.txt"
            configFile: String = default.txt

            scala>

  * for
    
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



