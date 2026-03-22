package com.andrest.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrest.apirest.apirest.Entities.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Long>{

}
