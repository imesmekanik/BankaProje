package service;

import static diger.SabitVeriler.dolarTlKur;
import static diger.SabitVeriler.euroDolarKur;
import static diger.SabitVeriler.euroTlKur;

import java.util.List;

import entity.Hareket;
import entity.Hesap;

public class HesaplaService {
	public List<Hesap> hesaplariDoldurveBakiyeHesapla(List<Hesap> hesaplar, List<Hareket> hareketler) {
		for (int i = 0; i < hesaplar.size(); i++) {
			for (int j = 0; j < hareketler.size(); j++) {
				if (hesaplar.get(i).getHesapNo() == hareketler.get(j).getGonderenHesap().getHesapNo()) {
					if (hareketler.get(j).getGonderenHesap().getBakiye() < hareketler.get(j).getTutar()) {
						// System.out.println("Yetersiz bakiye, islem gerceklestirilemedi.");
					} else {
						hesaplar.get(i).setBakiye(
								hareketler.get(j).getGonderenHesap().getBakiye() - hareketler.get(j).getTutar());
					}
				}

				if (hesaplar.get(i).getHesapNo() == hareketler.get(j).getAliciHesap().getHesapNo()) {

					if (hareketler.get(j).getGonderenHesap().getBakiye() < hareketler.get(j).getTutar()) {
						// System.out.println("Yetersiz bakiye, islem gerceklestirilemedi.");
					} else {
						if (hesaplar.get(i).getHesapParaBirimi().equals("tl")) {
							if (hareketler.get(j).getGonderenHesap().getHesapParaBirimi().equals("dolar")) {
								hesaplar.get(i).setBakiye(hareketler.get(j).getAliciHesap().getBakiye()
										+ (hareketler.get(j).getTutar() * dolarTlKur));
							} else if (hareketler.get(j).getGonderenHesap().getHesapParaBirimi().equals("dolar")) {
								hesaplar.get(i).setBakiye(hareketler.get(j).getAliciHesap().getBakiye()
										+ (hareketler.get(j).getTutar() * euroTlKur));
							} else {
								hesaplar.get(i).setBakiye(
										hareketler.get(j).getAliciHesap().getBakiye() + (hareketler.get(j).getTutar()));
							}
						} else if (hesaplar.get(i).getHesapParaBirimi().equals("dolar")) {
							if (hareketler.get(j).getGonderenHesap().getHesapParaBirimi().equals("tl")) {
								hesaplar.get(i).setBakiye(hareketler.get(j).getAliciHesap().getBakiye()
										+ (hareketler.get(j).getTutar() * (1 / dolarTlKur)));
							} else if (hareketler.get(j).getGonderenHesap().getHesapParaBirimi().equals("euro")) {
								hesaplar.get(i).setBakiye(hareketler.get(j).getAliciHesap().getBakiye()
										+ (hareketler.get(j).getTutar() * (euroDolarKur)));
							} else {
								hesaplar.get(i).setBakiye(
										hareketler.get(j).getAliciHesap().getBakiye() + (hareketler.get(j).getTutar()));
							}
						} else if (hesaplar.get(i).getHesapParaBirimi().equals("euro")) {
							if (hareketler.get(j).getGonderenHesap().getHesapParaBirimi().equals("tl")) {
								hesaplar.get(i).setBakiye(hareketler.get(j).getAliciHesap().getBakiye()
										+ (hareketler.get(j).getTutar() * (1 / euroTlKur)));
							} else if (hareketler.get(j).getGonderenHesap().getHesapParaBirimi().equals("dolar")) {
								hesaplar.get(i).setBakiye(hareketler.get(j).getAliciHesap().getBakiye()
										+ (hareketler.get(j).getTutar() * (1 / euroDolarKur)));
							} else {
								hesaplar.get(i).setBakiye(
										hareketler.get(j).getAliciHesap().getBakiye() + (hareketler.get(j).getTutar()));
							}
						}

					}
				}
			}
		}

		return hesaplar;
	}

}
