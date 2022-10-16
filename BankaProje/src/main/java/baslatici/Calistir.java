package baslatici;

import static diger.SabitVeriler.hareketlerFile;
import static diger.SabitVeriler.hesaplarFile;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.List;

import entity.Hesap;
import service.DosyaImportService;
import service.HesaplaService;
import service.RaporService;

public class Calistir {

	public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
		System.out.println("Test");
		DosyaImportService dosyaImportService = new DosyaImportService();

		// System.out.println(dosyaImportService.hesaplariOku(hesaplarFile));
		// System.out.println(dosyaImportService.hareketleriOku(hareketlerFile));

		System.out.println("**************************************************************\n\n");

		HesaplaService hesaplaService = new HesaplaService();
		List<Hesap> hesaplar = hesaplaService.hesaplariDoldurveBakiyeHesapla(
				dosyaImportService.hesaplariOku(hesaplarFile), dosyaImportService.hareketleriOku(hareketlerFile));

		System.out.println("**************************************************************");
		System.out.println("***********Transferler Sonrasi Hesaplar***********************\n\n");
		System.out.println(hesaplar);

		RaporService raporService = new RaporService();

		raporService.pdfYazdir(hesaplar);
	}
}
