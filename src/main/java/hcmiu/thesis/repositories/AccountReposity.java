package hcmiu.thesis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import hcmiu.thesis.entities.Account;

@Repository
public interface AccountReposity extends JpaRepository<Account, Integer> , CrudRepository<Account, Integer> {
	
	@Query("select a from Account a where a.username = ?1 and a.status = 1")
	Account findActiveAccountByUsername(String username);
	
	Account findByUsername(String username);
	
//	@Query("update Account set status = ?1")
//	Account updateStatus(Integer status);
}
