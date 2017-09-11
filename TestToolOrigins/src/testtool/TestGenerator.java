package testtool

import jxl.*
import jxl.write.*
import groovy.json.*
import groovyx.net.http.*

import org.apache.poi.ss.usermodel.ObjectData


import static jxl.Workbook.getWorkbook
import java.text.SimpleDateFormat

def language = "PL"
def start = System.currentTimeMillis()
//Read Excel

def ObjectType =['SalesProduct':[attrLocal:'[\'salesProduct\']'],'Risk':[attrLocal:'[\'riskList\']'],'Tariff':[attrLocal:'[\'tariffList\']'],'RiskSubject':[attrLocal:'[\'subjectList\']'],'RiskObject':[attrLocal:'[\'objectList\']']]
def SheetName = ['PL':[SalesProduct:'DanePakietu',Risk:'DaneUbezpieczeñ',Tariff:'DaneTaryfy',RiskSubject:'DanePodmiotu',RiskObject:'DanePrzedmiotu']]
def ObjectType2 =['Risk':[attrLocal:'[\'riskList\']'],'Tariff':[attrLocal:'[\'tariffList\']'],'RiskSubject':[attrLocal:'[\'subjectList\']'],'RiskObject':[attrLocal:'[\'objectList\']']]

def templateLocalisation="C:\\Users\\arekfr\\DaneTestowe.xls"
def outFileLocalisation="C:\\Users\\arekfr\\DaneTestoweOut.xls"
Workbook workbook = getWorkbook(new File(templateLocalisation))

//creating a copy to save results in
WritableWorkbook copy = Workbook.createWorkbook(new File(outFileLocalisation),workbook)

WritableSheet SalesProductData = copy.getSheet(SheetName.find {it.key==language}.value.SalesProduct);
WritableSheet RiskData = copy.getSheet(SheetName.find {it.key==language}.value.Risk);
WritableSheet TariffData = copy.getSheet(SheetName.find {it.key==language}.value.Tariff);
WritableSheet RiskSubjectData = copy.getSheet(SheetName.find {it.key==language}.value.RiskSubject);
WritableSheet RiskObjectData = copy.getSheet(SheetName.find {it.key==language}.value.RiskObject);
WritableSheet TestCases = copy.getSheet("PrzypadkiTestowe")

int firstColumn = 6
int descRow = 0
int symbolRow=1
int typeRow = 2
int FirstDataRow = 4
int FirstTC=2
def attributeMap= new LinkedHashMap()
def dataRows=0
def dataColumns = 0
def Request=''
List<String> PartnerlistKey=[], ObjectListKey= []
//SalesProduct
dataRows=SalesProductData.getRows()-FirstDataRow
dataColumns=SalesProductData.getColumns()-firstColumn
def symbol = SalesProductData.getRow(symbolRow)
def spid=0
for (i in FirstDataRow..FirstDataRow+dataRows-1)
{
    def Row=SalesProductData.getRow(i)
    def AttributeSymbol=SalesProductData.getRow(1)
    def RowSize=Row.length
    def attributeList= new LinkedHashMap()
    for (m in firstColumn..RowSize-1)
    {
        def DataCell=SalesProductData.getCell(m,i)
        def Type = DataCell.getType()
        def attributesymbol=symbol[m].contents
        if (Type==CellType.NUMBER)
        {

            def datacellvalue=DataCell.value.toString()
            if(datacellvalue.substring(datacellvalue.length()-2,datacellvalue.length())==".0")
            {
                datacellvalue= datacellvalue.substring(0,datacellvalue.length()-2)
            }
            attributeList[attributesymbol] = ['value':datacellvalue]
        }
        else if (Type==CellType.LABEL)
        {
            attributeList[attributesymbol] = ['value': DataCell.getContents()]

        }
        else if (Type== CellType.EMPTY)
        {
            //pusta
        }
        else if (Type==CellType.DATE)
        {
            DateCell dCell = (DateCell) DataCell;
            def data ='xyz'
            TimeZone gmtZone = TimeZone.getTimeZone("GMT");
            SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd");
            destFormat.setTimeZone(gmtZone);
            data = destFormat.format(dCell.getDate());
            attributeList[attributesymbol] = ['value': data]
        }

    }
    //REST attributelist request
    Request=/"attributeList":[/
    attributeList.each{
        key,value ->
            def dupa =attributeList.find{it.key==key}.value
            Request = Request + /{"symbol":/ + /"$key","value":"$value.value"},/
    }
    if(Request.charAt(Request.length()-1)==",")
    {
        Request= Request.substring(0,Request.length()-1)
    }
    Request=Request+/]/
    def ProductData=/"productData": {"name": "/+Row[2].contents+/","idProductModule":"/+Row[1].contents+/"}/
    def MetaData=/"metadata": {"id":"/+Row[0].contents+/"}/
    spid++
    // adding to map
    attributeMap[Row[0].contents] = ['IDPM':Row[1].contents,'Name':Row[2].contents,'Attributes':attributeList,'RequestAttributes':Request,'MetaData':MetaData,'ProductData':ProductData]

}

