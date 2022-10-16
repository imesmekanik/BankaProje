package service;

import static diger.SabitVeriler.hesaplarFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.DolarHesabi;
import entity.EuroHesabi;
import entity.Hareket;
import entity.Hesap;
import entity.TLHesabi;

public class DosyaImportService {
	int index = 1;

	public List<Hesap> hesaplariOku(String fileName) throws FileNotFoundException {
		// dosyadaki satırlar obje listesine çevirilecek.
		List<Hesap> hesaplar = new ArrayList<Hesap>();
		File file = new File(fileName);
		if (file.exists()) {
			// hesaplar dosya kontrol ve testi icin eklenildi, tercihen kullanilabilir.
			// System.out.println("hesaplar bulundu");

		} else {
			// hesaplar dosya kontrol ve testi icin eklenildi, tercihen kullanilabilir.
			// System.out.println("hesaplar bulanamadı");
		}
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			String[] split = scanner.nextLine().split(";");
			hesaplar.add(convertToHesap(split));
		}
		scanner.close();
		return hesaplar;
	}

	public Hesap convertToHesap(String[] array) {
		if (array[2].equals("tl")) {
			Hesap hesap = new TLHesabi(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]));
			return hesap;
		} else if (array[2].equals("dolar")) {
			Hesap hesap = new DolarHesabi(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]));
			return hesap;
		} else if (array[2].equals("euro")) {
			Hesap hesap = new EuroHesabi(Integer.parseInt(array[0]), array[1], array[2], Double.parseDouble(array[3]));
			return hesap;
		}
		return null;
	}

	public List<Hareket> hareketleriOku(String fileName) throws FileNotFoundException {
		// dosyadaki satırlar obje listesine çevirilecek.
		List<Hareket> hareketler = new ArrayList<Hareket>();
		File file = new File(fileName);
		if (file.exists()) {
			// hareket dosyasi kontrolu ve testi icin eklendi, tercihen kullanilabilir.
			// System.out.println("hareketler bulundu");

		} else {
			// hareket dosyasi kontrolu ve testi icin eklendi, tercihen kullanilabilir.
			// System.out.println("hareketler bulanamadı");
		}
		Scanner scanner = new Scanner(file);
		scanner.nextLine();
		while (scanner.hasNextLine()) {
			String[] split = scanner.nextLine().split(";");
			hareketler.add(convertToHareket(split));
		}
		scanner.close();
		return hareketler;
	}

	public Hareket convertToHareket(String[] array) throws FileNotFoundException {
		List<Hesap> hesaplarTmp = hesaplariOku(hesaplarFile);
		for (int i = 0; i < hesaplarTmp.size(); i++) {
			for (int j = 0; j < hesaplarTmp.size(); j++) {
				if (hesaplarTmp.get(i).getHesapNo() == Integer.parseInt(array[0])
						&& hesaplarTmp.get(j).getHesapNo() == Integer.parseInt(array[1])) {
					Hareket hareket = new Hareket(index++, hesaplarTmp.get(i), hesaplarTmp.get(j),
							Double.parseDouble(array[2]));
					return hareket;
				}
			}

		}
		return null;
	}
}
