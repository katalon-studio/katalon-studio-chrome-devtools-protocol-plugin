import com.github.kklisura.cdt.protocol.commands.Emulation as Emulation
import com.github.kklisura.cdt.protocol.commands.Page as Page
import com.github.kklisura.cdt.protocol.types.page.CaptureScreenshotFormat as CaptureScreenshotFormat
import com.github.kklisura.cdt.services.ChromeDevToolsService as ChromeDevToolsService
import com.katalon.cdp.CdpUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

WebUI.openBrowser('https://github.com')

ChromeDevToolsService cdts = CdpUtils.getService()

captureFullPageScreenshot(cdts, 'screenshot.png')

WebUI.closeBrowser()

def captureFullPageScreenshot(ChromeDevToolsService devToolsService, String outputFilename) {
    Page page = devToolsService.getPage()

    double width = 960

    double height = WebUI.executeJavaScript('return document.body.scrollHeight', null)

    Emulation emulation = devToolsService.getEmulation()

    emulation.setDeviceMetricsOverride(Double.valueOf(width).intValue(), Double.valueOf(height).intValue(), 1.0, Boolean.FALSE)

    emulation.setScrollbarsHidden(Boolean.TRUE)

    String image = page.captureScreenshot(CaptureScreenshotFormat.PNG, null, null, null)

    dump(outputFilename, image)

    emulation.setScrollbarsHidden(Boolean.FALSE)
}

def dump(String fileName, String data) {
    FileOutputStream fileOutputStream = null

    try {
        File file = new File(fileName)

        fileOutputStream = new FileOutputStream(file)

        fileOutputStream.write(Base64.getDecoder().decode(data))
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