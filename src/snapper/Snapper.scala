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

}
