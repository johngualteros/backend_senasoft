package com.senasoft.sena.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.senasoft.sena.models.Survey;

@Component("/api/v1/survey")
public class listReport extends AbstractPdfView {
    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        //  bring the information required in the report
        List<Survey> listacliente = (List<Survey>) model.get("listSurvery");
        PdfPTable tableInformation = new PdfPTable(1);
        PdfPCell celda = null;
        Font fuenteTitulo = FontFactory.getFont("sans-serif",16);
        celda = new PdfPCell(new Phrase("LIST SEVEYS ",fuenteTitulo));
        celda.setBorder(0);
        celda.setBackgroundColor(new Color(113, 204, 236));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);
        celda.setVerticalAlignment(Element.ALIGN_CENTER);
        celda.setPadding(20);

        tableInformation.addCell(celda);
        tableInformation.setSpacingAfter(30);

        PdfPTable tableSurvey = new PdfPTable(1);
        listacliente.forEach(survey -> {
            tableSurvey.addCell(survey.getTheme());
        });
        document.add(tableInformation);
        document.add(tableSurvey);
    }

    
}
