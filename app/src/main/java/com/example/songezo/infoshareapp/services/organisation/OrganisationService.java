package com.example.songezo.infoshareapp.services.organisation;

import com.example.songezo.infoshareapp.domain.Organisation;

import java.util.Set;

/**
 * Created by asiphe.dyani on 2016/12/13.
 */

public interface OrganisationService {

    Organisation getOrganisationByID(Long id);


    Organisation saveOrganisation(Organisation entity);

    Set<Organisation> findAll();
}
