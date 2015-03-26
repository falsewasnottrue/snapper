package snapper

sealed trait Powerable {
  def isPoweredOn: Boolean
}

object Plug extends Powerable {
  val isPoweredOn = true
}

case class SnapperOff(input: Powerable) extends Powerable {
  val isPoweredOn = false
}
case class SnapperOn(input: Powerable) extends Powerable {
  def isPoweredOn = input.isPoweredOn
}

case class Lamp(input: Powerable) extends Powerable {
  def isPoweredOn = input.isPoweredOn
}


object Snapper extends App {

  println("Hello world")

  val N = 4

  val x = Lamp(SnapperOff(SnapperOff(Plug)))

//  def buildChain(n: Integer): List[Powerable] = {
//    val snappers = n match {
//      case 0 => List(Plug)
//      case m => {
//        val innerChain = buildChain(m-1)
//        innerChain(m-1)
//      }
//    }
//
//    Plug ::
//  }
//
//  def snap(chain: List[Powerable]): List[Powerable] = ???




}

