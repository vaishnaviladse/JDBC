package jdbc_maven_wejm2;

import java.util.Scanner;

public class UserMain {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		User user = new User();

		UserCRUD crud = new UserCRUD();
		boolean exit1 = true;
		System.out.println("Enter the choice \n1.Signed Up User \n2.Login User \n3.Exit");
		int choice = scanner.nextInt();
		do {
			switch (choice) {
			case 1: {
//			System.out.println("Enter the ID");
//			int id=scanner.nextInt();
//			System.out.println("Enter the Name");
//			String name=scanner.next();
//			System.out.println("Enter the Email");
//			String email=scanner.next();
//			System.out.println("Enter the Password");
//			String password=scanner.next();
//			System.out.println("Enter the Address");
//			String address=scanner.next();

				// We can do like this also

				System.out.println("Enter the ID");
				user.setId(scanner.nextInt());
				System.out.println("Enter the Name");
				user.setName(scanner.next());
				System.out.println("Enter the Email");
				user.setEmail(scanner.next());
				System.out.println("Enter the Password");
				user.setPassword(scanner.next());
				System.out.println("Enter the Address");
				user.setAddress(scanner.next());

				crud.signupUser(user);

			}
				break;
			case 2: {
				System.out.println("Enter the Email");
				String email = scanner.next();
				user.setEmail(email);
				System.out.println("Enter the Password");
				String password = scanner.next();
				user.setPassword(password);
				boolean result = crud.loginUser(email, password);
				if (result) {
					System.out.println("Logged In Successfully....!!!");
					boolean exit = true;
					while (exit) {
						System.out.println(
								"Enter your choice  \n1.Add Facebook Passowrd \n2.Add Whatapp Password \n3.Add Snapchat Password \n4.Add Twitter Password \n5.Add Instagram Password \n6.Exit");
						int choice1 = scanner.nextInt();
						switch (choice1) {
						case 1: {
							System.out.println("Enter the Password of Facebook.....");
							String password1 = scanner.next();
							crud.updateFacebookPassword(password1, email);
						}
							break;
						case 2: {
							System.out.println("Enter the Password of Facebook.....");
							String password1 = scanner.next();
							crud.updateWhatappPassword(password1, email);
						}
							break;
						case 3: {
							System.out.println("Enter the Password of Facebook.....");
							String password1 = scanner.next();
							crud.updateSnapchatPassword(password1, email);
						}
							break;
						case 4: {
							System.out.println("Enter the Password of Facebook.....");
							String password1 = scanner.next();
							crud.updateTwitterPassword(password1, email);
						}
							break;
						case 5: {
							System.out.println("Enter the Password of Facebook.....");
							String password1 = scanner.next();
							crud.updateInstagramPassword(password1, email);
						}
							break;
						default:
							exit = false;
							break;
						}
					}
				} else {
					System.out.println("Failed to Login");
				}

			}
				break;
			case 3: {
				exit1 = false;
				System.out.println("Thank you..!!");

			}
				break;
			default: {
				System.out.println("Invalid choice...!!!");
			}
				break;
			}

		} while (exit1);
		scanner.close();
	}

}
