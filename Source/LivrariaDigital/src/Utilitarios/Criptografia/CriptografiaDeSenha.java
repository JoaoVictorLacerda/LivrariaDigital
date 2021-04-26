package Utilitarios.Criptografia;

public class CriptografiaDeSenha {
	private static String[] alfabeto= {
			"ú","Ú","y","r","j","k"," ","f",
			"o","q","a","h","v","ç","p","b",
			"g","s","m","d","t","z","c","i",
			"l","u","n","e","x","w","A","B",
			"C","D","E","F","G","H","I","J",
			"K","L","M","N","O","P","Q","R",
			"S","T","U","V","W","X","Y","Z",
			"Ç",",",".",";","?",":","ã","é",
			"à","á","õ","ó","ê","ô","â","Ã",
			"É","À","Á","Õ","Ó","Ê","Ô","Â",
			"1","2","3","4","5","6","7","8",
			"9","0","+","-","/","\\","*","$",
			"!","]","[","(",")","{","}",
			"=","_","Ç","\n","í","Í","#"
	};
	private static  StringBuilder contador= new StringBuilder();

	public String[] getAlfabeto() {
		return alfabeto;
	}

	public static String criptografia(String senha) {
		 String[] codigosCriptografia = {
				"cxr89,","fhH52,","3fgg7,","0829g,","5jfb2,","gca7d,","z1zca,","12cc9,",
				"aa5bc,","0820t,","1137g,","5jf4c,","3fg21,","z1zbz,","08291,","2448g,",
				"12ct1,","61bgg,","g5582,","12ca9,","61bt4,","8tz0g,","244cd,","5jfa0,",
				"gcaa3,","6zc2f,","aa5d4,","12cd6,","3fg56,","om3l4,","z2pla,","cac31,",
				"bi4c0,","hig98,","77tyx,","fuh76,","0pp61,","iuio9,","it552,","tig2a,",
				"01009,","j0a32,","m009g,","nha55,","iHbH7,","gg3rs,","b2b34,","9jgyt,",
				"op5H8,","x1c47,","189hi,","omlH7,","ad087,","ll282,","00llH,","c475a,",
				"k2bbc,","a35e9,","a3528,","04f74,","04gff,","0094g,","00920,","ef7d9,",
				"ef7e0,","gc8b0,","c2c51,","c2c47,","c2c91,","0c368,","6g7gg,","m4175,",
				"cop32,","32pco,","H40i9,","ccl22,","om675,","tjk82,","ph908,","eli56,",
				"29183,","292d0,","53gd1,","53gcg,","95767,","958c2,","958g3,","e47bf,",
				"c14e3,","c1421,","c15ed,","c15g8,","g6e4b,","g7wyx,","g6e4f,","g6e90,",
				"a784c,","bag58,","ba1ba,","2f149,","64b01,","64cg0,","64dfa,",
				"887bc,","abtur,","ciub4,","enop9,","i7858,","cac67,","ff650,"
		};
		contador.setLength(0);
		String[] lista =senha.split("");
		for (String s : lista) {
			for (int j = 0; j < alfabeto.length; j++) {
				if (s.equals(alfabeto[j])) {
					contador.append(codigosCriptografia[j]);
				}
			}

		}
		return contador.toString();
	}
	
	public static String descriptografia(String senha) {
		String[] codigoDescriptografia = {
				"cxr89","fhH52","3fgg7","0829g","5jfb2","gca7d","z1zca","12cc9",
                "aa5bc","0820t","1137g","5jf4c","3fg21","z1zbz","08291","2448g",
                "12ct1","61bgg","g5582","12ca9","61bt4","8tz0g","244cd","5jfa0",
                "gcaa3","6zc2f","aa5d4","12cd6","3fg56","om3l4","z2pla","cac31",
                "bi4c0","hig98","77tyx","fuh76","0pp61","iuio9","it552","tig2a",
                "01009","j0a32","m009g","nha55","iHbH7","gg3rs","b2b34","9jgyt",
                "op5H8","x1c47","189hi","omlH7","ad087","ll282","00llH","c475a",
                "k2bbc","a35e9","a3528","04f74","04gff","0094g","00920","ef7d9",
                "ef7e0","gc8b0","c2c51","c2c47","c2c91","0c368","6g7gg","m4175",
                "cop32","32pco","H40i9","ccl22","om675","tjk82","ph908","eli56",
                "29183","292d0","53gd1","53gcg","95767","958c2","958g3","e47bf",
                "c14e3","c1421","c15ed","c15g8","g6e4b","g7wyx","g6e4f","g6e90",
                "a784c","bag58","ba1ba","2f149","64b01","64cg0","64dfa",
                "887bc","abtur","ciub4","enop9","i7858","cac67","ff650"
		};
		contador.setLength(0);
		String[] lista =senha.split(",");
		for (String s : lista) {
			for (int j = 0; j < codigoDescriptografia.length; j++) {
				if (codigoDescriptografia[j].equals(s)) {
					contador.append(alfabeto[j]);
				}
			}

		}
		return contador.toString();
	}
}
