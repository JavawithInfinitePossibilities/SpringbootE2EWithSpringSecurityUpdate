/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.util;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 *
 */
@Component
public class EmailUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmailUtil.class);

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendItinerary(String toAddress, String filePath) {
		LOGGER.info("sendItinerary : {} , {}", toAddress, filePath);
		MimeMessage message = javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);
			messageHelper.setTo(toAddress);
			messageHelper.setSubject("Flight Ticket");
			messageHelper.setText("Please find the flight ticket in attachment.");
			messageHelper.addAttachment("Flight Ticket", new File(filePath));
			javaMailSender.send(message);
		} catch (MessagingException e) {
			LOGGER.error("Exception inside sendItinerary :" + e);
		}

	}
}
