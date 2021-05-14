import com.example.demo.Tech

object Rop {
  def main(args: Array[String]) = {


/*    apply((1,(2,5)))
    apply(haha("edc",1))*/


  }
  def helloScala(a:Int)="i am from scala"
  def apply(x:Any)=x match {
    case  (_,(_,c)) =>c
    case  haha(a,_)=>a
    case _ =>null
  }
 case class haha(val name:String,val id:Int)
}
