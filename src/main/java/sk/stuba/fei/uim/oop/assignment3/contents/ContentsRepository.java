package sk.stuba.fei.uim.oop.assignment3.contents;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentsRepository extends CrudRepository<Contents, Long> {
    List<Contents> findAll();
}



