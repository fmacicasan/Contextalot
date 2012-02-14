package com.lic.extracter.repository;

import com.lic.extracter.domain.Alchemer;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooRepositoryMongo;

@RooRepositoryMongo(domainType = Alchemer.class)
public interface AlchemerRepository {

    List<com.lic.extracter.domain.Alchemer> findAll();
}
