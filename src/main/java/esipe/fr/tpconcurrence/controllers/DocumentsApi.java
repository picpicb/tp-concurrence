package esipe.fr.tpconcurrence.controllers;

import esipe.fr.tpconcurrence.entities.Document;
import esipe.fr.tpconcurrence.entities.DocumentsList;
import esipe.fr.tpconcurrence.entities.ErrorDefinition;
import esipe.fr.tpconcurrence.entities.Lock;
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@ApiIgnore
public interface DocumentsApi {


    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "le document demandé", response = Document.class),
        @ApiResponse(code = 404, message = "le document n'existe pas", response = ErrorDefinition.class) })
    @RequestMapping(value = "/documents/{documentId}",
        method = RequestMethod.GET)
    ResponseEntity<Document> documentsDocumentIdGet(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId);


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "le document est mis à jour", response = Document.class) })
    @RequestMapping(value = "/documents/{documentId}",
        method = RequestMethod.POST)
    ResponseEntity<Document> documentsDocumentIdPost(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId,@ApiParam(value = "met à jour le texte, le titre, l'editeur et la date de mise à jour"  )  @Valid @RequestBody Document document);


    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "la liste des documents", response = DocumentsList.class) })
    @RequestMapping(value = "/documents",
        method = RequestMethod.GET)
    ResponseEntity<DocumentsList> documentsGet(@ApiParam(value = "numéro de la page à retourner") @Valid @RequestParam(value = "page", required = false) Integer page,@ApiParam(value = "nombre de documents par page") @Valid @RequestParam(value = "pageSize", required = false) Integer pageSize);


    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "le document créé", response = Document.class),
        @ApiResponse(code = 400, message = "le contenu n'est pas correction", response = ErrorDefinition.class) })
    @RequestMapping(value = "/documents",
        method = RequestMethod.POST)
    ResponseEntity<Document> documentsPost(@ApiParam(value = "" ,required=true )  @Valid @RequestBody Document document);

}