//Risk
dataRows=RiskData.getRows()-FirstDataRow
dataColumns=RiskData.getColumns()-firstColumn
symbol = RiskData.getRow(symbolRow)
for (i in FirstDataRow..FirstDataRow+dataRows-1)
{
    def Row=RiskData.getRow(i)
    def AttributeSymbol=RiskData.getRow(1)
    def RowSize=Row.length
    def attributeList= new LinkedHashMap()
    for (m in firstColumn..RowSize-1)
    {
        def DataCell=RiskData.getCell(m,i)
        def Type = DataCell.getType()
        def attributesymbol=symbol[m].contents
        if (Type==CellType.NUMBER)
        {
            def datacellvalue=DataCell.value.toString()
            if(datacellvalue.substring(datacellvalue.length()-2,datacellvalue.length())==".0")
            {
                datacellvalue= datacellvalue.substring(0,datacellvalue.length()-2)
            }
            attributeList[attributesymbol] = ['value':datacellvalue]
        }
        else if (Type==CellType.LABEL)
        {
            attributeList[attributesymbol] = ['value': DataCell.getContents()]

        }
        else if (Type== CellType.EMPTY)
        {
            //pusta
        }
        else if (Type==CellType.DATE)
        {
            DateCell dCell = (DateCell) DataCell;
            def data ='xyz'
            TimeZone gmtZone = TimeZone.getTimeZone("GMT");
            SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd");
            destFormat.setTimeZone(gmtZone);
            data = destFormat.format(dCell.getDate());
            attributeList[attributesymbol] = ['value': data]
        }

    }
    //REST attributelist request
    Request=/"attributeList":[/
    attributeList.each{
        key,value ->
            Request = Request + /{"symbol":/ + /"$key","value":"$value.value"},/
    }
    if(Request.charAt(Request.length()-1)==",")
    {
        Request= Request.substring(0,Request.length()-1)
    }
    Request=Request+/]/
    def ProductData=/"productData": {"name": "/+Row[2].contents+/","idProductModule":"/+Row[1].contents+/"}/
    def MetaData=/"metadata": {"id":"/+Row[0].contents+/"}/
    attributeMap[Row[0].contents] = ['IDPM':Row[1].contents,'Name':Row[2].contents,'Attributes':attributeList,'RequestAttributes':Request,'MetaData':MetaData,'ProductData':ProductData]
}

