package org.sid.Inventoryservice.Repository;

import org.sid.Inventoryservice.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface ProductRepository  extends JpaRepository<Product,Long>{

}
