package com.hans.jdbcExcercise;

import java.sql.Statement;
import java.time.LocalDate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnection {
	
	String url="jdbc:postgresql://localhost:5432/";
	String dbName="db_studenti";
	String user="postgres";
	String pass="root";
	Connection conn;
	Statement st;
	
	public DbConnection() throws SQLException {
	 conn=DriverManager.getConnection(url+dbName, user, pass);
	 st=conn.createStatement();
	 System.out.println("Database connesso!");
	
	}
	//INSERT INTO studenti(name, last_name, gender, birth_date, avg, min_vote, max_vote) VALUES('Hansel','Adjei','m','18-10-2003',8.7,7.5,9);
	public void inserisciStudente(Studente s) throws SQLException {
		String sql="INSERT INTO studenti(name, last_name, gender, birth_date, avg, min_vote, max_vote) "
				+ "VALUES('"+s.getName()+"','"+s.getLast_name()+"','"+s.getGender()+"','"+s.getBirth_date()+"',"+s.getAvg()+","+s.getMin_vote()+","+s.getMax_vote()+")";
		st.executeUpdate(sql);
		System.out.println(s.getName()+" è stato inserito nel Database!");
		
	}
	
	public void modificaStudente(Studente s) throws SQLException {
		String sql="UPDATE studenti SET name = '"+s.getName()+"', last_name = '"+s.getLast_name()+"', gender = '"+s.getGender()+"', birth_date = '"+s.getBirth_date()+"', avg = '"+s.getAvg()+"', min_vote = '"+s.getMin_vote()+"', max_vote = '"+s.getMax_vote()+"' WHERE id = "+s.getId();
		st.executeUpdate(sql);
		System.out.println(s.getName()+" è stato modificato nel Database!");
	}
	
	public Studente leggiStudente(long id) throws SQLException {
		String sql="SELECT * FROM studenti WHERE id="+id;
		ResultSet rs=st.executeQuery(sql);
		Studente s=null;
		if(rs.next()) {
			 long idStudente=rs.getLong("id");
			 String name=rs.getString("name");
			String last_name=rs.getString("last_name");
			 String gender=rs.getString("gender");
			 String birth_date=rs.getString("birth_date");
			 double avg=rs.getDouble("avg");
			 double min_vote=rs.getDouble("min_vote");
			 double max_vote=rs.getDouble("max_vote") ;
			 GenderType g=GenderType.m;
			 if(gender.equals("m")) {
				 g=GenderType.m;
			 }else if(gender.equals("f")) {
				 g=GenderType.f;
			 }
			 s=new Studente(idStudente, name,last_name, g, LocalDate.parse(birth_date), avg, min_vote, max_vote);
		}
		return s;
	}
	
	public void eliminaStudente(Studente s) throws SQLException {
		String sql="DELETE FROM studenti WHERE id="+s.getId();
		st.executeUpdate(sql);
		System.out.println(s.getName()+" è stato cancellato dal Database!");	
	}
	
	
	public void studenteMediaMigliore() throws SQLException {
		String sql="SELECT * FROM studenti WHERE avg = (SELECT MAX(avg) FROM studenti)";
		ResultSet rs=st.executeQuery(sql);
		Studente s=null;
		if(rs.next()) {
			 long idStudente=rs.getLong("id");
			 String name=rs.getString("name");
			String last_name=rs.getString("last_name");
			 String gender=rs.getString("gender");
			 String birth_date=rs.getString("birth_date");
			 double avg=rs.getDouble("avg");
			 double min_vote=rs.getDouble("min_vote");
			 double max_vote=rs.getDouble("max_vote") ;
			 GenderType g=GenderType.m;
			 if(gender.equals("m")) {
				 g=GenderType.m;
			 }else if(gender.equals("f")) {
				 g=GenderType.f;
			 }
			 s=new Studente(idStudente, name,last_name, g, LocalDate.parse(birth_date), avg, min_vote, max_vote);
			 System.out.println(s.getName()+" ha la media migliore tra gli studenti!: "+s.getAvg());
		}
		
	}
	
	
	
	
	
}
