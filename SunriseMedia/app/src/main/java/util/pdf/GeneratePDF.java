/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util.pdf;
import Database.util.SearchHelper;
import boooks.objects.Book;
import boooks.objects.SaleItem;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfAction;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;
import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;
import org.apache.poi.xddf.usermodel.text.TextAlignment;


/**
 *
 * @author mbaiu
 */
public class GeneratePDF {
    
    public static void createInvoicePDF(List<SaleItem> list) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("ggpdf.pdf"));
            document.open();
            if(list.size()>0){
                Paragraph paragraph = new Paragraph("Sunrise International Schools"); 
                paragraph.setFont(FontFactory.getFont(FontFactory.COURIER, 15.0f));
                document.add(paragraph);
                document.add(new Paragraph("Purchase #: "+list.get(0).getPurchaseID()));
                document.add(new Paragraph("Invoice #: "+list.get(0).getInvoiceID()));
                document.add(new Paragraph("Time: "+list.get(0).getTime()));

                
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                PdfPTable table = new PdfPTable(4);
                table.setWidths(new int[]{20,50,75,20});


            // t.setBorderColor(BaseColor.GRAY);
            // t.setPadding(4);
            // t.setSpacing(4);
            // t.setBorderWidth(1);

                PdfPCell c1 = new PdfPCell(new Phrase("#"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
                c1 = new PdfPCell(new Phrase("Book ID"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Title"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);

                c1 = new PdfPCell(new Phrase("Qty"));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(c1);
                
//                c1 = new PdfPCell(new Phrase("Price"));
//                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(c1);
                
                
                int count=1;
                int totalQty=0;
                table.setHeaderRows(1);
                for(SaleItem item :list){
                    table.addCell(String.valueOf(count++));
                    table.addCell(item.getBookID());
                    String title=SearchHelper.getBookByID(item.getBookID()).getTitle();
                    table.addCell(title);
                    table.addCell(String.valueOf(item.getQty()));
                    totalQty+=item.getQty();
//                    table.addCell(String.valueOf(item.getPrice()));
                }


                document.add(table);
                document.add(new Paragraph(" "));
                document.add(new Paragraph(" "));
                document.add(new Paragraph("Total Qty: "+totalQty));

            }
            
            PdfAction action = new PdfAction(PdfAction.PRINTDIALOG);
            writer.setOpenAction(action);
            
            document.close();
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Desktop.getDesktop().open(new File("ggpdf.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createPurchasePDF(SortedMap<String, List<SaleItem>> map) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("ggpdf.pdf"));
            document.open();
            if(map.size()>0){
                Paragraph paragraph = new Paragraph("Sunrise International Schools"); 
                paragraph.setFont(FontFactory.getFont(FontFactory.COURIER, 15.0f));
                document.add(paragraph);
                document.add(new Paragraph("Purchase #: "+map.get(map.firstKey()).get(0).getPurchaseID()));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph(" "));
                int totalQty=0;
                for (List<SaleItem> list : map.values()){
                    document.add(new Chunk(new DottedLineSeparator())); 
                    document.add(new Paragraph("Invoice #: "+list.get(0).getInvoiceID()));
                    document.add(new Paragraph("Time: "+list.get(0).getTime()));
                    document.add(new Paragraph(" "));

                    PdfPTable table = new PdfPTable(4);
                    table.setWidths(new int[]{20,50,75,20});


                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

                    PdfPCell c1 = new PdfPCell(new Phrase("#"));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);

                    c1 = new PdfPCell(new Phrase("Book ID"));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);

                    c1 = new PdfPCell(new Phrase("Title"));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);

                    c1 = new PdfPCell(new Phrase("Qty"));
                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(c1);

    //                c1 = new PdfPCell(new Phrase("Price"));
    //                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
    //                table.addCell(c1);


                    int count=1;
                    int invoiceQty=0;
                    table.setHeaderRows(1);
                    for(SaleItem item :list){
                        table.addCell(String.valueOf(count++));
                        table.addCell(item.getBookID());
                        String title=SearchHelper.getBookByID(item.getBookID()).getTitle();
                        table.addCell(title);
                        table.addCell(String.valueOf(item.getQty()));
                        invoiceQty+=item.getQty();
    //                    table.addCell(String.valueOf(item.getPrice()));
                    }
                    totalQty+=invoiceQty;

                    document.add(table);
                    document.add(new Paragraph("Invoice Qty: "+invoiceQty));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph(" "));
                    document.add(new Chunk(new DottedLineSeparator())); 
                }
                Paragraph totalQtyParagraph = new Paragraph("Total Qty: "+totalQty);
                totalQtyParagraph.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
                document.add(totalQtyParagraph);
                

            }
            
            PdfAction action = new PdfAction(PdfAction.PRINTDIALOG);
            writer.setOpenAction(action);
            
            document.close();
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Desktop.getDesktop().open(new File("ggpdf.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createPurchaseHistoryPDF(SortedMap<String, SortedMap<String,List<SaleItem>>> map) {
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document,new FileOutputStream("ggpdf.pdf"));
            document.open();
            if(map.size()>0){
                Paragraph paragraph = new Paragraph("Sunrise International Schools"); 
                paragraph.setFont(FontFactory.getFont(FontFactory.COURIER, 15.0f));
                document.add(paragraph);
                document.add(new Paragraph("Phone Number: "+ map.get(map.firstKey()).get(map.get(map.firstKey()).firstKey()).get(0).getPurchaseID()));
                    document.add(new Paragraph(" "));
                    document.add(new Paragraph(" "));
                int totalQty=0;
                
                
                for (String key1 : map.keySet()) { //for each grade in map
                    document.add(new Paragraph("Grade: "+key1));
                    document.add(new Paragraph(" "));
                    SortedMap<String, List<SaleItem>> innerMap = map.get(key1); //invoices
                    for (String key2 : innerMap.keySet()) {
                        List<SaleItem> itemList = innerMap.get(key2);
                        
                        document.add(new Chunk(new DottedLineSeparator())); 
                        document.add(new Paragraph("Invoice #: "+key2));
                        document.add(new Paragraph("Time: "+itemList.get(0).getTime()));
                        document.add(new Paragraph(" "));

                        PdfPTable table = new PdfPTable(5);
                        table.setWidthPercentage(100);
                        float[] columnWidths = {0.5f, 1.75f, 5.75f,1.0f,0.5f};
                        table.setWidths(columnWidths);
                    
                        PdfPCell c1 = new PdfPCell(new Phrase("#"));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);

                        c1 = new PdfPCell(new Phrase("Book ID"));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);

                        c1 = new PdfPCell(new Phrase("Title"));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);

                        c1 = new PdfPCell(new Phrase("Price"));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);
                        
                        c1 = new PdfPCell(new Phrase("Qty"));
                        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(c1);
                        
                        int count=1;
                        int invoiceQty=0;
                        table.setHeaderRows(1);
                        for(SaleItem item :itemList){
                            c1 = new PdfPCell(new Phrase(String.valueOf(count++)));
                            c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                            table.addCell(c1);
//                            table.addCell(String.valueOf(count++));
                            table.addCell(item.getBookID());
                            String title=SearchHelper.getBookByID(item.getBookID()).getTitle();
                            table.addCell(title);
                            table.addCell(String.valueOf(item.getPrice()));
                            table.addCell(String.valueOf(item.getQty()));
                            invoiceQty+=item.getQty();
                        //                    table.addCell(String.valueOf(item.getPrice()));
                        }
                        totalQty+=invoiceQty;

                        document.add(table);
                        document.add(new Paragraph("Invoice Qty: "+invoiceQty));
                        document.add(new Paragraph(" "));
                        document.add(new Paragraph(" "));
                        document.add(new Chunk(new DottedLineSeparator())); 
                        
                        
//                        totalQty+=itemList.size();
                    }
                }
                
                
