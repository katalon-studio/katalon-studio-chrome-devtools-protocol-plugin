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

## Companion products

### Katalon TestOps

[Katalon TestOps](https://analytics.katalon.com) is a web-based application that provides dynamic perspectives and an insightful look at your automation testing data. You can leverage your automation testing data by transforming and visualizing your data; analyzing test results; seamlessly integrating with such tools as Katalon Studio and Jira; maximizing the testing capacity with remote execution.

* Read our [documentation](https://docs.katalon.com/katalon-analytics/docs/overview.html).
* Ask a question on [Forum](https://forum.katalon.com/categories/katalon-analytics).
* Request a new feature on [GitHub](CONTRIBUTING.md).
* Vote for [Popular Feature Requests](https://github.com/katalon-analytics/katalon-analytics/issues?q=is%3Aopen+is%3Aissue+label%3Afeature-request+sort%3Areactions-%2B1-desc).
* File a bug in [GitHub Issues](https://github.com/katalon-analytics/katalon-analytics/issues).

### Katalon Studio
[Katalon Studio](https://www.katalon.com) is a free and complete automation testing solution for Web, Mobile, and API testing with modern methodologies (Data-Driven Testing, TDD/BDD, Page Object Model, etc.) as well as advanced integration (JIRA, qTest, Slack, CI, Katalon TestOps, etc.). Learn more about [Katalon Studio features](https://www.katalon.com/features/).
