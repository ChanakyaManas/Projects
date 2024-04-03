package Pojo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Emp {
private int eid;
private String ename;
private double esal;
private String edesg;
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public double getEsal() {
	return esal;
}
public void setEsal(double esal) {
	this.esal = esal;
}
public String getEdesg() {
	return edesg;
}
public void setEdesg(String edesg) {
	this.edesg = edesg;
}
@Override
public String toString() {
	return "Emp [eid=" + eid + ", ename=" + ename + ", esal=" + esal + ", edesg=" + edesg + "]";
}
public Emp(int eid, String ename, double esal, String edesg) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.esal = esal;
	this.edesg = edesg;
}
public Emp() {
	super();
	// TODO Auto-generated constructor stub
}
public Emp(PreparedStatement ps) throws SQLException {
    ResultSet rs = ps.executeQuery();
    if (rs.next()) {
        this.eid = rs.getInt("eid");
        this.ename = rs.getString("ename");
        this.esal = rs.getDouble("Esal");
        this.edesg = rs.getString("edesg");
    }
}


}
