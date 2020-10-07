package com.careerit.cbook;

import java.util.List;
import java.util.Scanner;

import com.careerit.cbook.domain.Contact;
import com.careerit.cbook.service.ContactService;
import com.careerit.cbook.service.ContactServiceImpl;

public class Manager {

	public static void main(String[] args) {

			ContactService service = new ContactServiceImpl();
			while(true) {
				Scanner sc = new Scanner(System.in);
				System.out.println("--------------------------------------------------------");
				System.out.println("1. Add 2.View all 3. Search 4. Update 5. Delete 6.exit");
				System.out.println("--------------------------------------------------------");
				System.out.println("Enter your choice :");
				int ch = sc.nextInt();
				switch (ch) {
				case 1:
					Contact contact = getContactFromUser();
					int res = service.addContact(contact);
					System.out.println("Contact is added with id:"+res);
				case 2:
					List<Contact> list = service.getContacts();
					showContacts(list);
					break;

				default:
					break;
				}
			}

	}
	
	private static Contact getContactFromUser() {
		//Logic Scanner sc = new Scanner(System.in);
		 Contact contact = new Contact(1004, "Manohar", "manohar@gmail.com", "98765678944");
		return contact;
	}

	private static void showContacts(List<Contact> list) {
		
		if(list.isEmpty()) {
			System.out.println("No contacts are added yet");
		}else {
			list.stream().forEach(c->{
				System.out.println(c.getCid() +" - "+c.getName()+" - "+c.getMobile()+" - "+c.getEmail());
			});
		}
		
	}

	
}
