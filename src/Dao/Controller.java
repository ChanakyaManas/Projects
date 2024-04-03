package Dao;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import Pojo.Emp;

@Component
public class Controller {
@Autowired
private Service svc;

public void savedata(String schema,String table) throws SQLException {
	svc.savedata(schema,table);
}
public void update(String ename,int id,String schema,String table,String name,String eid) throws Exception {
	svc.update(ename, id,schema,table,name,eid);
}
public void updateSal(Double esal,int id,String schema,String table,String sal,String eid) throws Exception {
	svc.updateSal(esal, id,schema,table,sal,eid);
}

public void updatedesg(String edesg,int id,String schema,String table,String desg,String eid) throws Exception {
	svc.updatedesg(edesg, id,schema,table,desg,eid);
}
public void delete(int id,String schema,String table,String eid) throws Exception {
	svc.delete(id,schema,table,eid);
}
public void getbyid(int id,String schema,String table,String eid,String name,String sal,String desg) throws Exception {
	svc.getbyid(id,schema,table,eid,name,sal,desg);
}
public void getall(String schema,String table,String eid,String name,String sal,String desg) throws Exception {
	svc.getall(schema,table,eid,name,sal,desg);
}

public void batch(ArrayList<Emp> e,String schema,String table) throws SQLException {
	svc.batch(e,schema,table);
}
public ArrayList<Emp>listall(String schema,String table,String eid,String name,String sal,String desg) throws SQLException{
	return svc.listall(schema,table,eid,name,sal,desg);
}
public void getdata(String schema,String table,String eid,String name,String sal,String desg) throws SQLException {
	 svc.getdata(schema, table,eid,name,sal,desg);
}
public void verify(String table,String Schema,String eid) throws SQLException {
	svc.verify(Schema, table, eid);
}
}
