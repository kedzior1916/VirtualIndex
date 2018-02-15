package com.projekt.wirtualny_indeks.index.utilities;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import java.util.Iterator;
import java.util.UUID;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.util.Map;

@Log4j2
@Component
public class PdfGenerator {

    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public void createPdf(String templateName, Map map, int documentId) throws Exception{
        Assert.notNull(templateName, "Nazwa szablonu nie moze byc pusta");
        Context ctx = new Context();
        if (map != null) {
            Iterator itMap = map.entrySet().iterator();
            while (itMap.hasNext()) {
                Map.Entry pair = (Map.Entry) itMap.next();
                ctx.setVariable(pair.getKey().toString(), pair.getValue());
            }
        }

        String processedHtml = templateEngine.process(templateName, ctx);
        FileOutputStream os = null;
        String fileName = "doc"+documentId;
        log.info(fileName);
        try {

            File outputFile = new File("src/main/resources/templates/pdf/"+fileName+".pdf");
            os = new FileOutputStream(outputFile);

            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(processedHtml);
            renderer.layout();
            renderer.createPDF(os, false);
            renderer.finishPDF();
        }
        finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) { /*ignore*/ }
            }
        }
    }

}
