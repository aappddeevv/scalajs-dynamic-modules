Very small example of dynamic module loading using scala.js.

The UI uses react, although that is not critical to show
dynamic module loading.

The example only uses the "fast" version of compilation.

This is a bare bones example.

## Running with Reload

The follow terminal commands start the scala side and
the bundler side in watch mode suitable for development.
A production build would contain other processing steps
in both build build specifications.

This build will update the scala module upon sbt
rebuild but it does not do module-level HMR, which
can be done for react, but this example does not show it.

If you change the code, the entire scala module is reloaded.

```sh
npm install
sbt ~webui/fastLinkJS
# seperate terminal
npm run watch
```

A bundle size visualizer is included so open 2 pages:

* app: http://localhost:8080
* bundle visualizer: http://localhost:8888

## Commentary

If you run `npm run build` you will see in the build folder, a
separate module something like `621.Scala.js`. Webpack automatically
sees the react dyanmic module and creates a bundle whose name
reflects the webpack output bundle name. It transforms the 
scala.js output `HeavyFeature` class into a name resembling
the webpack configuration, not the scala.js linker output model.

All of this worked the first time, so kudos to the scala.js team.

## Production build

To build the code and run it from the build directory with 
a static web server:

```sh
npm install
sbt webui/fullLinkJS
npm run start
```

Then open `http://localhost:8080'.
