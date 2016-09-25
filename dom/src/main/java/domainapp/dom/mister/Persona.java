package domainapp.dom.mister;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

import org.apache.isis.applib.annotation.MemberOrder;
@PersistenceCapable
public class Persona {
	
	// {{ Nombre (property)
			private String nombre;

			@Persistent
			@MemberOrder(sequence = "1")
			@javax.jdo.annotations.Column(allowsNull="false")
			public String getNombre() {
				return nombre;
			}

			public void setNombre(final String nombre) {
				this.nombre = nombre;
			}
			// }}
			
			// {{ Apellido (property)
			private String apellido;

			@Persistent
			@MemberOrder(sequence = "1")
			@javax.jdo.annotations.Column(allowsNull="false")
			public String getApellido() {
				return apellido;
			}

			public void setApellido(final String apellido) {
				this.apellido = apellido;
			}
			// }}



		// {{ Domicilio (property)
		private String domicilio;

		@Persistent
		@MemberOrder(sequence = "1")
		@javax.jdo.annotations.Column(allowsNull="false")
		public String getDomicilio() {
			return domicilio;
		}

		public void setDomicilio(final String domicilio) {
			this.domicilio = domicilio;
		}
		// }}
		
		// {{ Telefono(property)
		private int telefono;

		@Persistent
		@MemberOrder(sequence = "1")
		@javax.jdo.annotations.Column(allowsNull="false")
		public int getTelefono() {
			return telefono;
		}

		public void setTelefono(final int telefono) {
			this.telefono = telefono;
		}
		// }}


		// {{ CorreoElectronico (property)
				private String correoelectronico;

				@Persistent
				@MemberOrder(sequence = "1")
				@javax.jdo.annotations.Column(allowsNull="false")
				public String getCorreoelectronico() {
					return correoelectronico;
				}

				public void setCorreoelectronico(final String correoelectronico) {
					this.correoelectronico = correoelectronico;
				}
				// }}
				
				// {{ Dni(property)
				private int dni;

				@Persistent
				@MemberOrder(sequence = "1")
				@javax.jdo.annotations.Column(allowsNull="false")
				public int getDni() {
					return dni;
				}

				public void setDni(final int dni) {
					this.dni = dni;
				}
				// }}


}
