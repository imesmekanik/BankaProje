package entity;

public abstract class Hesap {
	private Integer hesapNo;
	private String hesapAdi;
	private String hesapParaBirimi;
	private Double bakiye;
	// List<Hareket> gelenGidenHareketler;

	// public abstract void bakiyeHesapla();

	public Hesap(Integer hesapNo, String hesapAdi, String hesapParaBirimi, Double bakiye) {
		super();
		this.hesapNo = hesapNo;
		this.hesapAdi = hesapAdi;
		this.hesapParaBirimi = hesapParaBirimi;
		this.bakiye = bakiye;
	}

	public Hesap() {

	}

	public Integer getHesapNo() {
		return hesapNo;
	}

	public void setHesapNo(Integer hesapNo) {
		this.hesapNo = hesapNo;
	}

	public String getHesapAdi() {
		return hesapAdi;
	}

	public void setHesapAdi(String hesapAdi) {
		this.hesapAdi = hesapAdi;
	}

	public String getHesapParaBirimi() {
		return hesapParaBirimi;
	}

	public void setHesapParaBirimi(String hesapParaBirimi) {
		this.hesapParaBirimi = hesapParaBirimi;
	}

	public Double getBakiye() {
		return bakiye;
	}

	public void setBakiye(Double bakiye) {
		this.bakiye = bakiye;
	}

	@Override
	public String toString() {
		return "\nHesap [hesapNo=" + hesapNo + ", hesapAdi=" + hesapAdi + ", hesapParaBirimi=" + hesapParaBirimi
				+ ", bakiye=" + bakiye + "]";
	}

}
