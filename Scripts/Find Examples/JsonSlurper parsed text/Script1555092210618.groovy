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
import groovy.json.JsonSlurper as JsonSlurper

assert [1, 2, 3].find({
	it > 1
}) == 2


readResponse = WS.sendRequestAndVerify(findTestObject('Values/Values Read', [('url') : GlobalVariable.g_base_url]))

WS.verifyResponseStatusCode(readResponse, 200)

def json = new JsonSlurper().parseText(readResponse.getResponseText())

def attributes = json.data

def name2EqValue2 = attributes.find({
		it.name == 'name2'
	}).value == 'value2' 

WS.verifyEqual(name2EqValue2, true)