//Tariff
dataRows=TariffData.getRows()-FirstDataRow
dataColumns=TariffData.getColumns()-firstColumn
symbol = TariffData.getRow(symbolRow)
for (i in FirstDataRow..FirstDataRow+dataRows-1)
{
    def Row=TariffData.getRow(i)
    def AttributeSymbol=TariffData.getRow(1)
    def RowSize=Row.length
    def attributeList= new LinkedHashMap()
    if (RowSize>=firstColumn) {

        for (m in firstColumn..RowSize - 1) {
            def DataCell = TariffData.getCell(m, i)
            def Type = DataCell.getType()
            def attributesymbol = symbol[m].contents
            if (Type == CellType.NUMBER) {
                def datacellvalue=DataCell.value.toString()
                if(datacellvalue.substring(datacellvalue.length()-2,datacellvalue.length())==".0")
                {
                    datacellvalue= datacellvalue.substring(0,datacellvalue.length()-2)
                }
                attributeList[attributesymbol] = ['value':datacellvalue]
            } else if (Type == CellType.LABEL) {
                attributeList[attributesymbol] = ['value': DataCell.getContents()]

            } else if (Type == CellType.EMPTY) {
                //pusta
            } else if (Type == CellType.DATE) {
                DateCell dCell = (DateCell) DataCell;
                def data = 'xyz'
                TimeZone gmtZone = TimeZone.getTimeZone("GMT");
                SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd");
                destFormat.setTimeZone(gmtZone);
                data = destFormat.format(dCell.getDate());
                attributeList[attributesymbol] = ['value': data]
            }

        }
    }
    //REST attributelist request
    Request=/"attributeList":[/
    attributeList.each{
        key,value ->
            Request = Request + /{"symbol":/ + /"$key","value":"$value.value"},/
    }
    if(Request.charAt(Request.length()-1)==",")
    {
        Request= Request.substring(0,Request.length()-1)
    }
    Request=Request+/]/
    def ProductData=/"productData": {"name": "/+Row[2].contents+/","idProductModule":"/+Row[1].contents+/"}/
    def MetaData=/"metadata": {"id":"/+Row[0].contents+/"}/
    attributeMap[Row[0].contents] = ['IDPM':Row[1].contents,'Name':Row[2].contents,'Attributes':attributeList,'RequestAttributes':Request,'MetaData':MetaData,'ProductData':ProductData]

}
//Object
dataRows=RiskObjectData.getRows()-FirstDataRow
dataColumns=RiskObjectData.getColumns()-firstColumn
symbol = RiskObjectData.getRow(symbolRow)
for (i in FirstDataRow..FirstDataRow+dataRows-1)
{
    def Row=RiskObjectData.getRow(i)
    def AttributeSymbol=RiskData.getRow(1)
    def RowSize=Row.length
    def attributeList= new LinkedHashMap()
    for (m in firstColumn..RowSize-1)
    {
        WritableCell DataCell=RiskObjectData.getCell(m,i)
        def Type = DataCell.getType()
        def attributesymbol=symbol[m].contents
        if (Type==CellType.NUMBER)
        {
            def datacellvalue=DataCell.value.toString()
            if(datacellvalue.substring(datacellvalue.length()-2,datacellvalue.length())==".0")
            {
                datacellvalue= datacellvalue.substring(0,datacellvalue.length()-2)
            }
            attributeList[attributesymbol] = ['value':datacellvalue]
        }
        else if (Type==CellType.LABEL)
        {
            attributeList[attributesymbol] = ['value': DataCell.getContents()]

        }
        else if (Type== CellType.EMPTY)
        {
            //pusta
        }
        else if (Type==CellType.DATE)
        {
            DateCell dCell = (DateCell) DataCell;
            def data ='xyz'
            TimeZone gmtZone = TimeZone.getTimeZone("GMT");
            SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd");
            destFormat.setTimeZone(gmtZone);
            data = destFormat.format(dCell.getDate());
            attributeList[attributesymbol] = ['value': data]
        }

    }
    //REST attributelist request
    Request=/"attributeList":[/
    attributeList.each{
        key,value ->
            Request = Request + /{"symbol":/ + /"$key","value":"$value.value"},/
    }
    if(Request.charAt(Request.length()-1)==",")
    {
        Request= Request.substring(0,Request.length()-1)
    }
    Request=Request+/]/
    def ProductData=/"productData": {"name": "/+Row[2].contents+/","idProductModule":"/+Row[1].contents+/"}/
    def MetaData=/"metadata": {"id":"/+Row[0].contents+/"}/
    attributeMap[Row[0].contents] = ['IDPM':Row[1].contents,'Name':Row[2].contents,'Attributes':attributeList,'RequestAttributes':Request,'MetaData':MetaData,'ProductData':ProductData]
    ObjectListKey[ObjectListKey.size()]=Row[0].contents
}
//Subject
dataRows=RiskSubjectData.getRows()-FirstDataRow
dataColumns=RiskSubjectData.getColumns()-firstColumn
symbol = RiskSubjectData.getRow(symbolRow)
for (i in FirstDataRow..FirstDataRow+dataRows-1)
{
    def Row=RiskSubjectData.getRow(i)
    def AttributeSymbol=RiskSubjectData.getRow(1)
    def RowSize=Row.length
    def attributeList= new LinkedHashMap()
    for (m in firstColumn..RowSize-1)
    {
        def DataCell=RiskSubjectData.getCell(m,i)
        def Type = DataCell.getType()
        def attributesymbol=symbol[m].contents
        if (Type==CellType.NUMBER)
        {
            def datacellvalue=DataCell.value.toString()
            if(datacellvalue.substring(datacellvalue.length()-2,datacellvalue.length())==".0")
            {
                datacellvalue= datacellvalue.substring(0,datacellvalue.length()-2)
            }
            attributeList[attributesymbol] = ['value':datacellvalue]
        }
        else if (Type==CellType.LABEL)
        {
            attributeList[attributesymbol] = ['value': DataCell.getContents()]

        }
        else if (Type== CellType.EMPTY)
        {
            //pusta
        }
        else if (Type==CellType.DATE)
        {
            DateCell dCell = (DateCell) DataCell;
            def data ='xyz'
            TimeZone gmtZone = TimeZone.getTimeZone("GMT");
            SimpleDateFormat destFormat = new SimpleDateFormat("yyyy-MM-dd");
            destFormat.setTimeZone(gmtZone);
            data = destFormat.format(dCell.getDate());
            attributeList[attributesymbol] = ['value': data]
        }


    }
    //REST attributelist request
    Request=/"attributeList":[/
    attributeList.each{
        key,value ->
            def dupa =attributeList.find{it.key==key}.value.value.toString()
            if (dupa.charAt(0)=="[" && dupa.charAt(dupa.length()-1)=="]")
            {
                Request = Request + /{"symbol":/ + /"$key","collectionValue":$value.value},/
            }
            else
            {
                Request = Request + /{"symbol":/ + /"$key","value":"$value.value"},/
            }
    }
    if(Request.charAt(Request.length()-1)==",")
    {
        Request= Request.substring(0,Request.length()-1)
    }
    Request=Request+/]/
    def ProductData=/"productData": {"name": "/+Row[2].contents+/","idProductModule":"/+Row[1].contents+/"}/
    def MetaData=/"metadata": {"id":"/+Row[0].contents+/"}/
    attributeMap[Row[0].contents] = ['IDPM':Row[1].contents,'Name':Row[2].contents,'Attributes':attributeList,'RequestAttributes':Request,'MetaData':MetaData,'ProductData':ProductData]
    PartnerlistKey[PartnerlistKey.size()]=Row[0].contents
}
//TestCases
dataRows=TestCases.getRows()-FirstTC
def TCMap= new LinkedHashMap()
def TCSubMap= new LinkedHashMap()
def id = 0
def TCMapKey
def LastTCMapKey
for (y in FirstTC..dataRows+FirstTC-1) {
    def Row=TestCases.getRow(y)
    def RowSize=Row.length
    TCMapKey = Row[0].contents
    if (LastTCMapKey!=null && LastTCMapKey!=TCMapKey)
    {
        TCSubMap.clear()
        id = 0
    }
    if (TCMap.find{it.key==TCMapKey}==null)
    {
        TCMap[TCMapKey] = ['SalesProduct': Row[1].contents,'SPTariff': Row[2].contents]
        LastTCMapKey=TCMapKey
    }
    else
    {

        try { TCSubMap[id] = ['Risk':Row[3].contents,'RiskTariff':Row[4].contents,'Subject':Row[5].contents,'Object':Row[6].contents]}
        catch (ArrayIndexOutOfBoundsException){println("exception "+TCMapKey)}
        id++
        TCMap[TCMapKey]<<TCSubMap
        LastTCMapKey=TCMapKey
    }

}

