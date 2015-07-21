package study_easy.org.hohenheim;

import javax.validation.constraints.Size;

/*
 * Klasse um ausschließlich Errormeldungen zu beinhalten welche durch eine Code
 * ausgewählt werden können falls Vehlerhafte eingaben gemacht wurden
 */
public class Error {

	 static String [] [] error = new String [3] [4];
	 @Size(max=999)
	 String name;
	 @Size(max=9999999)
	 String problem;
	 @Size(max=9999999)
	 String problemort;
	 
	 public String getName() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
	 
	 public String getProblem() {
			return problem;
		}
		public void setProblem(String problem) {
			this.problem = problem;
		}
		public String getProblemort() {
			return problemort;
		}
		public void setProblemort(String problemort) {
			this.problemort = problemort;
		}


}
