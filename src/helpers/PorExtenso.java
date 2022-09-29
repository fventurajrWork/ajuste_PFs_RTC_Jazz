package helpers;

public class PorExtenso {
	
//	public static void main(String[] args) {
//		PorExtenso pe = new PorExtenso();
//		String[] numeros = {"127", "120", "0,85", "1,03", "3,51" };
//		for(String numero : numeros)
//			System.out.printf("%s = %s%n", numero, pe.parseExtenso(numero));
//		
//	}

	public String parseExtenso(String numero) throws Exception{

		try {
			if (Numero.isInt(numero)) {
				return montaPfInteiro(numero) + "Inteiro(s)";
			}

			if (Numero.getInteiro(numero).equals("0")) {
				String fracionario = montaPfFracionario(Numero.getFracionario(numero)); 
				return  fracionario + "centésimo(s)";
			}
			
			String inteiro, fracionario;
			inteiro = montaPfInteiro(Numero.getInteiro(numero));
			fracionario = montaPfFracionario(Numero.getFracionario(numero)); 
			if ( fracionario != "00" )
				return  inteiro + " Inteiro(s) e " +  fracionario	+ "centésimo(s)";
			else
				return  inteiro + " Inteiro(s)";
			

		} catch (Exception e1) {
			throw new Exception("Falha na conversão");
		}		

	}

	private String montaPfFracionario(String numero) {
		Integer dezenas = Integer.parseInt(numero.substring(0, 1));
		Integer unidades = Integer.parseInt(numero.substring(1, 2));
		if(  dezenas == 1  ) {
			// de onze a dezenove
			if (unidades == 0 )
				return "Onze ";
			if (unidades == 1 )
				return "Onze ";
			if (unidades == 2 )
				return "Doze ";
			if (unidades == 3 )
				return "Treze ";
			if (unidades == 4 )
				return "Quatorze ";
			if (unidades == 5 )
				return "Quinze ";
			if (unidades == 6 )
				return "Dezesseis ";
			if (unidades == 7 )
				return "Dezessete ";
			if (unidades == 8 )
				return "Dezoito ";
			if (unidades == 9 )
				return "Dezenove ";
		} else {
			
			if ( dezenas == 2 ) {
				if ( unidades == 0 )
					return "Vinte";
				else
					return "Vinte e " + unidades(unidades.toString());
			} else 
			if ( dezenas == 3 ) {
				if ( unidades == 0 )
					return "Trinta";
				else
					return "Trinta e " + unidades(unidades.toString());
			} else
			if ( dezenas == 4 ) {
				if ( unidades == 0 )
					return "Quarenta";
				else
					return "Quarenta e " + unidades(unidades.toString());
			} else	
			if ( dezenas == 5 ) {
				if ( unidades == 0 )
					return "Cinquenta";
				else
					return "Cinquenta e " + unidades(unidades.toString());
			} else
			if ( dezenas == 6 ) {
				if ( unidades == 0 )
					return "Sessenta";
				else
					return "Sessenta e " + unidades(unidades.toString());
			} else		
			if ( dezenas == 7 ) {
				if ( unidades == 0 )
					return "Setenta";
				else
					return "Setenta e " + unidades(unidades.toString());
			} else
			if ( dezenas == 8 ) {
				if ( unidades == 0 )
					return "Oitenta";
				else
					return "Oitenta e " + unidades(unidades.toString());
			} else
			if ( dezenas == 9 ) {
				if ( unidades == 0 )
					return "Noventa";
				else
					return "Noventa e " + unidades(unidades.toString());
			};
		}
		return "";
			
	}

