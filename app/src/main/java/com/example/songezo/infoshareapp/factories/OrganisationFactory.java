package com.example.songezo.infoshareapp.factories;

import com.example.songezo.infoshareapp.domain.Organisation;

/**
 * Created by asiphe.dyani on 2016/12/10.
 */

public class OrganisationFactory {

    Organisation organisation;

    private static OrganisationFactory organisationFactory = null;

    public OrganisationFactory() {
    }

    public static OrganisationFactory getLogFactory(){
        if (organisationFactory == null){
            organisationFactory = new OrganisationFactory();
        }
        return organisationFactory;
    }

    public static Organisation createOrganisationFactory(Long id){
        Organisation organisation1 = new Organisation.Builder()
                .id(id)
                .build();

        return organisation1;
    }

    @Override
    public String toString() {
        return "organisationFactory{" +
                "organisation=" + organisation +
                '}';
    }
}
