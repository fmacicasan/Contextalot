package com.lic.extracter.repository;

import com.lic.extracter.domain.ExtraAlchemer;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooRepositoryMongo;

@RooRepositoryMongo(domainType = ExtraAlchemer.class)
public interface ExtraAlchemerRepository {

    List<com.lic.extracter.domain.ExtraAlchemer> findAll();
}
