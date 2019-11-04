import com.github.kklisura.cdt.launch.ChromeLauncher as ChromeLauncher
import com.github.kklisura.cdt.protocol.commands.Page as Page
import com.github.kklisura.cdt.protocol.types.page.PrintToPDF as PrintToPDF
import com.github.kklisura.cdt.protocol.types.page.PrintToPDFTransferMode as PrintToPDFTransferMode
import com.github.kklisura.cdt.services.ChromeDevToolsService as ChromeDevToolsService
import com.github.kklisura.cdt.services.ChromeService as ChromeService
import com.github.kklisura.cdt.services.types.ChromeTab as ChromeTab

/**
 * Copied from https://github.com/kklisura/chrome-devtools-java-client/blob/master/cdt-examples/src/main/java/com/github/kklisura/cdt/examples/PrintingPageToPdf.java
 */
// Create chrome launcher.
ChromeLauncher launcher = new ChromeLauncher()

// Launch chrome either as headless (true) - PDF printing is only supported on Chrome headless
// at the moment
ChromeService chromeService = launcher.launch(true)

// Create empty tab ie about:blank.
ChromeTab tab = chromeService.createTab()

// Get DevTools service to this tab
ChromeDevToolsService devToolsService = chromeService.createDevToolsService(tab)

// Get individual commands
Page page = devToolsService.getPage()

page.enable()

// Navigate to github.com.
page.navigate('http://github.com')

page.onLoadEventFired({ def loadEventFired ->
        System.out.println('Printing to PDF...')

        String outputFilename = 'test.pdf'

        Boolean landscape = false

        Boolean displayHeaderFooter = false

        Boolean printBackground = false

        Double scale = 1.0

        Double paperWidth = 8.27 // A4 paper format

        Double paperHeight = 11.7 // A4 paper format

        Double marginTop = 0.0

        Double marginBottom = 0.0

        Double marginLeft = 0.0

        Double marginRight = 0.0

        String pageRanges = ''

        Boolean ignoreInvalidPageRanges = false

        String headerTemplate = ''

        String footerTemplate = ''

        Boolean preferCSSPageSize = false

        PrintToPDFTransferMode mode = PrintToPDFTransferMode.RETURN_AS_BASE_64

        dump(outputFilename, devToolsService.getPage().printToPDF(landscape, displayHeaderFooter, printBackground, scale, 
                paperWidth, paperHeight, marginTop, marginBottom, marginLeft, marginRight, pageRanges, ignoreInvalidPageRanges, 
                headerTemplate, footerTemplate, preferCSSPageSize, mode))

        System.out.println('Done!')

        devToolsService.close()
    })

devToolsService.waitUntilClosed()

def dump(String fileName, PrintToPDF printToPDF) {
    FileOutputStream fileOutputStream = null

    try {
        File file = new File(fileName)

        fileOutputStream = new FileOutputStream(file)

        fileOutputStream.write(Base64.getDecoder().decode(printToPDF.getData()))
    }
    catch (IOException e) {
        e.printStackTrace()
    } 
    finally { 
        if (fileOutputStream != null) {
            try {
                fileOutputStream.flush()

                fileOutputStream.close()
            }
            catch (IOException e) {
                e.printStackTrace()
            } 
        }
    }
}