package enoca.backendchallenge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import enoca.backendchallenge.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
