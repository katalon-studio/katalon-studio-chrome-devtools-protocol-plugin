import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.github.kklisura.cdt.protocol.commands.Fetch
import com.github.kklisura.cdt.protocol.commands.Network as Network
import com.github.kklisura.cdt.protocol.commands.Page as Page
import com.github.kklisura.cdt.services.ChromeDevToolsService as ChromeDevToolsService
import com.katalon.cdp.CdpUtils as CdpUtils
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.util.internal.Base64 as Base64

WebUI.openBrowser('')

ChromeDevToolsService cdts = CdpUtils.getService()

Page page = cdts.getPage()

Network network = cdts.getNetwork()

Fetch fetch = cdts.getFetch()

fetch.onRequestPaused({def requestIntercepted -> 
	String interceptionId = requestIntercepted.getRequestId()
	
	boolean isMocked = requestIntercepted.getRequest().getUrl().contains('api.php')
	
	String response = '["Katalon Studio",["Katalon Studio"],["Katalon Studio is an automation testing solution developed by Katalon LLC. The software is built on top of the open-source automation frameworks Selenium, Appium with a specialized IDE interface for API, web, mobile and desktop application testing."],["https://en.wikipedia.org/wiki/Katalon_Studio"]]'
	
	String rawResponse = Base64.encode(response)
	
	System.out.printf('%s - %s%s', isMocked ? 'MOCKED' : 'CONTINUE', requestIntercepted.getRequest().getUrl(), System.lineSeparator())
	
	if(isMocked){
		fetch.fulfillRequest(interceptionId, 200, new ArrayList(), rawResponse, null)
	}
	else {
		fetch.continueRequest(interceptionId)
	}
})


fetch.enable()

// Enable page events.
page.enable()

// Navigate to wikipedia.
WebUI.navigateToUrl('https://en.wikipedia.org/wiki/Main_Page')

WebUI.setText(findTestObject('Page_Wikipedia the free encyclopedia/Search input'), 
    'Intercept request')

WebUI.waitForElementVisible(findTestObject('Page_Wikipedia the free encyclopedia/Select Katalon'), 10)

WebUI.click(findTestObject('Page_Wikipedia the free encyclopedia/Select Katalon'))

WebUI.waitForPageLoad(10)

