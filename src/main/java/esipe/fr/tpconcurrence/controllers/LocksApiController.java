package esipe.fr.tpconcurrence.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import esipe.fr.tpconcurrence.entities.Lock;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Api(tags = "locks")
@Controller
public class LocksApiController implements LocksApi{

    private static final Logger log = LoggerFactory.getLogger(DocumentsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public LocksApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    @ApiOperation(value = "pose un verrou sur le document", nickname = "documentsDocumentIdLockPut", notes = "l'utilisateur peut poser un verrou si aucun n'autre n'est posé ", response = Lock.class, tags={ "locks", })
    public ResponseEntity<Lock> documentsDocumentIdLockPut(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId, @ApiParam(value = "l'objet verrou posé"  )  @Valid @RequestBody Lock lock) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Lock>(objectMapper.readValue("{  \"owner\" : \"owner\",  \"created\" : \"2000-01-23T04:56:07.000+00:00\"}", Lock.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Lock>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Lock>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "supprime le verrou posé", nickname = "documentsDocumentIdLockDelete", notes = "", tags={ "locks", })
    public ResponseEntity<Void> documentsDocumentIdLockDelete(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }


    @ApiOperation(value = "retourne le verrou posé sur le document si présent", nickname = "documentsDocumentIdLockGet", notes = "", response = Lock.class, tags={ "locks", })
    public ResponseEntity<Lock> documentsDocumentIdLockGet(@ApiParam(value = "identifiant du document",required=true) @PathVariable("documentId") String documentId) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Lock>(objectMapper.readValue("{  \"owner\" : \"owner\",  \"created\" : \"2000-01-23T04:56:07.000+00:00\"}", Lock.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Lock>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Lock>(HttpStatus.NOT_IMPLEMENTED);
    }
}
