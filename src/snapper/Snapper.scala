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
  println(buildChain(N))

  val x = Lamp(SnapperOff(SnapperOff(Plug)))

  def buildChain(n: Integer): Powerable = {
    def buildSnapperChain(n: Integer): Powerable =
      if (n==0) Plug else SnapperOff(buildSnapperChain(n-1))

    Lamp(buildSnapperChain(n))
  }

  def snap(chain: Powerable): Powerable = ???

}

