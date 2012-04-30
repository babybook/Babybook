package com.oak.babybook.main;

import java.util.Date;
import java.util.Set;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.oak.babybook.objects.Event;
import com.oak.babybook.objects.EventType;
import com.oak.babybook.objects.Gender;
import com.oak.babybook.objects.Page;
import com.oak.babybook.objects.Person;
import com.oak.babybook.objects.Picture;
import com.oak.babybook.objects.User;
import com.oak.babybook.services.EventService;
import com.oak.babybook.services.PageService;
import com.oak.babybook.services.PersonService;
import com.oak.babybook.services.PictureService;
import com.oak.babybook.services.UserService;

public class TestBabyBook extends TestCase{

	UserService userService;
	PersonService personService;
	PictureService pictureService;
	PageService pageService;
	EventService eventService;

	static ApplicationContext context = new ClassPathXmlApplicationContext("babybook-test-context.xml");

	@Override
	public void setUp(){
		userService = (UserService)context.getBean("userService");
		personService = (PersonService)context.getBean("personService");
		eventService = (EventService)context.getBean("eventService");
		pictureService = (PictureService)context.getBean("pictureService");
		pageService = (PageService)context.getBean("pageService");
	}

	public void testUserBabyBook()  {

		User user = new User(null, "Patrick", "Michael", "Callaghan", new Date(), "patrick@oakitfinancial.co.uk", Gender.MALE, "user", "pass");
		userService.insertUser(user);

		Person beth = new Person(null, "Beth", "Anne", "Callaghan", new Date(), "beth@oakitfinancial.co.uk", Gender.FEMALE);
		personService.insertPerson(beth);
		user.addChild(beth);

		System.out.println(beth.getId());

		Person eva = new Person(null, "Eva", "May", "Callaghan", new Date(), "eva@oakitfinancial.co.uk", Gender.FEMALE);
		personService.insertPerson(eva);
		user.addChild(eva);

		Picture pic1 = new Picture(null, "MyPhoto.jpg", "Paris", "Me and the girls in Paris");
		Picture pic2 = new Picture(null, "Pic.gif", "Home", "Playing in front of the fire");

		pictureService.insertPicture(pic1);
		pictureService.insertPicture(pic2);

		user.addPicture(pic1);
		user.addPicture(pic2);

		Event event1 = new Event(null, "My Event", "At home", "Some short description", new Date(), EventType.SAYINGS, null);
		Event event2 = new Event(null, "Another Event", "In the park", "Another short description", new Date(), EventType.FIRST_STEPS, null);
		eventService.insertEvent(event1);
		eventService.insertEvent(event2);


		Picture pic3 = new Picture(null, "WithEvent.gif", "Event Pic", "Picture for the event");
		pictureService.insertPicture(pic3);
		user.addPicture(pic3);

		user.addEvent(event1);
		user.addEvent(event2);

		Event event3 = new Event(null, "Another1 Event", "In the park", "Another short description", new Date(), EventType.FIRST_STEPS, null);
		eventService.insertEvent(event3);
		user.addEvent(event3);
		userService.updateUser(user);

		Page page = new Page(null, "page name", "Page description", new Date(), new Date(), null);
		page.addEvent(event1);
		page.addEvent(event2);
		pageService.insertPage(page);
		user.addPage(page);
		userService.updateUser(user);

		User loadUser = userService.getUser(1l);
		System.out.println(loadUser);

		try {
			loadUser = userService.getUserByNamePass("user", "pass");
			System.out.println(loadUser);

			System.out.println(loadUser.toXML());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testUserRemovePicture()  {

		User user = userService.getUser(1l);
		System.out.println(user);

		Picture picture = user.getPicture(new Long(2));
		pictureService.delete(picture);

		this.userService.removePictureFromUser(user, new Long(2));
		this.userService.updateUser(user);

		Assert.assertEquals("Pictures not deleted correctly", 2, user.getPictures().size());

		try {
			User loadUser = userService.getUserByNamePass("user", "pass");
			System.out.println(loadUser);

			System.out.println(loadUser.toXML());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testUserRemoveEvent()  {

		User user = userService.getUser(1l);
		System.out.println(user);

		Event event = eventService.getEvent(new Long(2));
		eventService.delete(event);

		this.userService.removeEventFromUser(user, new Long(2));
		this.userService.updateUser(user);

		Assert.assertEquals("Events not deleted correctly", 2, user.getEvents().size());

		try {
			User loadUser = userService.getUserByNamePass("user", "pass");
			System.out.println(loadUser);

			System.out.println(loadUser.toXML());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testUserRemoveChild()  {

		User user = userService.getUser(1l);
		System.out.println(user);

		Person child = personService.getPerson(new Long(2));
		personService.delete(child);

		this.userService.removeChildFromUser(user, new Long(2));
		this.userService.updateUser(user);

		Assert.assertEquals("Children not deleted correctly", 1, user.getChildren().size());

		try {
			User loadUser = userService.getUserByNamePass("user", "pass");
			System.out.println(loadUser);

			System.out.println(loadUser.toXML());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testAddPictureToEvent()  {

		User user = userService.getUser(1l);
		System.out.println(user);

		Picture picture = user.getPicture(new Long(1));
		Event event = user.getEvent(3l);
		event.addPicture(picture);
		this.userService.updateUser(user);

		try {
			User loadUser = userService.getUserByNamePass("user", "pass");
			System.out.println(loadUser);

			System.out.println(loadUser.toXML());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void testShowPictures()  {

		User user = userService.getUser(1l);
		System.out.println(user);

		try {
			Set<Picture> pictures = user.getPictures();

			for (Picture picture : pictures){
				System.out.println("images/" + picture.getName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
