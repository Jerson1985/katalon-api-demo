import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

createResponse = WS.sendRequestAndVerify(findTestObject('Users/User 1 - Create', [('url') : GlobalVariable.g_base_url]))

WS.verifyResponseStatusCode(createResponse, 201)

WS.verifyElementPropertyValue(createResponse, 'firstName', 'Mitch')

WS.verifyElementPropertyValue(createResponse, 'lastName', 'Valenta')

readResponse = WS.sendRequest(findTestObject('Users/User 2 - Read - Single', [('id') : GlobalVariable.g_object_id, ('url') : GlobalVariable.g_base_url]))

WS.verifyResponseStatusCode(readResponse, 200)

WS.verifyElementPropertyValue(readResponse, 'firstName', 'Mitch')

WS.verifyElementPropertyValue(readResponse, 'lastName', 'Valenta')

readResponse = WS.sendRequestAndVerify(findTestObject('Users/User 3 - Update', [('id') : GlobalVariable.g_object_id, ('url') : GlobalVariable.g_base_url]))

WS.verifyResponseStatusCode(readResponse, 200)

WS.verifyElementPropertyValue(readResponse, 'firstName', 'Milo')

WS.verifyElementPropertyValue(readResponse, 'lastName', 'Valenta')

readResponse = WS.sendRequestAndVerify(findTestObject('Users/User 2 - Read - Single', [('id') : GlobalVariable.g_object_id
            , ('url') : GlobalVariable.g_base_url]))

WS.verifyResponseStatusCode(readResponse, 200)

WS.verifyElementPropertyValue(readResponse, 'firstName', 'Milo')

WS.verifyElementPropertyValue(readResponse, 'lastName', 'Valenta')

deleteResponse = WS.sendRequest(findTestObject('Users/User 4 - Delete', [('id') : GlobalVariable.g_object_id, ('url') : GlobalVariable.g_base_url]))

WS.verifyResponseStatusCode(deleteResponse, 200)

readResponse = WS.sendRequest(findTestObject('Users/User 2 - Read - Single', [('id') : GlobalVariable.g_object_id, ('url') : GlobalVariable.g_base_url]))

WS.verifyResponseStatusCode(readResponse, 404, FailureHandling.STOP_ON_FAILURE)

