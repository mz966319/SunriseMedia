package util.pdf.excel;

import Database.util.DatabaseHelper;
import Database.util.SearchHelper;
import boooks.objects.Book;
import boooks.objects.Inventory;
import java.awt.Desktop;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;
import java.io.IOException;  
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.poi.hssf.usermodel.HSSFSheet;  
import org.apache.poi.hssf.usermodel.HSSFWorkbook;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelHelper {  
    private static final String NAME = "Books.xlsx";

	public static void readExcel() {
		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
                            if(sh.getSheetName().equals("AAAAAM")){
				System.out.println("Sheet name is "+sh.getSheetName());
				System.out.println("---------");
				Iterator<Row> iterator = sh.iterator();
                                String time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
                                iterator.next();iterator.next();iterator.next();iterator.next();iterator.next();iterator.next();iterator.next();iterator.next();
				while(iterator.hasNext()) {
                                    
					Row row = iterator.next();
                                        System.out.println("ID:"+dataFormatter.formatCellValue(row.getCell(1))+  "Grade:"+row.getCell(3)+ " Subject:"+row.getCell(4)+" Title:"+row.getCell(5)+" Total Qty:"+row.getCell(6)+
                                                " Cost:"+row.getCell(7)+" Discount:"+row.getCell(9));
                                        if(!dataFormatter.formatCellValue(row.getCell(1)).isEmpty()&&!dataFormatter.formatCellValue(row.getCell(1)).equals("Total")){
                                            Book book= new Book();
                                            book.setId(String.valueOf(dataFormatter.formatCellValue(row.getCell(1))));
                                            book.setTitle(dataFormatter.formatCellValue(row.getCell(5)));
                                            book.setGrade(dataFormatter.formatCellValue(row.getCell(3)));
                                            book.setSubject(dataFormatter.formatCellValue(row.getCell(4)));
                                            int bookQty=0;
                                            if(!dataFormatter.formatCellValue(row.getCell(11)).isEmpty()){
                                                bookQty=Integer.valueOf(dataFormatter.formatCellValue(row.getCell(11)));
                                            }
                                            book.setQty(bookQty);
                                            if(dataFormatter.formatCellValue(row.getCell(7)).isEmpty()){
                                                book.setCost(0);
                                            }else if(dataFormatter.formatCellValue(row.getCell(7)).equals("53*2")){
                                                book.setCost(106);
                                            }else{
                                                book.setCost(Double.valueOf(dataFormatter.formatCellValue(row.getCell(7))));
                                            }
                                            if(!dataFormatter.formatCellValue(row.getCell(9)).isEmpty()){
                                                book.setCostDiscountRate(Double.valueOf(dataFormatter.formatCellValue(row.getCell(9))));
                                            }
                                            else{
                                                book.setCostDiscountRate(0);
                                            }
                                            
                                            book.setProfitRate(Double.valueOf(25));
                                            if(dataFormatter.formatCellValue(row.getCell(6)).isEmpty()){
                                                book.setTotalQty(0);
                                            }else{
                                                book.setTotalQty(Integer.valueOf(dataFormatter.formatCellValue(row.getCell(6))));
                                            }
                                            
                                            DatabaseHelper.addBook(book);
                                            
                                            
                                            
                                            String employeeID= "Admin";
                                            int rcvIndex = 1;

                                            String id = UUID.randomUUID().toString();
                                            if(bookQty>0){

                                                Inventory inventory = new Inventory(id,book.getId(),bookQty,time,employeeID,rcvIndex);
                                                DatabaseHelper.addInventory(inventory);
                                            }
             
                                            
                                            
                                            
                                            
                                        
                                        }
//					Iterator<Cell> cellIterator = row.iterator();
//					while (cellIterator.hasNext()) {
//						Cell cell = cellIterator.next();
//                                                
//						String cellValue = dataFormatter.formatCellValue(cell);
//						//if(cell.getCellType() == CellType.STRING) {
//						//	
//						//}
////                                                if()
//						System.out.print(cell.getColumnIndex()+"->"+cellValue+"\t");
//					}
					System.out.println();
				}
                            }
			}
			workbook.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
        
        public static void readExcel2() {
		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
                            if(sh.getSheetName().equals("Sheet1")){
				System.out.println("Sheet name is "+sh.getSheetName());
				System.out.println("---------");
				Iterator<Row> iterator = sh.iterator();
                                String time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
                                iterator.next();
				while(iterator.hasNext()) {
                                    
					Row row = iterator.next();
                                        System.out.println("ID:"+dataFormatter.formatCellValue(row.getCell(0))+  "Grade:"+row.getCell(1)+ " Subject:"+row.getCell(2)+" Title:"+row.getCell(3)+" Qty:"+row.getCell(4)+" Total Qty:"+row.getCell(5)+
                                                " Cost:"+row.getCell(6));
                                        if(!dataFormatter.formatCellValue(row.getCell(0)).isEmpty()&&!dataFormatter.formatCellValue(row.getCell(3)).isEmpty()){
                                            Book book= new Book();
                                            book.setId(String.valueOf(dataFormatter.formatCellValue(row.getCell(0))));
                                            book.setTitle(dataFormatter.formatCellValue(row.getCell(3)));
                                            book.setGrade(dataFormatter.formatCellValue(row.getCell(1)));
                                            book.setSubject(dataFormatter.formatCellValue(row.getCell(2)));
                                            
                                            int bookQty=0;
                                            if(!dataFormatter.formatCellValue(row.getCell(4)).isEmpty()){//Qty
                                                bookQty=Integer.valueOf(dataFormatter.formatCellValue(row.getCell(4)));
                                            }
                                            book.setQty(bookQty);
                                            
                                            if(dataFormatter.formatCellValue(row.getCell(6)).isEmpty()){//Cost
                                                book.setCost(0);
                                            }else{
                                                book.setCost(Double.valueOf(dataFormatter.formatCellValue(row.getCell(6))));
                                            }
                                            
                                            if(dataFormatter.formatCellValue(row.getCell(5)).isEmpty()){
                                                book.setTotalQty(0);
                                            }else{
                                                book.setTotalQty(Integer.valueOf(dataFormatter.formatCellValue(row.getCell(5))));
                                            }
                                            
                                            DatabaseHelper.addBook(book);
                                            
                                            
                                            
                                            String employeeID= "Admin";
                                            int rcvIndex = 1;

                                            String id = UUID.randomUUID().toString();
                                            if(bookQty>0){

                                                Inventory inventory = new Inventory(id,book.getId(),bookQty,time,employeeID,rcvIndex);
                                                DatabaseHelper.addInventory(inventory);
                                            }

                                        }
					System.out.println();
				}
                            }
			}
			workbook.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
        
        public static List<Book> getBooksFromExce() {
            List<Book> books = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(new File(NAME));
			Workbook workbook = new XSSFWorkbook(file);
			DataFormatter dataFormatter = new DataFormatter();
			Iterator<Sheet> sheets = workbook.sheetIterator();
			while(sheets.hasNext()) {
				Sheet sh = sheets.next();
                            if(sh.getSheetName().equals("Sheet1")){
				System.out.println("Sheet name is "+sh.getSheetName());
				System.out.println("---------");
				Iterator<Row> iterator = sh.iterator();
                                String time = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss").format(LocalDateTime.now());
                                iterator.next();
				while(iterator.hasNext()) {
                                    
					Row row = iterator.next();
//                                        System.out.println("ID:"+dataFormatter.formatCellValue(row.getCell(0))+  "Grade:"+row.getCell(1)+ " Subject:"+row.getCell(2)+" Title:"+row.getCell(3)+" Qty:"+row.getCell(4)+" Total Qty:"+row.getCell(5)+
//                                                " Cost:"+row.getCell(6));
                                        if(!dataFormatter.formatCellValue(row.getCell(3)).isEmpty()){
                                            Book book= new Book();
                                            book.setId(String.valueOf(dataFormatter.formatCellValue(row.getCell(0))));
                                            book.setTitle(dataFormatter.formatCellValue(row.getCell(3)));
                                            book.setGrade(dataFormatter.formatCellValue(row.getCell(1)));
                                            book.setSubject(dataFormatter.formatCellValue(row.getCell(2)));
                                            
                                            int bookQty=0;
                                            if(!dataFormatter.formatCellValue(row.getCell(4)).isEmpty()){//Qty
                                                bookQty=Integer.valueOf(dataFormatter.formatCellValue(row.getCell(4)));
                                            }
                                            book.setQty(bookQty);
                                            
                                            if(dataFormatter.formatCellValue(row.getCell(6)).isEmpty()){//Cost
                                                book.setCost(0);
                                            }else{
                                                book.setCost(Double.valueOf(dataFormatter.formatCellValue(row.getCell(6))));
                                            }
                                            
                                            if(dataFormatter.formatCellValue(row.getCell(5)).isEmpty()){
                                                book.setTotalQty(0);
                                            }else{
                                                book.setTotalQty(Integer.valueOf(dataFormatter.formatCellValue(row.getCell(5))));
                                            }
                                            
                                           
                                            books.add(book);
                                        }
				}
                            }
			}
			workbook.close();
                        return books;
                }
		catch(IOException | NumberFormatException e) {
                    return new ArrayList<>();
		}

	}
        
        public static void createNewExcelFile(){
           // Create a blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook();

            // Create a sheet in the workbook
            XSSFSheet sheet = workbook.createSheet("Sheet1");

            // Create a header row
            Row headerRow = sheet.createRow(0);

            // Add column headers
            Cell cell = headerRow.createCell(0);
            cell.setCellValue("ISBN");

            cell = headerRow.createCell(1);
            cell.setCellValue("Grade");

            cell = headerRow.createCell(2);
            cell.setCellValue("Subject");
            
            cell = headerRow.createCell(3);
            cell.setCellValue("Title");
            
            cell = headerRow.createCell(4);
            cell.setCellValue("Qty");
            
            cell = headerRow.createCell(5);
            cell.setCellValue("Total Qty");
            
            cell = headerRow.createCell(6);
            cell.setCellValue("P. Indvidual");



            // Write the workbook to a file
            try {
                FileOutputStream outputStream = new FileOutputStream("Books.xlsx");
                workbook.write(outputStream);
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Open the Excel file with the default application
            try {
                Desktop.getDesktop().open(new File("Books.xlsx"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
}  