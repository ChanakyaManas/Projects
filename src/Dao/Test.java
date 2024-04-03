package Dao;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import Pojo.Emp;

public class Test {
public static void main(String[] args) throws Exception {
	ApplicationContext ap=new AnnotationConfigApplicationContext(Myconfiguration.class);
	Controller c=ap.getBean(Controller.class);
	try {
	Scanner in=new Scanner(System.in);
	System.out.println("Enetr Schema name");
	String schema=in.next();
	System.out.println("Enter Table Name");
	String table=in.next();
System.out.println("No of Entries you want to make");
int count = in.nextInt();
in.nextLine();
System.out.println("Enter ID Field");
String id = in.nextLine();
System.out.println("Enter Name Field");
String name = in.nextLine();
System.out.println("Enter Sal Field");
String sal = in.nextLine();
System.out.println("Enter Desg Field");
String desg = in.nextLine();
	for(int i=1;i<=count;i++) 
	{
	System.out.println("Select Choice");
	System.out.println("1.Insert");
	System.out.println("2.Update");
	System.out.println("3.getbyid");
	System.out.println("4.getall");
	System.out.println("5.Delete");
	System.out.println("6.BatchInsert");
	System.out.println("7.listgetall");
	System.out.println("8.Create");
	System.out.println("9.Verify");
    System.out.println("Enter Operation No");
	int choice=in.nextInt();
//	in.nextLine();
	switch(choice)
	{
	case 1:
//	    c.getdata(schema, table,mid,name, sal, desg);
		c.getdata(schema, table, id, name, sal, desg);
		break;
	case 2:
		System.out.println("Pick up from Choice");
		System.out.println("1.Change Name");
		System.out.println("2.Change Salary");
		System.out.println("3.Change Desg");
		int sub=in.nextInt();
	if(sub==1) {
		System.out.println("Enter Your ID");
		int eid=in.nextInt();
		System.out.println("Enter Name");
		String ename=in.next();	
		c.update(ename, eid,schema,table,name,id);
	}
	else if(sub==2) {
		System.out.println("Enter Your ID");
		int eid=in.nextInt();
		System.out.println("Enter Salary");
		double esal=in.nextDouble();
		c.updateSal(esal, eid,schema,table,sal,id);
	}
	else if(sub==3) {
		System.out.println("Enter Desg");
		String edesg=in.next();
		System.out.println("Enter Your ID");
		int eid=in.nextInt();
		c.updatedesg(edesg, eid,schema,table,desg,id);
	}
	break;
	case 3:
	System.out.println("Enter Your ID");
		int eid=in.nextInt();
		c.getbyid(eid,schema,table,id,name,sal,desg);
		break;
	case 4:
		c.getall(schema,table,id,name,sal,desg);
	    break;
	case 5:
		System.out.println("Enter Your ID");
		int pid=in.nextInt();
		c.delete(pid,schema,table,id);
	break;
	case 6:
		ArrayList<Emp>l=new ArrayList<Emp>();
		int counts=in.nextInt();
		for(int j=0;j<counts;j++) {
		System.out.println("Enter Your ID");
		int eid1=in.nextInt();
		System.out.println("Enter Name");
		String ename=in.next();
		System.out.println("Enter Salary");
		double esal=in.nextDouble();
		System.out.println("Enter Desg");
		String edesg=in.next();
		l.add(new Emp(eid1, ename, esal, edesg));
		}
		c.batch(l,schema,table);
	break;
	case 7:
	ArrayList<Emp>lo=c.listall(schema,table,id,name,sal,desg);
		for(Emp e:lo) {
			System.out.println(e);		
		}
	break;
	case 8:
	c.savedata(schema, table);
	break;
	case 9:
//	System.out.println("Enter ID to Check");
	c.verify(schema, table, id);
	default:
		System.out.println("Error Entry");
	}
	}
	System.out.println("Out of loop");
	in.close();
	}catch(Exception e) {
		System.out.println(e.getMessage());
	}
	
	}
}
