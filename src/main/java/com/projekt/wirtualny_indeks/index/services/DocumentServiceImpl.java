package com.projekt.wirtualny_indeks.index.services;

import com.projekt.wirtualny_indeks.index.models.Document;
import com.projekt.wirtualny_indeks.index.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    DocumentRepository documentRepository;

    @Override
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @Override
    public Document getDocument(int id) {
        return documentRepository.findById(id).get();
    }

    @Override
    public Document getLastDocument() {
        return documentRepository.getLastDocument();
    }

    @Override
    public List<Document> getAllDocumentsByUserId(long id) {
        return documentRepository.getAllDocumentsByUserId(id);
    }


    @Override
    public void deleteDocument(int id) {
        documentRepository.deleteById(id);

    }

    @Override
    public void saveDocument(Document document) {
        documentRepository.save(document);

    }
}
