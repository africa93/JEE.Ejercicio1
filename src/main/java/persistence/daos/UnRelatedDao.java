package persistence.daos;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import persistence.entities.UnRelatedEntity;

public interface UnRelatedDao extends JpaRepository<UnRelatedEntity, Integer>{
	List<UnRelatedEntity> findByNickIgnoreCase(String nick);
	UnRelatedEntity findById(int n);
	List<UnRelatedEntity> findByIdGreaterThan(int id, Pageable pageable);
	
	@Query("select u from other_name_for_unrelatedentity u")
	List<UnRelatedEntity> findAll();
	
	@Query("select u.nick from other_name_for_unrelatedentity u where u.nick like ?1")
    List<String> findNickByNickLike(String nick);
    
    @Query("select u.id from other_name_for_unrelatedentity u where u.id > ?1 and u.id < ?2")
    List<Integer> findIdByIdBetween(int initial, int end);
    
    //Consulta: SQL
    @Query(value = "SELECT * FROM other_name_for_unrelatedentity WHERE KCIN = ?1", nativeQuery = true)
    UnRelatedEntity findByNick(String nick);
    
    @Query(value = "SELECT * FROM other_name_for_unrelatedentity", nativeQuery = true)
    List <UnRelatedEntity> findAllSQL();
}
