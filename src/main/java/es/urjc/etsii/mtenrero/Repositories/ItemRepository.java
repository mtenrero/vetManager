package es.urjc.etsii.mtenrero.Repositories;

import es.urjc.etsii.mtenrero.Entities.Item;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by was12 on 11/02/2017.
 */
public interface ItemRepository extends JpaRepository<Item,Long> {
    @CachePut("vetmanager")
    Item save(Item item);
    @Cacheable("vetmanager")
    Item findById(long id);
}
