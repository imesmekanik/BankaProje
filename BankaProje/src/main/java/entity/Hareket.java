package entity;

public class Hareket {
	int id;
	private Hesap gonderenHesap;
	private Hesap aliciHesap;

	private Double tutar;

	public Hareket(int id, Hesap gonderenHesap, Hesap aliciHesap, Double tutar) {
		super();
		this.id = id;
		this.gonderenHesap = gonderenHesap;
		this.aliciHesap = aliciHesap;
		this.tutar = tutar;
	}

	public Hareket() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Hesap getGonderenHesap() {
		return gonderenHesap;
	}

	public void setGonderenHesap(Hesap gonderenHesap) {
		this.gonderenHesap = gonderenHesap;
	}

	public Hesap getAliciHesap() {
		return aliciHesap;
	}

	public void setAliciHesap(Hesap aliciHesap) {
		this.aliciHesap = aliciHesap;
	}

	public Double getTutar() {
		return tutar;
	}

	public void setTutar(Double tutar) {
		this.tutar = tutar;
	}

	@Override
	public String toString() {
		return "\n\nHareket [id= " + id + " Gonderen Hesap=" + gonderenHesap + "\nAlici Hesap=" + aliciHesap
				+ "\n tutar=" + tutar + "]";
	}

}
