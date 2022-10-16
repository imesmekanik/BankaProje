package service;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import entity.Hesap;

public class RaporService {
	public void pdfYazdir(List<Hesap> hesaplar) throws FileNotFoundException, MalformedURLException {

		String path = "hesaplar.pdf";
		PdfWriter pdfWriter = new PdfWriter(path);
		PdfDocument pdfDocument = new PdfDocument(pdfWriter);

		pdfDocument.setDefaultPageSize(PageSize.A4);
		// float x = pdfDocument.getDefaultPageSize().getWidth() / 2;
		// float y = pdfDocument.getDefaultPageSize().getHeight() / 2;
		// System.out.println("x= " + x);
		// System.out.println("y= " + y);

		Document document = new Document(pdfDocument);
		float fourcol = 190f;

		float fourColumnWidth[] = { fourcol, fourcol, fourcol, fourcol };
		float fullWidth[] = { fourcol * 4 };

		Paragraph onesp = new Paragraph("\n");

		Border nb = new SolidBorder(Color.WHITE, 1, 0);

		document.add(new Paragraph("\n"));
		Border gb = new SolidBorder(Color.GRAY, 2);
		Table tableDivider = new Table(fullWidth);
		document.add(tableDivider.setBorder(gb));
		document.add(onesp);

		Table tableDivider2 = new Table(fullWidth);
		Border dgb = new DashedBorder(Color.GRAY, 0.5f);
		document.add(tableDivider2.setBorder(dgb));

		Paragraph producPara = new Paragraph("Hesaplar");

		document.add(producPara.setBold());
		Table threeColTable1 = new Table(fourColumnWidth);
		threeColTable1.setBackgroundColor(Color.BLACK, 0.7f);

		threeColTable1.addCell(new Cell().add("Hesap No").setBold().setFontColor(Color.WHITE).setBorder(nb));
		threeColTable1.addCell(new Cell().add("Hesap Adı").setBold().setFontColor(Color.WHITE)
				.setTextAlignment(TextAlignment.CENTER).setBorder(nb));
		threeColTable1.addCell(new Cell().add("Para Birimi").setBold().setFontColor(Color.WHITE)
				.setTextAlignment(TextAlignment.CENTER).setBorder(nb));
		threeColTable1.addCell(new Cell().add("Bakiye").setBold().setFontColor(Color.WHITE)
				.setTextAlignment(TextAlignment.RIGHT).setBorder(nb)).setMarginRight(15f);
		document.add(threeColTable1);

		Table threeColTable2 = new Table(fourColumnWidth);

		for (Hesap hesap : hesaplar) {

			threeColTable2.addCell(new Cell().add(hesap.getHesapNo() + "").setBorder(nb));
			threeColTable2.addCell(new Cell().add(String.valueOf(hesap.getHesapAdi()))
					.setTextAlignment(TextAlignment.CENTER).setBorder(nb));
			threeColTable2.addCell(
					new Cell().add(hesap.getHesapParaBirimi()).setTextAlignment(TextAlignment.RIGHT).setBorder(nb));
			threeColTable2.addCell(new Cell().add(String.valueOf(hesap.getBakiye()))
					.setTextAlignment(TextAlignment.RIGHT).setBorder(nb)).setMarginRight(15f);
		}
		document.add(threeColTable2.setMarginBottom(20f));

		Table threeColTable3 = new Table(fourColumnWidth);
		threeColTable3.addCell(new Cell().add("").setBorder(nb)).setMarginLeft(10f);

		document.add(threeColTable3);
		document.add(tableDivider2);

		document.close();
		System.out.println("pdf dosyasi olusturuldu.");

	}

}
