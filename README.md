# Katalon Studio Chrome DevTools Protocol Plugin

Integrate Chrome Devtools Protocol with Katalon Studio using https://github.com/kklisura/chrome-devtools-java-client.

## Usage

Only works with Chrome.

```groovy
WebUI.openBrowser('https://github.com')

ChromeDevToolsService cdts = CdpUtils.getService()
```

## Use cases

References:

* https://github.com/GoogleChromeLabs/puppeteer-examples.

* https://github.com/kklisura/chrome-devtools-java-client/tree/master/cdt-examples/src/main/java/com/github/kklisura/cdt/examples.

## Examples

See https://github.com/katalon-studio-samples/katalon-studio-chrome-devtools-protocol-plugin-samples (Please remember to install the plugin first). This includes two test cases:
* Print to PDF.
* Capture full page.

See also the library's repository (https://github.com/kklisura/chrome-devtools-java-client/tree/master/cdt-examples/src/main/java/com/github/kklisura/cdt/examples). Please make sure to convert Java's lambda syntax to Groovy's closure syntax.

## License

Katalon Studio's CONTRIBUTION LICENSE AGREEMENT.
