package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Pojo.Emp;
@Component
public class Service {
@Autowired
private Dao d;

public void savedata(String schema,String table) throws SQLException {
	d.save(schema,table);
}
public void update(String ename,int id,String schema,String table,String name,String eid) throws Exception {
	d.update(ename, id,schema,table,name,eid);
}
public void updateSal(Double esal,int id,String schema,String table,String sal,String eid) throws Exception {
	d.updateSal(esal, id,schema,table,sal,eid);
}

public void updatedesg(String edesg,int id,String schema,String table,String desg,String eid) throws Exception {
	d.updatedesg(edesg, id,schema,table,desg,eid);
}
public void delete(int id,String schema,String table,String eid) throws Exception {
	d.delete(id,schema,table,eid);
}
public void getbyid(int id,String schema,String table,String eid,String name,String sal,String desg) throws Exception {
	d.getbyId(id,schema,table,eid,name,sal,desg);
}
public void getall(String schema,String table,String eid,String name,String sal,String desg) throws Exception {
	d.getbyall(schema,table,eid,name,sal,desg);
}
public void batch(ArrayList<Emp> e,String schema,String table) throws SQLException {
	d.batc(e,schema,table);
}
public ArrayList<Emp>listall(String schema,String table,String eid,String name,String sal,String desg) throws SQLException{
	return d.listall(schema,table,eid,name,sal,desg);
}
//public void table(String tname) throws Exception {
//d.createtable(tname);
//}
public void schema(String schema) throws SQLException {
	d.createschema(schema);
}
public void getdata(String schema,String table,String eid,String name,String sal,String desg) throws SQLException {
	 d.getdata(schema, table,eid,name,sal,desg);
}
public void verify(String table,String Schema,String eid) throws SQLException {
	d.verify(Schema, table, eid);
}
}
