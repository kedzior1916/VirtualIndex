package com.projekt.wirtualny_indeks.index.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "documents")
@NoArgsConstructor
@Getter
@Setter
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    private int document_status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "document_type_id",nullable = false)
    private DocumentType documentType;


    public Document(int document_status, User user, DocumentType documentType)
    {
        this.document_status = document_status;
        this.user = user;
        this.documentType = documentType;
    }
}
