package test

import scala.scalajs.js
import js.Dynamic.{ literal => jsobj }
import js.annotation._
import org.scalajs.dom
import react._
import react.implicits._
import vdom._

object main {

  val DynamicHeavyFeatureComponent = `lazy`(() => js.dynamicImport(HeavyFeature.render).map(DynamicImport(_)))
  def DynamicHeavyFeatureD(props: HeavyFeature.Props) = createElement(DynamicHeavyFeatureComponent, props)

  val render = () => {
    div(new DivProps {
      style = new StyleAttr {
        display = "block"
      }
    })(
      // standard "string" component, loaded with the main bundle
      div("Demonstration of scala.js dynamic module splitting. The next block is dynamically loaded."),
      Suspense("HeavyFeature not loaded yet!")(
        DynamicHeavyFeatureD(new HeavyFeature.Props {
          message = "Yeah!"
        })
      )
    )
  }

  def main(args: Array[String]) = {
    println("scala.js app starting")
    react_dom.render(
      render(),
      dom.document.getElementById("container")
    )
  }
}
