package domainapp.dom.mister.Provedor;
/**
 * 
 * @author jose
 * Clase para validar las opciones de ingreso
 */
public class RegexValidation {
	
	public static final class ValidaCuit {
		private ValidaCuit() {

		}
		public static final String CUIT = "[+]?[0-9]{2}+[-]+[0-9]{8}+[-]+[0-9]{1}";
	}
	public static final class ValidaCorreo {
		private ValidaCorreo() {

		}
		public static final String CORREO = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
											+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	}
}
