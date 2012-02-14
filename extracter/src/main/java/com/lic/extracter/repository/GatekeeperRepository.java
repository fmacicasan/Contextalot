package com.lic.extracter.repository;

import com.lic.extracter.domain.Gatekeeper;
import java.util.List;
import org.springframework.roo.addon.layers.repository.mongo.RooRepositoryMongo;

@RooRepositoryMongo(domainType = Gatekeeper.class)
public interface GatekeeperRepository {

    List<com.lic.extracter.domain.Gatekeeper> findAll();
}
