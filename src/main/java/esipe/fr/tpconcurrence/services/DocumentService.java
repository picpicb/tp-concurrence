package esipe.fr.tpconcurrence.services;

import esipe.fr.tpconcurrence.entities.Document;
import esipe.fr.tpconcurrence.entities.DocumentSummary;
import esipe.fr.tpconcurrence.entities.DocumentsList;
import esipe.fr.tpconcurrence.exceptions.ApiException;
import esipe.fr.tpconcurrence.repositories.DocumentRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    DocumentRepository documentRepository;
    Logger logger = LogManager.getLogger("DocumentService");

    public Document findDocumentById(String id) throws ApiException {
        Optional<Document> document = documentRepository.findByDocumentId(id);
        if(document.isPresent()){
            logger.info("Retreived document: " + document.get().getId());
            return document.get();
        }else{
            logger.warn("Aucun document trouvé");
            throw new ApiException(404,"Aucun document trouvé");
        }
    }

    public DocumentsList findAll(int page, int pageSize){
        DocumentsList documentsList = new DocumentsList();
        documentsList.setPage(page);
        documentsList.setNbElements(pageSize);
        Pageable pageable = PageRequest.of(page,pageSize);
        for (Document d : documentRepository.findAll(pageable)) {
            documentsList.addDataItem(new DocumentSummary(d.getDocumentId(),d.getCreated(),d.getUpdated(),d.getTitle()));
        }
        return documentsList;
    }

    public Document save(Document doc) throws ApiException {
        if(doc.getDocumentId() != null && doc.getCreated() != null
                && doc.getUpdated() != null && doc.getTitle() != null
                && doc.getCreator() != null && doc.getEditor() != null
                && doc.getBody() != null){
            documentRepository.save(doc);
            return findDocumentById(doc.getDocumentId());
        }else{
            logger.warn("Impossible d'ajouter le document : "+doc.getId());
            throw new ApiException(400,"le contenu n'est pas correct");
        }
    }

    public Document updateDocument(Document document, String documentId) throws ApiException {
        Document updatedDocument = findDocumentById(documentId);
        logger.info("VERSION UPDATE ETAG: "+ document.getVersion());
        logger.info("VERSION MONGO ETAG: "+ updatedDocument.getVersion());
        if(document.getVersion().equals(updatedDocument.getVersion())){
            updatedDocument.setBody(document.getBody());
            updatedDocument.setTitle(document.getTitle());
            updatedDocument.setEditor(document.getEditor());
            updatedDocument.setUpdated(document.getUpdated());
            documentRepository.save(updatedDocument);
            return findDocumentById(documentId);
        }else{
            logger.warn("Une version plus récente existe");
            throw new ApiException(412,"Precondition Failed");
        }
    }

}

