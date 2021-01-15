const HtmlWebpackPlugin = require("html-webpack-plugin")
const path = require("path")
const { CleanWebpackPlugin } = require('clean-webpack-plugin')
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin


module.exports = {
  entry: process.env.NODE_ENV === "production" ?
    path.resolve(__dirname, "webui/target/scala-2.13/webui-opt/main.js") :
    path.resolve(__dirname, "webui/target/scala-2.13/webui-fastopt/main.js"),
  output: {
    path: path.resolve(__dirname, "build"),
    filename: "Scala.js"
  },
  plugins:
    (process.env.NODE_ENV === "production" ? [new BundleAnalyzerPlugin()] : []).concat(
      [
        new CleanWebpackPlugin({ cleanStaleWebpackAssets: false }),
        new HtmlWebpackPlugin({
          inject: "body",
          template: "public/index.html"
        })
      ]),
  devServer: {
    watchContentBase: true
  }
}