//                for (List<SaleItem> list : map.values()){
//                    document.add(new Chunk(new DottedLineSeparator())); 
//                    document.add(new Paragraph("Invoice #: "+list.get(0).getInvoiceID()));
//                    document.add(new Paragraph("Time: "+list.get(0).getTime()));
//                    document.add(new Paragraph(" "));
//
//                    PdfPTable table = new PdfPTable(4);
//                    table.setWidthPercentage(100);
//                    float[] columnWidths = {1.75f, 1.5f, 6.1f};
//                    table.setWidths(columnWidths);


                // t.setBorderColor(BaseColor.GRAY);
                // t.setPadding(4);
                // t.setSpacing(4);
                // t.setBorderWidth(1);

//                    PdfPCell c1 = new PdfPCell(new Phrase("#"));
//                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    table.addCell(c1);
//
//                    c1 = new PdfPCell(new Phrase("Book ID"));
//                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    table.addCell(c1);
//
//                    c1 = new PdfPCell(new Phrase("Title"));
//                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    table.addCell(c1);
//
//                    c1 = new PdfPCell(new Phrase("Qty"));
//                    c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//                    table.addCell(c1);
//
//    //                c1 = new PdfPCell(new Phrase("Price"));
//    //                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
//    //                table.addCell(c1);
//
//
//                    int count=1;
//                    int invoiceQty=0;
//                    table.setHeaderRows(1);
//                    for(SaleItem item :list){
//                        table.addCell(String.valueOf(count++));
//                        table.addCell(item.getBookID());
//                        String title=SearchHelper.getBookByID(item.getBookID()).getTitle();
//                        table.addCell(title);
//                        table.addCell(String.valueOf(item.getQty()));
//                        invoiceQty+=item.getQty();
//    //                    table.addCell(String.valueOf(item.getPrice()));
//                    }
//                    totalQty+=invoiceQty;
//
//                    document.add(table);
//                    document.add(new Paragraph("Invoice Qty: "+invoiceQty));
//                    document.add(new Paragraph(" "));
//                    document.add(new Paragraph(" "));
//                    document.add(new Chunk(new DottedLineSeparator())); 
//                }
//                Paragraph totalQtyParagraph = new Paragraph("Total Qty: "+totalQty);
//                totalQtyParagraph.setAlignment(com.itextpdf.text.Element.ALIGN_RIGHT);
//                document.add(totalQtyParagraph);
                

            }
            
            PdfAction action = new PdfAction(PdfAction.PRINTDIALOG);
            writer.setOpenAction(action);
            
            document.close();
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Desktop.getDesktop().open(new File("ggpdf.pdf"));
        } catch (IOException ex) {
            Logger.getLogger(GeneratePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void createBarcodesPdf(List<Book> books){
        try {
            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("barcode.pdf"));
            document.open();
            PdfPTable table = new PdfPTable(3);
            table.setWidthPercentage(100);
            float[] columnWidths = {1.75f, 1.5f, 6.1f};
            table.setWidths(columnWidths);
            for (Book book : books) {
                BufferedImage image = BarcodeGenerator.creadeBarCode(book.getId());
                PdfPCell cell = new PdfPCell();
                Image pdfImage = Image.getInstance(image, null);
                cell.addElement(pdfImage);
                table.addCell(cell);
                PdfPCell c1 = new PdfPCell(new Phrase(book.getId(),new Font(Font.FontFamily.TIMES_ROMAN, 10)));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(c1);
                c1 = new PdfPCell(new Phrase(book.getTitle(),new Font(Font.FontFamily.TIMES_ROMAN, 10)));
                c1.setHorizontalAlignment(Element.ALIGN_CENTER);
                c1.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                c1.set(66.67f); // set the width of the cell to 2/3 of the available width (100/3 * 2)
//                c1.setColspan(2); // set the colspan to 2 to span two columns

                table.addCell(c1);
            }
            document.add(table);
            PdfAction action = new PdfAction(PdfAction.PRINTDIALOG);
            writer.setOpenAction(action);
            File myFile = new File("barcode.pdf");
            Desktop.getDesktop().open(myFile);
            
//            Process p = Runtime
//			   .getRuntime()
//			   .exec("rundll32 url.dll,FileProtocolHandler barcode.pdf");
//			p.waitFor();
            
            document.close();

            
            
            // Open the PDF file once it is created
//            Desktop.getDesktop().browse(new URL("barcode.pdf"));
        } catch (IOException | DocumentException ex) {
            ex.printStackTrace();
        }
    }
}
