package jdbc_maven_1;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException  {
		Scanner scanner=new  Scanner(System.in);
		Person person=new Person();
		PersonCRUD crud =new PersonCRUD();
		boolean exit=true;
		System.out.println("==========Welcome=========");
		
		while(exit) {
	    System.out.println("Enter the choice \n1.save Person \n2.Update Person "
	    		+ "\n3.Delete Person \n4.Get Person By Id \n5.Get All Person \n6.Exit");
	    
		int choice= scanner.nextInt();
		 
		
			switch (choice) {
			case 1:{
				System.out.println("Enter the id");
				int id=scanner.nextInt();
				System.out.println("Enter the name");
				String name=scanner.next();
				System.out.println("Enter the phone");
				long phone=scanner.nextLong();
				
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				
				crud.savePerson(person);
			}
				
				break;
				
			case 2:{
				System.out.println("Enter the id");
				int id=scanner.nextInt();
				System.out.println("Enter the name");
				String name=scanner.next();
				System.out.println("Enter the phone");
				long phone=scanner.nextLong();
				
				person.setId(id);
				person.setName(name);
				person.setPhone(phone);
				
				crud.updatePerson(person);
			}break;
			
			case 3:{
				System.out.println("Enter the id");
				int id=scanner.nextInt();
						
				crud.deletePerson(id);
			}break;
			case 4:{
				System.out.println("Enter the id");
				int id=scanner.nextInt();			
				crud.getPerson(id);
			}break;
			case 5:{			
				crud.getAllPerson();
			}break;
			
			case 6:{
				exit=false;
				System.out.println("Thank you.....!");
			}break;
			default:{
				System.out.println("Invalid choice......!");
			}
			
			}
		}
		scanner.close();

	}
}


