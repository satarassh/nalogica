import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.CMYKColor;
import com.itextpdf.text.pdf.PdfWriter;


// http://www.ibm.com/developerworks/library/os-javapdf/index.html#download
public class TestPdf {
  public static void main(String[] args) {
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("test.pdf"));
			
			document.open();
			
			Anchor anchorTarget = new Anchor("Prva stran dokumenta.");
		    anchorTarget.setName("BackToTop");
		    Paragraph paragraph1 = new Paragraph();

		    paragraph1.setSpacingBefore(50);

		    paragraph1.add(anchorTarget);
		    document.add(paragraph1);
		    
		    for(int i=0; i<100; i++) {
			    String tekst = "Vec teksta, z razlicno barvo in tako naprej\nNova vrstica.";
			    document.add(new Paragraph(tekst, FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0))));
		    }
		    
		    document.close();
		} catch (FileNotFoundException | DocumentException e) {}
	}
}