def TCRequestMap= new LinkedHashMap()
def SalesProduct, RiskList, SPTariff,SubjectList,ObjectList,RiskTariff
def RiskList2, SubjectList2,ObjectList2

def TCMapSize=TCMap.size()
def TCMapKeySet=TCMap.keySet()
def RiskConID = 0
def SPID = 0
def RequestJSON = /{"root":{"applicationList":[{"state": "DEVELOPMENT","salesDate": "/+CalculationDate+/","validDate": "/+CalculationDate+/","versionDate": "/+CalculationDate+/","metadata": {"id": 1},"policyList":[/
def RequestJSON = /{"root":{"applicationList":[{"state": "DEVELOPMENT","salesDate": "2017-09-01","validDate": "2017-09-01","versionDate": "2017-12-31","metadata": {"id": 1},"policyList":[/

def RequestJSON = /{"root":{"applicationList":[{"state": "DEVELOPMENT","salesDate":/+CalculationDate+/,validDate": /+CalculationDate+/,"versionDate": "/+CalculationDate+/","metadata": {"id": 1},"policyList":[/
for (q in 0..TCMapSize-1)
{
    RiskConID=0
    TCMapKey=TCMapKeySet[q]
    SalesProduct= TCMap.find { it.key == TCMapKey }.value['SalesProduct']
    SPTariff=TCMap.find { it.key == TCMapKey }.value['SPTariff']
    def SPMetaData=/"metadata": {"id":"SP/+SPID+/"}/
    SPID++
    RequestJSON=RequestJSON+/{/+attributeMap.find{it.key==SalesProduct}.value.ProductData+/,/+SPMetaData+/,/+attributeMap.find{it.key==SalesProduct}.value.RequestAttributes
    RequestJSON=RequestJSON+/,"tariff":{/+attributeMap.find{it.key==SPTariff}.value.MetaData+/,/+attributeMap.find{it.key==SPTariff}.value.ProductData+/,/+attributeMap.find{it.key==SPTariff}.value.RequestAttributes+/}/
    //objectlist
    def Objectlist=/,"objectList": [/
    for (m in 0..ObjectListKey.size()-1){        def attrlist=attributeMap.find {it.key==ObjectListKey[m]}.value.RequestAttributes
        def objmetadata=attributeMap.find {it.key==ObjectListKey[m]}.value.MetaData
        Objectlist=Objectlist+/{/+attrlist+/,/+objmetadata+/}/
        if (m!=ObjectListKey.size()-1)
        {
            Objectlist=Objectlist+/,/
        }
        else
        {
            Objectlist=Objectlist+/],/
        }
    }
    RequestJSON=RequestJSON+Objectlist

    //partnerlist
    def PartnerList=/"partnerList": [/
    for (m in 0..PartnerlistKey.size()-1){        def attrlist=attributeMap.find {it.key==PartnerlistKey[m]}.value.RequestAttributes
        def objmetadata=attributeMap.find {it.key==PartnerlistKey[m]}.value.MetaData
        PartnerList=PartnerList+/{/+attrlist+/,/+objmetadata+/}/
        if (m!=PartnerlistKey.size()-1)
        {
            PartnerList=PartnerList+/,/
        }
        else
        {
            PartnerList=PartnerList+/]/
        }
    }

    RequestJSON=RequestJSON+PartnerList

    //RISKLIST
    RiskList=TCMap.find { it.key == TCMapKey }.value
    def RiskListRequest=/"riskList": [/
    for (p in 0..RiskList.size()-3) {
        RiskList2 = RiskList.find { it.key == RiskConID }
        SubjectList2 = RiskList2.value.Subject.tokenize(";")
        ObjectList2 = RiskList2.value.Object.tokenize(";")
        RiskTariff = RiskList2.value.RiskTariff



        // beginning
        def request = /{/
        //add product data
        request=request+attributeMap.find{it.key==RiskList2.value.Risk}.value.ProductData+/,/
        //add attrlist
        request=request+attributeMap.find{it.key==RiskList2.value.Risk}.value.RequestAttributes+/,/
        //add metadata
        request=request+attributeMap.find{it.key==RiskList2.value.Risk}.value.MetaData
        //add tariff
        request=request+/,"tariff":{/+attributeMap.find{it.key==RiskTariff}.value.ProductData+/},/
        // add subject list
        def TempSubList=""
        for (z in 0..SubjectList2.size()-1)
        {
            if (z!=SubjectList2.size()-1)
            {
                TempSubList = TempSubList + /{"ref": "/ + SubjectList2[z] +/","typeId":"/+attributeMap.find{it.key==SubjectList2[z]}.value.IDPM +/"},/
            }
            else
            {
                TempSubList =TempSubList + /{"ref": "/ + SubjectList2[z] +/","typeId":"/+attributeMap.find{it.key==SubjectList2[z]}.value.IDPM +/"}/
            }
        }
        request=request+/"insuredSubjectList":[/+TempSubList+/],/
        //add object list
        def TempObList=""
        for (z in 0..ObjectList2.size()-1)
        {
            if (z!=ObjectList2.size()-1)
            {
                TempObList = TempObList + /{"ref": "/ + ObjectList2[z] + /","typeId":"/+attributeMap.find{it.key==ObjectList2[z]}.value.IDPM +/"},/
            }
            else
            {
                TempObList = TempObList + /{"ref": "/ + ObjectList2[z] + /","typeId":"/+attributeMap.find{it.key==ObjectList2[z]}.value.IDPM +/"}/
            }
        }
        request=request+/"insuredObjectList":[/+TempObList+/]/
        //add ending
        request=request+/}/
        if (p!=RiskList.size()-3)
        {
            RiskListRequest=RiskListRequest+request+/,/
        }
        else
        {
            RiskListRequest=RiskListRequest+request
        }
        RiskConID++
    }
    RiskListRequest=RiskListRequest+/]/
    RequestJSON=RequestJSON+/,/+RiskListRequest+/}/
    if (q!=TCMapSize-1)
    {
        RequestJSON=RequestJSON+/,/
    }
}
RequestJSON=RequestJSON+/]}],"requestCapacity": 1}}/
copy.write()
copy.close();
workbook.close();
def stop = System.currentTimeMillis()
println(stop-start)

Result = RequestJSON