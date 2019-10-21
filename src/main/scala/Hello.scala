object Hello extends App {
  printf("Works")
  val pt = io.StdIn.readLine("What type of point do you want? \nOptions: \n2d \n3d?\n")
  val point = Point(pt);
  printf("Created point: %s", point.toString())
}

trait Point {

}

object Point {
  private class TwoD(xc: Int, yc: Int) extends EuclideanPoint(xc, yc) with Point {
    override def toString: String = s"{x: $xc, y: $yc}"
  }
  private class ThreeD(xc: Int, yc: Int, zc: Int) extends CartesianPoint(xc, yc, zc) with Point {
    override def toString: String = s"{x: $xc, y: $yc, z: $zc}"
  }

  def apply(s: String, xc: Int = 0, yc: Int = 0, zc: Int = 0): Point = {
    if(s == "2d") return new TwoD(xc, yc);
    if(s == "3d") return new ThreeD(xc, yc, zc)
    else throw new IllegalArgumentException("Invalid Point Type")
  }
}


class CartesianPoint(xc: Int, yc: Int, zc: Int) {
  val x: Int = xc;
  val y: Int = yc;
  val z: Int = zc;
}

class EuclideanPoint(xc: Int, yc: Int) {
  val x: Int = xc;
  val y: Int = yc;
}