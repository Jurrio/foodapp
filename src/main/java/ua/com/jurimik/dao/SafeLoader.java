package ua.com.jurimik.dao;

import ua.com.jurimik.dao.list.ListMealDAO;
import ua.com.jurimik.dao.list.ListUserDAO;
import ua.com.jurimik.service.MealService;
import ua.com.jurimik.service.UserService;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;

import org.apache.log4j.Logger;

public class SafeLoader {

	private static final Logger LOG = Logger.getLogger(SafeLoader.class);

	public static void unmarshall() {
		try {
			LOG.info("Unmarshalling meals, users");
			JAXBContext mealJaxbContext = JAXBContext.newInstance(ListMealDAO.class);
			JAXBContext userJaxbContext = JAXBContext.newInstance(ListUserDAO.class);

			Unmarshaller mealUnmarshaller = mealJaxbContext.createUnmarshaller();
			Unmarshaller userUnmarshaller = userJaxbContext.createUnmarshaller();

			mealUnmarshaller.unmarshal(new File("meals.xml"));
			userUnmarshaller.unmarshal(new File("users.xml"));

		} catch (PropertyException e) {
			LOG.warn("Problem encountered while setting properties {}", e);
		} catch (JAXBException ex) {
			LOG.warn("Problem encountered while unmarshalling objects {}", ex);
		}
	}

	public static void marshall() {
		try {
			LOG.info("Marshaling meals, users");
			JAXBContext mealJaxbContext = JAXBContext.newInstance(ListMealDAO.class);
			JAXBContext userJaxbContext = JAXBContext.newInstance(ListUserDAO.class);

			Marshaller mealMarshaller = mealJaxbContext.createMarshaller();
			Marshaller userMarshaller = userJaxbContext.createMarshaller();

			mealMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			userMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			mealMarshaller.marshal(MealService.showAll(), new File("EVENTS.xml"));
			LOG.info("Succesfully marshalled events");

			userMarshaller.marshal(UserService.getAll(), new File("USERS.xml"));
			LOG.info("Succesfully marshalled users");

		} catch (PropertyException e) {
			LOG.warn("Problem encountered while setting properties {}", e);
		} catch (JAXBException ex) {
			LOG.warn("Problem encountered while marshalling objects {}", ex);
		}
	}
}