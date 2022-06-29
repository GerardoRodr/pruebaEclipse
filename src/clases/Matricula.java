package clases;

public class Matricula {
	
	//Atributos
		private int num_matricula, cod_alumno, cod_curso;
		private String fecha, hora;
	//Constructor
		public Matricula(int num_matricula, int cod_alumno, int cod_curso, String fecha, String hora) {
			super();
			this.num_matricula = num_matricula;
			this.cod_alumno = cod_alumno;
			this.cod_curso = cod_curso;
			this.fecha = fecha;
			this.hora = hora;
		}
	//Metodos
		public int getNum_matricula() {
			return num_matricula;
		}
		public void setNum_matricula(int num_matricula) {
			this.num_matricula = num_matricula;
		}
		public int getCod_alumno() {
			return cod_alumno;
		}
		public void setCod_alumno(int cod_alumno) {
			this.cod_alumno = cod_alumno;
		}
		public int getCod_curso() {
			return cod_curso;
		}
		public void setCod_curso(int cod_curso) {
			this.cod_curso = cod_curso;
		}
		public String getFecha() {
			return fecha;
		}
		public void setFecha(String fecha) {
			this.fecha = fecha;
		}
		public String getHora() {
			return hora;
		}
		public void setHora(String hora) {
			this.hora = hora;
		}
		
		

}
