package helpers;

public class Numero {
	String numero;

	public void setNumero(String numero) {
		this.numero = numero;

	}

	public static boolean isFloat(String numero) {
		if (numero.indexOf(',') != -1)
			return true;
		return false;
	}

	public static boolean isInt(String numero) {
		return (!isFloat(numero));
	}

	public static String getInteiro(String numero) throws Exception {
		String resultado;
		try {
			// if ( isInt(numero) )
			// return numero;
			// else
			resultado = numero.split(",")[0];
			return resultado;
		} catch (Exception e) {
			throw new Exception("número inteiro " + numero + " inválido ");
		}

	}

	public static String getFracionario(String numero) throws Exception {
		// if ( isInt(numero) )
		// throw new Exception("número " + numero + " não tem parte fracionária");
		try {
			String fracionario = numero.split(",")[1];
			return fracionario;
		} catch (Exception e) {
			throw new Exception("número fracionário " + numero + " inválido ");
		}
	}

	public static void main(String[] args) {

		String[] mocs = { "1", "10", "15", "20", "25", "100", "2,01", "2,10", "3,15", "21,40", "18,21", "456,56" };
		try {
			// for(String moc : mocs) {
			// System.out.printf("parte inteira de %s é %s%n", moc, getInteiro(moc));
			//
			// }
			for (String moc : mocs) {
				System.out.printf("parte fracionária de %s é %s%n", moc, getFracionario(moc));

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
