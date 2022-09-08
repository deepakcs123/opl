package com.restapi.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restapi.entity.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Integer> {
		public Optional<ImageModel> findByName(String name);
}
