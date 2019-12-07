package esipe.fr.tpconcurrence.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import esipe.fr.tpconcurrence.entities.Document;
import esipe.fr.tpconcurrence.entities.DocumentsList;
import esipe.fr.tpconcurrence.entities.Lock;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Api(tags = "documents")
@Controller
public class DocumentsApiController implements DocumentsApi {

    private static final Logger log = LoggerFactory.getLogger(DocumentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public DocumentsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }
    @ApiOperation(value = "lis le document", nickname = "documentsDocumentIdGet", notes = "retourne un document", response = Document.class, tags={ "documents", })
    public ResponseEntity<Document> documentsDocumentIdGet(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Document>(objectMapper.readValue("\"\"", Document.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Document>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Document>(HttpStatus.NOT_IMPLEMENTED);
    }







    @ApiOperation(value = "mise à jour du document", nickname = "documentsDocumentIdPost", notes = "met à jour le document si l'utilisateur possède la dernière version et que personne n'a posé de verrou ", response = Document.class, tags={ "documents", })
    public ResponseEntity<Document> documentsDocumentIdPost(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId,@ApiParam(value = "met à jour le texte, le titre, l'editeur et la date de mise à jour"  )  @Valid @RequestBody Document document) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Document>(objectMapper.readValue("\"\"", Document.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Document>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Document>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "retourne tous les documents, pas de filtrage", nickname = "documentsGet", notes = "", response = DocumentsList.class, tags={ "documents", })
    public ResponseEntity<DocumentsList> documentsGet(@ApiParam(value = "numéro de la page à retourner") @Valid @RequestParam(value = "page", required = false) Integer page, @ApiParam(value = "nombre de documents par page") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<DocumentsList>(objectMapper.readValue("\"\"", DocumentsList.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<DocumentsList>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<DocumentsList>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "create a document", nickname = "documentsPost", notes = "", response = Document.class, tags={ "documents", })
    public ResponseEntity<Document> documentsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Document document) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Document>(objectMapper.readValue("\"\"", Document.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Document>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Document>(HttpStatus.NOT_IMPLEMENTED);
    }

}
