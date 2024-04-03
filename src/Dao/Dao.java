package Dao;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mysql.cj.protocol.Resultset;

import Pojo.Emp;
@Component
public class Dao {
@Autowired	
private DataSource ds;

public void save(String schema,String table) throws SQLException {
Connection c=ds.getConnection();

PreparedStatement ps=null;
Statement s=c.createStatement();
String sql="create schema if not exists "+schema;
s.executeUpdate(sql);
String query="create table if not exists "+schema+ "." +table+"(";	

Scanner in=new Scanner(System.in);
System.out.println("Enter cols count");	
int cols=in.nextInt();	
	for(int i=1;i<=cols;i++) {
	System.out.println("Enter column name");
	String colsname=in.next();
	in.nextLine();
	String datatype="";
//	Scanner in=new Scanner(System.in);
	System.out.println("1.Select Datatype");
	System.out.println("1.INT");
	System.out.println("2.VARCHAR(35)");
	System.out.println("3.Double");
	int j=in.nextInt();
	if(j==1) {
		datatype="INT";
	}
    if(j==2) {
    	datatype="VARCHAR(35)";
    }
    if(j==3) {
    	datatype="DOUBLE";
    }
    if(i==1) {
    	query+= colsname+" "+datatype+" "+"PRIMARY KEY"+" "+",";
    }
    if(i==cols) {
    query+= colsname+" "+datatype;
    }
    else if(i<cols&&i>1) {
    query+= colsname+" "+datatype+" , ";
    }
	}
	query+=")";
ps.executeUpdate(query);	
ps.close();
}
private void Insert(Emp e,String schema,String table) throws SQLException {
	Connection c=ds.getConnection();
	PreparedStatement ps=c.prepareStatement("Insert into "+schema+"."+table+" values(?,?,?,?)");
	ps.setInt(1, e.getEid());
	ps.setString(2, e.getEname());
	ps.setDouble(3, e.getEsal());
	ps.setString(4, e.getEdesg());
	int i=ps.executeUpdate();
	System.out.println(i);
	
}
public void getdata(String schema, String table,String eid,String name,String sal,String desg) throws SQLException {
    Emp e = new Emp(); // Initialize e with a new Emp object
    Scanner in = new Scanner(System.in);
    System.out.println("Enter Insert count");
    int n=in.nextInt();
    for (int j = 0; j < n; j++) 
    {	
    	
    	Connection c = ds.getConnection();
    System.out.println("Enter Your ID");
    int id=in.nextInt();	 
	PreparedStatement ps = c.prepareStatement("SELECT * FROM " + schema + "." + table + " WHERE "+eid+ "= ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        e.setEid(rs.getInt(eid)); // Assuming eid is the column name in your table
        e.setEname(rs.getString(name));
        e.setEsal(rs.getDouble(sal));
        e.setEdesg(rs.getString(desg));
        System.out.println("Data Existed: " + e.toString());
    } 
   
    else {  
    	
    	    System.out.println("Enter Name:");
    	    in.nextLine();   
    	    String ename = in.nextLine();
    	    System.out.println("Enter Esal:");
    	    Double esal = in.nextDouble();
    	    in.nextLine(); // Consume newline character after reading double
    	    System.out.println("Enter edesg:");
    	    String edesg = in.nextLine();

    	    e.setEid(id);
    	    e.setEname(ename);
    	    e.setEsal(esal);
    	    e.setEdesg(edesg);
    	    Insert(e, schema, table);
    	    System.out.println("Insertion done");
    		 }
    	
    	}
            
    	}
public void update(String name,int eid,String schema,String table,String ename,String id)throws Exception {
	Connection c=ds.getConnection();
	PreparedStatement ps=c.prepareStatement("update "+schema+"."+table+" set "+ ename+"=? where "+ id+"=?");
	ps.setString(1, name);
	ps.setInt(2, eid);
	int h=ps.executeUpdate();
	System.out.println("No of ENtries Affected"+h);	
}
public void updateSal(Double esal,int eid,String schema,String table,String sal,String id)throws Exception {
	Connection c=ds.getConnection();
	PreparedStatement ps=c.prepareStatement("update "+schema+"."+table+" set "+sal+"=? where "+id+"=?");
	ps.setDouble(1, esal);
	ps.setInt(2, eid);
	int h=ps.executeUpdate();
	System.out.println("No of ENtries Affected"+h);	
}
public void updatedesg(String edesg,int eid,String schema,String table,String ename,String id)throws Exception {
	Connection c=ds.getConnection();
	PreparedStatement ps=c.prepareStatement("update "+schema+".emp set "+ename+"=? where "+ id+"=?");
	ps.setString(1, edesg);
	ps.setInt(2, eid);
	int h=ps.executeUpdate();
	System.out.println("No of ENtries Affected"+h);	
}
public void delete(int id,String schema,String table,String eid)throws Exception{
	Connection c=ds.getConnection();
	PreparedStatement ps=c.prepareStatement("delete from "+schema+"."+table+ " where"+eid+"=?");
	ps.setInt(1, id);
	int h=ps.executeUpdate();
	System.out.println("No of Entries Affected::"+h);
}
public void getbyId(int id,String schema,String table,String eid,String name,String sal,String desg)throws Exception{
	Connection c=ds.getConnection();
	
	PreparedStatement ps=c.prepareStatement("select * from "+schema+"."+table +" where "+eid+"=?");
	ps.setInt(1, id);
    ResultSet sh=ps.executeQuery();
    while(sh.next()) {
    	System.out.println(sh.getInt(eid));
    	System.out.println(sh.getString(name));
    	System.out.println(sh.getDouble(sal));
    	System.out.println(sh.getString(desg));
//    	sh.toString();
    }
	
}
public void getbyall(String schema,String table,String eid,String name,String sal,String desg)throws Exception{
	Connection c=ds.getConnection();
	
	PreparedStatement ps=c.prepareStatement("select * from "+schema+"."+table);
//	ps.setInt(1, id);
    ResultSet sh=ps.executeQuery();
    while(sh.next()) {
    	System.out.println(sh.getInt(eid));
    	System.out.println(sh.getString(name));
    	System.out.println(sh.getDouble(sal));
    	System.out.println(sh.getString(desg));
//    	System.out.println("No of Entries Affected::"+sh);	
    }
   
	
}
public ArrayList<Emp> listall(String schema,String table,String eid,String name,String sal,String desg) throws SQLException{
	Connection c=ds.getConnection();
	PreparedStatement ps=c.prepareStatement("select *from "+schema+"."+table);
	ArrayList<Emp>l=new ArrayList<Emp>();
	ResultSet sh=ps.executeQuery();
	while(sh.next()) {
		Emp e=new Emp();
		e.setEid(sh.getInt(eid));
		e.setEname(sh.getString(name));
		e.setEsal(sh.getDouble(sal));
		e.setEdesg(sh.getString(desg));
		l.add(e);
	}
	return l;
	
}
public void batc(ArrayList<Emp> e,String schema,String table) throws SQLException {
	   Connection c=ds.getConnection();
	   PreparedStatement ps=c.prepareStatement("Insert into unitperson.emp values(?,?,?,?)");
	 for (Emp emp : e) {
	 ps.setInt(1, emp.getEid());
	 ps.setString(2, emp.getEname());
	 ps.setDouble(3, emp.getEsal());
	 ps.setString(4, emp.getEdesg());
	 ps.addBatch();
	 }
	 int[]a= ps.executeBatch();
	for (int i : a) {
		System.out.println(i);
	}
	ps.close();
	c.close();
}
public void createschema(String name) throws SQLException {
	Connection c=ds.getConnection();
	Statement ps=c.createStatement();
	String sql="create schema"+name;
 ps.executeUpdate(sql);	
 ps.close();
c.close();
System.out.println("Schema Created Sucessfully");
}
   public void verify(String schema,String table,String eid) throws SQLException {
    Emp e = new Emp(); // Initialize e with a new Emp object
    Scanner in = new Scanner(System.in);
    Connection c = ds.getConnection();
    System.out.println("Enter Your ID to check");
    int id=in.nextInt();	 
	PreparedStatement ps = c.prepareStatement("SELECT * FROM " + schema + "." + table + " WHERE "+eid+ "= ?");
    ps.setInt(1, id);
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        e.setEid(rs.getInt(eid)); // Assuming eid is the column name in your table
     System.out.println("data Existed :"+id);
    }
    else {
    	System.out.println("Please proceed to enter data by selecting insert");
    }
}}
