package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Company;

public interface CompanyService {

    public Iterable<Company> listAllCompanies();

    public Company getCompanyById(Integer id);

    public Company saveCompany(Company company);

    public void deleteCompany(Integer id);

}
