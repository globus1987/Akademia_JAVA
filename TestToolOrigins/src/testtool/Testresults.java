package testtool

import jxl.*
import jxl.write.*
import groovy.json.*

def language = "PL"

//Read Excel
def templateLocalisation="C:\\\\Users\\\\arekfr\\\\DaneTestowe.xls"
def outFileLocalisation="C:\\\\Users\\\\arekfr\\\\DaneTestoweOut.xls"
def SheetName = ['PL':'PrzypadkiTestowe']

def definitionDate = "2017-06-28"
Workbook workbook = Workbook.getWorkbook(new File(templateLocalisation))
WritableWorkbook copy = Workbook.createWorkbook(new File(outFileLocalisation),workbook)
WritableSheet TestCases = copy.getSheet(SheetName.find {it.key==language}.value)

//creating a copy to save results in
File datasheet = new File(outFileLocalisation)
File request = new File("C:\\Users\\arekfr\\request.txt")
File response = new File("C:\\Users\\arekfr\\response.txt")
String fileContents = context.expand( '${SimulateRequest#Response}').toString()
def PremiumColumn = 7
def FirstResult=2
def RestResponse = new JsonSlurper().parseText(  fileContents )
def PolicyList = new LinkedHashMap()
PolicyList = RestResponse.root.applicationList.policyList[0]
def premiumlist = []
def PolicySize = PolicyList.size()
int currentRow = FirstResult
for (a in 0..PolicySize-1)
{
    LinkedHashMap Policy= PolicyList.get(a)
    if (Policy.containsKey('premium')) {
        def Premium = Policy.find { it.key == 'premium' }.value.value
        Label SPPremium = new Label(PremiumColumn, currentRow, , Premium.toString());
        TestCases.addCell(SPPremium)
    }
    currentRow++
    def RiskList = new LinkedHashMap()
    RiskList = PolicyList.get(a).get('riskList')
    def RiskSize = RiskList.size()
    for (b in 0..RiskSize-1)
    {
        LinkedHashMap Risk= RiskList.get(b)
        if (Risk.containsKey('premium')) {
            def RiskPremium = Risk.find { it.key == 'premium' }.value.value
            Label RiskPremiumCell = new Label(PremiumColumn, currentRow, , RiskPremium.toString());
            TestCases.addCell(RiskPremiumCell)
        }
        currentRow++
    }

}
request.write(context.expand( '${SimulateRequest#Request}').toString())
response.write(context.expand( '${SimulateRequest#Response}').toString())
request.close()
response.close()
copy.write()
copy.close();
workbook.close();