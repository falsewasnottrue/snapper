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

//  val N = 4
//  val K = 47
//
//  val lampOn = snap(K, buildChain(N)).isPoweredOn
//  println(lampOn)

  import scala.io.Source
  val lines = Source.fromFile("src/snapper/A-large-practice.in").getLines.zipWithIndex
  lines.next // drop #cases

  while (lines.hasNext) {
    val (line, i) = lines.next

    val N = line.split(" ")(0).toInt
    val K = line.split(" ")(1).toInt

    val lampOn = snapK(K, buildChain(N)).isPoweredOn

    println("Case #" + i + ": " + (if (lampOn) "ON" else "OFF"))
  }

  def buildChain(n: Integer): Powerable = {
    def buildSnapperChain(n: Integer): Powerable =
      if (n==0) Plug else SnapperOff(buildSnapperChain(n-1))

    Lamp(buildSnapperChain(n))
  }

  def snap(chain: Powerable): Powerable = chain match {
    case Lamp(inner) => Lamp(snap(inner))

    case SnapperOn(inner) if inner.isPoweredOn => SnapperOff(snap(inner))
    case SnapperOn(inner) => SnapperOn(snap(inner))

    case SnapperOff(inner) if inner.isPoweredOn => SnapperOn(snap(inner))
    case SnapperOff(inner) => SnapperOff(snap(inner))

    case Plug => Plug
  }

  def snapK(k: Integer, chain: Powerable): Powerable =
    if (k==0) chain else snapK(k-1, snap(chain))
}

