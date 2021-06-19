/**
 * 
 */
package com.sid.e2e.springboot.locationdetails.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author Lenovo
 * To disable the security in GMAIL go to the below link
 * https://www.google.com/settings/security/lesssecureapps
 */
@Component
public class EmailUtilImpl implements EmailUtil {

	@Autowired
	private JavaMailSender sender;

	@Override
	public void sendEmail(String toAddress, String subject, String body) {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper messageHelper = new MimeMessageHelper(message);

		try {
			messageHelper.setTo(toAddress);
			messageHelper.setSubject(subject);
			messageHelper.setText(body);
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		sender.send(message);
	}

}
