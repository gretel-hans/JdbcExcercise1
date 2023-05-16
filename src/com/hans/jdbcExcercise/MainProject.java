package com.hans.jdbcExcercise;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class MainProject {

	public static void main(String[] args) {
		
		
		try {
			
			
			DbConnection db=new DbConnection();
			List<Studente> listaStudenti= new ArrayList<Studente>();
			listaStudenti.add(new Studente("Mario","Bianchi",GenderType.m,LocalDate.of(1980, 04, 12),9.0,8.0,9.3));
			listaStudenti.add(new Studente("Francesca","Bias",GenderType.f,LocalDate.of(2000, 06, 27),7.8,5.5,8.5));
			listaStudenti.add(new Studente("Marta","Geppa",GenderType.f,LocalDate.of(1999, 03, 29),9.8,9.0,10.0));
			listaStudenti.add(new Studente("Luigi","Fragola",GenderType.m,LocalDate.of(2005, 01, 25),7.0,4.5,8.0));

			
			//Studente Marta=new Studente("Marta","Ricci",GenderType.f,LocalDate.of(2003, 10, 18),10.0,9.5,10.0);
			//db.inserisciStudente(Marta);
			//Marta.setLast_name("Antonio");
			//db.modificaStudente(Marta);
			Studente s=db.leggiStudente(3);
			System.out.println(s);
			db.studenteMediaMigliore();
			//db.modificaStudente(s);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}

}
