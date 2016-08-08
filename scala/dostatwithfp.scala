import scala.collection.JavaConverters._
import java.io.File
import scala.util.matching.Regex

def makeProcessor[PAR, IN, OUT] : (PAR, (PAR, IN) => OUT) => IN => OUT = (p, f) => (i) => f(p, i)
def pipe[I, J, K]: (I => J, J =>K) => I => K = (l, r) => (i) => r(l(i))

def makeSelectProcessor(pattern: Regex, path: String) = {
    val f = new File(path)
    val list : Array[File] = f.listFiles()
    list.filter { (f) => pattern.pattern.matcher(f.getName()).find() }
}

def makeCharCount(multi: Int, list: Array[File]) = list map { s => multi * s.getName().length() }

val p1 = makeProcessor("^\\w".r, makeSelectProcessor)
val p2 = pipe(p1, makeProcessor(2, makeCharCount))

p1("/")
p2("/")

val p = pipe(makeProcessor("^\\w".r, makeSelectProcessor),
                makeProcessor(2, makeCharCount))
