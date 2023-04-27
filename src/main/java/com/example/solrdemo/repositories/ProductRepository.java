package com.example.solrdemo.repositories;

import com.example.solrdemo.data.Product;
import org.springframework.data.solr.repository.SolrCrudRepository;

import java.util.List;

public interface ProductRepository extends SolrCrudRepository<Product, String> {

    public List<Product> findByName(String name);

//    @Query("id:*?0* OR name:*?0*")
//    public Page<Product> findByCustomQuery(String searchTerm, Pageable pageable);
//
//    @Query(name = "Product.findByNamedQuery")
//    public Page<Product> findByNamedQuery(String searchTerm, Pageable pageable);

}