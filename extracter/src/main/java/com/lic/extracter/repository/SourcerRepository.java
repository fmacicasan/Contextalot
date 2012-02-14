package com.lic.extracter.repository;

import com.lic.extracter.domain.Sourcer;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooRepositoryMongo;

@RooRepositoryMongo(domainType = Sourcer.class)
public interface SourcerRepository {

    List<com.lic.extracter.domain.Sourcer> findAll();
}
