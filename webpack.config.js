const HtmlWebpackPlugin = require("html-webpack-plugin")
const path = require("path")
const { CleanWebpackPlugin } = require('clean-webpack-plugin')
const BundleAnalyzerPlugin = require('webpack-bundle-analyzer').BundleAnalyzerPlugin

const isProduction = process.env.NODE_ENV === 'production';
const scalaSuffix = isProduction ? "opt" : "fastopt"

module.exports = (env, argv) => {

  return {
    name: "scalajs",
    entry: path.resolve(__dirname, `webui/target/scala-2.13/webui-${scalaSuffix}/main.js`),
    output: {
      path: path.resolve(__dirname, "build"),
    },
    plugins: [
      new CleanWebpackPlugin({ cleanStaleWebpackAssets: false }),
      new HtmlWebpackPlugin({
        inject: "body",
        template: "public/index.html"
      })
    ],
  }
}
