package domain;

public class Ajuste {
	
	private static float pfAjustado;
	public static String getPfAjustado(Integer PFs, Integer diasUteis) {
		pfAjustado = (PFs * diasUteis) / 31f;
		return String.format("%.2f", pfAjustado);
		
	}
	
	public static String getPfSuporte() {
		float pfSuporte = pfAjustado * 5 / 1000f;
		return String.format("%.2f", pfSuporte);
	}
	

}
