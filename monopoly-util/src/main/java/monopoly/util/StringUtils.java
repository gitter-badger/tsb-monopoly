package monopoly.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * @author Herman Alonso Barrates Víquez
 *         http://www.codigofantasma.com/blog/implementar
 *         -encriptacion-md5-y-sha-en-java/
 */
public class StringUtils {

	// algoritmos
	public static String MD2 = "MD2";
	public static String MD5 = "MD5";
	public static String SHA1 = "SHA-1";
	public static String SHA256 = "SHA-256";
	public static String SHA384 = "SHA-384";
	public static String SHA512 = "SHA-512";
	private static String delimitador = "&-&-&";

	private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/***
	 * Convierte un arreglo de bytes a String usando valores hexadecimales
	 * 
	 * @param digest
	 *            arreglo de bytes a convertir
	 * @return String creado a partir de <code>digest</code>
	 */
	private static String toHexadecimal(byte[] digest) {
		String hash = "";
		for (byte aux : digest) {
			int b = aux & 0xff;
			if (Integer.toHexString(b).length() == 1)
				hash += "0";
			hash += Integer.toHexString(b);
		}
		return hash;
	}

	// http://www.codigofantasma.com/blog/implementar-encriptacion-md5-y-sha-en-java/
	/***
	 * Encripta un mensaje de texto mediante algoritmo de resumen de mensaje.
	 * 
	 * @param message
	 *            texto a encriptar
	 * @param algorithm
	 *            algoritmo de encriptacion, puede ser: MD2, MD5, SHA-1,
	 *            SHA-256, SHA-384, SHA-512
	 * @return mensaje encriptado
	 */
	public static String getStringMessageDigest(String message, String algorithm) {
		byte[] digest = null;
		byte[] buffer = message.getBytes();
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			messageDigest.reset();
			messageDigest.update(buffer);
			digest = messageDigest.digest();
		} catch (NoSuchAlgorithmException ex) {
			System.out.println("Error creando Digest");
		}
		return toHexadecimal(digest);
	}

	/**
	 * Encripta un password usando MD5
	 * 
	 * @param pass
	 *            El password no encriptado
	 * @return El password encriptado en MD5
	 */
	public static String encPass(String pass) {
		return StringUtils.getStringMessageDigest(pass, MD5);
	}

	/**
	 * Valida que el email sea válido
	 * 
	 * @param email
	 *            El email a validar
	 * @return true si el email es valido.
	 */
	// http://www.mkyong.com/regular-expressions/how-to-validate-email-address-with-regular-expression/
	public static boolean validateEmail(final String email) {
		Pattern pattern;
		Matcher matcher;

		pattern = Pattern.compile(EMAIL_PATTERN);

		matcher = pattern.matcher(email);
		return matcher.matches();

	}

	/**
	 * Verifica que el nombre de usuario sea válido. El nombre de usuario debe
	 * tener entre 3 y 15 caracteres y los caracteres permitidos son
	 * <code>" a-z 0-9 _ - "</code>
	 * 
	 * @param username
	 *            El nombre de usuario a validar
	 * @return true si es correcto.
	 */
	public static boolean validateUsername(final String username) {
		Pattern pattern;
		Matcher matcher;

		pattern = Pattern.compile(USERNAME_PATTERN);

		matcher = pattern.matcher(username);
		return matcher.matches();

	}

	/**
	 * 
	 * @param mensajeContenido
	 * @return
	 */
	@SuppressWarnings("resource")
	public static ArrayList<String> analizarCadena(String mensajeContenido) {
		ArrayList<String> tokens = new ArrayList<String>();
		Scanner tokenize = new Scanner(mensajeContenido);
		tokenize.useDelimiter(delimitador);
		while (tokenize.hasNext()) {
			tokens.add(tokenize.next());
		}
		return tokens;
	}

	/**
	 * Devuelve la FECHA actual en el formato {@code "dd/MM/yy HH:mm"}
	 * 
	 * @return La fecha actual
	 */
	private final static DateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yy HH:mm");

	public static String getFechaActual() {
		Calendar calendar = GregorianCalendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	/**
	 * Devuelve la HORA actual en el formato {@code "HH:mm"}
	 * 
	 * @return La hora actual
	 */
	private final static DateFormat timeFormat = new SimpleDateFormat("HH:mm");

	public static String getHoraActual() {
		Calendar calendar = GregorianCalendar.getInstance();
		return timeFormat.format(calendar.getTime());
	}

	private final static DecimalFormat decimalFormat = new DecimalFormat(
			"#,###,###,##0' €'");
	
	public static DecimalFormat getFormatoDecimal(){
		return decimalFormat;
	}

	/**
	 * Método para convertir un entero en moneda
	 *
	 * @param monto
	 *            monto a convertir en moneda
	 * @return devuelve el monto convertido en euro.
	 */
	public static String formatearAMoneda(int monto) {
		return decimalFormat.format(monto);
	}

	/**
	 * Verifica si un String es {@code null} o está vacía.
	 * 
	 * @param str
	 *            El String
	 * @return true si es null o está vacía
	 */
	public static boolean IsNullOrEmpty(String str) {
		if (str == null || str.trim().isEmpty())
			return true;
		return false;
	}

}
