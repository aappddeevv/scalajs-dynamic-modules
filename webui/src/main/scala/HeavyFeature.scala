package test

import scala.scalajs.js
import js.annotation._
import js.|
import react._
import react.implicits._
import vdom._

object HeavyFeature {

  trait Props extends js.Object {
    var message: js.UndefOr[String] = js.undefined
  }

  def apply(props: Props) = render.elementWith(props)

  val render: ReactFC[Props] = props => {
    div("Heavy feature that is dynamically loaded" + props.message.map(": " + _).getOrElse("."))
  }
  render.displayName("HeavyFeature")

}
