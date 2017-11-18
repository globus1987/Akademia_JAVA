package pl.atena.edu.moje.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelTest {

	public static void main(final String[] args)
			throws FileNotFoundException, IOException, EncryptedDocumentException, InvalidFormatException {
		FileInputStream nowyplik = new FileInputStream("D:/Akademia JAVA/TST.xls");
		Workbook wb = WorkbookFactory.create(new File("D:/Akademia JAVA/TST.xls"));
		System.out.println(wb);

		int SheetNumber;
		int RowNumber;
		int ColumnNumber;
		Sheet sheet = wb.getSheetAt(3);
		for (int k = 0; k <= sheet.getLastRowNum(); k++) {
			Row row = sheet.getRow(k);
			for (int i = 0; i <= row.getLastCellNum(); i++) {
				if (row.getCell(i) != null) {
					System.out.println(row.getCell(i));
					if (row.getCell(i).getCellType()==0 && DateUtil.isCellDateFormatted(row.getCell(i))){
						System.out.println("to jest format daty "+row.getCell(i)+" "+row.getCell(i).getDateCellValue());
						CreationHelper createhelper = wb.getCreationHelper();
						CellStyle cellStyle = row.getCell(i).getCellStyle();
						cellStyle.setDataFormat(createhelper.createDataFormat().getFormat("yyyy-MM-dd"));
						row.getCell(i).setCellStyle(cellStyle);
						System.out.println("to jest format daty "+row.getCell(i)+" "+row.getCell(i).getDateCellValue());

					}
				}

			}
		}

	}

}
