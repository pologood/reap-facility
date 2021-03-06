
export default {
  "entry": "src/index.js",
  "extraBabelPlugins": [
    "transform-runtime",
    "transform-decorators-legacy",
    "transform-class-properties",
    ["import", { "libraryName": "antd", "libraryDirectory": "es", "style": true }]
  ],
  "extraBabelIncludes": [
    "mock/devConfig.js"
  ],
  "env": {
    "development": {
      "extraBabelPlugins": [
        "dva-hmr"
      ]
    }
  },
  "externals": {
    "g2": "G2",
    "g-cloud": "Cloud",
    "g2-plugin-slider": "G2.Plugin.slider"
  },
  "publicPath": "./",
  "ignoreMomentLocale": true,
  "theme": "./src/theme.js",
  "hash": true
}
