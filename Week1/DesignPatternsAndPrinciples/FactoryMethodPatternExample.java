package DesignPatternsAndPrinciples;


abstract class Document {
 public abstract void open();
 public abstract void save();
}


class WordDocument extends Document {
 @Override
 public void open() {
     System.out.println("Opening Word document...");
 }

 @Override
 public void save() {
     System.out.println("Saving Word document...");
 }
}

class PdfDocument extends Document {
 @Override
 public void open() {
     System.out.println("Opening PDF document...");
 }

 @Override
 public void save() {
     System.out.println("Saving PDF document...");
 }
}

class ExcelDocument extends Document {
 @Override
 public void open() {
     System.out.println("Opening Excel document...");
 }

 @Override
 public void save() {
     System.out.println("Saving Excel document...");
 }
}


abstract class DocumentFactory {
 public abstract Document createDocument();
}


class WordDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new WordDocument();
 }
}

class PdfDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new PdfDocument();
 }
}

class ExcelDocumentFactory extends DocumentFactory {
 @Override
 public Document createDocument() {
     return new ExcelDocument();
 }
}


public class FactoryMethodPatternExample {
 public static void main(String[] args) {
     
     DocumentFactory wordFactory = new WordDocumentFactory();
     DocumentFactory pdfFactory = new PdfDocumentFactory();
     DocumentFactory excelFactory = new ExcelDocumentFactory();

     
     Document wordDoc = wordFactory.createDocument();
     Document pdfDoc = pdfFactory.createDocument();
     Document excelDoc = excelFactory.createDocument();

     
     wordDoc.open();
     wordDoc.save();

     pdfDoc.open();
     pdfDoc.save();

     excelDoc.open();
     excelDoc.save();
 }
}

