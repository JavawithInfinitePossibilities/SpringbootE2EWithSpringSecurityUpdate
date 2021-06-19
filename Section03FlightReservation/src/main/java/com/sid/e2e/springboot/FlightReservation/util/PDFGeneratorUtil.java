/**
 * 
 */
package com.sid.e2e.springboot.FlightReservation.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sid.e2e.springboot.FlightReservation.entities.Reservation;

/**
 * @author Lenovo
 *
 */
@Component
public class PDFGeneratorUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(PDFGeneratorUtil.class);

	public void generateItinary(Reservation reservation, String filePath) {
		LOGGER.info("Inside generateItinary : {},{}", reservation, filePath);
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filePath));
			document.open();
			document.add(generateTable(reservation));
			document.close();
		} catch (FileNotFoundException | DocumentException e) {
			LOGGER.error("Error in generateItinary :" + e);
		}
	}

	private Element generateTable(Reservation reservation) {
		PdfPTable pdfPTable = new PdfPTable(2);
		PdfPCell pCell;
		pCell = new PdfPCell(new Phrase("Flight Itinary"));
		pCell.setColspan(2);
		pdfPTable.addCell(pCell);

		pCell = new PdfPCell(new Phrase("Flight Details"));
		pCell.setColspan(2);
		pdfPTable.addCell(pCell);

		pdfPTable.addCell("Airline Name");
		pdfPTable.addCell(reservation.getFlight().getOperationAirlines());

		pdfPTable.addCell("Departure City ");
		pdfPTable.addCell(reservation.getFlight().getDepartureCity());

		pdfPTable.addCell("Arrival City ");
		pdfPTable.addCell(reservation.getFlight().getArrivalCity());

		pdfPTable.addCell("Flight Number ");
		pdfPTable.addCell(reservation.getFlight().getFlightNumber());

		pdfPTable.addCell("Departure Date ");
		pdfPTable.addCell(reservation.getFlight().getDateOfDeparture().toString());

		pdfPTable.addCell("Flight Departure Time");
		pdfPTable.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());

		pCell = new PdfPCell(new Phrase("Flight Details"));
		pCell.setColspan(2);
		pdfPTable.addCell(pCell);

		pdfPTable.addCell("First Name");
		pdfPTable.addCell(reservation.getPassenger().getFirstName());

		pdfPTable.addCell("Last Name");
		pdfPTable.addCell(reservation.getPassenger().getLastname());

		pdfPTable.addCell("Phone Number");
		pdfPTable.addCell(reservation.getPassenger().getPhone());

		pdfPTable.addCell("Email ");
		pdfPTable.addCell(reservation.getPassenger().getEmail());

		return pdfPTable;
	}
}
