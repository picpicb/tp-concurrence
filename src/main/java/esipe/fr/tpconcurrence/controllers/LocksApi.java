package esipe.fr.tpconcurrence.controllers;

import esipe.fr.tpconcurrence.entities.Lock;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.Valid;

@ApiIgnore
public interface LocksApi {

    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "le verrou est supprimé") })
    @RequestMapping(value = "/documents/{documentId}/lock",
            method = RequestMethod.DELETE)
    ResponseEntity<Void> documentsDocumentIdLockDelete(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId);


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le verrou posé", response = Lock.class),
            @ApiResponse(code = 204, message = "aucun verrou posé") })
    @RequestMapping(value = "/documents/{documentId}/lock",
            method = RequestMethod.GET)
    ResponseEntity<Lock> documentsDocumentIdLockGet(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId);


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "le verrou est posé", response = Lock.class),
            @ApiResponse(code = 409, message = "un verrou est déjà posé, retourne le verrou déjà posé", response = Lock.class) })
    @RequestMapping(value = "/documents/{documentId}/lock",
            method = RequestMethod.PUT)
    ResponseEntity<Lock> documentsDocumentIdLockPut(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId,@ApiParam(value = "l'objet verrou posé"  )  @Valid @RequestBody Lock lock);


}