	private String montaPfInteiro(String inteiro) {
		int numCaracteres = inteiro.length();
		if (numCaracteres == 1)
			return unidades(inteiro);
		if (numCaracteres == 2) {
			String dezena = dezenas(inteiro.substring(0, 1));
			String unidade = unidades(inteiro.substring(1, 2));
			if (Integer.parseInt(inteiro) >= 20)
				return dezena + " e " + unidade;
			else if (Integer.parseInt(inteiro) < 10)
				return unidade;
			if (unidade == "Um ")
				return "Onze ";
			if (unidade == "Dois ")
				return "Doze ";
			if (unidade == "Três ")
				return "Treze ";
			if (unidade == "Quatro ")
				return "Quatorze ";
			if (unidade == "Cinco ")
				return "Quinze ";
			if (unidade == "Seis ")
				return "Dezesseis ";
			if (unidade == "Sete ")
				return "Dezessete ";
			if (unidade == "Oito ")
				return "Dezoito ";
			if (unidade == "Nove ")
				return "Dezenove ";
			return dezena;
		}
		if (numCaracteres == 3) {
			String centena = centenas(inteiro.substring(0, 1));
			String dezena = dezenas(inteiro.toString().substring(1, 2));
			String unidade = unidades(inteiro.substring(2, 3));
			// System.out.printf("%s %s %s", centena, dezena, unidade);
			if (Integer.parseInt(inteiro) >= 200)
				if (dezena != "Dez ")
					return centena + " e " + dezena + " e " + unidade;
				else {
					if (unidade == "Um ")
						return centena + " e Onze ";
					if (unidade == "Dois ")
						return centena + " e Doze ";
					if (unidade == "Três ")
						return centena + " e Treze ";
					if (unidade == "Quatro ")
						return centena + " e Quatorze ";
					if (unidade == "Cinco ")
						return centena + " e Quinze ";
					if (unidade == "Seis ")
						return centena + " e Dezesseis ";
					if (unidade == "Sete ")
						return centena + " e Dezessete ";
					if (unidade == "Oito ")
						return centena + " e Dezoito ";
					if (unidade == "Nove ")
						return centena + " e Dezenove ";
				}
			else
				return ("Cento e " + dezena + " e " + unidade).replace("e  e", "e ");
		}
		if (numCaracteres == 4) {
			String milhar = milhares(inteiro.substring(0, 1));
			String centena = centenas(inteiro.substring(1, 2));
			String dezena = dezenas(inteiro.substring(2, 3));
			String unidade = unidades(inteiro.substring(3, 4));
			return (milhar + " e " + centena + " e " + dezena + " e " + unidade).replace("  ", " ").replace("e e", "e");
		}
		return "";
	};

	private String unidades(String pedaco) {
		switch (pedaco) {
		case "1":
			return "Um ";
		case "2":
			return "Dois ";
		case "3":
			return "Três ";
		case "4":
			return "Quatro ";
		case "5":
			return "Cinco ";
		case "6":
			return "Seis ";
		case "7":
			return "Sete ";
		case "8":
			return "Oito ";
		case "9":
			return "Nove ";
		default:
			return "";
		}

	}

	private String dezenas(String pedaco) {
		switch (pedaco) {
		case "1":
			return "Dez ";
		case "2":
			return "Vinte ";
		case "3":
			return "Trinta ";
		case "4":
			return "Quarenta ";
		case "5":
			return "Cinquenta ";
		case "6":
			return "Sessenta ";
		case "7":
			return "Setenta ";
		case "8":
			return "Oitenta ";
		case "9":
			return "Noventa ";
		default:
			return "";

		}
	}

	private String centenas(String pedaco) {
		switch (pedaco) {
		case "1":
			return " Cem ";
		case "2":
			return " Duzentos ";
		case "3":
			return " Trezentos ";
		case "4":
			return " Quatrocentos ";
		case "5":
			return " Quinhentos ";
		case "6":
			return " Seiscentos ";
		case "7":
			return " Setencentos ";
		case "8":
			return " Oitocentos ";
		case "9":
			return " Novecentos ";
		default:
			return "";
		}
	}

	private String milhares(String pedaco) {
		switch (pedaco) {
		case "1":
			return "Um mil ";
		case "2":
			return "Dois mil ";
		case "3":
			return "Três mil ";
		case "4":
			return "Quatro mil ";
		case "5":
			return "Cinco mil ";
		case "6":
			return "Seis mil ";
		case "7":
			return "Sete mil ";
		case "8":
			return "Oito mil ";
		case "9":
			return "Nove mil ";
		default:
			return "";
		}
	}
}
