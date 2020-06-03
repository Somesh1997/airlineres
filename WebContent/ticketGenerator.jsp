<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page trimDirectiveWhitespaces="true" %>
<%@page import="bean.GenerateTicketBean"%>
<%@page import="java.util.ArrayList"%>
<%@ page import="java.io.BufferedReader" %>
<%@ page import="java.io.FileOutputStream" %>
<%@ page import="com.itextpdf.text.BaseColor" %>
<%@ page import="com.itextpdf.text.Document" %>
<%@ page import="com.itextpdf.text.Element" %>
<%@ page import="com.itextpdf.text.Font" %>
<%@ page import="com.itextpdf.text.Image" %>
<%@ page import="com.itextpdf.text.List" %>
<%@ page import="com.itextpdf.text.ListItem" %>
<%@ page import="com.itextpdf.text.PageSize" %>
<%@ page import="com.itextpdf.text.Paragraph" %>
<%@ page import="com.itextpdf.text.Phrase" %>
<%@ page import="com.itextpdf.text.pdf.CMYKColor" %>
<%@ page import="com.itextpdf.text.pdf.PdfPCell" %>
<%@ page import="com.itextpdf.text.pdf.PdfPTable" %>
<%@ page import="com.itextpdf.text.pdf.PdfWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String pnr = "";
		pnr=request.getParameter("pnr");
		String src=((ArrayList<String>)request.getAttribute("source")).get(0);
		String des=((ArrayList<String>)request.getAttribute("destination")).get(0);
		String sector=src+" -> "+des;
		String depTime=((ArrayList<String>)request.getAttribute("departure")).get(0);
		String arrTime=((ArrayList<String>)request.getAttribute("arrival")).get(0);
		ArrayList<GenerateTicketBean> mylistdata = (ArrayList<GenerateTicketBean>)request.getAttribute("mylist");
	%>
	<%
	response.setContentType("application/pdf");
	Document document = new Document(PageSize.A4, 50, 50, 50, 50);
    try {
    PdfWriter writer = PdfWriter.getInstance(document, response.getOutputStream());
    document.open();
    String imagefile="D:\\Flight.png";
    Font font1 = new Font(Font.FontFamily.COURIER , 25, Font.BOLD);
    Font font2 = new Font(Font.FontFamily.COURIER , 16, Font.NORMAL,new CMYKColor(0, 51, 153, 255));
    Font font3 = new Font(Font.FontFamily.TIMES_ROMAN , 14, Font.BOLD);
    Image image=Image.getInstance(imagefile);
    image.scaleAbsolute(50f, 50f);
    document.add(image);
    document.add(new Phrase("SAVAN Airlines ",font1));
    document.add(new Paragraph("\n"));
    document.add(new Paragraph("Hi, "));
    document.add(new Paragraph("Your flight ticket for "+sector+" is confirm. Your ticket details are here below."));
    document.add(new Paragraph("Your ticket PNR is "+pnr+". Please use it for any further communication with us."));
    document.add(new Paragraph("\n \t\tDeparture Time- "+depTime));
    document.add(new Paragraph("\n \t\tArrival Time- "+arrTime));
    document.add(new Paragraph("\nPassenger Details:",font2));
    
    PdfPTable table =  new PdfPTable(5);
    table.setWidthPercentage(100);
    table.setSpacingBefore(20f); //Space before table
    table.setSpacingAfter(20f); //Space after table

    //Set Column widths
    float[] columnWidths = {1f, 1f, 1f,1f,1f};
    table.setWidths(columnWidths);

    PdfPCell cell1 = new PdfPCell(new Paragraph("Passenger",font3));
    cell1.setBorderColor(BaseColor.BLUE);
    cell1.setBackgroundColor(BaseColor.CYAN);
    cell1.setPadding(12);
    cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell1.setVerticalAlignment(Element.ALIGN_MIDDLE);

    PdfPCell cell2 = new PdfPCell(new Paragraph("Age",font3));
    cell2.setBorderColor(BaseColor.BLUE);
    cell2.setBackgroundColor(BaseColor.CYAN);
    cell2.setPadding(12);
    cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell2.setVerticalAlignment(Element.ALIGN_MIDDLE);

    PdfPCell cell3 = new PdfPCell(new Paragraph("Airline",font3));
    cell3.setBorderColor(BaseColor.BLUE);
    cell3.setBackgroundColor(BaseColor.CYAN);
    cell3.setPadding(12);
    cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell3.setVerticalAlignment(Element.ALIGN_MIDDLE);
    
    PdfPCell cell4 = new PdfPCell(new Paragraph("PNR",font3));
    cell4.setBorderColor(BaseColor.BLUE);
    cell4.setBackgroundColor(BaseColor.CYAN);
    cell4.setPadding(12);
    cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell4.setVerticalAlignment(Element.ALIGN_MIDDLE);
    
    PdfPCell cell5 = new PdfPCell(new Paragraph("Seat No",font3));
    cell5.setBorderColor(BaseColor.BLUE);
    cell5.setBackgroundColor(BaseColor.CYAN);
    cell5.setPadding(12);
    cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
    cell5.setVerticalAlignment(Element.ALIGN_MIDDLE);

    //To avoid having the cell border and the content overlap, if you are having thick cell borders
    cell1.setUseBorderPadding(true);
    cell2.setUseBorderPadding(true);
    cell3.setUseBorderPadding(true);
    cell4.setUseBorderPadding(true);
    cell5.setUseBorderPadding(true);
    table.addCell(cell1);
    table.addCell(cell2);
    table.addCell(cell3);
    table.addCell(cell4);
    table.addCell(cell5);
    
    for(GenerateTicketBean bean : mylistdata){
    	table.addCell(bean.getName());
        table.addCell(""+bean.getAge());
        table.addCell(bean.getAirlineNo());
        table.addCell(bean.getPnr());
        table.addCell(""+bean.getSeatNo());
    }
    
    //com.itextpdf.text.BaseColor
    
    document.add(table);
    document.add(new Paragraph("Terms and Conditions:",font2));
    List unorderedList = new List(List.UNORDERED);
    unorderedList.add(new ListItem("All passengers have to present their valid ID proof at the time of check-in."));
    unorderedList.add(new ListItem("Free baggage allowance: 15kg checked baggage and 7kg cabin baggage.\nBaggage more than specified units is subject to a charge to be paqid at airport during check-in. (Baggage allowance differ for infants)"));
    unorderedList.add(new ListItem("We recommend you check-in at least 3 hours prior to departure of your flight."));
    unorderedList.add(new ListItem("Recheck your baggage with your respective airline before travelling for hassle-free travel experience."));
    unorderedList.add(new ListItem("All time indicated are the local times (in 24 hrs format) at the relevant airport."));
    unorderedList.add(new ListItem("Please reference the airline PNR number, when communicating with the airline regarding this booking."));

    document.add(unorderedList);
    document.close();
    writer.close();
    }
    catch(Exception e)
    {
        System.out.println(e);
    }
	
	%>
</body>
</html>