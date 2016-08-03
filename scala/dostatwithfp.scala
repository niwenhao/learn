import scala.collection.JavaConverters._
import java.io.File
import scala.util.matching.Regex

def makeProcessor[POST, PAR, IN, OUT] : (PAR, (PAR, IN) => OUT, (OUT) => POST) => IN => POST = (p, f, fp) => (i) => fp(f(p, i))



def makeSelectProcessor(pattern: Regex, path: String) = {
    val f = new File(path)
    val list : Array[File] = f.listFiles()
    list.filter { (f) => pattern.pattern.matcher(f.getName()).find() }
}

def makeCharCount(multi: Int, list: Array[File]) = list map { s => multi * s.getName().length() }

val process = makeProcessor("^\\w".r, makeSelectProcessor,
                makeProcessor(2, makeCharCount, (i : Array[Int]) => i))


process("/")
    
val p1 = makeProcessor(2, makeCharCount, (i : Array[Int]) => i)
val p2 = makeProcessor("^\\w".r, makeSelectProcessor, p1)

p2("/")
