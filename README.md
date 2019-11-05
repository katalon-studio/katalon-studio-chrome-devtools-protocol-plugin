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

* Print to PDF (https://github.com/katalon-studio/katalon-studio-chrome-devtools-protocol-plugin/blob/master/Scripts/Print%20PDF/Script1572859522471.groovy).

* Capture full page (https://github.com/katalon-studio/katalon-studio-chrome-devtools-protocol-plugin/blob/master/Scripts/Capture%20full%20page/Script1572950577748.groovy).

* Examples at the library's repository (https://github.com/kklisura/chrome-devtools-java-client/tree/master/cdt-examples/src/main/java/com/github/kklisura/cdt/examples). Please make sure to convert Java's lambda syntax to Groovy's closure syntax.

## License

Katalon Studio's CONTRIBUTION LICENSE AGREEMENT.
