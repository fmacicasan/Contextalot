// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.lic.extracter.repository;

import com.lic.extracter.domain.Sourcer;
import java.math.BigInteger;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

privileged aspect SourcerRepository_Roo_Mongo_Repository {
    
    declare parents: SourcerRepository extends PagingAndSortingRepository<Sourcer, BigInteger>;
    
    declare @type: SourcerRepository: @Repository;
    
}
