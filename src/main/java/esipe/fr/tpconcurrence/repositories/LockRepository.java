package esipe.fr.tpconcurrence.repositories;

import esipe.fr.tpconcurrence.entities.Document;
import esipe.fr.tpconcurrence.entities.Lock;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LockRepository extends MongoRepository<Lock,String> {
}
