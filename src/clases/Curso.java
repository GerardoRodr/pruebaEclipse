package clases;

public class Curso {
	//Atributos
		int codCurso, ciclo, creditos,horas;
		String asignatura;
		//cONSTRUCTOR
		public Curso(int codCurs, String Asignatura, int Ciclo, int Credito, int Hrs) {
			codCurso = codCurs;
			ciclo=Ciclo;
			creditos=Credito;
			horas=Hrs;
			asignatura = Asignatura;
		}
		
		public int getCodCurso() {
			return codCurso;
		}
		public void setCodCurso(int codCurso) {
			this.codCurso = codCurso;
		}
		public int getCiclo() {
			return ciclo;
		}
		public void setCiclo(int ciclo) {
			this.ciclo = ciclo;
		}
		public int getCreditos() {
			return creditos;
		}
		public void setCreditos(int creditos) {
			this.creditos = creditos;
		}
		public int getHoras() {
			return horas;
		}
		public void setHoras(int horas) {
			this.horas = horas;
		}
		public String getAsignatura() {
			return asignatura;
		}
		public void setAsignatura(String asignatura) {
			this.asignatura = asignatura;
		}
		
		public String Ciclo(int numero) {
			String ciclo = "";	
			switch (numero) {
				case 0:
					ciclo ="Primero";
					break;
				case 1:
					ciclo ="Segundo";
					break;
				case 2:
					ciclo = "Tercero";
					break;
				case 3:
					ciclo = "Cuarto";
					break;
				case 4:
					ciclo = "Quinto";
					break;
				case 5:
					ciclo = "Sexto";
					break;
			}

			return ciclo;		
			
		}
}
